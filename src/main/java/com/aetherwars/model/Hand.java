package com.aetherwars.model;
import com.aetherwars.model.Card.*;
import java.util.*;
public class Hand {

    private List<Card> onHandCards;

    public Hand() {
        this.onHandCards = new ArrayList<Card>(5);
    }

    public void removeCardfromHand(int idx) {
        this.onHandCards.remove(idx);
    }

    public boolean isEmpty() {
        return (this.onHandCards.size() == 0);
    }

    public boolean isFull() {
        return (this.onHandCards.size() == 5);
    }

    public int numberOfCards() {
        return (this.onHandCards.size());
    }

    public Card getCard(int id) {
        return this.onHandCards.get(id);
    }
//    private final List<Card> Hand = new ArrayList<Card>();
//    public Hand{
//        int i;
//        for (i = 0; i < 5; i++){
//            this.Hand.add(getCard());
//        }
//    }
}
