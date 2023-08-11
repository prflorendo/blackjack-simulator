import java.util.Random;
public class Shoe extends Deck {
    final int NUM_DECKS;

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

    public Shoe(int NUM_DECKS) {
        super();
        this.NUM_DECKS = 6;
        for (int i = 1; i < NUM_DECKS; i++) {
            Deck iDeck = new Deck();
            getBottomCard().setNext(iDeck.getTopCard());
            setBottomCard(iDeck.getBottomCard());
        }
    }

    public int getNumDecks() {
        return NUM_DECKS;
    }

    private void shuffle(Random randomGenerator) {
        Card[] arrayDeck = toArray();

        for (int i = arrayDeck.length - 1; i >= 1; i--) {
            int swapIndex = randomGenerator.nextInt(i);
            swap(arrayDeck, i, swapIndex);
        }

        toLinkedList(arrayDeck);
    }

    public void shuffle() {
        shuffle(new Random());
    }

    public void shuffle(int seed) {
        shuffle(new Random(seed));
    }

    public Card[] toArray() {
        System.out.println("boobs");
        Card currentCard = getTopCard();
        Card[] arrayDeck = new Card[52 * NUM_DECKS];
        int index = 0;

        while (currentCard != null) {
            arrayDeck[index] = currentCard;

            index += 1;
            currentCard = currentCard.getNext();
        }
        return arrayDeck;
    }
}
