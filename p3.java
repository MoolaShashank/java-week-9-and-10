import java.util.Scanner;

public class WordLength2D {

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // end reached
        }
        return count;
    }

    // Method to split text manually using charAt()
    public static String[] splitText(String text) {

        int len = findLength(text);

        // Count spaces
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // Create words array
        String[] words = new String[spaceCount + 1];

        int start = 0;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }

        // Last word
        words[index] = text.substring(start, len);

        return words;
    }

    // Method to create 2D array [word, length]
    public static String[][] createWordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i]; // word
            int len = findLength(words[i]);
            result[i][1] = String.valueOf(len); // convert int → String
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Split words
            String[] words = splitText(text);

            // Create 2D array
            String[][] wordData = createWordLengthArray(words);

            // Display in tabular format
            System.out.println("\nWord\tLength");
            System.out.println("----------------");

            for (int i = 0; i < wordData.length; i++) {
                String word = wordData[i][0];
                int length = Integer.parseInt(wordData[i][1]); // convert back to int
                System.out.println(word + "\t" + length);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
