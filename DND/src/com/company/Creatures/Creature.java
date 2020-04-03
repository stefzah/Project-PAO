package com.company.Creatures;


import java.util.*;
import com.company.Effects.*;

public abstract class Creature implements Comparable<Creature>{
    private String name;
    private int max_hp;
    private int hp;

    private int max_dmg;
    private int dmg;

    private int max_armor;
    private int armor;

    private int spellslots;
    private int dex;
    private int vgr;
    private int str;
    private ArrayList<Effect> effects;
//    private ArrayList<Spells> spells;

    public Creature(String name){
        this.name = name;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void heal(int hp){
        this.hp += hp;
        if(this.hp>max_hp) this.hp = max_hp;
    }

    public void hurt(int hp){
        this.hp -= hp;
    }

    public int getSpellslots() {
        return spellslots;
    }

    public void setSpellslots(int spellslots) {
        this.spellslots = spellslots;
    }

    public Effect getEffect(int x) {
        return effects.get(x);
    }

    public void addEffect(Effect effect) {

        this.effects.add(effect);
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getVgr() {
        return vgr;
    }

    public void setVgr(int vgr) {
        this.vgr = vgr;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getMax_armor() {
        return max_armor;
    }

    public void setMax_armor(int max_armor) {
        this.max_armor = max_armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMax_dmg() {
        return max_dmg;
    }

    public void setMax_dmg(int max_dmg) {
        this.max_dmg = max_dmg;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void attack(Creature C) {

        Random RN = new Random();
        int hit;
        hit = RN.nextInt(20) + 1;
        if (hit >= C.armor) {
            int dmg = RN.nextInt(20) + 1 + this.dmg;
        }
    }

    abstract public void levelUp();

    public boolean isAlive() {
        return hp > 0;
    }

    public void showInfo(){
        System.out.println("Name: "+name+", Class: "+this.getClass().getSimpleName()+", HP:"+hp+", DMG:"+dmg+ ", Spellslots:"+spellslots+", STR:"+str+", VGR:"+vgr+", DEX:"+dex);
    }

    @Override
    public int compareTo(Creature C){
       return Integer.compare(this.hp, C.hp);
    }

}
