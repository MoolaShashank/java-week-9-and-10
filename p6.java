import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to GENERATE the exception
    public static void generateException(String text) {
        int start = 5;
        int end = 2; // start > end → invalid

        // This will throw IllegalArgumentException (invalid arguments)
        String result = text.substring(start, end);
        System.out.println(result);
    }

    // Method to HANDLE the exception
    public static void handleException(String text) {
        int start = 5;
        int end = 2;

        try {
            String result = text.substring(start, end);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // Step 1: Generate Exception (handled in main so program continues)
        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Step 2: Handle Exception inside method
        System.out.println("\nHandling Exception:");
        handleException(text);

        sc.close();
    }
}
