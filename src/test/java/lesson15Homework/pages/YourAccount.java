package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class YourAccount {

    //kliknięcie w link 'Information'
    public void informationLink() {
        By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
        getDriver().findElement(informationPageLocator).click();
    }

    //kliknięcie w link 'Order history and details'
    public void orderHistoryAndDetails() {
        By orderHistoryAndDetailsLinkLocator = By.id("history-link");
        getDriver().findElement(orderHistoryAndDetailsLinkLocator).click();
    }

    //kliknięcie w link 'Addresses'
    public void addresses() {
        By addressesPageLink = By.xpath("//a[@id=\"addresses-link\"]/span/i");
        getDriver().findElement(addressesPageLink).click();
    }

    //kliknięcie w link 'My wishlists'
    public void myWishlists() {
        By myWishlistsPageLocator = By.xpath("//a[@id=\"wishlist-link\"]/span/i");
        getDriver().findElement(myWishlistsPageLocator).click();
    }
}
