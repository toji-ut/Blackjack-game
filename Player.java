/**
 * The Player class represents a player in a game of Blackjack. Each player has a name and a hand of cards.
 */
import java.util.ArrayList;
import java.util.List;
public class Player {
    private String name; // A string representing the player's name
    private List<Card> hand; // A list of Card objects representing the player's hand

    /**
     * Constructs a new Player object with the given name and an empty hand.
     *
     * @param name a string representing the player's name
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>(); // Create a new ArrayList to hold the player's hand
    }

    /**
     * Returns the player's name.
     *
     * @return a string representing the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a Card object to the player's hand.
     *
     * @param card a Card object to add to the player's hand
     */
    public void addCard(Card card) {
        hand.add(card); // Add the card to the player's hand
    }

    /**
     * Calculates the value of the player's hand according to the rules of Blackjack.
     *
     * @return an integer representing the value of the player's hand
     */
    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        // Iterate over the cards in the player's hand and calculate the value of the hand
        for (Card card : hand) {
            value += card.getValue();

            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        // If the value of the hand is greater than 21 and the hand contains Aces, reduce the value of the Aces to 1
        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value; // Return the value of the player's hand
    }

    /**
     * Prints the player's hand to the console, hiding the first card if showFirstCard is false.
     *
     * @param showFirstCard a boolean indicating whether or not to show the first card in the player's hand
     */
    public void printHand(boolean showFirstCard) {
        System.out.println(name + "'s hand:"); // Print the player's name and indicate that it is their hand

        // Iterate over the cards in the player's hand and print them to the console, hiding the first card if necessary
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0 && !showFirstCard) {
                System.out.println("[hidden]");
            } else {
                System.out.println(hand.get(i));
            }
        }

        System.out.println("Hand value: " + getHandValue()); // Print the value of the player's hand
        System.out.println(); // Add a newline for formatting purposes
    }
}
