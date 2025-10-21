package lesson5Homework;

public class LeapYear {

    public static void main(String[] args) {

        int year = 2024;

        if (isLeapYear(year)) {
            System.out.println(year + " - it is a leap year.");
        } else {
            System.out.println(year + "- it is not a leap year.");
        }

    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Niepoprawny rok");
        }

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
