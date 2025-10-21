package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;


public class LogIn {

    // kliknięcie w link rejestracji
    public LogIn clickSignupLink() {
        $("a[data-link-action='display-register-form']").click();
        return this;
    }

    // kliknięcie w button 'Sign In'
    public LogIn clickSignInButton() {
        $("#submit-login").click();
        return this;
    }

    // uzupełnienie pola 'Email'
    public LogIn enterEmail(String email) {
        $("#field-email").setValue(email);
        return this;
    }

    // uzupełnienie pola 'Password'
    public LogIn enterPassword(String password) {
        $("#field-password").setValue(password);
        return this;
    }

    // kliknięcie w link 'Forgot your password?'
    public LogIn clickPasswordRecoveryLink() {
        $x("//div[@class='forgot-password']/a").click();
        return this;
    }

    // asercja - pobranie komunikatu walidacyjnego HTML5 "Wypełnij pole"
    public String getValidationMessage() {
        SelenideElement emailInput = $("#field-email");
        return emailInput.getAttribute("validationMessage");
    }

    // asercja - sprawdzenie komunikatu 'Authentication failed.'
    public LogIn verifyAuthenticationFailedMsgDisplayed() {
        $x("//li[@class='alert alert-danger']").shouldBe(visible);
        return this;
    }
}

