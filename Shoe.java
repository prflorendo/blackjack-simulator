import java.util.Random;
public class Shoe extends Deck {
    final int numDecks;

    public Shoe() {
        super();
        numDecks = 6;
        for (int i = 1; i < numDecks; i++) {
            Deck iDeck = new Deck();
            getBottomCard().setNext(iDeck.getTopCard());
            setBottomCard(iDeck.getBottomCard());
        }
    }

    public Shoe(int numDecks) {
        super();
        this.numDecks = 6;
        for (int i = 1; i < numDecks; i++) {
            Deck iDeck = new Deck();
            getBottomCard().setNext(iDeck.getTopCard());
            setBottomCard(iDeck.getBottomCard());
        }
    }

    public int getNumDecks() {
        return numDecks;
    }

    public void shuffle() {
        shuffle(new Random());
    }

    public void shuffle(int seed) {
        shuffle(new Random(seed));
    }

    private void shuffle(Random randomGenerator) {
        Card[] arrayDeck = toArray();

        for (int i = arrayDeck.length - 1; i >= 1; i--) {
            int swapIndex = randomGenerator.nextInt(i);
            swap(arrayDeck, i, swapIndex);
        }

        toLinkedList(arrayDeck);
    }

    public Card[] toArray() {
        System.out.println("boobs");
        Card currentCard = getTopCard();
        Card[] arrayDeck = new Card[52 * numDecks];
        int index = 0;

        while (currentCard != null) {
            arrayDeck[index] = currentCard;

            index += 1;
            currentCard = currentCard.getNext();
        }
        return arrayDeck;
    }
}
