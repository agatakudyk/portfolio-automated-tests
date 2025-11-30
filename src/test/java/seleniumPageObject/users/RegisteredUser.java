package seleniumPageObject.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static seleniumPageObject.driver.DriverProvider.getDriver;

public class RegisteredUser {

    //uzupełnienie pola 'First name'
    public void name(String userName) {
        getDriver().findElement(By.id("field-firstname")).sendKeys(userName);
    }

    //uzupełnienie pola 'Last name'
    public void lastName(String userLastName) {
        getDriver().findElement(By.id("field-lastname")).sendKeys(userLastName);
    }

    //uzupełnienie pola 'Email'
    public void email(String email) {
        getDriver().findElement(By.id("field-email")).sendKeys(email);
    }

    //uzupełnienie pola 'Password'
    public void password(String password) {
        getDriver().findElement(By.id("field-password")).sendKeys(password);
    }

    //Your personal information - uzupełnienie pola 'New password' / nowe hasło
    public void newPassword(String password) {
        getDriver().findElement(By.xpath("//input[@name=\"new_password\"]")).sendKeys(password);
    }


    //uzupełnienie pola 'Address'
    public void address(String address) {
        getDriver().findElement(By.id("field-address1")).sendKeys(address);
    }

    //uzupełnienie pola 'Zip/Postal Code'
    public void postalCode(String postalCode) {
        WebElement postaCodeField = getDriver().findElement(By.id("field-postcode"));
        postaCodeField.clear();
        postaCodeField.sendKeys(postalCode);
    }

    //uzupełnienie pola 'City'
    public void city(String city) {
        WebElement cityInAddressField = getDriver().findElement(By.id("field-city"));
        cityInAddressField.clear();
        cityInAddressField.sendKeys(city);
    }

}
