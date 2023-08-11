public class Player {
    Card hand;
    int handValue;
    boolean hasAce;

    public Player() {
        newHand();
    }

    public void newHand() {
        hand = null;
        handValue = 0;
        hasAce = false;
    }

    public void hit(Card newCard) {
        newCard.setNext(hand);
        hand = newCard;

        int value = newCard.getValue();

        if (value == 1) {
            hasAce = true;
            handValue += 11;
        } else if (value > 10) {
            handValue += 10;
        } else {
            handValue += value;
        }
    }

    public int getHandValue() {
        if (handValue > 21 && hasAce) {
            return handValue - 10;
        }
        return handValue;
    }

    public boolean busted() {
        return getHandValue() > 21;
    }
}
