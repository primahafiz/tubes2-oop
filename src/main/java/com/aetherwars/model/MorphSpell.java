package com.aetherwars.model;

public class MorphSpell extends Spell {
    private int targetId;

    public MorphSpell(int id, String name, String desc, String path, int mana, int duration, int targetId){
        super(id, name, desc, path, mana, duration);
        this.targetId = targetId;
    }

    public int getTargetId(){
        return this.targetId;
    }

    public void printCardInfo(){
        super.printCardInfo();
        System.out.println("TargetId: " + getTargetId());
    }

    public Type getCardType() {
        return Type.MORPH;
    }
}
