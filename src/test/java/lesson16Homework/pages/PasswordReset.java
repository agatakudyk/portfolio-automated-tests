package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class PasswordReset {

    // uzupełnienie pola 'Email address'
    public void email() {
        $x("//input[@class='form-control']").setValue("test.mail@wp.pl");
    }

    // kliknięcie w button 'Send reset link'
    public void sendResetLink() {
        $("#send-reset-link").shouldBe(visible).click();
    }

    // kliknięcie w link 'Back to Login'
    public void backToLoginPageLink() {
        $x("//i[@class='material-icons']").shouldBe(visible).click();
    }

    // asercja - sprawdzenie komunikatu potwierdzającego wysłanie maila
    public boolean isMsgOfSentMsgDisplayed() {
        return $x("//li[@class='item']/p").shouldBe(visible).isDisplayed();
    }
}