package main.java.model;

public class Board {
    int size;
    Symbol[][] gameBoard;

    public Board(int size) {
        this.size = size;
        gameBoard = new Symbol[size][size];
    }

    public boolean addSymbol(Symbol symbol, int inputRow, int inputColumn) {
        if (gameBoard[inputRow][inputColumn] != null) {
            System.out.println("Adding piece on non-empty spot");
            return false;
        }
        gameBoard[inputRow][inputColumn] = symbol;
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public Symbol[][] getGameBoard() {
        return this.gameBoard;
    }
}
