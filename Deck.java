import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class represents a standard deck of 52 playing cards. The deck is created
 * when a new Deck object is instantiated, and the cards are shuffled randomly.
 */
public class Deck {
    private List<Card> cards; // A list of Card objects representing the deck

    /**
     * Constructs a new Deck object with 52 playing cards, one for each combination of suit and rank.
     * The cards are shuffled randomly after they are created.
     */
    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; // An array of strings representing the suits of the cards
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; // An array of strings representing the ranks of the cards

        cards = new ArrayList<>(); // Create a new ArrayList to hold the Card objects

        // Iterate over the suits and ranks to create a Card object for each combination and add it to the deck
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }

        Collections.shuffle(cards); // Shuffle the deck randomly
    }

    /**
     * Removes and returns the first card from the deck.
     *
     * @return a Card object representing the first card in the deck
     */
    public Card drawCard() {
        return cards.remove(0); // Remove and return the first card in the deck
    }
}
