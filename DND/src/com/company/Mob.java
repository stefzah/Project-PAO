package com.company;

import com.company.Creatures.*;

public class Mob extends Group {
    public Mob() {
        nr_member = 3;
        members.add(new Goblin());
        members.add(new Goblin());
        members.add(new Goblin());
    }
}
