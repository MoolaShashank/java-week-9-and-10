import java.util.Scanner;

public class AnagramChecker {

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String s1, String s2) {

        // Step 1: Check length
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[256]; // ASCII frequency array

        // Step 2: Count frequency of first string
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }

        // Step 3: Subtract frequency using second string
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i)]--;
        }

        // Step 4: Check if all frequencies are zero
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter first string: ");
            String s1 = sc.nextLine();

            System.out.print("Enter second string: ");
            String s2 = sc.nextLine();

            // Optional: ignore case
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            // Process
            boolean result = areAnagrams(s1, s2);

            // Output
            if (result) {
                System.out.println("The strings are Anagrams ✅");
            } else {
                System.out.println("The strings are NOT Anagrams ❌");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
