public class HomeworkLesson4 {
    public static void main(String[] args) {
        // Zadanie 1 - obliczenie oceny
        zad1Ocena(93);
        zad1Ocena(87);
        zad1Ocena(71);
        zad1Ocena(65);
        zad1Ocena(22);
        zad1Ocena(222);
        // Zadanie 3 - liczba parzysta i nieparzysta
        zad3Parzysta(20);
        zad3Parzysta(34);
        zad3Parzysta(15);
        zad3Parzysta(19);
        zad3Parzysta(-10);
        zad3Parzysta(-9);
        // Zadanie 2 - konwerter temperatury
        zad2Temperatura(40, 'C');
        zad2Temperatura(-10, 'C');
        zad2Temperatura(100, 'F');
        zad2Temperatura(0, 'F');
    }

    public static void zad1Ocena(int number) {

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

    public static void zad3Parzysta(int liczba) {

        if (liczba % 2 == 0) {
            if (liczba % 5 == 0) {
                System.out.println(liczba + " - jest liczbą parzystą i wielokrotnością 5.");
            } else {
                System.out.println(liczba + " - jest liczbą parzystą, ale nie wielokrotnością 5.");
            }

        } else {
            if (liczba % 5 == 0) {
                System.out.println(liczba + " - jest liczbą nieparzystą i wielokrotnością 5.");
            } else {
                System.out.println(liczba + " - jest liczbą nieparzystą, ale nie wielokrotnością 5.");
            }
        }
    }
    public static void zad2Temperatura(int temperatura, char typ) {

            if (typ == 'F') {
                System.out.println((temperatura - 32) * 5/9 + "C");
            } else if (typ == 'C') {
                System.out.println((temperatura * 9/5) +32 + "F");
            } else {
                System.out.println("Nierozpoznany typ temperatury");
            }
    }
}

