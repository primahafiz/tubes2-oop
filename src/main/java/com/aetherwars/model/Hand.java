package com.aetherwars.model;
import com.aetherwars.model.Card.*;
import com.aetherwars.util.InvalidException;

import java.util.*;
public class Hand {
    private final List<Card> onHandCards;
    public Hand() {
        this.onHandCards = new ArrayList<Card>(5);
    }

    // Menambahkan kartu ke Board
    public void addCardtoHand(Card card, int idx)  {
        if(this.onHandCards.size() < 5) {
            // if (isValidIdx(idx)) {
                this.onHandCards.add(idx, card);
            //}
        }
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

    // Memeriksa apakah yang dipilih merupakan slot kosong
    // True jika slot kosong
    public boolean isValidIdx(int idx) {
        return (this.onHandCards.get(idx) == null);
    }

    public int numberOfCards() {
        return (this.onHandCards.size());
    }

    public Card getCard(int id) {
        return this.onHandCards.get(id);
    }

    public void printHand() {
        int i;
        for (i = 0;i < this.onHandCards.size();i++){
            System.out.println("Kartu ke-" + (i+1));
            this.onHandCards.get(i).printCardInfo();
            System.out.println();
        }
    }
}
