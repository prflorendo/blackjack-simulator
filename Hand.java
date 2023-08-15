/**
 * The Hand class represents a player's blackjack hand(s) as a linked list
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Hand {
    private Card cards;
    private Hand next;
    private int value;
    private boolean hasAce;

    /**
     * Default constructor, initializes all values to null/zero.
     */
    public Hand() {
        this.cards = null;
        this.next = null;
        this.value = 0;
        this.hasAce = false;
    }

    /**
     * Inserts a new empty hand at the front of the linked list.
     * @param next
     */
    public Hand(Hand next) {
        this.cards = null;
        this.next = next;
        this.value = 0;
        this.hasAce = false;
    }

    /**
     * Constructs a hand with the given list of cards
     * @param cards The desired cards in the hand
     */
    public Hand (Card cards) {
        this.cards = cards;
        this.next = null;
        this.value = calculateValue();
        this.hasAce = false;
    }

    /**
     * Constructs a hand with the given list of cards and inserts it at the
     * beginning of the linked list.
     * @param cards The desired cards in the hand
     * @param next The desired list of hands
     */
    public Hand (Card cards, Hand next) {
        this.cards = cards;
        this.next = next;
        this.value = calculateValue();
        this.hasAce = false;
    }

    /**
     * Calculates the true value of the cards in the hand
     * @return the true value of the hand
     */
    private int calculateValue() {
        int value = 0;
        Card currentCard = cards;

        while (currentCard != null) {
            value += currentCard.getValue();
            currentCard = currentCard.getNext();
        }

        return value;
    }

    /**
     * Returns the cards in the hand
     * @return the cards in the hand
     */
    public Card getCards() {
        return cards;
    }

    /**
     * Sets the cards in the hand to the given list of cards
     * @param cards The desired cards
     */
    public void setCards(Card cards) {
        this.cards = cards;
    }

    /**
     * Returns the next hand in list
     * @return the next hand in the list
     */
    public Hand getNext() {
        return next;
    }

    /**
     * Sets the next hand in the list to the given value
     * @param next The desired next hand in the list
     */
    public void setNext(Hand next) {
        this.next = next;
    }

    /**
     * Calculates the optimal value of the hand
     * @return The hand's optimal value
     */
    public int getValue() {
        if (value > 21 && hasAce()) {
            return value - 10;
        }
        return value;
    }

    /**
     * Adds the given value to the hand
     * @param value The desired value to add
     */
    public void addValue(int value) {
        this.value += value;
    }

    /**
     * Checks if the hand contains an ace
     * @return true if the hand contains an ace; false otherwise
     */
    public boolean hasAce() {
        return hasAce;
    }

    /**
     * Sets hasAce to true when an ace is drawn
     * TODO: Move into setCards
     */
    public void drawAce() {
        hasAce = true;
    }

    /**
     * Checks if a hand is soft, which means it can have two possible values 
     * due to containing an ace
     * @return true if the hand is a soft hand; false otherwise
     */
    public boolean isSoft() {
        return (hasAce() && getValue() < 21);
    }

    /**
     * Checks if the hand has busted, or is greater than 21
     * @return true if the hand has busted, false otherwise
     */
    public boolean busted() {
        return getValue() > 21;
    }
}