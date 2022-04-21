package com.aetherwars.model;

public class PtnSpell extends Spell {
    private int attack;
    private int hp;

    public PtnSpell(int id, String name, String desc, String path, int mana, int duration, int attack, int hp){
        super(id, name, desc, path, mana, duration);
        this.attack = attack;
        this.hp = hp;
    }

    public int getPtnAttack(){
        return this.attack;
    }

    public int getPtnHp(){
        return this.hp;
    }

    public void swapAttackHp(){
        int temp = this.attack;
        this.attack = this.hp;
        this.hp = temp;
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
