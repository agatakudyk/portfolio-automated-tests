package lesson16Homework.users;

import static com.codeborne.selenide.Selenide.$;


public class UnregisteredUserData {

    // uzupełnienie pola 'First name'
    public void firstName() {
        $("#field-firstname").setValue("Tomasz");
    }

    // uzupełnienie pola 'Last name'
    public void lastName() {
        $("#field-lastname").setValue("Kot");
    }

    // uzupełnienie pola 'Email'
    public void email() {
        $("#field-email").setValue("kot123@wp.pl");
    }

    // uzupełnienie pola 'Password'
    public void password() {
        $("#field-password").setValue("Mojehaslo123");
    }

    // uzupełnienie pola 'Address'
    public void address() {
        $("#field-address1").setValue("ul. Jaskrawa 23");
    }

    // uzupełnienie pola 'Zip/Postal Code'
    public void postalCode() {
        $("#field-postcode").setValue("11-788");
    }

    // uzupełnienie pola 'City'
    public void city() {
        $("#field-city").setValue("Koszalin");
    }
}

