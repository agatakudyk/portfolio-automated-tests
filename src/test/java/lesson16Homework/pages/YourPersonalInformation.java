package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class YourPersonalInformation {

    // Personal Information – checkbox zgody na przetwarzanie danych osobowych
    public YourPersonalInformation customerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").shouldBe(visible).click();
    }

    // Personal Information – checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").shouldBe(visible).click();
    }

    // Kliknięcie w button 'Save'
    public void saveButton() {
        $x("//button[@class='btn btn-primary form-control-submit float-xs-right']").shouldBe(visible).click();
    }

    // Asercja – sprawdzenie pojawienia się komunikatu 'Information successfully updated.'
    public boolean isMsgThatInformationUpdated() {
        return $x("//ul/li[contains(text(),'Information successfully updated.')]").shouldBe(visible).isDisplayed();
    }
}
