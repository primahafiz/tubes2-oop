package com.aetherwars.model;

public class PtnSpell extends Spell implements Info {
    private int attack;
    private int hp;

    public PtnSpell(int id, String name, String desc, String path, int mana, int duration, int attack, int hp){
        super(id, name, desc, path, mana, duration);
        this.attack = attack;
        this.hp = hp;
    }

    public int getSpellAttack(){
        return this.attack;
    }

    public int getHp(){
        return this.hp;
    }

    @Override
    public Type getCardType() {
        return Type.PTN;
    }
}
