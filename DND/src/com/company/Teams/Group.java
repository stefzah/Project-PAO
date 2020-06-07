package com.company.Teams;

import com.company.Creatures.Creature;
import com.company.Events.Logger;
import com.company.Events.Map;

import java.io.IOException;
import java.util.*;

abstract public class Group {
    public int nr_member;
    public ArrayList<Creature> members = new ArrayList<>();
    protected int[] poz = new int[2];
    boolean turn = true;

    public String showInfo() {
        StringBuilder str = new StringBuilder();
        str.append("This group has ").append(this.nr_member).append(" members: \n");
        for(Creature C : members){
            str.append(C.showInfo()).append("\n");
        }
        Logger.log("Group::showInfo");
        return str.toString();
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
