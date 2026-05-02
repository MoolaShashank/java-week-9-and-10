import java.util.Scanner;

public class WordMinMax {

    // Find length without using length()
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

    // Split text into words using charAt()
    public static String[] splitText(String text) {

        int len = findLength(text);

        // Count spaces
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        String[] words = new String[spaceCount + 1];

        int start = 0, index = 0;

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

    // Create 2D array [word, length]
    public static String[][] createWordLengthArray(String[] words) {

        String[][] data = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            int len = findLength(words[i]);
            data[i][1] = String.valueOf(len);
        }

        return data;
    }

    // Find shortest and longest word indexes
    public static int[] findMinMax(String[][] data) {

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < data.length; i++) {
            int len = Integer.parseInt(data[i][1]);

            if (len < Integer.parseInt(data[minIndex][1])) {
                minIndex = i;
            }

            if (len > Integer.parseInt(data[maxIndex][1])) {
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            // Process
            String[] words = splitText(text);
            String[][] wordData = createWordLengthArray(words);
            int[] result = findMinMax(wordData);

            // Output
            System.out.println("\nWord\tLength");
            System.out.println("----------------");

            for (int i = 0; i < wordData.length; i++) {
                System.out.println(wordData[i][0] + "\t" + wordData[i][1]);
            }

            System.out.println("\nShortest Word: " + wordData[result[0]][0]);
            System.out.println("Longest Word: " + wordData[result[1]][0]);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
