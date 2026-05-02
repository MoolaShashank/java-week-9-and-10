import java.util.Scanner;

public class UniqueCharacters {

    // a) Find length without using length()
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

    // b) Find unique characters using charAt()
    public static char[] getUniqueCharacters(String text) {

        int len = findLength(text);

        // Temporary array (max possible size)
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {

            char current = text.charAt(i);
            boolean isDuplicate = false;

            // Check if already present in temp
            for (int j = 0; j < index; j++) {
                if (temp[j] == current) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not duplicate → store
            if (!isDuplicate) {
                temp[index++] = current;
            }
        }

        // Create exact-size array
        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // Display result
    public static void display(char[] arr) {

        System.out.println("\nUnique Characters:");
        for (char ch : arr) {
            System.out.print(ch + " ");
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

            // Output
            display(uniqueChars);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
