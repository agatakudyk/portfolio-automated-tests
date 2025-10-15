package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class MyWishlists {

    //wejście na link 'My wishlist'
    public void myWishlistLink() {
        By myWishlistLinkLocator = By.xpath("//p[@class=\"wishlist-list-item-title\"]");
        getDriver().findElement(myWishlistLinkLocator).click();
    }
}
