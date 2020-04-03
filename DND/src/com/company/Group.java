package com.company;

import com.company.Creatures.Creature;
import javafx.util.Pair;

import java.util.Random;

abstract public class Group {
    protected int nr_member;
    protected Creature[] members;
    protected int[] poz = new int[2];
    boolean turn = true;

    public void showInfo() {
        System.out.println("This group has " + this.nr_member + " members:");
        for (int i = 0; i < nr_member; i++)
            members[i].showInfo();
    }

    public void setPoz(int x, int y) {
        poz[0] = x;
        poz[1] = y;
        Map.place[poz[0]][poz[1]] = this;
    }

    public void goNorth() {
        Map.place[poz[0]][poz[1]] = null;
        poz[0]--;
        Map.place[poz[0]][poz[1]] = this;
    }

    public void goSouth() {
        Map.place[poz[0]][poz[1]] = null;
        poz[0]++;
        Map.place[poz[0]][poz[1]] = this;
    }

    public void goEast() {
        Map.place[poz[0]][poz[1]] = null;
        poz[1]++;
        Map.place[poz[0]][poz[1]] = this;
    }

    public void goWest() {
        Map.place[poz[0]][poz[1]] = null;
        poz[1]--;
        Map.place[poz[0]][poz[1]] = this;
    }

    public int[] getPoz() {
        return poz;
    }
}
