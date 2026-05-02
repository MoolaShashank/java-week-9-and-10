import java.util.Scanner;

public class PalindromeChecker {

    // Logic 1: Iterative (two pointers)
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Logic 2: Recursive
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end) return true;

        if (text.charAt(start) != text.charAt(end)) return false;

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Reverse using charAt()
    public static String reverseString(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return reversed;
    }

    public static boolean isPalindromeUsingArray(String text) {

        String reversed = reverseString(text);

        if (text.length() != reversed.length()) return false;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != reversed.charAt(i)) {
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
            String text = sc.nextLine();

            boolean result1 = isPalindromeIterative(text);
            boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
            boolean result3 = isPalindromeUsingArray(text);

            // Output
            System.out.println("\nUsing Iterative Method: " + result1);
            System.out.println("Using Recursive Method: " + result2);
            System.out.println("Using Reverse Method: " + result3);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
