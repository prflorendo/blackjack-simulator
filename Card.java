/**
 * The Card class represents a set of playing cards in the form of a 
 * linked list. 
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Card {
    private static final int SPADE = 1;
    private static final int CLUB = 2;
    private static final int HEART = 3;
    private static final int DIAMOND = 4;
    private static final int ACE = 1;
    private static final int JACK = 11;
    private static final int QUEEN = 14;
    private static final int KING = 15;
    private final int suit;
    private final int value;
    private Card nextCard;

    /**
     * Default constructor. Initializes a single card as an Ace of Spades.
     */
    public Card() {
        suit = SPADE;
        value = 1;
        nextCard = null;
    }

    /**
     * Constructs a copy of the given Card while removing the rest of the cards
     * in the list.
     * @param copyCard The card to be copied
     */
    public Card(Card copyCard) {
        this.suit = copyCard.getSuit();
        this.value = copyCard.getValue();
        this.nextCard = null;
    }

    /**
     * Constructs a Card with the given suit and value
     * @param suit The desired suit of the new card
     * @param value The desired value of the new card
     */
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        nextCard = null;
    }

    /**
     * Constructs a Card with the given suit and value, then inserts it at
     * the beginning of the given list of cards.
     * @param suit The desired suit of the new card
     * @param value The desired value of the new card
     * @param nextCard The linked list of cards
     */
    public Card(int suit, int value, Card nextCard) {
        this.suit = suit;
        this.value = value;
        this.nextCard = nextCard;
    }

    /**
     * Returns the suit of the Card
     * @return The Card's suit
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the value of the Card
     * @return The Card's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the next Card in the linked list
     * @return The next Card in the linked list
     */
    public Card getNext() {
        return nextCard;
    }

    /**
     * Updates next item in the list to point to the given Card
     * @param nextCard The desired next Card in the list
     */
    public void setNext(Card nextCard) {
        this.nextCard = nextCard;
    }

    /**
     * Returns a String representation of the Card in the form 
     * "[Value] of [Suit]"
     * @return a String representation of this object
     */
    public String toString() {
        String card = "";
        int value = getValue();
        int suit = getSuit();

        if (value == ACE) {
            card += "A";
        } else if (value == JACK) {
            card += "J";
        } else if (value == QUEEN) {
            card += "Q";
        } else if (value == KING) {
            card += "K";
        } else if (value <= 10) {
            card += value;
        } else {
            card += "Invalid value!";
        }

        card += " of ";

        switch (suit) {
            case SPADE:
                card += "Spades";
                break;
            case CLUB:
                card += "Clubs";
                break;
            case HEART:
                card += "Hearts";
                break;
            case DIAMOND:
                card += "Diamonds";
                break;
            default:
                card += "Invalid suit!";
        }
        return card;
    }

    /**
     * Compares this object to another Card. If the two cards have the same
     * suit, returns the difference between their values. Else, returns the
     * difference between their suits, with Diamond > Heart > Club > Spade.
     * @param compareCard The Card to be compared
     * @return The value 0 if this Card is equal to the argument Card;
     *         A value less than 0 if this Card is comes before the argument
     *         Card in a sorted deck; and a value greater than 0 if this Card
     *         comes after the argument Card in a sorted deck
     */
    public int compareTo(Card compareCard) {
        if (getSuit() == compareCard.getSuit()) {
            return getValue() - compareCard.getValue();
        }
        return getSuit() - compareCard.getSuit();
    }

    /**
     * Determines if two Cards are equivalent to each other
     * @param compareCard The Card to be compared
     * @return true if both Cards have the same value and suit; false otherwise
     */
    public boolean equals(Card compareCard) {
        return compareTo(compareCard) == 0;
    }

    /**
     * Compares the value of this card with another Card. Similar to compareTo,
     * except suit-insensitive.
     * @param compareCard The Card to be compared
     * @return 0 if both cards have the same value; a value less than 0 if this
     *         Card has a value less than the argument Card; and a value greater
     *         than 0 if this Card has a value greater than the argument Card 
     */
    public int compareValue(Card compareCard) {
        return getValue() - compareCard.getValue();
    }

    /**
     * Determines if two cards have the same value. Similar to equals, except
     * suit-insensitive.
     * @param compareCard The Card to be compared
     * @return true if both Cards have the same value; false otherwise
     */
    public boolean equalsValue(Card compareCard) {
        return compareValue(compareCard) == 0;
    }
}