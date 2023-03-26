import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
    private List<Player> players;
    private Deck deck;

    public Blackjack(int numPlayers) {
        players = new ArrayList<>();
        deck = new Deck();

        for (int i = 1; i <= numPlayers; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
        }

        Player dealer = new Player("Dealer");
        players.add(dealer);

        System.out.println("Let's play Blackjack!");
        System.out.println();

        for (Player player : players) {
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
        }

        for (Player player : players) {
            if (player.getName().equals("Dealer")) {
                player.printHand(false);
            } else {
                player.printHand(true);
            }
        }

        for (Player player : players) {
            if (player.getName().equals("Dealer")) {
                while (player.getHandValue() < 17) {
                    player.addCard(deck.drawCard());
                    player.printHand(false);
                }
            } else {
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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                System.out.println();
                new Blackjack(numPlayers);
                break;
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                System.out.println();
            }
        }
    }
}
