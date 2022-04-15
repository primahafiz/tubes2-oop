import java.util.List;
import java.util.ArrayList;

// import class Card, Deck, Hand, Board

public class Player {
    private String Name;
    private int hp;
    private int Mana;

    private List<Card> onHandCards;
    private List<Card> onBoardCards;
    // private List<Card> Deck;

    // constructor
    public player(String name) {
        this.Name = name;
        this.hp = 80;
        // this.Mana = mana;
        this.onHandCards = new ArrayList<Card>(5);
        this.onBoardCards = new ArrayList<Card>(5);
        // this.Deck = new ArrayList<Card>();
    }

    // Draw card from deck
    public void drawCard(Deck deck) {
        this.onHandCards.add(deck.drawCard());
        // Membuang kartu apabila kartu di Hand melebihi 5
        if(this.onHandCards.size() > 5) {
            Random rand = new Random();
            int id = rand.nextInt(this.onHandCards.size());
            this.onHandCards.remove(id);
        }
    }

    // Remove card from hand
    public void removeCard(Card card) {
        this.onHandCards.remove(card);
    }

    // Getter name
    public String getName() {
        return this.Name;
    }

    // Getter HP
    public int getHp() {
        return this.hp;
    }

    // Setter HP
    public int setHp(int hp) {
        this.hp = hp;
    }

    // Getter Mana
    public int getMana() {
        return this.Mana;
    }

    // Setter Mana 
    public int setMana(int mana) {
        this.Mana = mana;
    }

    // Setter HP
    public int setHp(int hp) {
        this.hp = hp;
    }

    // Getter onHandCards
    public List<Card> getOnHand() {
        return this.onHand;
    }

    // Getter onBoardCards
    public List<Card> getOnBoard() {
        return this.onBoard
    }

    // Mengambil kartu baru
    public void drawCard(Deck deck) {
        this.onHand.add(deck.drawCard());
    }

    // Melihat deskripsi dan atribut kartu hand maupun board
    public void showCard(Card card) {
        System.out.println("Name : " + card.getName());
        System.out.println("Description : " + card.getDescription());
        System.out.println("Type : " + card.getType());
    }

    // Mengeluarkan kartu / memindahkan kartu dari hand ke board
    public void playCard(Card card) {
        this.onBoardCards.add(card);
        this.onHandCards.remove(card);
    }

    // Menyerang musuh
    public void attack(Board onBoardCard, Board enemyOnBoardCard, Player enemy) {
        // Health karakter pemain berkurang sesuai dengan attack karakter
        // musuh dan attack modifier tipe kedua karakter (tetap berkurang meskipun karakter musuh mati).        
        if isAttckValid() {
            enemy.setHp(enemy.getHp() - onBoardCard.getAttack());
        } 

        // Jika karakter musuh mati, exp karakter pemain akan bertambah sebesar level karakter musuh.
        if enemy.getHp() == 0 {
            this.onBoardCard.setExp(this.onBoardCard.getExp() + enemyOnBoardCard.getLevel());
        }

        // Jika exp karakter pemain melebihi batas yang diperlukan, level karakter pemain akan meningkat.
        if this.onBoardCard.getExp() > this.onBoardCard.getLevel() * 10 {
            this.onBoardCard.setLevel(this.onBoardCard.getLevel() + 1);
        }
    }

    // Beralih ke fase selanjutnya.

}