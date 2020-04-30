package com.company.Events;

import com.company.Teams.Campaign;

import java.util.Scanner;

public class Game {

    private static Game single_instance = null;
    static int time = 0;
    private Map map;
    private Campaign campaign;

    public Game() {
        DataExtractor csvScanner = DataExtractor.getInstance();
        Logger.clearLogger();
        Logger.log("Game");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome traveller! You will embark on a journey to find the secret treasure.\n"
                + "Press enter to start!");
        scanner.nextLine();


        int option = -1;
        while (option != 1 && option != 0) {
            System.out.println("Do you wish to continue from the previous game, or start a new one?\n"
                    + "0 - Continue\n" + "1 - New Game\n" + "Type a valid option and press enter.");
            option = scanner.nextInt();
            if (option == 1) {
                map = new Map(10, 10);
                campaign = new Campaign(1, 1);
                System.out.println("The following people are your comrades. Guide them to victory");
                campaign.showInfo();
                System.out.println("Press enter to continue!");
                scanner.nextLine();
                System.out.println("This is your map. Your position is marked by the C character. You must go to the T spot (T for Treasure). You might encounter some enemies on your way, so be ready!");
            }
            else if (option == 0 && csvScanner.fileExists("Map.csv")) {
                map = new Map(csvScanner.getMapInfo());
                campaign = Map.campaign;
            }
            else if (option == 0){
                System.out.println("There is no previous save.");
                option = -1;
            }
        }


        int[] poz = campaign.getPoz();
        while (poz[0] != map.getLength() || poz[1] != map.getWidth()) {
            map.show();
            map.move();
        }
        if (poz[0] == map.getLength() && poz[1] == map.getWidth())
            System.out.println("Congratulations! You have found the treasure.");
        System.exit(0);
    }

    static void endGame() {
        System.out.println("Game Over!");
        System.exit(0);
    }

    static void incrementTime() {
        time += 1;
    }


}
