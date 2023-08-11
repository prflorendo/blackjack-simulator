import java.util.Random;
public class Deck {
    private Card topCard;
    private Card bottomCard;

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
    }
    
    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public Card getBottomCard() {
        return bottomCard;
    }

    public void setBottomCard(Card bottomCard) {
        this.bottomCard = bottomCard;
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

    private Card[] toArray() {
        Card currentCard = topCard;
        Card[] arrayDeck = new Card[52];
        int index = 0;
        
        while (currentCard != null) {
            arrayDeck[index] = currentCard;

            index += 1;
            currentCard = currentCard.getNext();
        }

        return arrayDeck;
    }

    protected void swap(Card[] arrayDeck, int a, int b) {
        Card swapCard = arrayDeck[a];
        arrayDeck[a] = arrayDeck[b];
        arrayDeck[b] = swapCard;
    }

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

    public String toString() {
        String str = "";
        Card currentCard = topCard;
        
        while (currentCard != null) {
            str += currentCard + "\n";
            currentCard = currentCard.getNext();
        }

        return str;
    }
}