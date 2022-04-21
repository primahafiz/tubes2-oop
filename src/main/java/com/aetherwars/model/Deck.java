package com.aetherwars.model;
import java.util.*;
public class Deck {

    private final List<Card> CardDeck= new ArrayList<Card>();

    public Deck(){
        Random rand = new Random();
        int capacity = rand.nextInt(20) + 40;
        int i;
        for (i = 0; i < capacity; i++){
            //this.CardDeck.add();
        }
    }

    public List<Card> getCard() {
        List<Card> C = new ArrayList<Card>();
        int i;
        for (i =0; i< 3;i++){
             C.add(this.CardDeck.get(i));
             this.CardDeck.remove(i);
        }
        return C;
    }
}
