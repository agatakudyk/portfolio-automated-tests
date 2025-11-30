package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class NewAddress {

    //kliknięcie w button 'Save
    public void saveButton() {
        getDriver().findElement( By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]")).click();
    }
}
