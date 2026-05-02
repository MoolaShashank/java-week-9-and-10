import java.util.Scanner;

public class CharacterClassifier {

    // Method to classify a character
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        // Check if alphabet
        if (ch >= 'a' && ch <= 'z') {

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }

        } else {
            return "Not a Letter";
        }
    }

    // Method to create 2D array [character, type]
    public static String[][] analyzeText(String text) {

        int len = text.length();
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);         // store character
            result[i][1] = checkCharacter(ch);         // store type
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayResult(String[][] data) {

        System.out.println("\nCharacter\tType");
        System.out.println("------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter a string: ");
            String text = sc.nextLine();

            // Process
            String[][] result = analyzeText(text);

            // Display
            displayResult(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
