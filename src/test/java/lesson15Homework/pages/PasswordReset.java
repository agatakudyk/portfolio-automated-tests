package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class PasswordReset {

    //uzupełnienie pola 'Email address'
    public void email() {
        By recoveryMailLocator = By.xpath("//input[@class=\"form-control\"]");
        getDriver().findElement(recoveryMailLocator).sendKeys("test.mail@wp.pl");
    }

    //kliknięcie w button 'Send reset link'
    public void sendResetLink() {
        By passwordRecoveryButtonLocator = By.id("send-reset-link");
        getDriver().findElement(passwordRecoveryButtonLocator).click();
    }

    //kliknięcie w link 'Back to Login'
    public void backToLoginPageLink() {
        By backToLoginPageLocator = By.xpath("//i[@class=\"material-icons\"]");
        getDriver().findElement(backToLoginPageLocator).click();
    }
}