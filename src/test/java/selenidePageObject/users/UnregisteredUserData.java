package selenidePageObject.users;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class UnregisteredUserData {

    // uzupełnienie pola 'First name'
    public void firstName() {
        $("#field-firstname").shouldBe(visible).setValue("Tomasz");
    }

    // uzupełnienie pola 'Last name'
    public void lastName() {
        $("#field-lastname").shouldBe(visible).setValue("Kot");
    }

    // uzupełnienie pola 'Email'
    public void email() {
        String uniqueEmail = "kot" + System.currentTimeMillis() + "@wp.pl";
        $("#field-email").shouldBe(visible).setValue(uniqueEmail);
    }

    // uzupełnienie pola 'Password'
    public void password() {
        $("#field-password").shouldBe(visible).setValue("Mojehaslo123");
    }

    // uzupełnienie pola 'Address'
    public void address() {
        $("#field-address1").shouldBe(visible).setValue("ul. Jaskrawa 23");
    }

    // uzupełnienie pola 'Zip/Postal Code'
    public void postalCode() {
        $("#field-postcode").shouldBe(visible).setValue("11-788");
    }

    // uzupełnienie pola 'City'
    public void city() {
        $("#field-city").shouldBe(visible).setValue("Koszalin");
    }
}

