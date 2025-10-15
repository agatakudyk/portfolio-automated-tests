package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class MyWishlists {

    //wejście na link listy 'My wishlist'
    public void myWishlistLink() {
        By myWishlistLinkLocator = By.xpath("//p[@class=\"wishlist-list-item-title\"]");
        getDriver().findElement(myWishlistLinkLocator).click();
    }

    //wejście na link listy 'Ulubione'
    public void ulubioneWishlistLink() {
        By ulubioneWishlistLinkLocator = By.xpath("//a[@class=\"wishlist-list-item-link\"]" +
                "/p[contains(text(),\"Ulubione\")]");
        getDriver().findElement(ulubioneWishlistLinkLocator).click();
    }

    //przejście na stronę 'My wishlists'
    public void myWishlistsPage() {
        By myWishlistsLinkLocator = By.xpath("//nav[@data-depth=\"4\"]//a[contains(., \"My wishlists\")]");
        getDriver().findElement(myWishlistsLinkLocator).click();
    }

    //kliknięcie w 'Create new list
    public void createNewList() {
        By createNewListWishlistLinkLocator = By.xpath("//div[@class=\"wishlist-container-header\"]" +
                "/a[contains(text(),\"Create new list\")]");
        getDriver().findElement(createNewListWishlistLinkLocator).click();
    }

    //Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń
    public void addNameOfNewList() {
        By createNameOfNewListWishlistLocator = By.xpath("//input[@placeholder=\"Add name\"]");
        getDriver().findElement(createNameOfNewListWishlistLocator).sendKeys("Super lista");
    }

    //Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'
    public void createWishlistButton() {
        By createWishlistButtonLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
        getDriver().findElement(createWishlistButtonLocator).click();
    }
}
