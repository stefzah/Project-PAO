package com.company.Teams;

import com.company.Creatures.Creature;
import com.company.Events.Logger;
import com.company.Events.Map;

import java.io.IOException;
import java.util.*;

abstract public class Group {
    protected int nr_member;
    protected SortedSet<Creature> members = new TreeSet<>();
    protected int[] poz = new int[2];
    boolean turn = true;

    public void showInfo() {
        System.out.println("This group has " + this.nr_member + " members:");
        for(Creature C : members){
            C.showInfo();
        }
        Logger.log("Group::showInfo");
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

        Logger.log("Group::goNorth");
    }

    public void goSouth() {
        Map.place[poz[0]][poz[1]] = null;
        poz[0]++;
        Map.place[poz[0]][poz[1]] = this;
        Logger.log("Group::goSouth");
    }

    public void goEast() {
        Map.place[poz[0]][poz[1]] = null;
        poz[1]++;
        Map.place[poz[0]][poz[1]] = this;
        Logger.log("Group::goEast");
    }

    public void goWest() {
        Map.place[poz[0]][poz[1]] = null;
        poz[1]--;
        Map.place[poz[0]][poz[1]] = this;
        Logger.log("Group::goWest");
    }

    public int[] getPoz() {
        return poz;
    }
}
