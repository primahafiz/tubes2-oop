package com.aetherwars.model;

import java.util.ArrayList;
import java.util.List;

public class Character extends Card implements Info {
  private Type type;
  private int attack;
  private int health;
  private int attackUp;
  private int healthUp;
  private int exp;
  private int level;
  private boolean hasAttack;
  private List<Spell> spellList;


  public Character(int id, String name, String desc, String path, int mana, Type type, int attack, int health, int attackUp, int healthUp) {
    super(id, name, desc, path, mana);
    this.type = type;
    this.attack = attack;
    this.health = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
    this.exp = 0;
    this.level = 1;
    this.hasAttack = false;
    this.spellList = new ArrayList<>(); //(id1, durasi), (id2, durasi)
    // list of health (id1, health1), (id2, health2) 1 2 3        1 2 4   123
    // list of attack 1 2                                         1 2 3   124
    // ngambil dr yg health positif
    // swap duration
    // list of attack swap, list of health swap
  }

  // getter

  public Type getType(){
    return this.type;
  }

  public int getAttack(){
    return this.attack;
  } // ngambil dr list of attack, list of swap attack, attack

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

  public boolean hasAttack(){
    return this.hasAttack;
  }

  public void updateDur(int turn) {} // ngeupdate duration dari spell yang temp, ngubah this.mana

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

  public void levelUp(int lvl) {
    this.level += lvl;
  }

  public boolean isDead(){
    return this.health == 0;
  }

  public boolean isCharacter() { return true;}

  public void addSpell() {}

  public void LvlEffect(LvlSpell s){
    this.exp = 0;
    int predictLvl = s.getAdd() + this.getLevel();
    if (predictLvl >= 1 && predictLvl <= 10){
      this.level = predictLvl;
    } else if (predictLvl > 10){
      this.level = 10;
    } else {
      this.level = 1;
    }
  }

  public void MorphEffect(Character c){
    this.id = c.getId(); this.name = c.getName();
    this.desc = c.getDesc(); this.imagePath = c.getImagePath();
    this.mana = c.getMana(); this.type = c.getType();
    this.attack = c.getAttack(); this.health = c.getHealth();
    this.attackUp = c.getAttackUp(); this.healthUp = c.getHealthUp();
    this.exp = 0; this.level = 1;
    this.hasAttack = false;
    this.spellList = new ArrayList<>();
  }

  @Override
  public Type getCardType() {
    return Type.CHARACTER;
  }


  /*
  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
  */

}
