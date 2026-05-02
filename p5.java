import java.util.Scanner;

public class StringIndexDemo {

    // Method to GENERATE the exception
    public static void generateException(String text) {
        // Accessing invalid index → beyond length
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }

    // Method to HANDLE the exception
    public static void handleException(String text) {
        try {
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // Step 1: Generate Exception (handled in main to continue program)
        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Step 2: Handle Exception inside method
        System.out.println("\nHandling Exception:");
        handleException(text);

        sc.close();
    }
}
