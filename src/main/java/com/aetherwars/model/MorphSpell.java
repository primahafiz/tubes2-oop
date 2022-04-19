package com.aetherwars.model;

public class MorphSpell extends Spell implements Info{
    private int targetId;

    public MorphSpell(int id, String name, String desc, String path, int mana, int duration, int targetId){
        super(id, name, desc, path, mana, duration);
        this.targetId = targetId;
    }

    public int getTargetId(){
        return this.targetId;
    }

    @Override
    public Type getCardType() {
        return Type.MORPH;
    }
}
