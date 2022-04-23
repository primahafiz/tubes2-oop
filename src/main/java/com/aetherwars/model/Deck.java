package com.aetherwars.model;
import java.util.*;
public class Deck {

    private List<Card> CardDeck;

    public Deck() {
        this.CardDeck = new ArrayList<>();
    }

    public void initializeDeck() {
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

    public void printDeck() {
        int i;
        for (i = 0;i < this.CardDeck.size();i++){
            System.out.println("Kartu ke-" + (i+1));
            CardDeck.get(i).printCardInfo();
            System.out.println();
        }
    }
}
