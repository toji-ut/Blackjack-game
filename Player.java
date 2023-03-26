import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            value += card.getValue();

            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public void printHand(boolean showFirstCard) {
        System.out.println(name + "'s hand:");

        for (int i = 0; i < hand.size(); i++) {
            if (i == 0 && !showFirstCard) {
                System.out.println("[hidden]");
            } else {
                System.out.println(hand.get(i));
            }
        }

        System.out.println("Hand value: " + getHandValue());
        System.out.println();
    }
}
