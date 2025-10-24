package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class CreateAccount {

    //kliknięcie w button 'Save'
    public void saveButton() {
        $(".form-control-submit").shouldBe(visible).click();
    }

    //kliknięcie w checkbox informacji o przetwarzaniu danych osobowych
    public void customerPrivacyCheckbox() {
        $x("//input[@name=\"customer_privacy\"]").shouldBe(interactable).click();
    }

    //checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        $x("//input[@name=\"psgdpr\"]").shouldBe(interactable).click();
    }

    //potwierdzenie pojawienia się komunikatu 'Wypełnij to pole'
    public String getValidationMsg() {
            return $("#field-firstname").shouldBe(visible).getAttribute("validationMessage");
    }
}
