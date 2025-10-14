package lesson15Homework.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class RegisteredUser {

    //uzupełnienie pola 'First name'
    public void name() {
        By nameLocator = By.id("field-firstname");
        getDriver().findElement(nameLocator).sendKeys("Anna");
}

//uzupełnienie pola 'Last name'
    public void lastName() {
        By surnameLocator = By.id("field-lastname");
        getDriver().findElement(surnameLocator).sendKeys("Testowianka");
    }

    //uzupełnienie pola 'Email'
    public void email() {
        By mailLocator = By.id("field-email");
        getDriver().findElement(mailLocator).sendKeys("testowianka274@wp.pl");
    }

    //uzupełnienie pola 'Password'
    public void password() {
        By passwordLocator = By.id("field-password");
        getDriver().findElement(passwordLocator).sendKeys("Password123");
    }

    //uzupełnienie pola 'New password' / nowe hasło
    public void newPassword() {
        By newPasswordFieldLocator = By.xpath("//input[@name=\"new_password\"]");
        getDriver().findElement(newPasswordFieldLocator).sendKeys("TestTest123");
    }
}
