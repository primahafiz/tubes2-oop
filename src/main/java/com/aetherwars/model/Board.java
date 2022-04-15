package com.aetherwars.model;

import java.util.List;

public class Board {
    private List<Card> onBoardCards;

    public boolean isEmpty() {
        return this.onBoardCards == 0;
    }

    public void addCardtoBoard(Card card) {
        this.onBoardCards.add(card);
    }

    public void removeCardfromBoard(Card card) {
        this.onBoardCards.remove(card);
    }    
}
