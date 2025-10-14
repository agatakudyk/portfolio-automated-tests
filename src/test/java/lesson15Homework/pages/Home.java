package lesson15Homework.pages;

import org.openqa.selenium.By;
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
}
