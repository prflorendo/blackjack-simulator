public class Card {
    private final int suit;
    private final int value;
    private Card nextCard;

    public Card() {
        suit = 0;
        value = 1;
        nextCard = null;
    }

    public Card(Card nextCard) {
        suit = 0;
        value = 1;
        nextCard = null;
    }

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        nextCard = null;
    }

    public Card(int suit, int value, Card nextCard) {
        this.suit = suit;
        this.value = value;
        this.nextCard = nextCard;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public Card getNext() {
        return nextCard;
    }

    public void setNext(Card nextCard) {
        this.nextCard = nextCard;
    }

    public String toString() {
        String card = "";
        int value = getValue();
        int suit = getSuit();

        if (value == 1) {
            card += "Ace";
        } else if (value == 11) {
            card += "Jack";
        } else if (value == 12) {
            card += "Queen";
        } else if (value == 13) {
            card += "King";
        } else if (value <= 10) {
            card += value;
        } else {
            card += "Invalid value!";
        }

        card += " of ";

        switch (getSuit()) {
            case 0:
                card += "Spades";
                break;
            case 1:
                card += "Clubs";
                break;
            case 2:
                card += "Hearts";
                break;
            case 3:
                card += "Diamonds";
                break;
            default:
                card += "Invalid suit!";
        }
        return card;
    }
}