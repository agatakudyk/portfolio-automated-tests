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

    //uzupełnienie pola 'Address'
    public void address() {
        By addressFieldLocator = By.id("fieldaddress1");
        getDriver().findElement(addressFieldLocator).sendKeys("ul. Prosta 11");
    }

    //uzupełnienie pola 'Zip/Postal Code'
    public void postalCode() {
        By postalCodeFieldLocator = By.id("field-postcode");
        getDriver().findElement(postalCodeFieldLocator).sendKeys("11-234");
    }

    //uzupełnienie pola 'City'
    public void city() {
        By cityFieldLocal = By.id("field-city");
        getDriver().findElement(cityFieldLocal).sendKeys("Warszawa");
    }

    //wpisanie nowej nazwy miasta
    public void newCity() {
        By cityInAddressFieldLocator = By.id("field-city");
      WebElement cityInAddressField = getDriver().findElement(cityInAddressFieldLocator);
        cityInAddressField.clear();
        cityInAddressField.sendKeys("Opole");
    }
}
