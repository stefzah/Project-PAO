package com.company.Events;

import com.company.App;
import com.company.Teams.Campaign;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Game {

    private static Game single_instance = null;
    static int time = 0;
    static public Map map;
    static public Campaign campaign;

    public Game() {
        DataExtractor csvScanner = DataExtractor.getInstance();
        Logger.clearLogger();
        Logger.log("Game");

        final App[] app = new App[1];
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    app[0] = new App();
                    app[0].setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    static public void newGame() {
        Logger.log("Game::newGame");
        map = new Map(20, 20);
        campaign = new Campaign(1, 1 ,3);
        startGame();

    }
    static public void continueGame() {
        Logger.log("Game::continueGame");
        DataExtractor csvScanner = DataExtractor.getInstance();
        map = new Map(csvScanner.getMapInfo());
        campaign = Map.campaign;
        startGame();
    }
    static void endGame() {
        System.out.println("Game Over!");
        System.exit(0);
    }
    static void startGame(){

            int[] poz = campaign.getPoz();


            if (poz[0] == map.getLength() && poz[1] == map.getWidth())
                System.out.println("Congratulations! You have found the treasure.");


    }
    static void incrementTime() {
        time += 1;
    }


}
