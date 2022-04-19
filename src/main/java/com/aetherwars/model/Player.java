package com.aetherwars.model;

import com.aetherwars.model.Card.*;
import com.aetherwars.model.Character.*;
import com.aetherwars.model.Board.*;
import com.aetherwars.model.Hand.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Player {
    private String Name;
    private int hp;
    private int Mana;

    private Board board;
    private Hand hand;

    // private List<Card> Deck;

    // constructor
    public void player(String name, int mana) {
        this.Name = name;
        this.hp = 80;
        this.Mana = mana;

        this.board = new Board();
        this.hand = new Hand();

    }

    // reset Mana
    public void resetMana(int mana) {
        this.Mana = mana;
    }

    // Getter name
    public String getName() {
        return this.Name;
    }

    // Getter HP
    public int getHp() {
        return this.hp;
    }

    // Setter HP
    public void setHp(int hp) {
        this.hp = hp;
    }

    // Getter Mana
    public int getMana() {
        return this.Mana;
    }

    // Setter Mana
    public void setMana(int mana) {
        this.Mana = mana;
    }

    // Mengambil kartu dari Deck
    public void drawCard() {
        // draw 3 kartu teratas dari deck
        this.deck.drawCard();

        // remove kartu dari hand kalo penuh
        if(this.hand.isFull()) {
            Random rand = new Random();
            int id = rand.nextInt(this.hand.numberOfCards());
            this.hand.removeCardfromHand(id);
        }
    }

    // Melihat deskripsi dan atribut kartu hand maupun board
    public void showCard(Card card) {
        if card.getType() == "Character" {
            System.out.println("Name : " + card.getName());
            System.out.println("Description : " + card.getDesc());
            // System.out.println("Type : " + card.getType());
            //atk
            //hp
            //level
            //exp

        } else { // kartu spell
            System.out.println("Name : " + card.getName());
            System.out.println("Description : " + card.getDesc());
            // System.out.println("Type : " + card.getType());
            //atk
            //hp
            //level
            //exp
        }

    }

    // Mengeluarkan kartu / memindahkan kartu dari hand ke board
    public void playCard(int idx) {
        if (this.Mana >= this.hand.getCard(idx).getMana()) {
            board.addCardtoBoard(this.hand.getCard(idx),idx);
            this.Mana -= this.hand.getCard(idx).getMana();
            this.hand.removeCardfromHand(idx);
        } else {
            System.out.println("This player doesn't have enough mana");
        }
    }

    // Attack
    // attackerCharacterIdx = indeks kartu yang digunakan untuk attack
    // enemyCharacterIdx = indeks kartu musuh yang di attack
    public void attack(int attackerCharacterIdx, int enemyCharacterIdx, Player enemy) {
        // Card attacker = this.board.getCard(attackerCharacterIdx);
        // Card enemyCharacter = enemy.board.getCard(enemyCharacterIdx);

        Character attacker = (Character)this.board.getCard(attackerCharacterIdx);
        Character enemyCharacter = (Character)this.board.getCard(enemyCharacterIdx);

        // Health karakter musuh berkurang sesuai dengan attack karakter
        // pemain dan attack modifier tipe kedua karakter

        // Health karakter pemain berkurang sesuai dengan attack karakter
        // musuh dan attack modifier tipe kedua karakter (tetap berkurang
        // meskipun karakter musuh mati).
        enemyCharacter.setHealth(enemyCharacter.getAttack());


        // Jika karakter musuh mati, exp karakter pemain akan bertamba sebesar level karakter musuh
        if (enemyCharacter.getHealth() == 0) {
            attacker.addExp(enemyCharacter.getLevel());
        }

        // Jika exp karakter pemain melebihi batas yang diperlukan, level karakter pemain akan meningkat
        while (attacker.getExp() > (attacker.getLevel() * 2) - 1) {
                attacker.levelUp(1);
                attacker.addExp(-2);
        }

    }

    // Attack jika board lawan sudah tidak ada kartu
    public void attackEnemy(int attackerIdx, Player enemy) {
        Character attacker = (Character)this.board.getCard(attackerIdx);

        if (enemy.board.isEmpty()) {
            enemy.setHp(enemy.getHp() - attacker.getAttack());
        }
    }

    // Beralih ke fase selanjutnya.

}