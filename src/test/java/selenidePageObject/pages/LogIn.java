package selenidePageObject.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class LogIn {

    // kliknięcie w link rejestracji
    public void signupLink() {
        $("a[data-link-action='display-register-form']").shouldBe(visible).click();
    }

    // kliknięcie w button 'Sign In'
    public void signInButton() {
        $("#submit-login").shouldBe(visible).click();
    }

    // uzupełnienie pola 'Email'
    public void emailField() {
        $("#field-email").shouldBe(visible).setValue("blablabla@wp.pl");
    }

    // uzupełnienie pola 'Password'
    public void passwordField() {
        $("#field-password").shouldBe(visible).setValue("blepassword");
    }

    // kliknięcie w link 'Forgot your password?'
    public void passwordRecoveryLink() {
        $x("//div[@class='forgot-password']/a").shouldBe(visible).click();
    }

    // asercja - pobranie komunikatu walidacyjnego "Wypełnij pole"
    public String getValidationMessage() {
        return $("#field-email").shouldBe(visible).getAttribute("validationMessage");
    }

    // asercja - sprawdzenie komunikatu 'Authentication failed.'
    public boolean isMsgAuthenticationFailedDisplayed() {
        return $x("//li[@class='alert alert-danger']").shouldBe(visible).isDisplayed();
    }
}

