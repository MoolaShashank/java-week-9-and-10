import java.util.Scanner;

public class StringLengthWithoutBuiltin {

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;

        try {
            // Keep accessing characters until it throws exception
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Reached beyond last index → count is the length
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter a string: ");
            String text = sc.next();

            // Manual method
            int manualLength = findLength(text);

            // Built-in method
            int builtInLength = text.length();

            // Output
            System.out.println("\nLength (without length()): " + manualLength);
            System.out.println("Length (using length()): " + builtInLength);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
