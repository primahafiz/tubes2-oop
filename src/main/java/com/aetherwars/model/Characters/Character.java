package com.aetherwars.model.Characters;

import java.util.ArrayList;
import java.util.List;

import com.aetherwars.model.Card;
import com.aetherwars.model.Type;
import com.aetherwars.model.Spells.LvlSpell;
import com.aetherwars.model.Spells.PtnSpell;
import com.aetherwars.model.Spells.Spell;
import com.aetherwars.model.Spells.SwapSpell;

import java.util.*;
import java.lang.Math;

public class Character extends Card  {
  private Type type;
  private double attack;
  private double health;
  private double baseAttack;
  private double baseHealth;
  private double attackUp;
  private double healthUp;
  private int exp;
  private int level;
  private boolean hasAttacked;
  private int swapDur;
  private List<PtnSpell> listPtnSpell;

  public Character(int id, String name, String desc, String path, int mana, Type type, double attack, double health, double attackUp, double healthUp) {
    super(id, name, desc, path, mana);
    this.type = type;
    this.attack = attack;
    this.health = health;
    this.baseAttack = attack;
    this.baseHealth = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
    this.exp = 0;
    this.level = 1;
    this.hasAttacked = false;
    this.swapDur = 0;
    this.listPtnSpell = new ArrayList<>();
  }

  // getter

  public Type getType(){
    return this.type;
  }

  public double getAttack(){
    return Math.max(this.attack + this.getTempAttack(), 0);
  }

  public double getHealth(){
    return Math.max(this.health + this.getTempHealth(), 0);
  }

  public double getBaseAttack(){
    return this.baseAttack;
  }

  public double getBaseHealth(){
    return this.baseHealth;
  }

  public double getAttackUp(){
    return this.attackUp;
  }

  public double getHealthUp(){
    return this.healthUp;
  }

  public int getExp(){
    return this.exp;
  }

  public int getLevel(){
    return this.level;
  }

  public boolean hasAttacked(){
    return this.hasAttacked;
  }

  public void setHasAttackedTrue() {
    this.hasAttacked = true;
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
    int expAkhir = this.exp += exp;
    if (expAkhir >= 0) {
      this.exp = expAkhir;
    } else {
      this.exp = 0;
    }
  }

  public void setHealth(double health){
    this.health = Math.max(health, 0);
  }

  public void levelUp(int lvl) {
    int predictLvl = this.level + lvl;
    this.level = Math.min(predictLvl, 10);
    this.attack = this.baseAttack + this.attackUp * (this.level - 1);
    this.health = this.baseHealth + this.healthUp * (this.level - 1);
  }

  public boolean isDead(){
    return this.health == 0;
  }

  public boolean isCharacter() { return true;}

  public int getSwapDur(){
    return this.swapDur;
  }

  public int getManaNeeded(Spell s){
    int mana = 0;
    if (s.getCardType() == Type.LVL) {
      mana = (int) this.getLevel()/2;
    } else {
      mana = s.getMana();
    }
    return mana;
  }

  private double getTempAttack(){
    double tempAttack = 0;
    for (PtnSpell s : this.listPtnSpell){
      tempAttack += s.getPtnAttack();
    }
    return tempAttack;
  }

  private double getTempHealth(){
    double tempHealth = 0;
    for (PtnSpell s : this.listPtnSpell){
      tempHealth += s.getPtnHp();
    }
    return tempHealth;
  }

  public List<PtnSpell> getListSpell(){
    return this.listPtnSpell;
  }

  public void addSpell(PtnSpell s){
    this.listPtnSpell.add(s);
  }

  private void updateSpellList(){
    List<PtnSpell> object = new ArrayList<PtnSpell>();
    for (PtnSpell s : this.listPtnSpell){
      s.minusDur();
      if (s.getDuration() == 0){
        object.add(s);
      }
    }
    for (PtnSpell s : object){
      this.listPtnSpell.remove(s);
    }
  }

  private void swapPtnSpellList(){
    // swap attack and duration in list
    for (PtnSpell s : this.listPtnSpell){
      s.swapAttackHp();
    }
  }

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
    this.attack = this.baseAttack + this.attackUp * (this.level - 1);
    this.health = this.baseHealth + this.healthUp * (this.level - 1);
  }

  public void MorphEffect(int targetId, List<Card> cards){
    Character c = getCharFromId(targetId, cards);
    this.id = c.getId(); this.name = c.getName();
    this.desc = c.getDesc(); this.imagePath = c.getImagePath();
    this.mana = c.getMana(); this.type = c.getType();
    this.attack = c.getAttack(); this.health = c.getHealth();
    this.attackUp = c.getAttackUp(); this.healthUp = c.getHealthUp();
    this.exp = 0; this.level = 1;
    this.hasAttacked = false; this.swapDur = 0;
    this.listPtnSpell = new ArrayList<>();
  }

  public void PtnEffect(PtnSpell p){
    this.addSpell(p);
  }

  public void SwapEffect(SwapSpell s){
    if (this.swapDur > 0){
      this.swapDur += s.getDuration();
    } else {
      this.swapDur = s.getDuration();
      double val = this.attack;
      this.attack = this.health;
      this.health = val;
      this.swapPtnSpellList();
    }
  }

  public void swapBack(){
    double val = this.attack;
    this.attack = this.health;
    this.health = val;
    this.swapPtnSpellList();
  }

  // ngeupdate duration dari spell yang temp, ngubah this.mana
  // kayaknya mana dihandle player
  public void updateDur(int turn) {
    this.updateSpellList();
    if (swapDur > 0){
      this.swapDur -= 1;
      if (this.swapDur == 0){
        this.swapBack();
      }
    }

  }

  public Character getCharFromId (int id, List<Card> cards){
    int idx = 0;
    for (Card card: cards){
      if (card.getId() == id){
        break;
      }
      idx++;
    }
    return (Character) cards.get(idx);
  }

  public void printCardInfo(){
    super.printCardInfo();
    System.out.println("Attack: " + getAttack());
    System.out.println("Health: " + getHealth());
    System.out.println("AttackUp: " + getAttackUp());
    System.out.println("HealthUp: " + getHealthUp());
    System.out.println("CharLvl: " + getLevel());
    System.out.println("CharExp: " + getExp());
  }

  public void minusHealth(double damage){
    // kalo damage >= getHealth() -> langsung this.health = 0
    // kalo damage < getHealth():
      // kalo getTempHealth() > 0 -> minus dari tempHealth dulu
        // kalo damage >= tempHealth -> set this.health jadi this.health -=  declare ArrayList baru
        // kalo lebih kecil
      // kalo ga ada langsung minus dari this.health
        // kalo damage >= this.health set this.health = 0
        // kalo damage < this.health set this.health -= damage
    System.out.println("minus Health");
    if (damage >= this.getHealth()){
      this.health = 0;
    } else {
      if (this.getTempHealth() > 0){
        if (damage >= this.getTempHealth()){
          this.health -= (damage - this.getTempHealth());
          this.listPtnSpell = new ArrayList<PtnSpell>();
        } else {
          this.minusHelper(damage);
        }
      } else {
        if (damage >= this.health){
          this.health = 0;
        } else {
          this.health -= damage;
        }
      }
    }
  }

  public void setLevel(int level){
    this.level = level;
  }

  private void minusHelper(double damage){
    List<Integer> listidx = new ArrayList<Integer>();
    double total = 0;
    int i = 0;
    // reverse
    Collections.reverse(this.listPtnSpell);

    // catat indeks temp health yang terpakai
    for (PtnSpell p : this.listPtnSpell){
      if (p.getPtnHp() > 0){
        total += p.getPtnHp();
        listidx.add(i);
        if (total >= damage){
          break;
        }
      }
      i += 1;
    }

    // memperbarui listPtnSpell
    if (total > damage){
      int lastidx = listidx.get(listidx.size() - 1);

      this.listPtnSpell.get(lastidx).setPtnHp(total-damage);

      for (int j = 0; j < listidx.size() - 1; j++){
        int index = listidx.get(j);
        this.listPtnSpell.remove(index);
      }

    } else if (total == damage){
      for (Integer l : listidx){
        this.listPtnSpell.remove((int) l);
      }
    }
    // System.out.println(i);
    // reverse back
    Collections.reverse(this.listPtnSpell);
  }
  
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
