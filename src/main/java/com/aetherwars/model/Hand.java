package com.aetherwars.model;
import com.aetherwars.model.Card.*;
import java.util.*;
public class Hand {
    private final List<Card> onHandCards;
    public Hand() {
        this.onHandCards = new ArrayList<Card>(5);
    }
    
    public void removeCardFromHand(int idx) {
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
}
