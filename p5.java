import java.util.Scanner;

public class FrequencyUsingUnique {

    // a) Method to find unique characters using charAt()
    public static char[] getUniqueCharacters(String text) {

        int len = text.length();
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {

            char current = text.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < index; j++) {
                if (temp[j] == current) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[index++] = current;
            }
        }

        // Create exact size array
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // b) Method to find frequency using unique characters
    public static String[][] findFrequency(String text, char[] unique) {

        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {

            char ch = unique[i];
            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == ch) {
                    count++;
                }
            }

            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(count);
        }

        return result;
    }

    // Display method
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
            char[] uniqueChars = getUniqueCharacters(text);
            String[][] result = findFrequency(text, uniqueChars);

            // Output
            display(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
