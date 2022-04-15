package com.aetherwars.model;

public class Character extends Card{
  private Type type;
  private int attack;
  private int health;
  private int attackUp;
  private int healthUp;
  private int exp;
  private int level;


  public Character(int id, String name, String desc, String path, int mana, Type type, int attack, int health, int attackUp, int healthUp) {
    super(id, name, desc, path, mana);
    this.type = type;
    this.attack = attack;
    this.health = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
    this.exp = 0;
    this.level = 1;
  }

  // getter

  public Type getType(){
    return this.type;
  }

  public int getAttack(){
    return this.attack;
  }

  public int getHealth(){
    return this.health;
  }

  public int getAttackUp(){
    return this.attackUp;
  }

  public int getHealthUp(){
    return this.healthUp;
  }

  public int getExp(){
    return this.exp;
  }

  public int getLevel(){
    return this.level;
  }

  private boolean isStrongerThan(Character c){
    boolean stronger = false;

    if ((this.getType() == Type.END && c.getType() == Type.NETHER) ||
        (this.getType() == Type.NETHER && c.getType() == Type.OVERWORLD) ||
        (this.getType() == Type.OVERWORLD && c.getType() == Type.END)) {
      stronger = true;
    }

    return stronger;
  }
  private boolean isEqual(Character c){
    return this.getType() == c.getType();
  }

  public double getDamage(Character c){
    double damage;

    if (this.isStrongerThan(c)){
      damage = 2 * attack;
    } else if (this.isEqual(c)) {
      damage = attack;
    } else {
      damage =  0.5 * attack;
    }

    return damage;
  }

  public void addExp(int exp){
    this.exp += exp;
  }

  public void setHealth(int health){
    this.health = health;
  }

  public boolean isDead(){
    return this.health == 0;
  }


  /*
  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
  */

}
