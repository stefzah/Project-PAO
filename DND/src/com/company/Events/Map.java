package com.company.Events;

import com.company.App;
import com.company.MapGUI;
import com.company.Teams.Campaign;
import com.company.Teams.Group;
import com.company.Teams.Mob;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {
    static private int length;
    static private int width;
    public static Group[][] place;
    public static Campaign campaign;

    public Map(int length, int width) {
        Map.length = length;
        Map.width = width;
        place = new Group[length + 2][width + 2];
        int ct = 0;
        while (ct < 10) {
            int l, c;
            Random rand = new Random();
            l = rand.nextInt(length - 1) + 2;
            c = rand.nextInt(width - 1) + 2;
            while (place[l][c] != null) {
                l = rand.nextInt(length - 1) + 2;
                c = rand.nextInt(width - 1) + 2;
            }
            place[l][c] = new Mob();
            place[l][c].setPoz(l, c);
            ct++;
        }
        final MapGUI[] app = new MapGUI[1];
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app[0] = new MapGUI();
                app[0].setVisible(true);
            }
        });

    }

    public Map(ArrayList<String> map) {
        length = map.size() - 2;
        width = map.get(0).length() - 2;
        place = new Group[length + 2][width + 2];
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                if (map.get(i).charAt(j) == 'M') place[i][j] = new Mob();
                if (map.get(i).charAt(j) == 'C') {
                    campaign = new Campaign(i, j);
                    place[i][j] = campaign;
                }
            }
        }
        final MapGUI[] app = new MapGUI[1];
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app[0] = new MapGUI();
                app[0].setVisible(true);
            }
        });

    }


    public static String show() {
        StringBuilder str = new StringBuilder();
        //str.append("Turn: ").append(Game.time).append("\n");
        for (int i = 0; i <= length + 1; i++) {
            for (int j = 0; j <= width + 1; j++) {
                if (place[i][j] != null) {
                    if (place[i][j].getClass().getSimpleName().equals("Mob")) str.append("M");
                    else if (place[i][j].getClass().getSimpleName().equals("Campaign")) str.append("C");
                } else if (i == length && j == width) str.append("T");
                else if (i != 0 && j != 0 && i != length + 1 && j != width + 1) str.append(".");
                else str.append("#");
            }
            //str.append("\n");
        }
        return str.toString();
    }
    public static void checkForTreasure(){
        int[] poz = campaign.getPoz();
        if (poz[0] == getLength() && poz[1] == getWidth()) {
            System.out.println("Congratulations! You have found the treasure.");
            System.exit(0);
        }
    }

    static public void goNorth(){
        int[] poz = campaign.getPoz();
        if (poz[0] > 1) {
            if (place[poz[0] - 1][poz[1]] != null) {
                Battle battle = new Battle(campaign, place[poz[0] - 1][poz[1]]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goNorth();
            checkForTreasure();
        }
    }

    static public void goEast(){
        int[] poz = campaign.getPoz();
        if (poz[1] < width) {
            if (place[poz[0]][poz[1] + 1] != null) {
                Battle battle = new Battle(campaign, place[poz[0]][poz[1] + 1]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goEast();
            checkForTreasure();
        }
    }
    static public void goSouth(){
        int[] poz = campaign.getPoz();
        if (poz[0] < length) {
            if (place[poz[0] + 1][poz[1]] != null) {
                Battle battle = new Battle(campaign, place[poz[0] + 1][poz[1]]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goSouth();
            checkForTreasure();
        }
    }
    static public void goWest(){
        int[] poz = campaign.getPoz();
        if (poz[1] > 1) {
            if (place[poz[0]][poz[1] - 1] != null) {
                Battle battle = new Battle(campaign, place[poz[0]][poz[1] - 1]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goWest();
            checkForTreasure();
        }
    }

    public static void setCampaign(Campaign campaign) {
        Map.campaign = campaign;

    }

    static public int getLength() {
        return length;
    }

    public void setLength(int length) {
        Map.length = length;
    }

    static public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        Map.width = width;
    }

}
