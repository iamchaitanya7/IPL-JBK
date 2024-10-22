package com.test.service;

import com.test.dao.DaoIPL;
import com.test.entity.PlayersIPL;

import java.util.HashMap;
import java.util.List;

public class ServiceIPL {
    private DaoIPL daoIPL = null;

    /*public ServiceIPL() {
        //daoIPL = new DaoIPL();
    }*/

    //Method to return all players.
    public List<PlayersIPL> fetchAllPlayers() {
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

    //Get all players by all team.
    public HashMap<String, List<PlayersIPL>> getAllPlayersByTeam() {
        daoIPL = new DaoIPL();
        return daoIPL.getAllPlayersByTeam();
    }

    //Get players by a specific team.
    public List<PlayersIPL> getPlayersByTeam(String team) {
        daoIPL = new DaoIPL();
        return daoIPL.getPlayersByTeam(team);
    }

    //Add a player to a specific team.
    public void addPlayerToTeam(String team, PlayersIPL player) {
        daoIPL = new DaoIPL();
        daoIPL.addPlayerToTeam(team, player);
    }
}
