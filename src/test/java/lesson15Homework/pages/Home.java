package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class Home {

    //kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'
    public void wishlistIconOfPosterTodayIsAGoodDay() {
        By heartButtonOfTodayIsAGoodDayFramedPosterLocator = By.xpath(
                "//a[contains(text(),\"Today is a good day Framed\")]" +
                        "/../../../button[@class=\"wishlist-button-add\"]");
        getDriver().findElement(heartButtonOfTodayIsAGoodDayFramedPosterLocator).click();
    }

    //kliknięcie w button 'Cancel' w Popupie
    public void closeWishlistPopupOfUnregisteredUser() {
        By cancelPopupButtonLocator = By.xpath("//a[contains(text(),\"Sign in\")]" +
                "/../button[contains(text(),\"Cancel\")]");
        getDriver().findElement(cancelPopupButtonLocator).click();
    }

    //wejście na stronę produktu 'Today is a good day Framed Poster'
    public void enterProductPageOfTodayIsAGoodDayFramedPoster() {
        By openTodayIsAGoodDayFramedPosterLocator = By.xpath("//a[@class=\"thumbnail product-thumbnail\"]" +
                "/img[@alt=\"Today is a good day Framed poster\"]");
        getDriver().findElement(openTodayIsAGoodDayFramedPosterLocator).click();
    }

    //kliknięcie wishlist-button produktu 'Hummingbird printed t-shirt'
    public void wishlistIconOfHummingbirdPrintedTshirt() {
        By heartButtonOfHummingbirdLocator = By.xpath(
                "//a[contains(text(),\"Hummingbird printed t-shirt\")]" +
                        "/../../../button[@class=\"wishlist-button-add\"]");
        getDriver().findElement(heartButtonOfHummingbirdLocator).click();
    }

    //Popup 'Add to whishlist' - kliknięcie w link 'My wishlist'
    public void myWishlistSelection() {
        By myWishlistPopupLocator = By.xpath("//div[@class=\"modal-body\"]" +
                "/div/ul/li[@class=\"wishlist-list-item\"]");
        getDriver().findElement(myWishlistPopupLocator).click();
    }

    //kliknięcie wishlist-button produktu 'Mug The adventure begins'
    public void wishlistIconOfMugTheAdventureBegins() {
        By heartButtonOfMugTheAdventureLocator = By.xpath("//a[contains(text(),\"Mug The adventure begins\")]" +
                "/../../../button[@class=\"wishlist-button-add\"]");
        getDriver().findElement(heartButtonOfMugTheAdventureLocator).click();
    }
}
