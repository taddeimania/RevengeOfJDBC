package io.joel.models;

public class Stat {
    private int id;
    private String name;
    private int wins;
    private int losses;

    public Stat(int id, String name, int wins, int losses) {
        this.id = id;
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    public Stat(String name, int wins, int losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}
