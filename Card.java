/**
 * The Card class represents a playing card in a deck. Each card has a suit, rank, and value.
 * The value of each card is calculated based on its rank, with face cards being worth 10 points
 * and Aces being worth 11 points by default.
 */

public class Card {
    private final String suit; // the suit of the card
    private final String rank; // the rank of the card


    /**
     * Constructs a new Card object with the specified suit and rank.
     * @param suit a String representing the suit of the card
     * @param rank a String representing the rank of the card
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }


    /**
     * Returns the suit of the card.
     * @return a String representing the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the rank of the card.
     * @return a String representing the rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Calculates and returns the value of the card based on its rank.
     * Face cards are worth 10 points and Aces are worth 11 points by default.
     * @return an integer representing the value of the card
     */
    public int getValue() {
        if (rank.equals("Ace")) {
            return 11;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }

    /**
     * Returns a String representation of the card, in the format "rank of suit".
     * @return a String representing the card
     */
    public String toString() {
        return rank + " of " + suit;
    }
}
