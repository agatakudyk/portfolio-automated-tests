package selenidePageObject.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ContactUs {

    //kliknięcie w button 'Send'
    public void sendButton() {
        $x("//input[@class=\"btn btn-primary\"]").shouldBe(visible).click();
    }

    //wpisanie treści wiadomości
    public void msgFillIn() {
        $("#contactform-message").shouldBe(visible).setValue("Chcę otrzymać FV za zamówienie.");
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public boolean isValidationMsgDisplayed() {
        return $x("//li[contains(text(),\"The message cannot be blank.\")]").shouldBe(visible).isDisplayed();
    }

    //asercja - potwierdzenie komunikatu informacyjnego 'Your message has been successfully sent to our team.'
    public boolean isInformationMsgDisplayed() {
        return $x("//li[contains(text(),\"Your message has " +
                "been successfully sent to our team.\")]").shouldBe(visible).isDisplayed();
    }
}
