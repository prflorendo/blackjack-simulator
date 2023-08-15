/**
 * The Player class represents a player at a blackjack table.
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Player {
    Hand hand;

    /**
     * Constructs a new player with an empty hand
     */
    public Player() {
        newHand();
    }

    /**
     * Gives the player a fresh hand
     */
    public void newHand() {
        hand = new Hand();
    }

    /**
     * Simulates receiving a card from the dealer, or hitting.
     * 
     * Most of the logic was written before a separate hand class was created.
     * Moving this into hand would allow the scope of several methods to become
     * private.
     * TODO: Move most of the method to Hand
     * @param newCard
     */
    public void hit(Card newCard) {
        newCard.setNext(hand.getCards());
        hand.setCards(newCard);

        int value = newCard.getValue();

        if (value == 1) {
            hand.drawAce();
            hand.addValue(11);
        } else if (value > 10) {
            hand.addValue(10);;
        } else {
            hand.addValue(value);
        }
    }

    /**
     * Returns a list of the player's hands
     * @return a list of the player's hands
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Splits a player's hand into two hands and inserts it into the middle of
     * the list. This should only be done when a player's hand contains two
     * cards of the same value.
     * @param hand The desired hand to split
     */
    public void split(Hand hand) {
        Hand splitHand = new Hand(hand.getCards().getNext());
        splitHand.setNext(hand.getNext());
        hand.getCards().setNext(null);

        hand.setNext(splitHand);
    }
}