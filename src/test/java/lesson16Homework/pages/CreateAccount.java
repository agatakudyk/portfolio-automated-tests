package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;


public class CreateAccount {

    // kliknięcie w button 'Save'
    public CreateAccount clickSaveButton() {
        $(".form-control-submit").click();
        return this;
    }

    // kliknięcie w checkbox informacji o przetwarzaniu danych osobowych
    public CreateAccount clickCustomerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").click();
        return this;
    }

    // kliknięcie w checkbox akceptacji regulaminu i polityki prywatności
    public CreateAccount clickTermsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").click();
        return this;
    }

    // pobranie komunikatu walidacyjnego HTML5 'Wypełnij to pole'
    public String getValidationMessage() {
        SelenideElement firstNameField = $("#field-firstname");
        return firstNameField.getAttribute("validationMessage");
    }
}

