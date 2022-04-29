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
                //Card cardclone = (Card) c.getCards().get(random).clone();
                Card cardclone = cctorCard(c.getCards().get(random));
                CardDeck.add(cardclone);
            }
        } catch (Exception e) {

        }
    }

    public List<Card> getCard() throws CloneNotSupportedException {
        List<Card> C = new ArrayList<Card>();
        int i;
        if (this.CardDeck.size() >= 3){
            for (i = 0; i < 3; i++){
                C.add((Card) this.CardDeck.get(i).clone());
            }
            for (i = 0; i < 3; i++){
                this.CardDeck.remove(i);
            }
        }
        else if(this.CardDeck.size() > 0){
            for (i = 0; i < this.CardDeck.size(); i++){
                C.add((Card) this.CardDeck.get(i).clone());
            }
            for (i =0; i< this.CardDeck.size(); i++){
                this.CardDeck.remove(i);
            }
        }
        return C;
    }

    public int getSize(){
        return this.CardDeck.size();
    }

    public List<Card> getAll(){
        return this.CardDeck;
    }

    public void addCard(Card c){
        CardDeck.add(c);
    }

    public Card cctorCard(Card c){
        if (c instanceof Character) {
            Character cc = (Character) c;
            return (Card) new Character(cc.getId(), cc.getName(), cc.getDesc(), cc.getImagePath(), cc.getMana(), cc.getType(), cc.getAttack(), cc.getHealth(), cc.getAttackUp(), cc.getHealthUp());
        } else if (c instanceof PtnSpell) {
            PtnSpell cc = (PtnSpell) c;
            return (Card) new PtnSpell(cc.getId(), cc.getName(), cc.getDesc(), cc.getImagePath(), cc.getMana(), cc.getDuration(), cc.getPtnAttack(), cc.getPtnHp());
        } else if (c instanceof MorphSpell) {
            MorphSpell cc = (MorphSpell) c;
            return (Card) new MorphSpell(cc.getId(), cc.getName(), cc.getDesc(), cc.getImagePath(), cc.getMana(), cc.getDuration(), cc.getTargetId());
        } else if (c instanceof SwapSpell) {
            SwapSpell cc = (SwapSpell) c;
            return (Card) new SwapSpell(cc.getId(), cc.getName(), cc.getDesc(), cc.getImagePath(), cc.getMana(), cc.getDuration());
        } else {
            LvlSpell cc = (LvlSpell) c;
            return (Card) new LvlSpell(cc.getId(), cc.getName(), cc.getDesc(), cc.getImagePath(), cc.getMana(), cc.getDuration(), cc.getAdd());
        }
    }
}