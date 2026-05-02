import java.util.Scanner;

public class CardGame {

    // a) Initialize deck
    public static String[] initializeDeck() {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        int n = suits.length * ranks.length;
        String[] deck = new String[n];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }

        return deck;
    }

    // b) Shuffle deck
    public static void shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomIndex = i + (int)(Math.random() * (n - i));

            // swap
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // c) Distribute cards
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {

        if (players * cardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return null;
        }

        String[][] result = new String[players][cardsPerPlayer];

        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[index++];
            }
        }

        return result;
    }

    // d) Display players and cards
    public static void display(String[][] playersCards) {

        if (playersCards == null) return;

        for (int i = 0; i < playersCards.length; i++) {

            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println("  " + playersCards[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter number of players: ");
            int players = sc.nextInt();

            System.out.print("Enter number of cards per player: ");
            int cards = sc.nextInt();

            // Process
            String[] deck = initializeDeck();
            shuffleDeck(deck);

            String[][] distributed = distributeCards(deck, players, cards);

            // Output
            display(distributed);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
