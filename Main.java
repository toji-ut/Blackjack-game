/**
 * This class represents the entry point of the Blackjack game.
 */
import java.util.Scanner;

public class Main {
    /**
     * The main method of the game.
     */
    public static void main(String[] args) {
        // Display welcome message and prompt for number of players
        System.out.println("""
            Welcome to Blackjack!
             _____     _____     _____     _____
            |A    |   |A    |   |A    |   |A    |
            |♠   ♠|   |♣   ♣|   |♥   ♥|   |♦   ♦|
            |  ♠  |   |  ♣  |   |  ♥  |   |  ♦  |
            | ♠ ♠ |   | ♣ ♣ |   | ♥ ♥ |   | ♦ ♦ |
            |_____|   |_____|   |_____|   |_____|
            """);
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many players?: ");
        int numPlayers = scanner.nextInt();
        System.out.println();

        // Start the game
        new Blackjack(numPlayers);
    }
}
