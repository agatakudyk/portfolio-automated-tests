package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static seleniumPageObject.driver.DriverProvider.getDriver;
import static seleniumPageObject.driver.DriverProvider.getWaiter;


public class ProductTodayIsAGoodDayFramedPoster {

    //kliknięcie w button 'Add to cart'
    public void addToCartButton() {
        getDriver().findElement(By.xpath("//button[@data-button-action=\"add-to-cart\"]")).click();
    }

    //Popup w oknie produktu - kliknięcie w button 'Proceed to checkout'
    public void closeAddToCartPopupLocator() {
        getDriver().findElement(By.xpath("//a[@class=\"btn btn-primary\"]/i")).click();
    }

    //Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym pomyślne dodanie
    public boolean isSuccessPopupDisplayed() {
        By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to " +
                "your shopping cart\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
        return getDriver().findElement(addProductPopupLocator).isDisplayed();
    }

}
