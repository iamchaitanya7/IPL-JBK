package com.test.service;

import com.test.dao.DaoIPL;
import com.test.entity.PlayersIPL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceIPL {
    private DaoIPL daoIPL = null;
    private List<PlayersIPL> players = new ArrayList<> ();

    /*public ServiceIPL() {
        //daoIPL = new DaoIPL();
    }*/

    //Method to return all players.
    public List<PlayersIPL> getAllPlayers() {
        daoIPL = new DaoIPL();
        return daoIPL.getAllPlayers();
    }

    //Method to add a player.
    public void registerPlayer(PlayersIPL player) {
        daoIPL = new DaoIPL();
        daoIPL.addPlayer(player);
    }

    //Method to find a player by jersey number.
    public PlayersIPL findPlayerByJerseyNo(int jerseyNo) {
        daoIPL = new DaoIPL();
        return daoIPL.getPlayerByJerseyNo(jerseyNo);
    }

    public HashMap<String, List<PlayersIPL>> getAllPlayersByTeam() {
        return players.stream()
                .collect(Collectors.groupingBy(PlayersIPL::getTeam, HashMap::new, Collectors.toList()));
    }

    public List<PlayersIPL> getPlayersByTeam(String teamName) {
        return players.stream()
                .filter(player -> teamName.equalsIgnoreCase(player.getTeam()))
                .collect(Collectors.toList());
    }

    //Add a player to a specific team.
    public void addPlayerToTeam(String team, PlayersIPL player) {
        daoIPL = new DaoIPL();
        daoIPL.addPlayerToTeam(team, player);
    }

    // Method to get the player with the highest wickets.
    public PlayersIPL getPlayerWithHighestWickets() {
        return getAllPlayers().stream()
                .max(Comparator.comparingInt(PlayersIPL::getWickets))
                .orElse(null); // Returns null if no players are available
    }

    // Method to get the player with the lowest wickets.
    public PlayersIPL getPlayerWithLowestWickets() {
        return getAllPlayers().stream()
                .min(Comparator.comparingInt(PlayersIPL::getWickets))
                .orElse(null); // Returns null if no players are available
    }

    // Method to get the player with the highest runs.
    public PlayersIPL getPlayerWithHighestRuns() {
        return getAllPlayers().stream()
                .max(Comparator.comparingInt(PlayersIPL::getRuns))
                .orElse(null);
    }

    // Method to get the player with the lowest runs.
    public PlayersIPL getPlayerWithLowestRuns() {
        return getAllPlayers().stream()
                .min(Comparator.comparingInt(PlayersIPL::getRuns))
                .orElse(null);
    }

    // Method to get the player with the highest strike rate.
    public PlayersIPL getPlayerWithHighestStrikeRate() {
        return getAllPlayers().stream()
                .max(Comparator.comparingDouble(PlayersIPL::getStrikeRate))
                .orElse(null);
    }

    // Method to get the player with the lowest strike rate.
    public PlayersIPL getPlayerWithLowestStrikeRate() {
        return getAllPlayers().stream()
                .min(Comparator.comparingDouble(PlayersIPL::getStrikeRate))
                .orElse(null);
    }

    public List<PlayersIPL> getPlayersByName(String name) {
        return players.stream()
                .filter(player -> name.equalsIgnoreCase(player.getName()))
                .collect(Collectors.toList());
    }
}
