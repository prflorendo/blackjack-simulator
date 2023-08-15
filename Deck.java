import java.util.Random;
/**
 * Represents a deck of playing cards as a linked list.
 * 
 * @author prflorendo
 * @version 8/11/2023
 */
public class Deck {
    private Card topCard;
    private Card bottomCard;
    int numCards;

    /**
     * Constructs a full deck of 52 cards without Jokers.
     */
    public Deck() {
        for (int suit = 1; suit <= 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                Card nextCard = new Card(suit, value);
                if (suit == 1 && value == 1) {
                    topCard = nextCard;
                    bottomCard = nextCard;
                } else {
                    bottomCard.setNext(nextCard);
                    bottomCard = nextCard;
                }
            }
        }
        numCards = 52;
    }
    
    /**
     * Returns the top card of the deck.
     * @return The top card of the deck
     */
    public Card getTopCard() {
        return topCard;
    }

    /**
     * Sets the top card of the deck to the given Card
     * @param topCard the desired top card
     */
    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    /**
     * Returns the last card in the deck
     * @return The bottom card of the deck
     */
    public Card getBottomCard() {
        return bottomCard;
    }

    /**
     * Sets the bottom card of the deck to the given card
     * @param bottomCard the desired bottom card
     */
    public void setBottomCard(Card bottomCard) {
        this.bottomCard = bottomCard;
    }

    /**
     * Shuffles the deck using a random seed.
     */
    public void shuffle() {
        shuffle(new Random());
    }

    /**
     * Shuffles the deck using the given seed, 
     * allowing shuffles to be replicated
     * @param seed The desired seed
     */
    public void shuffle(int seed) {
        shuffle(new Random(seed));
    }

    /**
     * Uses a modified version of the Fisher-Yates algorithm in order to
     * randomly shuffle the deck, randomizing the order of cards in the deck.
     * @param randomGenerator The seed passed by the public shuffle call
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
     * Converts the deck of cards from a linked list into an array for
     * shuffling purposes.
     * @return The array representation of the deck
     */
    private Card[] toArray() {
        Card currentCard = topCard;
        Card[] arrayDeck = new Card[getNumCards()];
        int index = 0;
        
        while (currentCard != null) {
            arrayDeck[index] = currentCard;

            index += 1;
            currentCard = currentCard.getNext();
        }

        return arrayDeck;
    }

    /**
     * Swaps two Cards in the given array
     * @param arrayDeck The array of cards
     * @param a The first element to be swapped
     * @param b The second element to be swapped
     */
    protected void swap(Card[] arrayDeck, int a, int b) {
        Card swapCard = arrayDeck[a];
        arrayDeck[a] = arrayDeck[b];
        arrayDeck[b] = swapCard;
    }

    /**
     * Converts the given array of cards back into its 
     * linked list representation
     * @param arrayDeck The deck to be converted
     */
    protected void toLinkedList(Card[] arrayDeck) {
        Card currentCard = arrayDeck[0];
        topCard = currentCard;

        for (int i = 0; i < arrayDeck.length - 1; i++) {
            currentCard.setNext(arrayDeck[i + 1]);
            currentCard = currentCard.getNext();
        }

        bottomCard = currentCard;
        bottomCard.setNext(null);

        currentCard = topCard;
    }

    /**
     * Returns a string representation of the object. Results in a list of
     * every card in the deck separated by newline characters.
     * @return a string representation of the object.
     */
    public String toString() {
        String str = "";
        Card currentCard = topCard;
        
        while (currentCard != null) {
            str += currentCard + "\n";
            currentCard = currentCard.getNext();
        }

        return str;
    }

    /**
     * Simulates dealing a card by removing the top card from the deck
     * @return The top card of the deck
     */
    public Card dealCard() {
        Card dealtCard = topCard;

        topCard = topCard.getNext();
        setNumCards(numCards - 1);

        return dealtCard;
    }

    /**
     * Returns the number of cards left in the deck
     * @return the number of cards left in the deck
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * Sets the number of cards in the deck to the given value
     * @param numCards The desired number of cards in the deck
     */
    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }
}