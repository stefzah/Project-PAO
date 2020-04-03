package com.company;

import com.company.Creatures.*;

public class Mob extends Group {
    public Mob() {
        nr_member = 3;
        members = new Creature[3];
        members[0] = new Goblin();
        members[1] = new Goblin();
        members[2] = new Goblin();
    }
}
