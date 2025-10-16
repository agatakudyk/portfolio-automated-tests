package lesson5Homework;

public class MonthsOfSeasons {

    // Napisz kod (w metodzie main) wypisujący informacje o porze roku w zależności od podanego miesiąca

    public static void main(String[]args) {

        String month = "june";

        if (month.equalsIgnoreCase( "March") || month.equalsIgnoreCase( "April") || month.equalsIgnoreCase( "May")) {
            System.out.println("It is Spring.");
        } else if (month.equalsIgnoreCase(  "June") || month.equalsIgnoreCase(  "July") || month.equalsIgnoreCase(  "August")) {
            System.out.println("It is Summer.");
        } else if (month.equalsIgnoreCase( "September") || month.equalsIgnoreCase( "October") || month.equalsIgnoreCase( "November")) {
            System.out.println("It is Autumn.");
        } else if (month.equalsIgnoreCase( "December") || month.equalsIgnoreCase( "January") || month.equalsIgnoreCase(  "February")) {
            System.out.println("It is Winter.");
        } else {
            System.out.println("Please enter a valid value.");
        }

    }
}
