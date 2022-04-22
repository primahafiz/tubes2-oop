package com.aetherwars.model;
import java.util.*;
public class Deck {

    private List<Card> CardDeck= new ArrayList<Card>();

    public Deck() {
        try{
            Random rand = new Random();
            int capacity = rand.nextInt(20) + 40;
            int i;
            CardReader c = new CardReader();
            c.addAllCards();
            for (i = 0;i < capacity; i++){
                int random = rand.nextInt(c.getCards().size());
                CardDeck.add(c.getCards().get(random));
            }
        } catch (Exception e) {

        }
    }

    public List<Card> getCard() {
        List<Card> C = new ArrayList<Card>();
        int i;
        for (i =0; i< 3;i++){
             C.add(this.CardDeck.get(i));
             this.CardDeck.remove(i);
        }
        return C;
    }

    public List<Card> getAll(){
        return this.CardDeck;
    }

    public void addCard(Card c){
        CardDeck.add(c);
    }
}
