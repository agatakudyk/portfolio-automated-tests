package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class OrderConfirmation {

    // kliknięcie w button 'Save'
    public void saveButtonInForm() {
        $x("//button[contains(text(),'Save')]").shouldBe(visible).click();
    }

    // checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        $x("//input[@name='customer_privacy']").shouldBe(visible).click();
    }

    // checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        $x("//input[@name='psgdpr']").shouldBe(visible).click();
    }

    // kliknięcie w link kontaktu z działem obsługi klienta
    public void customerServiceDepartmentContact() {
        $x("//a[contains(text(),'customer service department.')]").shouldBe(visible).click();
    }

    // asercja - potwierdzenie pojawienia się komunikatu potwierdzającego 'Your order is confirmed'
    public boolean isMsgThatOrderConfirmed() {
        return $x("//h3[@class='h1 card-title']/i").shouldBe(visible).isDisplayed();
    }

    // asercja - pobranie komunikatu walidacyjnego
    public String getValidationMsg() {
        return $("#field-firstname").shouldBe(visible).getText();
    }
}
