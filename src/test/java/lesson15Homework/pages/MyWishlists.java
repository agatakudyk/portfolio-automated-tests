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
}
