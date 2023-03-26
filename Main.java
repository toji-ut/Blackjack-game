import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Welcome to Blackjack!
                 _____     _____     _____     _____
                |A    |   |A    |   |A    |   |A    |
                |♠   ♠|   |♣   ♣|   |♥   ♥|   |♦   ♦|
                |  ♠  |   |  ♣  |   |  ♥  |   |  ♦  |
                | ♠ ♠ |   | ♣ ♣ |   | ♥ ♥ |   | ♦ ♦ |
                |____V|   |_____|   |_____|   |_____|
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many players?: ");
        int numPlayers = scanner.nextInt();
        System.out.println();
        new Blackjack(numPlayers);
    }
}