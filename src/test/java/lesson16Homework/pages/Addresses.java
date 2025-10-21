package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;

public class Addresses {

    // kliknięcie w button 'Continue' (przejście do 'Shipping Method')
    public Addresses clickContinueButton() {
        $x("//section[@id='checkout-addresses-step']//button[@type='submit']").click();
        return this;
    }

    // pobranie komunikatu walidacyjnego HTML5
    public String getValidationMessage() {
        return $x("//input[@name='address1']").getAttribute("validationMessage");
    }
}

