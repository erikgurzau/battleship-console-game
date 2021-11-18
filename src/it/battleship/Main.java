package it.battleship;

import it.battleship.board.exceptions.PositionException;
import it.battleship.game.BattleshipGame;
import it.battleship.game.Display;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PositionException {
        Scanner sc = new Scanner(System.in);
        BattleshipGame game;
        String name = "";
        int opt;
        boolean hasName = false;

        try {
            do {
                opt = Display.printMenu();

                switch (opt) {
                    case 1 -> {
                        if (!hasName) {
                            System.out.print("\nInserisci il tuo nome: ");
                            name = sc.next();
                            hasName = true;
                        }
                        game = new BattleshipGame(name);
                        game.run();
                    }
                    case 2 -> {
                        game = new BattleshipGame();
                        game.run();
                    }
                    case 3 -> {
                        Display.printRules();
                        System.out.print("\nPremi un tasto per continuare...");
                        sc.nextLine();
                    }
                }
            } while (opt != 0);
        } catch (InputMismatchException e) { }
        Display.printCredits();
    }
}
