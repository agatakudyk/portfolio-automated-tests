package lesson4Homework;

public class HomeworkLesson4 {
    public static void main(String[] args) {
        // Zadanie 1 - obliczenie oceny
        showGrade(93);
        showGrade(87);
        showGrade(71);
        showGrade(65);
        showGrade(22);
        showGrade(222);
        // Zadanie 3 - liczba parzysta i nieparzysta
        checkNumber(20);
        checkNumber(34);
        checkNumber(15);
        checkNumber(19);
        checkNumber(-10);
        checkNumber(-9);
        // Zadanie 2 - konwerter temperatury
        showTemperature(40, 'C');
        showTemperature(-10, 'C');
        showTemperature(100, 'F');
        showTemperature(0, 'F');
    }

    public static void showGrade(int number) {

        if (number <= 100 && number >= 90) {
            System.out.println("Ocena A");
        } else if (number <= 89 && number >= 80) {
            System.out.println("Ocena B");
        } else if (number <= 79 && number >= 70) {
            System.out.println("Ocena C");
        } else if (number <= 69 && number >= 60) {
            System.out.println("Ocena D");
        } else if (number <= 59 && number >= 0) {
            System.out.println("Ocena F");
        } else {
            System.out.println("Wpisałeś nieprawidłową liczbę. Spróbuj jeszcze raz.");
        }
    }

    public static void checkNumber(int liczba) {

        if (liczba % 2 == 0 && liczba % 5 == 0) {
            System.out.println(liczba + " - jest liczbą parzystą i wielokrotnością 5.");
        } else if (liczba % 2 == 0 && liczba % 5 != 0) {
            System.out.println(liczba + " - jest liczbą parzystą, ale nie wielokrotnością 5.");
        } else if (liczba % 2 != 0 && liczba % 5 == 0) {
            System.out.println(liczba + " - jest liczbą nieparzystą i wielokrotnością 5.");
        } else {
            System.out.println(liczba + " - jest liczbą nieparzystą, ale nie wielokrotnością 5.");
        }
    }
}

public static void showTemperature(int temperatura, char typ) {

    if (typ == 'F') {
        System.out.println((temperatura - 32) * 5 / 9 + "C");
    } else if (typ == 'C') {
        System.out.println((temperatura * 9 / 5) + 32 + "F");
    } else {
        System.out.println("Nierozpoznany typ temperatury");
    }
}
}

