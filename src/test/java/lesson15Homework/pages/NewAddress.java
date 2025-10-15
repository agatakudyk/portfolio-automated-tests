package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class NewAddress {

    //uzupełnienie pola 'Address'
    public void address() {
        By addressFieldLocator = By.id("field-address1");
        getDriver().findElement(addressFieldLocator).sendKeys("ul. Kwiatowa 15");
    }
}
