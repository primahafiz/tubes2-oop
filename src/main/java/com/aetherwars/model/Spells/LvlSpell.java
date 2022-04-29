package com.aetherwars.model.Spells;

import com.aetherwars.model.Type;
import com.aetherwars.model.Characters.Character;

// import com.aetherwars.model.Character;

public class LvlSpell extends Spell {
    private int add;

    public LvlSpell(int id, String name, String desc, String path, int mana, int duration, int add){
        super(id, name, desc, path, mana, duration);
        this.add = add;
    }

    public int getMana(Character c){
        return (int) c.getLevel() / 2;
    }

    public int getAdd(){
        return this.add;
    }

    public void printCardInfo(){
        super.printCardInfo();
        System.out.println("Add: " + getAdd());
    }

    public Type getCardType() {
        return Type.LVL;
    }
}
