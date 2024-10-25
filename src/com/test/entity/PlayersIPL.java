package com.test.entity;

public class PlayersIPL {
    private int jerseyNo;
    private String name;
    private int runs;
    private int wickets;
    private String team;
    private double strikeRate;

    public PlayersIPL(int jerseyNo, String name, int runs, int wickets, double strikeRate) {
        this.jerseyNo = jerseyNo;
        this.name = name;
        this.runs = runs;
        this.wickets = wickets;
        this.team = null;
        this.strikeRate = strikeRate;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public String getTeam () {
        return team;
    }

    public void setTeam (String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player [Jersey No=" + jerseyNo + ", Name=" + name + ", Runs=" + runs + ", Wickets=" + wickets +
                ", Strike Rate=" + strikeRate + ", team='" + team + "]";
    }
}
