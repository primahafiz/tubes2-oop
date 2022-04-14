package com.aetherwars.model;

public class Character extends Card{
  private Type type;
  private int attack;
  private int health;
  private int attackUp;
  private int healthUp;


  public Character(int id, String name, String desc, String path, int mana, Type type, int attack, int health, int attackUp, int healthUp) {
    super(id, name, desc, path, mana);
    this.type = type;
    this.attack = attack;
    this.health = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
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

  /*
  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
  */

}
