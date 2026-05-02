import java.util.Scanner;

public class TrimCompare {

    // Find start and end indexes after trimming spaces
    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Create substring manually using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    // Compare two strings using charAt()
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
            // Input
            System.out.print("Enter text with spaces: ");
            String text = sc.nextLine();

            // Manual trim
            int[] indexes = findTrimIndexes(text);

            String manualTrim;
            if (indexes[0] > indexes[1]) {
                manualTrim = ""; // all spaces case
            } else {
                manualTrim = createSubstring(text, indexes[0], indexes[1]);
            }

            // Built-in trim
            String builtInTrim = text.trim();

            // Compare
            boolean result = compareStrings(manualTrim, builtInTrim);

            // Output
            System.out.println("\nManual Trim: [" + manualTrim + "]");
            System.out.println("Built-in Trim: [" + builtInTrim + "]");

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
