/**
 * This class implements a simple game of Blackjack.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
    private List<Player> players;
    private Deck deck;

    /**
     * Constructor for the Blackjack game.
     *
     * @param numPlayers the number of players in the game
     */
    public Blackjack(int numPlayers) {
        players = new ArrayList<>();
        deck = new Deck();

        // Create players
        for (int i = 1; i <= numPlayers; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
        }

        // Create dealer and add to player list
        Player dealer = new Player("Dealer");
        players.add(dealer);

        System.out.println("Let's play Blackjack!");
        System.out.println();

        // Deal initial cards to players
        for (Player player : players) {
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
        }

        // Print initial hands of players
        for (Player player : players) {
            if (player.getName().equals("Dealer")) {
                player.printHand(false);
            } else {
                player.printHand(true);
            }
        }

        // Players take turns hitting or standing
        for (Player player : players) {
            if (player.getName().equals("Dealer")) {
                // Dealer hits until hand value is 17 or more
                while (player.getHandValue() < 17) {
                    player.addCard(deck.drawCard());
                    player.printHand(false);
                }
            } else {
                // Player hits or stands
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.print(player.getName() + ", do you want to hit or stand? ");
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("hit")) {
                        player.addCard(deck.drawCard());
                        player.printHand(true);

                        if (player.getHandValue() > 21) {
                            System.out.println(player.getName() + " busts!");
                            System.out.println();
                            break;
                        }
                    } else if (input.equalsIgnoreCase("stand")) {
                        System.out.println(player.getName() + " stands.");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
                        System.out.println();
                    }
                }
            }
        }

        // Determine winner and print results
        int dealerHandValue = players.get(players.size() - 1).getHandValue();

        for (int i = 0; i < players.size() - 1; i++) {
            Player player = players.get(i);

            if (player.getHandValue() > 21) {
                System.out.println(player.getName() + " loses!");
            } else if (dealerHandValue > 21) {
                System.out.println(player.getName() + " wins!");
            } else if (player.getHandValue() > dealerHandValue) {
                System.out.println(player.getName() + " wins!");
            } else if (player.getHandValue() == dealerHandValue) {
                System.out.println(player.getName() + " pushes.");
            } else {
                System.out.println(player.getName() + " loses!");
            }
        }

        System.out.println();

        // Ask if the players want to play again
        Scanner scanner = new Scanner(System.in);

        // While loop to check if the person wants to play again or no
        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            String input = scanner.nextLine();
            // If yes, then create a new game
            if (input.equalsIgnoreCase("yes")) {
                System.out.println();
                new Blackjack(numPlayers);
                break;
            // If no, then exit the game
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("Thanks for playing!");
                break;
            // Otherwise tell the user that input is invalid
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                System.out.println();
            }
        }
    }
}
