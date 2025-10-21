package lesson5Homework;

public class DaysInMonth {

    public static void main(String[]args) {

        daysInMonth(1,2024);

        daysInMonth(2, 2025);

    }

    /**
     * Miesiące z 31 dniami
     * Styczeń (1), Marzec (3), Maj (5), Lipiec (7), Sierpień (8), Październik (10), Grudzień (12).
     * Miesiące z 30 dniami Kwiecień (4), Czerwiec (6), Wrzesień (9), Listopad (11).
     * Luty
     * Luty ma 28 dni, a w roku przestępnym ma 29 dni.
     * @param numerMiesiaca numer miesiaca
     * @param rok rok
     * @return ilosc dni w miesiącu
     */
    public static int daysInMonth(int numerMiesiaca, int rok) {


        if(numerMiesiaca < 1 || numerMiesiaca > 12){
            throw new IllegalArgumentException("Niepoprawny numer miesiąca");
        }
        boolean isLeapYear = LeapYear.isLeapYear(rok);

        int numberOfDays;
        switch (numerMiesiaca){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numberOfDays = 31;
                break;
            case 2:
                numberOfDays = 28;
                if(isLeapYear){
                    numberOfDays++;
                }
                break;
            default:
                numberOfDays = 30;
        }

        return numberOfDays;

    }
}


