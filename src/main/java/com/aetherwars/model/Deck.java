package com.aetherwars.model;
import java.util.*;
public class Deck {

    private final List<Card> CardDeck= new ArrayList<Card>();
    public Deck(){
        Random rand = new Random();
        int capacity = rand.nextInt(20) + 40;
        int i;
        for (i = 0; i < capacity; i++){
            this.CardDeck.add();
        }
    }

    public Card getCard() {
        return this.CardDeck.remove(0);
    }
}
