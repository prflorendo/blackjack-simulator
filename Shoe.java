import java.util.Random;
/**
 * The shoe class represents a shoe, which is a typically a combination of 6-8
 * decks.
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Shoe extends Deck {
    final int NUM_DECKS;

    /**
     * Constructs a new shoe object by constructing 6 decks and linking them 
     * together
     */
    public Shoe() {
        super();
        NUM_DECKS = 6;
        for (int i = 1; i < NUM_DECKS; i++) {
            Deck iDeck = new Deck();
            getBottomCard().setNext(iDeck.getTopCard());
            setBottomCard(iDeck.getBottomCard());
        }
        setNumCards(52 * NUM_DECKS);
    }

    /**
     * Constructs a new shoe with the given number of decks
     * @param NUM_DECKS The desired number of decks
     */
    public Shoe(int NUM_DECKS) {
        super();
        this.NUM_DECKS = 6;
        for (int i = 1; i < NUM_DECKS; i++) {
            Deck iDeck = new Deck();
            getBottomCard().setNext(iDeck.getTopCard());
            setBottomCard(iDeck.getBottomCard());
        }
    }

    /**
     * Returns the number of decks in the shoe
     * @return the number of decks in the shoe
     */
    public int getNumDecks() {
        return NUM_DECKS;
    }

    /**
     * Uses a modified version of Fisher-Yates to shuffle the shoe
     * @param randomGenerator the seed passed by the public call
     */
    private void shuffle(Random randomGenerator) {
        Card[] arrayDeck = toArray();

        for (int i = arrayDeck.length - 1; i >= 1; i--) {
            int swapIndex = randomGenerator.nextInt(i);
            swap(arrayDeck, i, swapIndex);
        }

        toLinkedList(arrayDeck);
    }

    /**
     * Shuffles the shoe using a random seed
     */
    public void shuffle() {
        shuffle(new Random());
    }

    /**
     * Shuffles the shoe using the given seed
     */
    public void shuffle(int seed) {
        shuffle(new Random(seed));
    }

    /**
     * Converts the linked list of cards into its array representation
     * @return The array representation of the shoe
     */
    public Card[] toArray() {
        Card currentCard = getTopCard();
        Card[] arrayDeck = new Card[getNumCards() * NUM_DECKS];
        int index = 0;

        while (currentCard != null) {
            arrayDeck[index] = currentCard;

            index += 1;
            currentCard = currentCard.getNext();
        }
        return arrayDeck;
    }
}
