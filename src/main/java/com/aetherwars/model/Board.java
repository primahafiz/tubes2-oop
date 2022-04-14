public class Board {
    private List<Card> onBoardCards;

    public isEmpty() {
        return this.onBoardCards == 0;
    }

    public addCardtoBoard(Card card) {
        this.onBoardCards.add(card);
    }

    public removeCardfromBoard(Card card) {
        this.onBoardCards.remove(card);
    }    
}
