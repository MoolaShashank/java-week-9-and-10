import java.util.Scanner;

public class BMIAnalyzer {

    // a) Take input: weight (kg) and height (cm)
    public static double[][] getInput(int n, Scanner sc) {

        double[][] data = new double[n][2]; // [weight, height]

        System.out.println("Enter Weight (kg) and Height (cm) for " + n + " persons:");

        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " Weight: ");
            data[i][0] = sc.nextDouble();

            System.out.print("Person " + (i + 1) + " Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        return data;
    }

    // b) Calculate BMI and Status
    public static String[] calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        // Round to 2 decimals
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;

        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        return new String[]{String.valueOf(bmi), status};
    }

    // c) Process all data into 2D array
    public static String[][] processData(double[][] input) {

        String[][] result = new String[input.length][4];

        for (int i = 0; i < input.length; i++) {

            double weight = input[i][0];
            double height = input[i][1];

            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height); // Height
            result[i][1] = String.valueOf(weight); // Weight
            result[i][2] = bmiData[0];             // BMI
            result[i][3] = bmiData[1];             // Status
        }

        return result;
    }

    // d) Display in tabular format
    public static void display(String[][] data) {

        System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {

            System.out.println((i + 1) + "\t" +
                    data[i][0] + "\t\t" +
                    data[i][1] + "\t\t" +
                    data[i][2] + "\t" +
                    data[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int n = 10;

            double[][] input = getInput(n, sc);
            String[][] result = processData(input);

            display(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
