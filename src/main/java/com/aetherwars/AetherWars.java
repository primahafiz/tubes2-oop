package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Scanner;

import com.aetherwars.model.*;
import com.aetherwars.model.Deck;
import com.aetherwars.model.Character;
import com.aetherwars.util.CSVReader;
import com.aetherwars.util.InvalidException;

public class AetherWars {

    // untuk tes dan debugging
    public static void main(String[] args) throws InvalidException {

    // Baca CSV
    try {
      CardReader c = new CardReader(); // ctor
      c.addAllCards(); // masukin card ke c
      int i = 0;
      for (Card card : c.getCards()){
        i += 1;
        System.out.println("Kartu ke-" + i);
        card.printCardInfo(); // print setiap card
        System.out.println();
      }

      // Ambil Kartu
      Card creeper = c.getCards().get(0);
      Card sheep = c.getCards().get(1);
      Card zombie = c.getCards().get(2);
      Card skeleton = c.getCards().get(3);
      Card enderman = c.getCards().get(4);

      // kalo mau debug di sini
      
        // Construct Player
        Player player1 = new Player("Alex", 10);
        Player player2 = new Player("Steven", 10);

        // Print Deck Player 1
        System.out.println("DECK PLAYER 1");
        player1.getDeck().printDeck();
        System.out.println();

        // Print Deck Player 2
        System.out.println("DECK PLAYER 2");
        player2.getDeck().printDeck();
        System.out.println();

        // Ambil 3 kartu teratas dari deck (keknya getCard belum bisa)
        int x;
        System.out.println("TOP 3 CARDS DECK PLAYER 1");
        List<Card> topDeck = player1.getDeck().getCard();
        for (x = 0; x < topDeck.size(); x++) {
            System.out.println("Kartu ke-" + (x+1));
            topDeck.get(x).printCardInfo();
            System.out.println();
        }

        // Add kartu ke Hand Player 1
        player1.getHand().addCardtoHand(sheep,0);
        player1.getHand().addCardtoHand(zombie,1);
        player1.getHand().addCardtoHand(skeleton,2);
        System.out.println();

        System.out.println("HAND PLAYER 1");
        player1.getHand().printHand();

        // Add kartu ke Hand Player 2
        player2.getHand().addCardtoHand(sheep,0);
        player2.getHand().addCardtoHand(enderman,1);
        System.out.println();

        System.out.println("HAND PLAYER 2");
        player2.getHand().printHand();

        // TESTING ATTACK PLAYER
        // playCard = keluarin kartu ke board, harusnya kurangin Mana Player
        player1.playCard(1,1);

        int manaSisa = player1.getMana();
        System.out.println(manaSisa);

        // Tambah kartu ke board Player 1
        player1.getBoard().addCardtoBoard(sheep, 0);
        // player1.getBoard().addCardtoBoard(skeleton, 1);
        player1.getBoard().printBoard();

        // Tambah kartu ke board Player 2
        player2.getBoard().addCardtoBoard(enderman, 0);
        player2.getBoard().addCardtoBoard(zombie, 1);

        // Attack
        player2.attack(0,1, player1);

        // Belum bisa,,,,
        System.out.println("BOARD PLAYER 1 SETELAH DI ATTACK pt 2");
        player1.getBoard().printBoard();

    } catch (Exception e){
//
    }


    }
}
