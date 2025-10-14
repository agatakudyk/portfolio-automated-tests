package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class LogIn {

    //kliknięcie w link rejestracji
    public void signupLink() {
        By signupLocator = By.cssSelector("a[data-link-action=\"display-register-form\"]");
        getDriver().findElement(signupLocator).click();
    }

    //kliknięcie w button 'Sign In'
    public void signInButton() {
        By loginButtonLocator = By.id("submit-login");
        getDriver().findElement(loginButtonLocator).click();
    }

    //uzupełnienie pola 'Email / email nieistniejący w bazie
    public void emailField() {
        By emailInputLocator = By.id("field-email");
        getDriver().findElement(emailInputLocator).sendKeys("blablabla@wp.pl");
    }

    // uzupełnienie pola 'Password'
    public void passwordField() {
        By passwordLoginLocator = By.id("field-password");
        getDriver().findElement(passwordLoginLocator).sendKeys("blepassword");
    }

    //kliknięcie w link 'Forgot your password?'
    public void passwordRecoveryLink() {
        By passwordRecoveryLocator = By.xpath(" //div[@class=\"forgot-password\"]/a");
        getDriver().findElement(passwordRecoveryLocator).click();
    }
}
