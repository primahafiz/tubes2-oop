package com.aetherwars.model.Spells;

import com.aetherwars.model.Type;

public class PtnSpell extends Spell {
    private double attack;
    private double hp;

    public PtnSpell(int id, String name, String desc, String path, int mana, int duration, double attack, double hp){
        super(id, name, desc, path, mana, duration);
        this.attack = attack;
        this.hp = hp;
    }

    public double getPtnAttack(){
        return this.attack;
    }

    public double getPtnHp(){
        return this.hp;
    }

    public void swapAttackHp(){
        double temp = this.attack;
        this.attack = this.hp;
        this.hp = temp;
    }

    public void setPtnHp(double hp){
        this.hp = hp;
    }

    public void printCardInfo(){
        super.printCardInfo();
        System.out.println("Ptn Attack: " + getPtnAttack());
        System.out.println("Ptn Attack: " + getPtnHp());
    }

    public Type getCardType() {
        return Type.PTN;
    }
}
