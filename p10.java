import java.util.Scanner;

public class LowerCaseCompare {

    // Method to convert string to lowercase using charAt() + ASCII logic
    public static String toLowerManual(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // if uppercase letter, convert using ASCII difference (32)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
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
            String manualLower = toLowerManual(text);

            // Built-in conversion
            String builtInLower = text.toLowerCase();

            // Compare results
            boolean result = compareStrings(manualLower, builtInLower);

            // Output
            System.out.println("\nManual Lowercase: " + manualLower);
            System.out.println("Built-in Lowercase: " + builtInLower);

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
