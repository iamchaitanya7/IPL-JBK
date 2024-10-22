package com.test.controller;

import com.test.entity.PlayersIPL;
import com.test.service.ServiceIPL;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ControllerIPL {
    private ServiceIPL service;
    private Scanner scanner;

    /*public ControllerIPL() {
        service = new ServiceIPL();
        scanner = new Scanner(System.in);
    }*/

    //Start the IPL app.
    public void startIPL(String team) {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println ("=== === === === === === === === === === === === === " );
            System.out.println("IPL Management System");
            System.out.println ("=== === === === === === === === === === === === === " );
            System.out.println("1. View All Players");
            System.out.println("2. Add New Player");
            System.out.println("3. Find Player by Jersey Number");
            System.out.println("4. View All Team Players");
            System.out.println("5. Find Players by Team Name");
            System.out.println("6. Find Player by Highest Runs");
            System.out.println("7. Find Player by Lowest Runs");
            System.out.println("8. Find Player by Highest Wicket");
            System.out.println("9. Find Player by Lowest Wicket");
            System.out.println("10. Find Player by Highest Strike Rate");
            System.out.println("11. Find Player by Lowest Strike Rate");
            System.out.println("12. Exit");
            System.out.println ("=== === === === === === === === === === === === === " );
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllPlayers();
                    break;
                case 2:
                    addNewPlayer();
                    break;
                case 3:
                    findPlayerByJerseyNo();
                    break;
                case 4:
                    displayAllPlayersByTeam();
                    break;
                case 5:
                    displayPlayersByTeam(team);
                    break;
                case 6:
                    findPlayerByJerseyNo();
                    break;
                case 7:
                    findPlayerByJerseyNo();
                    break;
                case 8:
                    findPlayerByJerseyNo();
                    break;
                case 9:
                    findPlayerByJerseyNo();
                    break;
                case 10:
                    findPlayerByJerseyNo();
                    break;
                case 11:
                    findPlayerByJerseyNo();
                    break;
                case 12:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    //Method to view all players.
    private void viewAllPlayers() {
        service = new ServiceIPL();
        List<PlayersIPL> players = service.fetchAllPlayers();
        for (PlayersIPL player : players) {
            System.out.println(player);
        }
    }

    //Method to add a new player.
    private void addNewPlayer() {
        scanner = new Scanner(System.in);
        System.out.println("Enter Jersey No: ");
        int jerseyNo = scanner.nextInt();
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Runs: ");
        int runs = scanner.nextInt();
        System.out.println("Enter Wickets: ");
        int wickets = scanner.nextInt();
        System.out.println("Enter Strike Rate: ");
        double strikeRate = scanner.nextDouble();

        PlayersIPL newPlayer = new PlayersIPL(jerseyNo, name, runs, wickets, strikeRate);
        service.registerPlayer(newPlayer);
        System.out.println("Player added successfully!");
    }

    // Method to find player by jersey number
    private void findPlayerByJerseyNo() {
        scanner = new Scanner(System.in);
        System.out.println("Enter Jersey No: ");
        int jerseyNo = scanner.nextInt();
        PlayersIPL player = service.findPlayerByJerseyNo(jerseyNo);

        if (player != null) {
            System.out.println(player);
        } else {
            System.out.println("Player not found!");
        }
    }

    // Method to print all players by team
    public void displayAllPlayersByTeam() {
        HashMap<String, List<PlayersIPL>> playersByTeam = service.getAllPlayersByTeam();
        for (String team : playersByTeam.keySet()) {
            System.out.println("Team: " + team);
            for (PlayersIPL player : playersByTeam.get(team)) {
                System.out.println(player);
            }
        }
    }

    // Method to display players for a specific team
    public void displayPlayersByTeam(String team) {
        List<PlayersIPL> players = service.getPlayersByTeam(team);
        if (players.isEmpty()) {
            System.out.println("No players found for team " + team);
        } else {
            System.out.println("Team: " + team);
            for (PlayersIPL player : players) {
                System.out.println(player);
            }
        }
    }
}
