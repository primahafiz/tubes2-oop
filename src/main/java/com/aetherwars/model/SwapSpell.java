package com.aetherwars.model;

public class SwapSpell extends Spell implements Info {
    public SwapSpell(int id, String name, String desc, String path, int mana, int duration){
        super(id, name, desc, path, mana, duration);
    }


    @Override
    public Type getCardType() {
        return Type.SWAP;
    }
}
