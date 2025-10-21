package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;


public class OrderConfirmation {

    // kliknięcie w button 'Save'
    public OrderConfirmation clickSaveButton() {
        $x("//button[contains(text(),'Save')]").click();
        return this;
    }

    // checkbox zgody na przetwarzanie danych osobowych
    public OrderConfirmation clickCustomerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").click();
        return this;
    }

    // checkbox akceptacji regulaminu i polityki prywatności
    public OrderConfirmation clickTermsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").click();
        return this;
    }

    // kliknięcie w link kontaktu z działem obsługi klienta
    public OrderConfirmation clickCustomerServiceDepartmentContact() {
        $x("//a[contains(text(),'customer service department.')]").click();
        return this;
    }

    // asercja - potwierdzenie pojawienia się komunikatu potwierdzającego 'Your order is confirmed'
    public OrderConfirmation verifyOrderConfirmedMsg() {
        $x("//h3[@class='h1 card-title']/i").shouldBe(visible);
        return this;
    }

    // asercja - pobranie komunikatu walidacyjnego (HTML5 validation)
    public String getValidationMessage() {
        SelenideElement firstNameField = $("#field-firstname");
        return firstNameField.getAttribute("validationMessage");
    }
}
