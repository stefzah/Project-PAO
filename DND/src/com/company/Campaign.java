package com.company;

import com.company.Creatures.Creature;
import com.company.Creatures.Ranger;
import com.company.Creatures.Warrior;
import com.company.Creatures.Wizard;

public class Campaign extends Group {
    public Campaign() {
        nr_member = 3;
        members = new Creature[3];
        members[0] = new Ranger();
        members[1] = new Warrior();
        members[2] = new Wizard();
    }
}
