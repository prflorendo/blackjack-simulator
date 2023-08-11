public class Player {
    Hand hand;

    public Player() {
        newHand();
    }

    public void newHand() {
        hand = new Hand();
    }

    public void hit(Card newCard) {
        newCard.setNext(hand.getCards());
        hand.setCards(newCard);

        int value = newCard.getValue();

        if (value == 1) {
            hand.drawAce();
            hand.addValue(11);
        } else if (value > 10) {
            hand.addValue(10);;
        } else {
            hand.addValue(value);
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void split(Hand hand) {
        Hand splitHand = new Hand(hand.getCards().getNext());
        hand.getCards().setNext(null);

        hand.setNext(splitHand);
    }
}