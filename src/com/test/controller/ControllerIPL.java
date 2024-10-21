package com.test.controller;

import com.test.entity.PlayersIPL;
import com.test.service.ServiceIPL;
import java.util.List;
import java.util.Scanner;

public class ControllerIPL {
    private ServiceIPL service;
    private Scanner scanner;

    public ControllerIPL() {
        service = new ServiceIPL();
        scanner = new Scanner(System.in);
    }

    // Start the IPL app
    public void startIPL() {
        while (true) {
            System.out.println("===== IPL Management System =====");
            System.out.println("1. View All Players");
            System.out.println("2. Add New Player");
            System.out.println("3. Find Player by Jersey Number");
            System.out.println("4. Exit");
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
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to view all players
    private void viewAllPlayers() {
        List<PlayersIPL> players = service.fetchAllPlayers();
        for (PlayersIPL player : players) {
            System.out.println(player);
        }
    }

    // Method to add a new player
    private void addNewPlayer() {
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
        System.out.println("Enter Jersey No: ");
        int jerseyNo = scanner.nextInt();
        PlayersIPL player = service.findPlayerByJerseyNo(jerseyNo);

        if (player != null) {
            System.out.println(player);
        } else {
            System.out.println("Player not found!");
        }
    }
}
