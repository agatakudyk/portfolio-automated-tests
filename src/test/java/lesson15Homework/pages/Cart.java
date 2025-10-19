package lesson15Homework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


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
        WebElement emptyCartMsg = getDriver().findElement(emptyCartMsgLocator);
        return emptyCartMsg.isDisplayed();
    }

    //asercja - sprawdzenie nazwy produktu
    public String getProductNameInCart() {
        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]/a");
        String productNameInCart = getDriver().findElement(productNameInCartLocator).getText();
        return productNameInCart;
    }
}
