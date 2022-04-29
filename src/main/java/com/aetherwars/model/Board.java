package com.aetherwars.model;

// import java.util.List;
// import java.util.ArrayList;
// import com.aetherwars.model.Card.*;
// import com.aetherwars.util.InvalidException;

public class Board implements cardSlot {
    private Card[] onBoardCards;

    // Constructor
    public Board() {
        this.onBoardCards = new Card[5];
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

    @Override
    public String toString(){
        String res="";
        for(int i=0;i<5;i++){
            if(this.onBoardCards[i]==null){
                res+="null\n";
            }else{
                res+=this.onBoardCards[i].toString()+"\n";
            }
        }
        return res;
    }

}