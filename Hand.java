public class Hand {
    private Card cards;
    private Hand next;
    private int value;
    private boolean hasAce;

    public Hand() {
        this.cards = null;
        this.next = null;
        this.value = 0;
        this.hasAce = false;
    }

    public Hand(Hand next) {
        this.cards = null;
        this.next = next;
        this.value = 0;
        this.hasAce = false;
    }

    public Hand (Card cards) {
        this.cards = cards;
        this.next = null;
        this.value = getValue();
        this.hasAce = false;
    }

    public Hand (Card cards, Hand next) {
        this.cards = cards;
        this.next = next;
        this.value = calculateValue();
        this.hasAce = false;
    }

    private int calculateValue() {
        int value = 0;
        Card currentCard = cards;

        while (currentCard != null) {
            value += currentCard.getValue();
            currentCard = currentCard.getNext();
        }

        return value;
    }

    public Card getCards() {
        return cards;
    }

    public void setCards(Card cards) {
        this.cards = cards;
    }

    public Hand getNext() {
        return next;
    }

    public void setNext(Hand next) {
        this.next = next;
    }

    public int getValue() {
        if (value > 21 && hasAce()) {
            return value - 10;
        }
        return value;
    }

    public void addValue(int value) {
        this.value += value;
    }

    public boolean hasAce() {
        return hasAce;
    }

    public void drawAce() {
        hasAce = true;
    }

    public boolean isSoft() {
        return (hasAce() && getValue() < 21);
    }

    public boolean busted() {
        return getValue() > 21;
    }
}