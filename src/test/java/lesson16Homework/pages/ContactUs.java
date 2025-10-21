package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class ContactUs {

    // wpisanie treści wiadomości
    public ContactUs enterMessage(String message) {
        $("#contactform-message").setValue(message);
        return this;
    }

    // kliknięcie w button 'Send'
    public ContactUs clickSendButton() {
        $x("//input[@class='btn btn-primary']").click();
        return this;
    }

    // asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public ContactUs verifyValidationMsgDisplayed() {
        $x("//li[contains(text(),'The message cannot be blank.')]").shouldBe(visible);
        return this;
    }

    // asercja - potwierdzenie komunikatu informacyjnego
    public ContactUs verifyInformationMsgDisplayed() {
        $x("//li[contains(text(),'Your message has been successfully sent to our team.')]").shouldBe(visible);
        return this;
    }
}

