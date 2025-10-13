package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class Home {

    //zmiana języka / kliknięcie w dropdown-button
    public void languageDropdownButton() {
        By languageDropdownButtonLocator = By.xpath("//button[@data-toggle=\"dropdown\"]");
        getDriver().findElement(languageDropdownButtonLocator).click();
    }

    //wybór opcji 'English' na liście języków
    public void englishLanguageSelectionFromDropdown() {
        By englishLanguageSwitchLocator = By.xpath("//a[@data-iso-code=\"en\"]");
        getDriver().findElement(englishLanguageSwitchLocator).click();
    }

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
