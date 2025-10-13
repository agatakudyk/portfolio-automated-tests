package lesson15Homework.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class UnregisteredUserData {

    //uzupełnienie pola 'First name'
public void firstName() {
    By firstNameFieldLocator = By.id("field-firstname");
    getDriver().findElement(firstNameFieldLocator).sendKeys("Tomasz");
}

//uzupełnienie pola 'Last name'
    public void lastName() {
        By lastNameFieldLocator = By.id("field-lastname");
        getDriver().findElement(lastNameFieldLocator).sendKeys("Kot");
    }
    //uzupełnienie pola 'Email'
    public void email() {
        By emailFieldLocator = By.id("field-email");
        getDriver().findElement(emailFieldLocator).sendKeys("kot123@wp.pl");
    }
}
