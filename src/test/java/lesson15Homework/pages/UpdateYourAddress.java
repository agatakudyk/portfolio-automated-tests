package lesson15Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class UpdateYourAddress {

    //kliknięcie w button 'Save'
    public void saveButton() {
        getDriver().findElement(By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]"))
                .click();
    }
}
