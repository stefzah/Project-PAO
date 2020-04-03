package com.company.Creatures;

public class Warrior extends Creature {
    public Warrior() {

        super("Warrenus");

        this.setMax_hp(15);
        this.setHp(15);

        this.setMax_armor(12);
        this.setArmor(12);

        this.setMax_dmg(12);
        this.setDmg(12);

        this.setSpellslots(2);
        this.setStr(12);
        this.setVgr(12);
        this.setDex(10);
    }

    public void levelUp() {
        this.setMax_hp(this.getMax_hp() + 2);
        this.setHp(this.getMax_hp());

        this.setVgr(this.getVgr() + 1);

        this.setMax_dmg(this.getMax_dmg() + 2);
        this.setDmg(this.getMax_dmg());
    }

}
