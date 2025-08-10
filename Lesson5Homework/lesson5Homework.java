package Lesson5Homework;

public class lesson5Homework {

    public static void main(String[] args) {

        String month = "March";

        switch(month) {
            case "March":
                System.out.println("Wiosna");
                break;
            case "July":
                System.out.println("Lato");
                break;
            case "October":
                System.out.println("Jesień");
                break;
            case "January":
                System.out.println("Zima");
                break;
            default:
                System.out.println("Wpisałeś błędną wartość.");
        }
    }
}
