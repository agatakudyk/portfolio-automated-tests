package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class ProductTodayIsAGoodDayFramedPoster {

    //kliknięcie w button 'Add to cart'
    public void addToCartButton() {
        By addTocCartLocator = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
        getDriver().findElement(addTocCartLocator).click();
    }

    //Popup w oknie produktu - kliknięcie w button 'Proceed to checkout'
    public void closeAddToCartPopupLocator() {
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
        getDriver().findElement(closeAddToCartPopupLocator).click();
    }

    //Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym pomyślne dodanie
    public boolean isSuccessPopupDisplayed() {
        By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to " +
                "your shopping cart\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
        return getDriver().findElement(addProductPopupLocator).isDisplayed();
    }

}
