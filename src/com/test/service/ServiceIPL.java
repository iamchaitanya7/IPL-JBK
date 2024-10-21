package com.test.service;

import com.test.dao.DaoIPL;
import com.test.entity.PlayersIPL;
import java.util.List;

public class ServiceIPL {
    private DaoIPL daoIPL = null;

    public ServiceIPL() {
        //daoIPL = new DaoIPL();
    }

    // Method to return all players
    public List<PlayersIPL> fetchAllPlayers() {
        daoIPL = new DaoIPL();
        return daoIPL.getAllPlayers();
    }

    // Method to add a player
    public void registerPlayer(PlayersIPL player) {
        daoIPL = new DaoIPL();
        daoIPL.addPlayer(player);
    }

    // Method to find a player by jersey number
    public PlayersIPL findPlayerByJerseyNo(int jerseyNo) {
        daoIPL = new DaoIPL();
        return daoIPL.getPlayerByJerseyNo(jerseyNo);
    }
}
