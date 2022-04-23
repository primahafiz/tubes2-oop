package com.aetherwars.model;

import java.util.List;
import java.util.ArrayList;
import com.aetherwars.model.Card.*;
import com.aetherwars.util.InvalidException;

public class Board {
    private List<Card> onBoardCards;

    // Constructor
    public Board() {
        this.onBoardCards = new ArrayList<Card>(5);
    }

    // Menambahkan kartu ke Board
    public void addCardtoBoard(Card card, int idx) {
        if (this.onBoardCards.size() < 5) {
            // if (isValidIdx(idx)) {
                this.onBoardCards.add(idx, card);
            //} else {
                // throw new InvalidException("This slot has been occupied");
            // }
        }
    }

    // Menghapus card dari board
    public void removeCardfromBoard(int idx) throws InvalidException {
        if (!isValidIdx(idx)) {
            this.onBoardCards.remove(idx);
        } else {
            throw new InvalidException("There is no card in this slot");
        }
    }

    // Getter Card yang terletak pada posisi id di Board
    public Card getCard(int id) {
        return this.onBoardCards.get(id);
    }

    // Memeriksa apakah yang dipilih merupakan slot kosong
    // True jika slot kosong
    public boolean isValidIdx(int idx) {
        return (this.onBoardCards.get(idx) == null);
    }

    // Memeriksa apakah terdapat kartu character pada slot yang dipilih
    // True jika terdapat character pada slot
    public boolean isCharacterAvailable(int idx) {
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

    public void printBoard() {
        int i;
        for (i = 0;i < this.onBoardCards.size();i++){
            System.out.println("Kartu ke-" + (i+1));
            this.onBoardCards.get(i).printCardInfo();
            System.out.println();
        }
    }
}