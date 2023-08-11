public class Card {
    private final int suit;
    private final int value;
    private Card nextCard;

    public Card() {
        suit = 1;
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
            card += "A";
        } else if (value == 11) {
            card += "J";
        } else if (value == 12) {
            card += "Q";
        } else if (value == 13) {
            card += "K";
        } else if (value <= 10) {
            card += value;
        } else {
            card += "Invalid value!";
        }

        card += " of ";

        switch (suit) {
            case 1:
                card += "Spades";
                break;
            case 2:
                card += "Clubs";
                break;
            case 3:
                card += "Hearts";
                break;
            case 4:
                card += "Diamonds";
                break;
            default:
                card += "Invalid suit!";
        }
        return card;
    }

    public int compareTo(Card compareCard) {
        if (getSuit() == compareCard.getSuit()) {
            return getValue() - compareCard.getValue();
        }
        return getSuit() - compareCard.getSuit();
    }

    public boolean equals(Card compareCard) {
        return compareTo(compareCard) == 0;
    }

    public int compareValue(Card compareCard) {
        return getValue() - compareCard.getValue();
    }

    public boolean equalsValue(Card compareCard) {
        return compareValue(compareCard) == 0;
    }
}