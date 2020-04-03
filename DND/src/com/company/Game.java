package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Game single_instance = null;
    static int time = 0;
    private Map map;
    private Campaign campaign;

    Game() {
        System.out.println("Welcome traveller! You will embark on a journey to find the secret treasure.\n"
                + "Press enter to start!");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        campaign = new Campaign();
        System.out.println("The following people are your comrades. Guide them to victory");
        campaign.showInfo();
        System.out.println("Press enter to continue!");
        scanner.nextLine();
        System.out.println("This is your map. Your position is marked by the C character. You must go to the T spot (T for Treasure). You might encounter some enemies on your way, so be ready!");
        map = new Map(10, 20, campaign);

        int[] poz=campaign.getPoz();
        while(poz[0]!=map.getLength()||poz[1]!=map.getWidth())
        {
            map.show();
            map.move();
        }
        if(poz[0]==map.getLength()&&poz[1]==map.getWidth())
            System.out.println("Congratulations! You have found the treasure.");
            System.exit(0);
    }

    static void endGame(){
            System.out.println("Game Over!");
            System.exit(0);
    }

    static void incrementTime() {
        time += 1;
    }


}
