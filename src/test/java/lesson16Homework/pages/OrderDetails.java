package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class OrderDetails {

    // uzupełnienie treści wiadomości
    public OrderDetails enterMessageText() {
        $x("//textarea[@name='msgText']").setValue("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");
        return this;
    }

    // kliknięcie 'Send'
    public OrderDetails clickSendButton() {
        $x("//*[@name='submitMessage']").click();
        return this;
    }

    // kliknięcie w link 'Reorder'
    public OrderDetails clickReorderLink() {
        $x("//a[@class='button-primary' and text()='Reorder']").click();
        return this;
    }

    // asercja - pojawienie się komunikatu walidacji 'The message cannot be blank.'
    public OrderDetails verifyValidationMsgDisplayed() {
        $x("//li[contains(text(),'The message cannot be blank.')]").shouldBe(visible);
        return this;
    }

    // asercja - potwierdzenie wysłania wiadomości 'Message successfully sent'
    public OrderDetails verifyInformationMsgDisplayed() {
        $x("//li[contains(text(),'Message successfully sent')]").shouldBe(visible);
        return this;
    }
}