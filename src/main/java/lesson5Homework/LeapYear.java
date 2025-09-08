package lesson5Homework;

public class LeapYear {

    public static void main(String[]args) {

        int year = 2024;

        if(year %4 == 0 && year %100 != 0) {
            System.out.println(year + " - it is a leap year.");
        } else if (year %4 != 0 && year %100 ==0) {
            System.out.println(year + "- it is not a leap year.");
        } else {
            System.out.println("Please enter a valid value.");
        }
    }
}
