package main.java.com.tictactoegame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import main.java.model.Board;
import main.java.model.Player;
import main.java.model.Symbol;
import main.java.model.SymbolType;
import main.java.model.SymbolTypeO;
import main.java.model.SymbolTypeX;


public class TicTacToeGame {
    Deque<Player> playerQueue;
    Board board;

    public void initialize() {
        // Initialize player list - hardcoded size for now.
        // Initialize board - hardcoded size for now.

        Player playerA = new Player("PlayerA", new SymbolTypeO(SymbolType.ZERO));
        Player playerB = new Player("PlayerB", new SymbolTypeX(SymbolType.CROSS));

        playerQueue = new LinkedList<>();
        playerQueue.add(playerA);
        playerQueue.add(playerB);

        board = new Board(3);
    }

    public String start() {
        // create a loop and run till no winner or game tied.

        boolean noWinner = true;
        int freeSpaces = board.getSize() * board.getSize();

        while(noWinner) {
            Player playerTurn = playerQueue.removeFirst();

            // get number of free spaces from board, if no free space left, game is tied, return.
            if (freeSpaces == 0) {
                System.out.println("GAME IS TIED");
                return "GAME TIED";
            }

            // reading the user input
            System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // TODO
            //  1. Validate if user input for row and column is valid.
            //  2. Validate if user input is on a free spot (Need to maintain list of free spots).
            //  3. If any of validations fail, continue loop with same player.

            boolean symbolAdded = board.addSymbol(playerTurn.getSymbol(), inputRow, inputColumn);

            if (!symbolAdded) {
                playerQueue.addFirst(playerTurn);
                continue;
            }
            freeSpaces--;

            if (isWinner(inputRow, inputColumn, playerTurn.getSymbol())) {
                System.out.println("Winner is: " + playerTurn.getName());
                return playerTurn.getName();

            }
            playerQueue.add(playerTurn);
        }

        return "GAME ENDED";
    }

    public boolean isWinner(int row, int column, Symbol symbol) {

        boolean rowCheck = true;
        boolean columnCheck = true;
        boolean diagonalCheck = true;
        boolean antiDiagonalCheck = true;

        // Row check
        for (int i=0;i< board.getSize();i++) {
            if (board.getGameBoard()[row][i] == null || board.getGameBoard()[row][i] != symbol) {
                rowCheck = false;
                break;
            }
        }

        //Column check
        for (int i=0;i< board.getSize();i++) {
            if (board.getGameBoard()[i][column] == null || board.getGameBoard()[i][column] != symbol) {
                columnCheck = false;
                break;
            }
        }

        //Diagonal check
        for (int i=0,j=0;i< board.getSize();i++,j++) {
            if(board.getGameBoard()[i][j] == null || board.getGameBoard()[i][j] != symbol) {
                diagonalCheck = false;
                break;
            }
        }

        //Anti diagonal check
        for (int i=0,j= board.getSize()-1;i< board.getSize();i++,j--) {
            if (board.getGameBoard()[i][j] == null || board.getGameBoard()[i][j] != symbol) {
                antiDiagonalCheck = false;
                break;
            }
        }

        return rowCheck || columnCheck || diagonalCheck || antiDiagonalCheck;

    }

}
