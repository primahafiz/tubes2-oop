package com.aetherwars.model;

import java.util.List;
import java.util.ArrayList;
import com.aetherwars.model.Card.*;

public class Board {
    private List<Card> onBoardCards;

    // Constructor
    public Board() {
        this.onBoardCards = new ArrayList<Card>(5);
    }

    // Menambahkan kartu ke Board
    public void addCardtoBoard(Card card, int idx) {
        if (this.onBoardCards.size() < 5) {
            this.onBoardCards.get(idx) = card;
        } else {
            System.out.println("Board is full");
        }
    }

    // Menghapus card dari board
    public void removeCardfromBoard(Card card) {
        this.onBoardCards.remove(card);
    }

    // Getter Card yang terletak pada posisi id di Board
    public Card getCard(int id) {
        return this.onBoardCards.get(id);
    }

    // Memeriksa apakah yang dipilih merupakan slot kosong
    public boolean isValidIdx(int idx) {
        return (this.onBoardCards.get(idx) != null);
    }

    // Memeriksa apakah ada kartu di Board
    public boolean isEmpty() {
        return (this.onBoardCards.size() == 0);
    }

    // Board penuh
    public boolean isFull() {
        return (this.onBoardCards.size() == 5);
    }

    // Mengembalikan jumlah kartu di board
    public int numberOfCards() {
        return (this.onBoardCards.size());
    }
}