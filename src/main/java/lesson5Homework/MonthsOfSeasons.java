package lesson5Homework;

public class MonthsOfSeasons {

    // Napisz kod (w metodzie main) wypisujący informacje o porze roku w zależności od podanego miesiąca

    public static void main(String[]args) {

        String month = "xxx";

        if (month == "March" || month == "April" || month == "May") {
            System.out.println("It is Spring.");
        } else if (month == "June" || month == "July" || month == "August") {
            System.out.println("It is Summer.");
        } else if (month == "September" || month == "October" || month == "November") {
            System.out.println("It is Autumn.");
        } else if (month == "December" || month == "January" || month == "February") {
            System.out.println("It is Winter.");
        } else {
            System.out.println("Please enter a valid value.");
        }

    }
}
