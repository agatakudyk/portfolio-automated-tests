package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class Cart {

    //usunięcie produktu z koszyka
    public void deleteCartItem() {
        By trashIconLocator = By.xpath("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]");
        getDriver().findElement(trashIconLocator).click();
    }

    //powrót na stronę główną
    public void homePageLink() {
        By homepageLinkLocator = By.id("_desktop_logo");
        getDriver().findElement(homepageLinkLocator).click();
    }

    //kliknięcie w button 'Proceed to checkout'
    public void proceedToCheckoutButton() {
        By proceedToCheckoutButtonLocator = By.xpath("//a[contains(text(),\"Proceed to checkout\")]");
        getDriver().findElement(proceedToCheckoutButtonLocator).click();
    }

    //asercja - sprawdzenie zgodności nazwy produktu w koszyku
    public boolean isProductInCart() {
        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]" +
                "/a[contains(text(),\"Today is a good day Framed poster\")]");
        String productNameInCart = getDriver().findElement(productNameInCartLocator).getText();
        return "Today is a good day Framed poster".equals(productNameInCart);
    }

    //asercja - potwierdzenie pojawienia się komunikatu, że koszyk jest pusty
    public boolean isMsgThatCartEmpty() {
        By emptyCartMsgLocator = By.xpath("//span[contains(text(),\"There are no more items in your cart\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(emptyCartMsgLocator));
        return getDriver().findElement(emptyCartMsgLocator).isDisplayed();
    }

    //asercja - sprawdzenie nazwy produktu
    public String getProductNameInCart() {
        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]/a");
        return getDriver().findElement(productNameInCartLocator).getText();
    }
    public String getUnitPrice(){
        By unitPriceOfItemLocator = By.xpath("//div[@class=\"product-line-info product-price h5 \"]" + "/div[@class=\"current-price\"]");
        WebElement unitPriceOfItem = getDriver().findElement(unitPriceOfItemLocator);
        return unitPriceOfItem.getText().replace("zł", "").replace(",", ".").trim();
    }
    public String getQuantity(){
        By numberInItemsSectionLocator = By.xpath("//input[@class='js-cart-line-product-quantity form-control']");
        WebElement numberInItemSection = getDriver().findElement(numberInItemsSectionLocator);
        return numberInItemSection.getDomAttribute("value");
    }

    public String getTotal(){
        By totalPriceLocator = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
        WebElement totalPriceElement = getDriver().findElement(totalPriceLocator);
        return  totalPriceElement.getText().replace("zł", "").replace(",", ".").trim();
    }

    public String getQuantitySummary(){
        By numberInPurchaseSummarySectionLocator = By.xpath("//span[@class='label js-subtotal']");
        WebElement numberInPurchaseSummarySection = getDriver().findElement(numberInPurchaseSummarySectionLocator);
        return numberInPurchaseSummarySection.getText();
    }

}
