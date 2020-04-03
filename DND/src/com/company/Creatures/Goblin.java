package com.company.Creatures;

public class Goblin extends Creature{
    public Goblin() {

        super("Goblin");

        this.setMax_hp(8);
        this.setHp(8);

        this.setMax_armor(10);
        this.setArmor(10);

        this.setMax_dmg(6);
        this.setDmg(6);

        this.setSpellslots(0);
        this.setStr(8);
        this.setVgr(8);
        this.setDex(6);
    }

    public void levelUp() {
    }

}
