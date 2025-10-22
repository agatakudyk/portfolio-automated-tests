package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class Addresses {

    // kliknięcie w button 'Continue' (przejście do 'Shipping Method')
    public void continueButton() {
       $x("//section[@id='checkout-addresses-step']//button[@type='submit']").shouldBe(visible).click();
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public String getValidationMsg() {
        return $x("//input[@name='address1']").shouldBe(visible).getAttribute("validationMessage");
    }
}

