package com.company;

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
    }

    public void showInfo() {
        System.out.println("Your team:");
        Allies.showInfo();
        System.out.println("The enemy:");
        Enemies.showInfo();
        showOptions();
    }

    public void surrender() {
        System.out.println("You were captured by the goblins :(");
        win = false;
    }

    public void fight(){
        win = true;
    }

    public boolean isWin() {
        return win;
    }
}
