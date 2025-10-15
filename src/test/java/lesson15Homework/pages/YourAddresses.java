package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class YourAddresses {

    //usunięcie nowego adresu
    public void deleteNewAddress() {
        By deleteNewAddressButtonLocator = By.xpath("//address[text()[contains(.,\"Janowiec\")]]" +
                "/../..//span[contains(text(),\"Delete\")]");
        getDriver().findElement(deleteNewAddressButtonLocator).click();
    }
}
