package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class Cart {

    //usunięcie produktu z koszyka
    public void deleteCartItem() {
        By trashIconLocator = By.xpath("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]");
        getDriver().findElement(trashIconLocator).click();
    }

        //powrót na stronę główną
    public void homePageLink() {
        By homepageLinkLocator = By.id("_desktop_logo");
        getDriver().findElement(homepageLinkLocator).click();
    }

    //kliknięcie w button 'Proceed to checkout'
        public void proceedToCheckoutButton() {
            By proceedToCheckoutButtonLocator = By.xpath("//a[contains(text(),\"Proceed to checkout\")]");
            getDriver().findElement(proceedToCheckoutButtonLocator).click();
        }
}
