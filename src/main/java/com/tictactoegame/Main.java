package main.java.com.tictactoegame;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initialize();
        String result = game.start();
        System.out.println(result);
    }
}
