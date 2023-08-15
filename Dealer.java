/**
 * The Dealer class represents the Dealer in a blackjack game. The dealer is
 * a kind of player, except it deals cards from the shoe to the other players,
 * and all the players are competing against the dealer.
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Dealer extends Player {
    Deck shoe;

    /**
     * Default constructor. Constructs a Dealer object with a fresh shoe.
     */
    public Dealer() {
        this.shoe = new Shoe();
    }

    /**
     * Constructs a Dealer object with the given shoe.
     * @param shoe The Dealer's shoe.
     */
    public Dealer(Shoe shoe) {
        this.shoe = shoe;
    }

    /**
     * Simulates dealing a card by removing the top card from the shoe.
     * @return The first card in the shoe
     */
    public Card dealCard() {
        Card dealtCard = shoe.getTopCard();
        shoe.setTopCard(dealtCard.getNext());

        return dealtCard;
    }

    /**
     * Returns the Dealer's shoe.
     * @return The dealer's shoe
     */
    public Deck getShoe() {
        return shoe;
    }

    /**
     * Sets the Dealer's shoe to the given value
     * @param shoe The desired shoe
     */
    public void setShoe(Deck shoe) {
        this.shoe = shoe;
    }

    /**
     * When making playing decisions, the players need to compare the value
     * of their hands to the value of the dealer's upcard. Shows the dealer's
     * upcard without revealing any of the dealer's other cards.
     * @return The first card of the dealer's hand.
     */
    public Card upcard() {
        return new Card(getHand().getCards());
    }
}