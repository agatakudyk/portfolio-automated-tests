package seleniumPageObject.users;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class UnregisteredUserData {

    //uzupełnienie pola 'First name'
    public void firstName(String firstName) {
        getDriver().findElement(By.id("field-firstname")).sendKeys(firstName);
    }

    //uzupełnienie pola 'Last name'
    public void lastName(String lastName) {
        getDriver().findElement(By.id("field-lastname")).sendKeys(lastName);
    }

    //uzupełnienie pola 'Email'
    public void email(String email) {
        getDriver().findElement(By.id("field-email")).sendKeys(email);
    }

    //uzupełnienie pola 'Password'
    public void password(String password) {
        getDriver().findElement(By.id("field-password")).sendKeys(password);
    }

    //uzupełnienie pola 'Address'
    public void address(String address) {
        getDriver().findElement(By.id("field-address1")).sendKeys(address);
    }

    //uzupełnienie pola 'Zip/Postal Code'
    public void postalCode(String postalCode) {
        getDriver().findElement(By.id("field-postcode")).sendKeys(postalCode);
    }

    //uzupełnienie pola 'City'
    public void city(String city) {
        getDriver().findElement(By.id("field-city")).sendKeys(city);
    }
}
