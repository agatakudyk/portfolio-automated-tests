package lesson16Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static lesson16Homework.driver.DriverProvider.getDriver;


public class Cart {

    //usunięcie produktu z koszyka
    public void deleteCartItem() {
        $x("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]").shouldBe(visible).click();
    }

    //powrót na stronę główną
    public void homePageLink() {
        $("_desktop_logo").shouldBe(visible).click();
    }

    //kliknięcie w button 'Proceed to checkout'
    public void proceedToCheckoutButton() {
        $x("//a[contains(text(),\"Proceed to checkout\")]").shouldBe(visible).click();
    }

    //asercja - sprawdzenie zgodności nazwy produktu w koszyku
    public boolean isProductInCart() {
        return $x("//div[@class=\"product-line-info\"]/a[contains(text(),\"Today is a good day Framed poster\")]")
                .shouldBe(visible).isDisplayed();
    }

    //asercja - potwierdzenie pojawienia się komunikatu, że koszyk jest pusty
    public boolean isMsgThatCartEmpty() {
        return $x("//span[contains(text(),\"There are no more items in your cart\")]").isDisplayed();
    }

    //asercja - sprawdzenie nazwy produktu
    public String getProductNameInCart() {
        return $x("//div[@class=\"product-line-info\"]/a").getText();
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
