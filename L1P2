import java.util.Scanner;

public class SubstringCompare {

    // Create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result += text.charAt(i);   // build substring manually
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
            System.out.print("Enter a string: ");
            String text = sc.next();

            System.out.print("Enter start index: ");
            int start = sc.nextInt();

            System.out.print("Enter end index: ");
            int end = sc.nextInt();

            // Using charAt()
            String sub1 = createSubstring(text, start, end);

            // Using built-in substring()
            String sub2 = text.substring(start, end);

            // Compare both substrings
            boolean result = compareStrings(sub1, sub2);

            // Output
            System.out.println("\nSubstring using charAt(): " + sub1);
            System.out.println("Substring using substring(): " + sub2);

            if (result) {
                System.out.println("Both substrings are SAME ✅");
            } else {
                System.out.println("Substrings are DIFFERENT ❌");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
