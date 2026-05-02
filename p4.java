public class NullPointerDemo {

    // Method to GENERATE NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // Exception here
    }

    // Method to HANDLE NullPointerException
    public static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Step 1: Generate Exception (handled in main so program continues)
        System.out.println("Generating Exception:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Step 2: Refactored version (handled inside method)
        System.out.println("\nHandling Exception:");
        handleException();
    }
}
