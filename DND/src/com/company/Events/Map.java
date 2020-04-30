package com.company.Events;

import com.company.Teams.Campaign;
import com.company.Teams.Group;
import com.company.Teams.Mob;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {
    private int length;
    private int width;
    public static Group[][] place;
    public static Campaign campaign;

    public Map(int length, int width) {
        this.length = length;
        this.width = width;
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
    }

    public Map(ArrayList<String> map) {
        this.length = map.size() - 2;
        this.width = map.get(0).length() - 2;
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
    }


    public void show() {
        System.out.println("Turn: " + Game.time);
        for (int i = 0; i <= length + 1; i++) {
            for (int j = 0; j <= width + 1; j++) {
                if (place[i][j] != null) {
                    if (place[i][j].getClass().getSimpleName().equals("Mob")) System.out.print("M");
                    else if (place[i][j].getClass().getSimpleName().equals("Campaign")) System.out.print("C");
                } else if (i == length && j == width) System.out.print("T");
                else if (i != 0 && j != 0 && i != length + 1 && j != width + 1) System.out.print(".");
                else System.out.print("#");
            }
            System.out.print("\n");
        }
    }

    public void move() {
        Game.incrementTime();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an action:");
        System.out.println("8 - Go North");
        System.out.println("6 - Go East");
        System.out.println("2 - Go South");
        System.out.println("4 - Go West");
        System.out.println("0 - Rest");
        System.out.println("7 - Show Info");
        System.out.println("9 - Save Game");
        System.out.println("Type a valid input then press enter: ");
        int command = scanner.nextInt();
        int[] poz = campaign.getPoz();

        if (command == 8 && poz[0] > 1) {
            if (place[poz[0] - 1][poz[1]] != null) {
                Battle battle = new Battle(campaign, place[poz[0] - 1][poz[1]]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goNorth();
        } else if (command == 6 && poz[1] < width) {
            if (place[poz[0]][poz[1] + 1] != null) {
                Battle battle = new Battle(campaign, place[poz[0]][poz[1] + 1]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goEast();
        } else if (command == 2 && poz[0] < length) {
            if (place[poz[0] + 1][poz[1]] != null) {
                Battle battle = new Battle(campaign, place[poz[0] + 1][poz[1]]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goSouth();
        } else if (command == 4 && poz[1] > 1) {
            if (place[poz[0]][poz[1] - 1] != null) {
                Battle battle = new Battle(campaign, place[poz[0]][poz[1] - 1]);
                if (!battle.isWin()) Game.endGame();
            }
            campaign.goWest();
        } else if (command == 7) campaign.showInfo();
        else if (command == 9) {
            DataExtractor csvScanner = DataExtractor.getInstance();
            csvScanner.loadMapData(place);
        }
    }

    public static void setCampaign(Campaign campaign) {
        Map.campaign = campaign;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
