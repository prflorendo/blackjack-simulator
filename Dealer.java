public class Dealer extends Player {
    Deck shoe;

    public Dealer() {
        this.shoe = new Shoe();
    }

    public Dealer(Shoe shoe) {
        this.shoe = shoe;
    }

    public Card dealCard() {
        Card dealtCard = shoe.getTopCard();
        shoe.setTopCard(dealtCard.getNext());

        return dealtCard;
    }

    public Deck getShoe() {
        return shoe;
    }

    public void setShoe(Deck shoe) {
        this.shoe = shoe;
    }
}
