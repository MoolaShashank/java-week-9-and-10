import java.util.Scanner;

public class ArrayIndexDemo {

    // Method to GENERATE the exception
    public static void generateException(String[] names) {
        int invalidIndex = names.length; // out of bounds
        System.out.println("Accessing index: " + invalidIndex);
        System.out.println(names[invalidIndex]); // Exception occurs here
    }

    // Method to HANDLE the exception
    public static void handleException(String[] names) {
        int invalidIndex = names.length;

        try {
            System.out.println("Accessing index: " + invalidIndex);
            System.out.println(names[invalidIndex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] names = new String[n];

        // Input names
        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }

        // Step 1: Generate Exception (handled in main so program continues)
        System.out.println("\nGenerating Exception:");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Step 2: Handle Exception inside method
        System.out.println("\nHandling Exception:");
        handleException(names);

        sc.close();
    }
}
