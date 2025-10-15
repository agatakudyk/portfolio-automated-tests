package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class NewAddress {

    //kliknięcie w button 'Save
    public void saveButton() {
        By saveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]");
        getDriver().findElement(saveButtonLocator).click();
    }
}
