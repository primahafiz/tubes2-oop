package com.aetherwars.model;
import com.aetherwars.model.Card.*;
import com.aetherwars.util.InvalidException;

import java.util.*;
public class Hand {
    private Card[] onHandCards;

    public Hand() {
        this.onHandCards = new Card[5];
    }

    // Menambahkan kartu ke Hand
    public void addCardtoHand(Card card, int idx) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (this.onHandCards[i] != null) {
                count++;
            }
        }

        if (count < 5) {
            if (isValidIdx(idx)) {
                this.onHandCards[idx] = card;
            }
        }
    }

    public void removeCardfromHand(int idx) {
        this.onHandCards[idx] = null;
    }

    // Hand kosong
    public boolean isEmpty() {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onHandCards[i] == null){
                count++;
            }
        }
        return (count == 5);
    }

    // Hand penuh
    public boolean isFull() {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onHandCards[i] != null){
                count++;
            }
        }
        return (count == 5);
    }

    // Memeriksa apakah yang dipilih merupakan slot kosong
    // True jika slot kosong
    public boolean isValidIdx(int idx) {
        return (this.onHandCards[idx] == null);
    }

    public Card getCard(int id) {
        return this.onHandCards[id];
    }

    public int countCard() {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onHandCards[i] != null){
                count++;
            }
        }
        return count;
    }


    public void printHand() {
        int i;
        for (i = 0;i < this.onHandCards.length; i++){
            if (this.onHandCards[i] != null) {
                System.out.println("Kartu ke-" + (i+1));
                this.onHandCards[i].printCardInfo();
                System.out.println();
            }
        }
    }
}
