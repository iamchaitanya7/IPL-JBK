package com.test.entity;

public class PlayersIPL {
    private int jerseyNo;
    private String name;
    private int runs;
    private double strikerate;

    public PlayersIPL(){

    }

    public PlayersIPL (int jerseyNo, String name, int runs, double strikerate) {
        this.jerseyNo = jerseyNo;
        this.name = name;
        this.runs = runs;
        this.strikerate = strikerate;
    }

    public int getJerseyNo () {
        return jerseyNo;
    }

    public void setJerseyNo (int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getRuns () {
        return runs;
    }

    public void setRuns (int runs) {
        this.runs = runs;
    }

    public double getStrikerate () {
        return strikerate;
    }

    public void setStrikerate (double strikerate) {
        this.strikerate = strikerate;
    }

    @Override
    public String toString () {
        return "PlayersIPL{" +
                "jerseyNo=" + jerseyNo +
                ", name='" + name + '\'' +
                ", runs=" + runs +
                ", strikerate=" + strikerate +
                '}';
    }
}
