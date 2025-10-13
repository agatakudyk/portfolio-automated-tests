package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class LogIn {

    //kliknięcie w link rejestracji
    public void signupLink () {
        By signupLocator = By.cssSelector("a[data-link-action=\"display-register-form\"]");
        getDriver().findElement(signupLocator).click();
    }
}
