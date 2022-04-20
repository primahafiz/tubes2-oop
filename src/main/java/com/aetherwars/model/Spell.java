package com.aetherwars.model;

abstract class Spell extends Card{
    protected int duration;

    public Spell (int id, String name, String desc, String path, int mana, int duration){
        super(id, name, desc, path, mana);
        this.duration = duration;
    }

    // getter

    public int getDuration() {
        return this.duration;
    }

    public void minusDur(){
        if (this.duration > 0){
            this.duration -= 1;
        }
    }

    abstract Type getCardType();
}
