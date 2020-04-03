package com.company.Effects;

import com.company.Creatures.*;


public class Effect {
    private Creature target;
    private String type;
    private int value;
    private int duration;

    public boolean isActive() {
        return duration > 0;
    }

    private void execute() {
        if (type.equals("poison")) {
            target.hurt(value);
        }

        if (type.equals("regen")) {
            target.heal(value);
        }

        if (type.equals("weaken")) {
            target.setArmor(target.getMax_armor() - 5);
        }

        duration--;
    }

    private void restore() {
        if (type.equals("weaken")) {
            target.setArmor(target.getMax_armor() + 5);
        }
    }
}


