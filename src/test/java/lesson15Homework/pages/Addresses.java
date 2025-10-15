package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class Addresses {

    //kliknięcie w button 'Continue' (przejście do 'Shipping Method')
    public void continueButton() {
        By addreessContinuseLocator = By.xpath("//section[@id=\"checkout-addresses-step\"]" +
                "//button[@type=\"submit\"]");
        getDriver().findElement(addreessContinuseLocator).click();
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
}
