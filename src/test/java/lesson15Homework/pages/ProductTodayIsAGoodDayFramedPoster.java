package lesson15Homework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class ProductTodayIsAGoodDayFramedPoster {

    public void addToCartButton() {   //kliknięcie w button 'Add to cart'
        By addTocCartLocator = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
        getDriver().findElement(addTocCartLocator).click();
    }

    public void closeAddToCartPopupLocator(){
    By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
    getDriver().findElement(closeAddToCartPopupLocator).click();
}
}
