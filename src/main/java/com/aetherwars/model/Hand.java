package com.aetherwars.model;
import com.aetherwars.model.Card.*;
import java.util.*;
public class Hand {
    private final List<Card> Hand = new ArrayList<Card>();
    public Hand{
        int i;
        for (i = 0; i < 5; i++){
            this.Hand.add(getCard());
        }
    }
}
