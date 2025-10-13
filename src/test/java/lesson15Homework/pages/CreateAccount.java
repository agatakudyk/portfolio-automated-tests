package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class CreateAccount {

    //kliknięcie w button 'Save'
    public void saveButton() {
        By saveLocator = By.cssSelector(".form-control-submit");
        getDriver().findElement(saveLocator).click();
    }
}
