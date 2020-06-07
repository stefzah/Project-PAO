package com.company.Teams;

import com.company.Creatures.Goblin;

public class Mob extends Group {
    public Mob() {
        nr_member = 3;
        for(int i=0;i<nr_member;i++) {
            members.add(new Goblin("Goblin"+i));
        }
    }
}
