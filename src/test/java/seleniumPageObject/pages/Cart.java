package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static seleniumPageObject.driver.DriverProvider.getDriver;
import static seleniumPageObject.driver.DriverProvider.getWaiter;


public class Cart {

    //usunięcie produktu z koszyka
    public void deleteCartItem() {
        getDriver().findElement(By.xpath("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]")).click();
    }

    //powrót na stronę główną
    public void homePageLink() {
        getDriver().findElement( By.id("_desktop_logo")).click();
    }

    //kliknięcie w button 'Proceed to checkout'
    public void proceedToCheckoutButton() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Proceed to checkout\")]")).click();
    }

    //asercja - sprawdzenie zgodności nazwy produktu w koszyku
    public boolean isProductInCart() {
        String productNameInCart = getDriver().findElement(By.xpath("//div[@class=\"product-line-info\"]" +
                "/a[contains(text(),\"Today is a good day Framed poster\")]")).getText();
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
        return getDriver().findElement(By.xpath("//div[@class=\"product-line-info\"]/a")).getText();
    }
    public String getUnitPrice(){
        WebElement unitPriceOfItem = getDriver().findElement(By.xpath("//div[@class=\"product-line-info product-price h5 \"]" + "/div[@class=\"current-price\"]"));
        return unitPriceOfItem.getText().replace("zł", "").replace(",", ".").trim();
    }
    public String getQuantity(){
        WebElement numberInItemSection = getDriver().findElement(By.xpath("//input[@class='js-cart-line-product-quantity form-control']"));
        return numberInItemSection.getDomAttribute("value");
    }

    public String getTotal(){
        return getDriver().findElement(By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']"))
                .getText().replace("zł", "").replace(",", ".").trim();
    }

    public String getQuantitySummary(){
       return getDriver().findElement(By.xpath("//span[@class='label js-subtotal']")).getText();
    }

}
