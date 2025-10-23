package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class OrderDetails {

    // uzupełnienie treści wiadomości
    public void msgFillIn() {
        $x("//textarea[@name='msgText']").shouldBe(visible).setValue("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");
    }

    // kliknięcie 'Send'
    public void sendButton() {
        $x("//*[@name='submitMessage']").shouldBe(visible).click();
    }

    // kliknięcie w link 'Reorder'
    public void reorderLink() {
        $x("//a[@class='button-primary' and text()='Reorder']").shouldBe(visible).click();
    }

    // asercja - pojawienie się komunikatu walidacji 'The message cannot be blank.'
    public boolean isValidationMsgDisplayed() {
        return $x("//li[contains(text(),'The message cannot be blank.')]").shouldBe(visible).isDisplayed();
    }

    // asercja - potwierdzenie wysłania wiadomości 'Message successfully sent'
    public boolean isInformationMsgDisplayed() {
        return $x("//li[contains(text(),'Message successfully sent')]").shouldBe(visible).isDisplayed();
    }
}