package com.aetherwars.model.Spells;

import com.aetherwars.model.Type;

public class SwapSpell extends Spell {
    public SwapSpell(int id, String name, String desc, String path, int mana, int duration){
        super(id, name, desc, path, mana, duration);
    }

    public void printCardInfo(){
        super.printCardInfo();
    }

    public Type getCardType() {
        return Type.SWAP;
    }
}
