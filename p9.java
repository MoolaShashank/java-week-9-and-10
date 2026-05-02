import java.util.Scanner;

public class CalendarDisplay {

    // a) Month names
    public static String getMonthName(int month) {
        String[] months = {
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
        };
        return months[month - 1];
    }

    // Leap year check
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // b) Days in month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // c) First day of month (0=Sun ... 6=Sat)
    public static int getFirstDay(int month, int year) {
        int d = 1;

        int y0 = year - (14 - month) / 12;
        int x  = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }

    // d) Display calendar
    public static void displayCalendar(int month, int year) {

        String monthName = getMonthName(month);
        int days = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);

        System.out.println("\n   " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // indentation for first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // print days
        for (int day = 1; day <= days; day++) {

            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter month (1-12): ");
            int month = sc.nextInt();

            System.out.print("Enter year: ");
            int year = sc.nextInt();

            displayCalendar(month, year);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
