import java.util.Scanner;

public class SplitCompare {

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // reached end
        }
        return count;
    }

    // Method to split text manually using charAt()
    public static String[] splitText(String text) {

        int len = findLength(text);

        // Count spaces to determine number of words
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int wordCount = spaceCount + 1;

        // Store words
        String[] words = new String[wordCount];

        int start = 0;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }

        // last word
        words[index] = text.substring(start, len);

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Manual split
            String[] manualWords = splitText(text);

            // Built-in split
            String[] builtInWords = text.split(" ");

            // Compare
            boolean result = compareArrays(manualWords, builtInWords);

            // Output
            System.out.println("\nManual Split:");
            for (String word : manualWords) {
                System.out.print(word + " ");
            }

            System.out.println("\nBuilt-in Split:");
            for (String word : builtInWords) {
                System.out.print(word + " ");
            }

            if (result) {
                System.out.println("\n\nBoth results are SAME ✅");
            } else {
                System.out.println("\n\nResults are DIFFERENT ❌");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
