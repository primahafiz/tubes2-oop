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
                Card cardclone = (Card) c.getCards().get(random).clone();
                CardDeck.add(cardclone);
            }
        } catch (Exception e) {

        }
    }

    public List<Card> getCard() {
        List<Card> C = new ArrayList<Card>();
        int i;
        if (this.CardDeck.size() >= 3){
            for (i = 0; i < 3; i++){
                C.add(this.CardDeck.get(i));
            }
            for (i = 0; i < 3; i++){
                this.CardDeck.remove(i);
            }
        }
        else if(this.CardDeck.size() > 0){
            for (i = 0; i < this.CardDeck.size(); i++){
                C.add(this.CardDeck.get(i));
            }
            for (i =0; i< this.CardDeck.size(); i++){
                this.CardDeck.remove(i);
            }
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