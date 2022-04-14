package com.aetherwars.model;

public class MorphSpell extends Spell {
    private int attackId;

    public MorphSpell(int id, String name, String desc, String path, int mana, int duration, int attackId){
        super(id, name, desc, path, mana, duration);
        this.attackId = attackId;
    }

    public int getAttackId(){
        return this.attackId;
    }
}
