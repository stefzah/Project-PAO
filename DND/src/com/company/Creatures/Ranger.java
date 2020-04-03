package com.company.Creatures;

public class Ranger extends Creature {
    public Ranger() {

        super("Elion");

        this.setMax_hp(10);
        this.setHp(10);

        this.setMax_armor(15);
        this.setArmor(15);

        this.setMax_dmg(10);
        this.setDmg(10);

        this.setSpellslots(3);
        this.setStr(9);
        this.setVgr(10);
        this.setDex(14);
    }

    public void levelUp() {
        this.setMax_hp(this.getMax_hp() + 1);
        this.setHp(this.getMax_hp());

        this.setMax_armor(this.getMax_armor()+1);
        this.setArmor(this.getMax_armor());

        this.setDex(this.getDex() + 1);

        this.setMax_dmg(this.getMax_dmg() + 1);
        this.setDmg(this.getMax_dmg());
    }
}
