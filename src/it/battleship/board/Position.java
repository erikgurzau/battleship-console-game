package it.battleship.board;

import it.battleship.board.exceptions.PositionException;

public class Position {
    private final int row;
    private final int column;

    public Position(int row, int column) throws PositionException {
        if (row < 0 || column < 0)
            throw new PositionException("Valori consentiti maggiori di 1");
        this.row = row;
        this.column = column;
    }

    public Position(char row, int column) throws PositionException {
        if (row < 'a' || column < 0)
            throw new PositionException("Valori consentiti maggiori di a1");
        this.row = decode(row);
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public static int decode(char row) {
        return row - 'a';
    }

    public static char encode(int row) {
        return (char)('a' + row);
    }

    public String toStringEncode(Position position) {
        return "(" + (char)('a' + position.getRow()) + "," + (position.getColumn() + 1) + ")";
    }

    public static boolean isInRange(char row, int column, Board board) throws PositionException {
        int decodeRow = decode(row);
        if (decodeRow >= board.getLength() || column > board.getLength() || decodeRow < 0 || column < 0)
            throw new PositionException("Errore, valori consentiti tra a1 e " + Position.encode(board.getLength() - 1) + board.getLength());
        else return true;
    }

    @Override
    public String toString (){
        return "(" + row + "," + column + ")";
    }

}
