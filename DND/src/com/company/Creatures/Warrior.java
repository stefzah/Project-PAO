package com.company.Creatures;

import com.company.Events.DataExtractor;

public class Warrior extends Creature {
    public Warrior(String name) {

        super(name);

        DataExtractor csvScanner = DataExtractor.getInstance();

        this.setMax_hp(csvScanner.getClassInfo(getClass().getSimpleName(), "Max_hp"));
        this.setHp(this.getMax_hp());

        this.setMax_armor(csvScanner.getClassInfo(getClass().getSimpleName(), "Max_armor"));
        this.setArmor(this.getMax_armor());

        this.setMax_dmg(csvScanner.getClassInfo(getClass().getSimpleName(), "Max_dmg"));
        this.setDmg(this.getMax_dmg());

        this.setSpellslots(csvScanner.getClassInfo(getClass().getSimpleName(), "Spellslots"));
        this.setStr(csvScanner.getClassInfo(getClass().getSimpleName(), "STR"));
        this.setVgr(csvScanner.getClassInfo(getClass().getSimpleName(), "VGR"));
        this.setDex(csvScanner.getClassInfo(getClass().getSimpleName(), "DEX"));
    }

    public void levelUp() {
        this.setMax_hp(this.getMax_hp() + 2);
        this.setHp(this.getMax_hp());

        this.setVgr(this.getVgr() + 1);

        this.setMax_dmg(this.getMax_dmg() + 2);
        this.setDmg(this.getMax_dmg());
    }

}
