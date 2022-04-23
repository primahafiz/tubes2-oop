package com.aetherwars.model;

public class Board {
    // private List<Card> onBoardCards;
    private Card[] onBoardCards;

    // Constructor
    public Board() {
        this.onBoardCards = new Card[5];
        //this.onBoardCards = {null, null,null,null,null};
    }

    // Menambahkan kartu ke Board
    public void addCardtoBoard(Card card, int idx) {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onBoardCards[i] != null){
                count++;
            }
        }

        if (count < 5) {
            if (isValidIdx(idx)) {
                this.onBoardCards[idx] = card;
            }
        }
    }

    // Menghapus card dari board
    public void removeCardfromBoard(int idx) {
        if (!isValidIdx(idx)) {
            this.onBoardCards[idx] = null;
        }
    }

    // Getter Card yang terletak pada posisi id di Board
    public Card getCard(int id) {
        return this.onBoardCards[id];
    }

    // Memeriksa apakah yang dipilih merupakan slot kosong
    // True jika slot kosong
    public boolean isValidIdx(int idx) {
        return (this.onBoardCards[idx] == null);
    }

    // Memeriksa apakah terdapat kartu character pada slot yang dipilih
    // True jika terdapat character pada slot
    public boolean isCharacterAvailable(int idx) {
        return (this.onBoardCards[idx] != null);
    }

    // Memeriksa apakah ada kartu di Board
    public boolean isEmpty() {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onBoardCards[i] == null){
                count++;
            }
        }
        return (count == 5);
    }

    // Board penuh
    public boolean isFull() {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onBoardCards[i] != null){
                count++;
            }
        }
        return (count == 5);
    }

    public int countCard() {
        int count = 0;
        for (int i = 0; i< 5 ; i++){
            if (this.onBoardCards[i] != null){
                count++;
            }
        }
        return count;
    }

    public void printBoard() {
        int i;
        for (i = 0;i < this.onBoardCards.length; i++){
            if (this.onBoardCards[i] != null) {
                System.out.println("Kartu ke-" + (i+1));
                this.onBoardCards[i].printCardInfo();
                System.out.println();
            }
        }
    }
}