import java.util.Scanner;

public class NumberFormatDemo {

    // Method to GENERATE the exception
    public static void generateException(String text) {
        // This will throw NumberFormatException if text is not a valid integer
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    // Method to HANDLE the exception
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value (text or number): ");
        String text = sc.next();

        // Step 1: Generate Exception (caught in main so program continues)
        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Step 2: Handle Exception inside method
        System.out.println("\nHandling Exception:");
        handleException(text);

        sc.close();
    }
}
