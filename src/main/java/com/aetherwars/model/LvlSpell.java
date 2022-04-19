package com.aetherwars.model;

public class LvlSpell extends Spell {
    private int add;

    public LvlSpell(int id, String name, String desc, String path, int mana, int duration, int add){
        super(id, name, desc, path, mana, duration);
        this.add = add;
    }

    public int getAdd(){
        return this.add;
    }

    public Type getCardType() {
        return Type.LVL;
    }
}
