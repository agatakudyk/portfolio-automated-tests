package lesson16Homework.users;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RegisteredUser {

    // uzupełnienie pola 'First name'
    public void name() {
        $("#field-firstname").setValue("Anna");
    }

    // uzupełnienie pola 'Last name'
    public void lastName() {
        $("#field-lastname").setValue("Testowianka");
    }

    // uzupełnienie pola 'Email'
    public void email() {
        $("#field-email").setValue("testowianka306@wp.pl");
    }

    // uzupełnienie pola 'Password'
    public void password() {
        $("#field-password").setValue("Password123");
    }

    // Your personal information - nowe hasło
    public void newPassword() {
        $x("//input[@name='new_password']").setValue("TestTest123");
    }

    // Login page - wpisanie nowego hasła
    public void newLoginPassword() {
        $("#field-password").setValue("TestTest123");
    }

    // uzupełnienie pola 'Address'
    public void address() {
        $("#field-address1").setValue("ul. Prosta 11");
    }

    // uzupełnienie pola 'Zip/Postal Code'
    public void postalCode() {
        $("#field-postcode").setValue("11-234");
    }

    // uzupełnienie pola 'City'
    public void city() {
        $("#field-city").setValue("Warszawa");
    }

    // wpisanie nowej nazwy miasta
    public void newCity() {
        $("#field-city").setValue("Opole");
    }

    // uzupełnienie nowego 'Address'
    public void createNewAddress() {
        $("#field-address1").setValue("ul. Kwiatowa 15");
    }

    // uzupełnienie nowego 'Zip/Postal Code'
    public void createNewZipPostaCode() {
        $("#field-postcode").setValue("88-111");
    }

    // uzupełnienie nowego 'City'
    public void createNewCity() {
        $("#field-city").setValue("Janowiec");
    }

    // zmiana danych w polu 'Zip/Postal Code'
    public void replaceNewZipPostaCode() {
        $("#field-postcode").setValue("02-333");
    }
}

