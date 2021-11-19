package it.battleship.player;
import it.battleship.board.*;
import it.battleship.board.exceptions.BoardException;
import it.battleship.board.exceptions.PositionException;
import it.battleship.game.Display;
import it.battleship.ships.Ship;
import it.battleship.ships.utils.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private final Board board;
    private boolean isCPU;


    public Player(String name){
        this.name = name;
        board = new Board(10);
        isCPU = false;
    }

    public Player(String name, boolean isCPU){
        this.name = name;
        board = new Board(10);
        this.isCPU = isCPU;
    }

    public Player(){
        this.name = randName();
        board = new Board(10);
        isCPU = true;
    }

    public Player(boolean isCPU){
        this.name = randName();
        board = new Board(10);
        this.isCPU = isCPU;
    }

    private ArrayList<Ship> initShips(){
        ArrayList<Ship> list = new ArrayList<>();
        for (ShipType type: ShipType.values()){
            for (int i = 0; i < type.getNumShips(); i++){
                list.add(new Ship(ShipType.toItalianNameShip(type), type.getShipLength()));
            }
        }
        return list;
    }

    private String randName(){
        Random rand = new Random();
        String letters = "abcdefghiljkmnopqrstuvwxyz";
        String name = "";
        int maxLung = 10, minLung = 3;
        int l = rand.nextInt(maxLung - minLung) + minLung;
        for (int i=0; i<l; i++){
            name += letters.charAt(rand.nextInt(letters.length()));
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public void setIsCPU(boolean CPU) {
        isCPU = CPU;
    }

    public boolean isCPU(){
        return isCPU;
    }

    public void addAllShips(){
        if (!isCPU) {
            boolean isAdded;
            Position position;
            Direction direction;
            String messageInputPosition = "- Inserisci la coordinata (es. A1): ";
            String messageInputDirection = "- Inserisci la direzione (h/v): ";
            Scanner sc = new Scanner(System.in);
            ArrayList<Ship> list = initShips();
            for (int i = 0; i < list.size(); i++) {
                Ship ship = list.get(i);
                do {
                    Display.printBoard(board);
                    Display.printCurrentShip(ship, countShip(list, ship.getLength()));

                    position = Input.readPosition(sc, board, messageInputPosition);
                    direction = Input.readDirection(sc, messageInputDirection);
                    ship.setPosition(position);
                    ship.setDirection(direction);

                    try {
                        isAdded = board.addShip(ship);
                    } catch (BoardException | PositionException e) {
                        Display.printError(e.toString());
                        isAdded = false;
                    }
                } while (!isAdded);
                list.remove(i);
                i--;
            }
            Display.printBoard(board);
        }else randAddAllShips();
    }

    private void randAddAllShips(){
        Random random = new Random();
        ArrayList<Ship> list = initShips();

        boolean isAdded;
        Position position;
        Direction direction;
        int deadlock = 0, limit = 1000;

        for (int i = 0; i < list.size(); i++){
            Ship ship = list.get(i);
            deadlock = 0;
            do {
                try {
                    position = new Position(random.nextInt(board.getLength()), random.nextInt(board.getLength()));
                    direction = random.nextBoolean() ? Direction.VERTICAL : Direction.HORIZONTAL;
                    ship.setPosition(position);
                    ship.setDirection(direction);
                    isAdded = board.addShip(ship);
                } catch (BoardException | PositionException e){ isAdded = false; }
                if (!isAdded) deadlock++;
                if (deadlock > limit) {
                    reset();
                    i = -1;
                    break;
                }
            } while (!isAdded);
        }
    }

    public boolean hasShipsLive(){
        return board.getNumShips() > 0;
    }

    private int countShip(ArrayList<Ship> ships, int length){
        int count = 0;
        for (Ship ship: ships){
            if (ship.getLength() == length) count++;
        }
        return count;
    }

    public int shipsLeft(){
        return board.getNumShips();
    }

    public boolean addHit(Position pos) throws BoardException {
        return board.addHit(pos);
    }

     public Position randShoot() throws PositionException {
        Random random = new Random();
        int x = random.nextInt(board.getLength());
        int y = random.nextInt(board.getLength());
        return new Position(x, y);
    }

    public Position shoot() throws PositionException {
        if (isCPU) return randShoot();
        else {
            Scanner sc = new Scanner(System.in);
            return Input.readPosition(sc, board,  "- " + name + ", dove vuoi sparare? ");
        }
    }

    private void reset(){
        board.reset();
    }

}
