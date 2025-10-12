package lesson15Homework.pages;

import com.codeborne.selenide.selector.ByDeepShadowCss;
import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class HomePage {

    public void languageDropdownButton() {   //dropdown-button z listą języków
        getDriver().findElement(ByDeepShadowCss.xpath("//button[@data-toggle=\"dropdown\"]")).click();
    }

    public void englishLanguageSelectionOnDropdown() {    //wybór opcji 'English' na liście z językami
        getDriver().findElement(By.xpath("//a[@data-iso-code=\"en\"]")).click();
    }

    public void signInLink() {
    }

    public void wishlistIconOfPosterTodayIsAGoodDay() {  //kliknięcie wishlist-button produktu 'Today is a good day.."
        getDriver().findElement(By.xpath("//a[contains(text(),\\\"Today is a good day Framed\\\")]\" +\n" +
                "                            \"/../../../button[@class=\\\"wishlist-button-add\\\"]")).click();
    }

    public void closeWishlistPopupOfInregisteredUser() {  //kliknięcie w button 'Cancel' w Popupie
        getDriver().findElement(By.xpath("//a[contains(text(),\\\"Sign in\\\")]\" +\n" +
                "                    \"/../button[contains(text(),\\\"Cancel\\\")]")).click();
    }
}
