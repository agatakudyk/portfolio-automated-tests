package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class YourPersonalInformation {

    // Personal Information – checkbox zgody na przetwarzanie danych osobowych
    public YourPersonalInformation customerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").click();
        return this;
    }

    // Personal Information – checkbox akceptacji regulaminu i polityki prywatności
    public YourPersonalInformation termsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").click();
        return this;
    }

    // Kliknięcie w button 'Save'
    public YourPersonalInformation saveButton() {
        $x("//button[@class='btn btn-primary form-control-submit float-xs-right']").click();
        return this;
    }

    // Asercja – sprawdzenie pojawienia się komunikatu 'Information successfully updated.'
    public boolean isMsgThatInformationUpdated() {
        return $x("//ul/li[contains(text(),'Information successfully updated.')]")
                .shouldBe(visible)
                .isDisplayed();
    }
}
