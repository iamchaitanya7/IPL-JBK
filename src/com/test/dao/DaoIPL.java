package com.test.dao;

import com.test.entity.PlayersIPL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DaoIPL {
    private List<PlayersIPL> playersList;
    private HashMap<String, List<PlayersIPL>> teamPlayersMap;

    public DaoIPL() {
        playersList = new ArrayList<>();
        // Add 25 players with sample data
        playersList.add(new PlayersIPL(7, "MS Dhoni", 4500, 25, 87.3));
        playersList.add(new PlayersIPL(18, "Virat Kohli", 6200, 8, 91.5));
        playersList.add(new PlayersIPL(45, "Rohit Sharma", 5100, 6, 88.9));
        playersList.add(new PlayersIPL(33, "Steve Smith", 4800, 4, 82.5));
        playersList.add(new PlayersIPL(17, "AB de Villiers", 5600, 15, 95.0));
        playersList.add(new PlayersIPL(99, "Lasith Malinga", 1200, 170, 75.2));
        playersList.add(new PlayersIPL(24, "Ben Stokes", 3200, 90, 88.1));
        playersList.add(new PlayersIPL(12, "Kane Williamson", 4100, 5, 81.6));
        playersList.add(new PlayersIPL(25, "Chris Gayle", 6900, 20, 90.3));
        playersList.add(new PlayersIPL(35, "Jasprit Bumrah", 1100, 120, 76.4));
        playersList.add(new PlayersIPL(63, "Ravindra Jadeja", 2900, 120, 87.8));
        playersList.add(new PlayersIPL(48, "Andre Russell", 2400, 90, 93.5));
        playersList.add(new PlayersIPL(22, "Hardik Pandya", 2600, 85, 91.7));
        playersList.add(new PlayersIPL(4, "David Warner", 5800, 7, 92.1));
        playersList.add(new PlayersIPL(9, "Bhuvneshwar Kumar", 800, 105, 72.0));
        playersList.add(new PlayersIPL(21, "KL Rahul", 3700, 3, 89.4));
        playersList.add(new PlayersIPL(50, "Yuzvendra Chahal", 350, 130, 78.2));
        playersList.add(new PlayersIPL(88, "Pat Cummins", 900, 110, 85.6));
        playersList.add(new PlayersIPL(19, "Shikhar Dhawan", 5500, 2, 86.0));
        playersList.add(new PlayersIPL(39, "Rishabh Pant", 3300, 2, 89.9));
        playersList.add(new PlayersIPL(55, "Mitchell Starc", 700, 120, 77.5));
        playersList.add(new PlayersIPL(5, "Suresh Raina", 5400, 25, 86.8));
        playersList.add(new PlayersIPL(10, "Trent Boult", 850, 115, 80.0));
        playersList.add(new PlayersIPL(8, "Sunil Narine", 1400, 145, 82.4));
        playersList.add(new PlayersIPL(2, "Faf du Plessis", 5000, 7, 88.5));
    }

    //Method to get the list of all players.
    public List<PlayersIPL> getAllPlayers() {
        return playersList;
    }

    //Method to add a player to the list.
    public void addPlayer(PlayersIPL player) {
        playersList.add(player);
    }

    //Method to add players to specific teams.
    public void playersByTeams(){
        //Creating playersList for CSK, MI, and RCB teams and group them by team.
        List<PlayersIPL> cskPlayers = new ArrayList<>();
        cskPlayers.add(new PlayersIPL(7, "MS Dhoni", 4500, 25, 87.3));
        cskPlayers.add(new PlayersIPL(18, "Virat Kohli", 6200, 8, 91.5));
        cskPlayers.add(new PlayersIPL(45, "Rohit Sharma", 5100, 6, 88.9));
        cskPlayers.add(new PlayersIPL(33, "Steve Smith", 4800, 4, 82.5));
        cskPlayers.add(new PlayersIPL(17, "AB de Villiers", 5600, 15, 95.0));

        List<PlayersIPL> miPlayers = new ArrayList<>();
        miPlayers.add(new PlayersIPL(99, "Lasith Malinga", 1200, 170, 75.2));
        miPlayers.add(new PlayersIPL(24, "Ben Stokes", 3200, 90, 88.1));
        miPlayers.add(new PlayersIPL(12, "Kane Williamson", 4100, 5, 81.6));
        miPlayers.add(new PlayersIPL(25, "Chris Gayle", 6900, 20, 90.3));
        miPlayers.add(new PlayersIPL(35, "Jasprit Bumrah", 1100, 120, 76.4));

        List<PlayersIPL> rcbPlayers = new ArrayList<>();
        rcbPlayers.add(new PlayersIPL(63, "Ravindra Jadeja", 2900, 120, 87.8));
        rcbPlayers.add(new PlayersIPL(48, "Andre Russell", 2400, 90, 93.5));
        rcbPlayers.add(new PlayersIPL(22, "Hardik Pandya", 2600, 85, 91.7));
        rcbPlayers.add(new PlayersIPL(4, "David Warner", 5800, 7, 92.1));
        rcbPlayers.add(new PlayersIPL(9, "Bhuvneshwar Kumar", 800, 105, 72.0));

        //Adding players to the HashMap for respective teams.
        teamPlayersMap = new HashMap<>();
        teamPlayersMap.put("CSK", cskPlayers);
        teamPlayersMap.put("MI", miPlayers);
        teamPlayersMap.put("RCB", rcbPlayers);

    }

    public HashMap<String, List<PlayersIPL>> getAllPlayersByTeam() {
        return playersList.stream()
                .collect(Collectors.groupingBy(PlayersIPL::getTeam, HashMap::new, Collectors.toList()));
    }

    public List<PlayersIPL> getPlayersByTeam(String teamName) {
        return playersList.stream()
                .filter(player -> teamName.equalsIgnoreCase(player.getTeam()))
                .collect(Collectors.toList());
    }



    //Method to add a player to a specific team.
    public void addPlayerToTeam(String team, PlayersIPL player) {
        teamPlayersMap.computeIfAbsent(team, k -> new ArrayList<>()).add(player);
    }

    //Method to get player by specific jersey number.
    public PlayersIPL getPlayerByJerseyNo(int jerseyNo) {
        for (PlayersIPL player : playersList) {
            if (player.getJerseyNo() == jerseyNo) {
                return player;
            }
        }
        return null;
    }
}
