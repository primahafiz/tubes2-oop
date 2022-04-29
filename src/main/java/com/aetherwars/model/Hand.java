package com.aetherwars.model;
// import com.aetherwars.model.Card.*;
import java.util.*;

import com.aetherwars.util.HandFullExp;
public class Hand implements cardSlot {
    private final List<Card> onHandCards;
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

    public void addCard(Card c)throws HandFullExp{
        if(onHandCards.size()<5){
            onHandCards.add(c);
            return;
        }
        throw new HandFullExp();
    }

    @Override
    public String toString(){
        String res = "";
        for(int i=0;i<this.onHandCards.size();i++){
            res=this.onHandCards.get(i).toString()+"\n";
        }
        return res;
    }
}