package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.aetherwars.model.Type;
import com.aetherwars.model.Character;
import com.aetherwars.model.Card;
import com.aetherwars.util.CSVReader;
import com.aetherwars.model.CardReader;

public class AetherWars {


  public static void main(String[] args) {

    try {
      System.out.println("Hello World");
      CardReader c = new CardReader(); // ctor
      c.addAllCards(); // masukin card ke c
      int i = 0;
      for (Card card : c.getCards()){
        i += 1;
        System.out.println("Kartu ke-" + i);
        card.printCardInfo(); // print setiap card
        System.out.println();
      }

      // kalo mau debug di sini

    } catch (Exception e){

    }

  }
}
