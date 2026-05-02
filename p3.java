import java.util.Scanner;

public class CharArrayCompare {

    // Method to convert string to char array manually (without toCharArray)
    public static char[] getCharacters(String text) {

        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }

        return result;
    }

    // Method to compare two char arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
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

            // User-defined method
            char[] manualArray = getCharacters(text);

            // Built-in method
            char[] builtInArray = text.toCharArray();

            // Compare arrays
            boolean result = compareArrays(manualArray, builtInArray);

            // Output arrays
            System.out.print("\nManual char array: ");
            for (char c : manualArray) {
                System.out.print(c + " ");
            }

            System.out.print("\nBuilt-in char array: ");
            for (char c : builtInArray) {
                System.out.print(c + " ");
            }

            // Final result
            if (result) {
                System.out.println("\n\nBoth arrays are SAME ✅");
            } else {
                System.out.println("\n\nArrays are DIFFERENT ❌");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
