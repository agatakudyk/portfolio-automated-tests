package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class Payment {

    // wybór opcji 'Pay by bank wire'
    public void payByBankWire() {
        $("#payment-option-2").shouldBe(visible).click();
    }

    // wybór opcji 'Pay by Check'
    public void payByCheck() {
        $("#payment-option-1").shouldBe(visible).click();
    }

    // wybór checkboxa zgody
    public void agreeToTermsCheckbox() {
        $x("//input[@name='conditions_to_approve[terms-and-conditions]']").shouldBe(visible).click();
    }

    // kliknięcie w button 'Place Order'
    public void placeOrderButton() {
        $x("//div[@class='ps-shown-by-js']/button").shouldBe(visible).click();
    }
}
