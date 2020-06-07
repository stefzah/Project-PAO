package com.company.Events;

import com.company.BattleGUI;
import com.company.MapGUI;
import com.company.Teams.Group;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Battle {
    static public Group Allies;
    static public Group Enemies;
    static public boolean win;

    public Battle(Group Allies, Group Enemies) {
        win = true;
        final BattleGUI[] app = new BattleGUI[1];
        Battle.Allies = Allies;
        Battle.Enemies = Enemies;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app[0] = new BattleGUI();
                app[0].setVisible(true);
            }
        });



    }

    static public String[] showInfo() {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        String[] str = new String[2];
        str1.append("Your team:\n");
        str1.append(Allies.showInfo());
        str2.append("The enemy:\n");
        str2.append(Enemies.showInfo());
        Logger.log("Battle::showInfo");
        str[0] = str1.toString();
        str[1] = str2.toString();
        return str;
    }

    static public void surrender() {
        Logger.log("Battle:surrender");
        System.out.println("You were captured by the goblins :(");
        win = false;
        System.exit(0);
    }

    static public void fight() {
        Logger.log("Battle:fight");
        win = true;
        DataExtractor csvScanner = DataExtractor.getInstance();
        csvScanner.deleteCompanion(0);
        Allies.members.remove(Allies.members.get(0));
        Allies.nr_member--;
        if (csvScanner.getCompanionCount()==0){
            System.out.println("You were defeated by the goblins :(");
            win = false;
            System.exit(0);
        }

    }

    public boolean isWin() {
        return win;
    }
}
