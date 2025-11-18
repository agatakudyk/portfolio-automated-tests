package lesson16Homework.users;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RegisteredUser {

    // uzupełnienie pola 'First name'
    public void name() {
        $("#field-firstname").shouldBe(visible).setValue("Anna");
    }

    // uzupełnienie pola 'Last name'
    public void lastName() {
        $("#field-lastname").shouldBe(visible).setValue("Testowianka");
    }

    // uzupełnienie pola 'Email'
    public void email() {
        String uniqueEmail = "testowianka" + System.currentTimeMillis() + "@wp.pl";
        $("#field-email").shouldBe(visible).setValue(uniqueEmail);
    }

    // uzupełnienie pola 'Password'
    public void password() {
        $("#field-password").shouldBe(visible).setValue("Password123");
    }

    // Your personal information - nowe hasło
    public void newPassword() {
        $x("//input[@name='new_password']").shouldBe(visible).setValue("TestTest123");
    }

    // Login page - wpisanie nowego hasła
    public void newLoginPassword() {
        $("#field-password").shouldBe(visible).setValue("TestTest123");
    }

    // uzupełnienie pola 'Address'
    public void address() {
        $("#field-address1").shouldBe(visible).setValue("ul. Prosta 11");
    }

    // uzupełnienie pola 'Zip/Postal Code'
    public void postalCode() {
        $("#field-postcode").shouldBe(visible).setValue("11-234");
    }

    // uzupełnienie pola 'City'
    public void city() {
        $("#field-city").shouldBe(visible).setValue("Warszawa");
    }

    // wpisanie nowej nazwy miasta
    public void newCity() {
        $("#field-city").shouldBe(visible).setValue("Opole");
    }

    // uzupełnienie nowego 'Address'
    public void createNewAddress() {
        $("#field-address1").shouldBe(visible).setValue("ul. Kwiatowa 15");
    }

    // uzupełnienie nowego 'Zip/Postal Code'
    public void createNewZipPostaCode() {
        $("#field-postcode").shouldBe(visible).setValue("88-111");
    }

    // uzupełnienie nowego 'City'
    public void createNewCity() {
        $("#field-city").shouldBe(visible).setValue("Janowiec");
    }

    // zmiana danych w polu 'Zip/Postal Code'
    public void replaceNewZipPostaCode() {
        $("#field-postcode").shouldBe(visible).setValue("02-333");
    }
}

