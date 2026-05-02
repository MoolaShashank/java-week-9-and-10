import java.util.Scanner;

public class VotingEligibility {

    // Method to take ages as input and return array
    public static int[] getAges(int n, Scanner sc) {

        int[] ages = new int[n];

        System.out.println("Enter ages of " + n + " students:");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]); // store age

            if (ages[i] < 0) {
                result[i][1] = "false"; // invalid age
            } else if (ages[i] >= 18) {
                result[i][1] = "true"; // can vote
            } else {
                result[i][1] = "false"; // cannot vote
            }
        }

        return result;
    }

    // Method to display result in tabular format
    public static void display(String[][] data) {

        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            int age = Integer.parseInt(data[i][0]);
            boolean canVote = Boolean.parseBoolean(data[i][1]);

            System.out.println(age + "\t" + canVote);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int n = 10; // fixed number of students

            int[] ages = getAges(n, sc);
            String[][] result = checkEligibility(ages);

            display(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
