import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency and return 2D array
    public static String[][] findFrequency(String text) {

        int[] freq = new int[256]; // ASCII frequency array

        // Step 1: Count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array [character, frequency]
        String[][] result = new String[uniqueCount][2];

        int index = 0;

        // Step 4: Store character and frequency
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char)i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    // Method to display result
    public static void display(String[][] data) {

        System.out.println("\nCharacter\tFrequency");
        System.out.println("--------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter a string: ");
            String text = sc.nextLine();

            // Process
            String[][] result = findFrequency(text);

            // Output
            display(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
