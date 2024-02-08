package TicTacToe;

import java.util.HashMap;
import java.util.Map;

public enum PieceType {
    X('X'),
    O('O'),
    EMPTY(' ');

    private static final Map<Character, PieceType> symbolToPieceType = new HashMap<>();

    static {
        for (PieceType pieceType : PieceType.values()) {
            symbolToPieceType.put(pieceType.getSymbol(), pieceType);
        }
    }

    private final char symbol;

    PieceType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static PieceType fromSymbol(char symbol) {
        return symbolToPieceType.getOrDefault(symbol, EMPTY);
    }
}
