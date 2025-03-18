package main.java.model;

public class Player {
    String name;
    Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }
}
