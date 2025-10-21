package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;


public class PersonalInformation {

    // Personal Information - checkbox zgody na przetwarzanie danych osobowych
    public PersonalInformation clickCustomerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").click();
        return this;
    }

    // Personal Information - checkbox akceptacji regulaminu i polityki prywatności
    public PersonalInformation clickTermsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").click();
        return this;
    }

    // Kliknięcie w button 'Continue'
    public PersonalInformation clickContinueButton() {
        $x("//section[@id='checkout-personal-information-step']//button[@type='submit']").click();
        return this;
    }
}

