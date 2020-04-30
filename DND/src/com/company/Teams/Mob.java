package com.company.Teams;

import com.company.Creatures.*;
import com.company.Teams.Group;

public class Mob extends Group {
    public Mob() {
        nr_member = 3;
        members.add(new Goblin());
        members.add(new Goblin());
        members.add(new Goblin());
    }
}
