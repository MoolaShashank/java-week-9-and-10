import java.util.Scanner;

public class UpperCaseCompare {

    // Method to convert string to uppercase using charAt() + ASCII logic
    public static String toUpperManual(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // if lowercase letter, convert using ASCII difference (32)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }

            result += ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input full text
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Manual conversion
            String manualUpper = toUpperManual(text);

            // Built-in conversion
            String builtInUpper = text.toUpperCase();

            // Compare results
            boolean result = compareStrings(manualUpper, builtInUpper);

            // Output
            System.out.println("\nManual Uppercase: " + manualUpper);
            System.out.println("Built-in Uppercase: " + builtInUpper);

            if (result) {
                System.out.println("Both results are SAME ✅");
            } else {
                System.out.println("Results are DIFFERENT ❌");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
