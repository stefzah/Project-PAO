package com.company;

import com.company.Creatures.Creature;
import com.company.Creatures.Ranger;
import com.company.Creatures.Warrior;
import com.company.Creatures.Wizard;

public class Campaign extends Group {
    public Campaign() {
        nr_member = 3;
        members.add(new Ranger());
        members.add(new Warrior());
        members.add(new Wizard());
    }
}
