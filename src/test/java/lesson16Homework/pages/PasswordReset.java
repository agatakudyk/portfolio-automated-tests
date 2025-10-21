package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class PasswordReset {

    // uzupełnienie pola 'Email address'
    public PasswordReset enterEmail(String email) {
        $x("//input[@class='form-control']").setValue(email);
        return this;
    }

    // kliknięcie w button 'Send reset link'
    public PasswordReset clickSendResetLink() {
        $("#send-reset-link").click();
        return this;
    }

    // kliknięcie w link 'Back to Login'
    public PasswordReset clickBackToLoginPage() {
        $x("//i[@class='material-icons']").click();
        return this;
    }

    // asercja - sprawdzenie komunikatu potwierdzającego wysłanie maila
    public PasswordReset verifySentMsgDisplayed() {
        $x("//li[@class='item']/p").shouldBe(visible);
        return this;
    }
}