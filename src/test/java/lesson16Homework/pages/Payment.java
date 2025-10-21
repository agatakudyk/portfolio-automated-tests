package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class Payment {

    // wybór opcji 'Pay by bank wire'
    public Payment selectPayByBankWire() {
        $("#payment-option-2").click();
        return this;
    }

    // wybór opcji 'Pay by Check'
    public Payment selectPayByCheck() {
        $("#payment-option-1").click();
        return this;
    }

    // wybór checkboxa zgody
    public Payment agreeToTerms() {
        $x("//input[@name='conditions_to_approve[terms-and-conditions]']").click();
        return this;
    }

    // kliknięcie w button 'Place Order'
    public Payment clickPlaceOrderButton() {
        $x("//div[@class='ps-shown-by-js']/button").click();
        return this;
    }
}
