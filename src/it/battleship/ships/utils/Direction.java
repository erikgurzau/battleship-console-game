package it.battleship.ships.utils;

import it.battleship.ships.utils.exceptions.DirectionException;

public enum Direction {
    HORIZONTAL,
    VERTICAL;

    public static Direction decode(char c) throws DirectionException {
        if (c == 'h' || c == 'H') return HORIZONTAL;
        else if (c == 'v' || c == 'V') return VERTICAL;
        else throw new DirectionException("Il carattere '"+c+"' non può essere convertito in una direzione");
    }

    public static Direction decode(String str) throws DirectionException {
        if (str.toLowerCase().equals("horizontal")) return HORIZONTAL;
        else if (str.toLowerCase().equals("vertical")) return VERTICAL;
        else throw new DirectionException("La stringa '"+str+"' non può essere convertita in una direzione");
    }
}
