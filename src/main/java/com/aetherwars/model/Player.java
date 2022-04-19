package com.aetherwars.model;

import com.aetherwars.model.Card.*;
import com.aetherwars.model.Character.*;
import com.aetherwars.model.Spell.*;
import com.aetherwars.model.Board.*;
import com.aetherwars.model.Hand.*;
import com.aetherwars.model.Deck.*;

import com.aetherwars.util.InvalidException;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Player {
    private String Name;
    private int hp;
    private int Mana;

    private Board board;
    private Hand hand;
    private Deck deck;

    // constructor
    public void Player(String name, int mana) {
        this.Name = name;
        this.hp = 80;
        this.Mana = mana;

        this.board = new Board();
        this.hand = new Hand();
        this.deck = new Deck();

    }

    // return player's Deck
    public Deck getDeck() {
        return this.deck;
    }

    // return player's hand
    public Hand getHand() {
        return this.hand;
    }

    // return player's board
    public Board getBoard() {
        return this.board;
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
        this.deck.getCard();

        // remove kartu dari hand kalo penuh
        if(this.hand.isFull()) {
            Random rand = new Random();
            int id = rand.nextInt(this.hand.numberOfCards());
            this.hand.removeCardfromHand(id);
        }
    }

    // Melihat deskripsi dan atribut kartu hand maupun board
    public void showCard(Card card) {
        if (card.getCardType() == Type.CHARACTER) {
            Character charCard = (Character) card;
            System.out.println("Name : " + card.getName());
            System.out.println("Description : " + card.getDesc());
            System.out.println("Type : " + charCard.getType());
            System.out.println("Atk : " + charCard.getAttack());
            System.out.println("HP : " + charCard.getHealth());
            System.out.println("Level : " + charCard.getLevel());

        } else { // kartu spell
            Spell spellCard = (Spell) card;
            System.out.println("Name : " + card.getName());
            System.out.println("Description : " + card.getDesc());
            System.out.println("Type : " + spellCard.getCardType());
            System.out.println("Mana : " + spellCard.getMana());
            System.out.println("Duration : " + spellCard.getDuration());

            if (spellCard.getCardType() == Type.PTN) {
                PtnSpell ptnSpellCard = (PtnSpell) spellCard;
                System.out.println("Atk : " + ptnSpellCard.getPtnAttack());
                System.out.println("HP : " + ptnSpellCard.getPtnHp());

            } else if (spellCard.getCardType() == Type.LVL) {
                LvlSpell lvlSpellCard = (LvlSpell) spellCard;
                System.out.println("Add : " + lvlSpellCard.getAdd());

            }  else {
                MorphSpell morphSpellCard = (MorphSpell) spellCard;
                System.out.println("Id : " + morphSpellCard.getTargetId());
            }

        }

    }

    // Mengeluarkan kartu / memindahkan kartu dari hand ke board
    public void playCard(int idx) throws InvalidException {
        Card cardPlayed = this.hand.getCard(idx);

        // Memeriksa apakah player mempunyai Mana yang cukup untuk mengeluarkan kartu
        if (this.Mana >= cardPlayed.getMana()) {
            board.addCardtoBoard(cardPlayed,idx);
            this.Mana -= cardPlayed.getMana();
            this.hand.removeCardfromHand(idx);
        } else {
            throw new InvalidException("This player doesn't have enough mana");
        }
    }

    // Menggunakan spell card pada character card
    public void useSpell(int spellCardIdx, int charChardIdx, List<Card> card) throws InvalidException {
        Character charCard = (Character)this.board.getCard(charChardIdx);
        Spell spellCard = (Spell)this.hand.getCard(spellCardIdx);
        Type spellType = spellCard.getCardType();

        if (this.board.isCharacterAvailable(charChardIdx)) {
            switch (spellType) {
                case PTN:
                    PtnSpell ptnSpellCard = (PtnSpell) spellCard;
                    //ptn effect
                    break;

                case LVL:
                    LvlSpell lvlSpellCard = (LvlSpell) spellCard;
                    charCard.LvlEffect(lvlSpellCard);
                    break;

                case SWAP:
                    SwapSpell swapSpellCard = (SwapSpell) spellCard;
                    //swap effect
                    break;

                case MORPH:
                    MorphSpell morphSpellCard = (MorphSpell) spellCard;
                    int targetId = morphSpellCard.getTargetId();
                    charCard.MorphEffect(targetId, card);
                    break;
            }
            this.hand.removeCardfromHand(spellCardIdx);

        } else {
            throw new InvalidException("Spell card can only be used to Character");
        }

    }

    // Attack
    // attackerCharacterIdx = indeks kartu yang digunakan untuk attack
    // enemyCharacterIdx = indeks kartu musuh yang di attack
    public void attack(int attackerCharacterIdx, int enemyCharacterIdx, Player enemy) {
        Character attacker = (Character)this.board.getCard(attackerCharacterIdx);
        Character enemyCharacter = (Character)enemy.board.getCard(enemyCharacterIdx);

        // Character yang sudah pernah menyerang tidak bisa menyerang lagi
        if (!attacker.hasAttacked()) {
            // Health karakter musuh berkurang sesuai dengan attack karakter
            // pemain dan attack modifier tipe kedua karakter

            // Health karakter pemain berkurang sesuai dengan attack karakter
            // musuh dan attack modifier tipe kedua karakter (tetap berkurang
            // meskipun karakter musuh mati).
            double damage = attacker.getDamage(enemyCharacter);
            enemyCharacter.setHealth((int) (enemyCharacter.getHealth() - damage));


            // Jika karakter musuh mati, exp karakter pemain akan bertamba sebesar level karakter musuh
            if (enemyCharacter.getHealth() == 0) {
                // jika sudah level 10 maka karakter tidak mendapatkan exp
                if (attacker.getLevel() < 10) {
                    attacker.addExp(enemyCharacter.getLevel());
                }
            }

            // Jika exp karakter pemain melebihi batas yang diperlukan, level karakter pemain akan meningkat
            while ((attacker.getExp() > (attacker.getLevel() * 2) - 1) && (attacker.getLevel() < 10)) {
                attacker.levelUp(1);
                attacker.addExp(-2);
            }

            // satu karakter hanya dapat menyerang satu kali
            attacker.setHasAttackedTrue();
        }

    }

    // Attack jika board lawan sudah tidak ada kartu
    public void attackEnemy(int attackerIdx, Player enemy) throws InvalidException {
        Character attacker = (Character)this.board.getCard(attackerIdx);

        if (enemy.board.isEmpty()) {
            enemy.setHp(enemy.getHp() - attacker.getAttack());
        } else {
            throw new InvalidException("You have to attack enemy's character first");
        }
    }

    // Beralih ke fase selanjutnya.

}