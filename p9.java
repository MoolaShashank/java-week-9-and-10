import java.util.Scanner;

public class RockPaperScissors {

    // 0 = Rock, 1 = Paper, 2 = Scissors
    public static int getComputerChoice() {
        return (int)(Math.random() * 3);
    }

    // Decide winner: 1 = Player, -1 = Computer, 0 = Draw
    public static int getWinner(int player, int computer) {

        if (player == computer) return 0;

        if ((player == 0 && computer == 2) ||  // rock beats scissors
            (player == 1 && computer == 0) ||  // paper beats rock
            (player == 2 && computer == 1)) {  // scissors beats paper
            return 1;
        }

        return -1;
    }

    // Convert choice to string
    public static String choiceToString(int choice) {
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }

    // Calculate stats (wins + percentages)
    public static String[][] calculateStats(int playerWins, int compWins, int totalGames) {

        String[][] stats = new String[2][3];

        double playerPercent = (playerWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.format("%.2f%%", playerPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f%%", compPercent);

        return stats;
    }

    // Display results
    public static void displayResults(String[][] gameResults, String[][] stats) {

        System.out.println("\nGame\tPlayer\tComputer\tWinner");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" +
                    gameResults[i][0] + "\t" +
                    gameResults[i][1] + "\t\t" +
                    gameResults[i][2]);
        }

        System.out.println("\nStats:");
        System.out.println("Player/Computer\tWins\tPercentage");
        System.out.println("--------------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t\t" +
                               stats[i][1] + "\t" +
                               stats[i][2]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of games: ");
            int n = sc.nextInt();

            String[][] results = new String[n][3];

            int playerWins = 0;
            int compWins = 0;

            for (int i = 0; i < n; i++) {

                System.out.println("\nGame " + (i + 1));
                System.out.print("Enter choice (0=Rock, 1=Paper, 2=Scissors): ");
                int playerChoice = sc.nextInt();

                int compChoice = getComputerChoice();

                int winner = getWinner(playerChoice, compChoice);

                String result;
                if (winner == 1) {
                    result = "Player";
                    playerWins++;
                } else if (winner == -1) {
                    result = "Computer";
                    compWins++;
                } else {
                    result = "Draw";
                }

                results[i][0] = choiceToString(playerChoice);
                results[i][1] = choiceToString(compChoice);
                results[i][2] = result;
            }

            String[][] stats = calculateStats(playerWins, compWins, n);

            displayResults(results, stats);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
