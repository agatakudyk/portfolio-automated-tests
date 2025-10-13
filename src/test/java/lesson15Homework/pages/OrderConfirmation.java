package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class OrderConfirmation {

    //kliknięcie w button 'Save'
    public void saveButtonInForm() {
        By saveButtonLocator = By.xpath("//button[contains(text(),\"Save\")]");
        getDriver().findElement(saveButtonLocator).click();
    }
}
