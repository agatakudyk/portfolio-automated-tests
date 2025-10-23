package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class PersonalInformation {

    // Personal Information - checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").shouldBe(visible).click();
    }

    // Personal Information - checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").shouldBe(visible).click();
    }

    // Kliknięcie w button 'Continue'
    public void continueButton() {
        $x("//section[@id='checkout-personal-information-step']//button[@type='submit']").shouldBe(visible).click();
    }
}

