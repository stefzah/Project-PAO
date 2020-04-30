package com.company.Events;

import com.company.Teams.Group;

import java.util.Scanner;

public class Battle {
    private Group Allies;
    private Group Enemies;
    private boolean win;

    public Battle(Group Allies, Group Enemies) {
        this.Allies = Allies;
        this.Enemies = Enemies;
        System.out.println("You have encountered an angry mob!");
        showOptions();
    }

    public void showOptions() {
        System.out.println("Choose your next move:");
        System.out.println("0 - Battle Info");
        System.out.println("1 - Surrender");
        System.out.println("2 - Fight");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if (option == 0) showInfo();
        if (option == 1) surrender();
        if (option == 2) fight();
        Logger.log("Battle:showOptions");
    }

    public void showInfo() {
        System.out.println("Your team:");
        Allies.showInfo();
        System.out.println("The enemy:");
        Enemies.showInfo();
        showOptions();
        Logger.log("Battle::showInfo");
    }

    public void surrender() {
        System.out.println("You were captured by the goblins :(");
        win = false;
        Logger.log("Battle:surrender");
    }

    public void fight(){
        win = true;
        Logger.log("Battle:fight");
    }

    public boolean isWin() {
        return win;
    }
}
