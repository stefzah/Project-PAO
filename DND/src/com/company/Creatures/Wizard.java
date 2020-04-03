package com.company.Creatures;

public class Wizard extends Creature {
    public Wizard() {

        super("Azimuth");

        this.setMax_hp(12);
        this.setHp(12);

        this.setMax_armor(12);
        this.setArmor(12);

        this.setMax_dmg(8);
        this.setDmg(8);

        this.setSpellslots(5);
        this.setStr(11);
        this.setVgr(11);
        this.setDex(11);
    }

    public void levelUp() {
        this.setMax_hp(this.getMax_hp() + 1);
        this.setHp(this.getMax_hp());

        this.setVgr(this.getVgr() + 1);

        this.setMax_dmg(this.getMax_dmg() + 1);
        this.setDmg(this.getMax_dmg());
    }

}
