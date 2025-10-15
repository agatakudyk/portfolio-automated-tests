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

    //wejście w link 'Edit'
    public void editAddress() {
        By editAddressesLinkLocator = By.xpath(
                "//footer[@class=\"address-footer\"]/a[@data-link-action=\"edit-address\"]");
        getDriver().findElement(editAddressesLinkLocator).click();
    }

    //kliknięcie w link 'Create new address'
    public void createNewAddressLink() {
        By createNewAddressLinkLocator = By.xpath("//a[@data-link-action=\"add-address\"]");
        getDriver().findElement(createNewAddressLinkLocator).click();
    }

    //kliknięcie w link 'Update'
    public void updateAddress() {
        By updateNewAddressButtonLocator = By.xpath("//address[text()[contains(.,\"Janowiec\")]]" +
                "/../..//span[contains(text(),\"Update\")]");
        getDriver().findElement(updateNewAddressButtonLocator).click();
    }
}
