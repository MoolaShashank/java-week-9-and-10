import java.util.Scanner;

public class StudentGradeSystem {

    // a) Generate random marks (2-digit: 10–99)
    public static int[][] generateMarks(int n) {

        int[][] marks = new int[n][3]; // Physics, Chemistry, Maths

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int)(Math.random() * 90) + 10;
            }
        }

        return marks;
    }

    // b) Calculate total, average, percentage
    public static double[][] calculateResults(int[][] marks) {

        int n = marks.length;
        double[][] results = new double[n][3]; // total, average, percentage

        for (int i = 0; i < n; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            // Round to 2 decimal places
            avg = Math.round(avg * 100.0) / 100.0;
            percent = Math.round(percent * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = percent;
        }

        return results;
    }

    // c) Assign grades
    public static String[] calculateGrades(double[][] results) {

        int n = results.length;
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {

            double p = results[i][2];

            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }

        return grades;
    }

    // d) Display scorecard
    public static void display(int[][] marks, double[][] results, String[] grades) {

        System.out.println("\nStudent\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {

            System.out.println((i + 1) + "\t" +
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t" +
                    marks[i][2] + "\t" +
                    (int)results[i][0] + "\t" +
                    results[i][1] + "\t" +
                    results[i][2] + "\t" +
                    grades[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            int[][] marks = generateMarks(n);
            double[][] results = calculateResults(marks);
            String[] grades = calculateGrades(results);

            display(marks, results, grades);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
