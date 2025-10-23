package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


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
        return $x("//span[contains(text(),\"There are no more items in your cart\")]")
                .shouldBe(visible).isDisplayed();
    }

    //asercja - sprawdzenie nazwy produktu
    public String getProductNameInCart() {
        return $x("//div[@class=\"product-line-info\"]/a").getText();
    }

    public String getUnitPrice() {
        return $x("//div[@class=\"product-line-info product-price h5 \"]/div[@class=\"current-price\"]")
                .shouldBe(visible).getText().replace("zł", "").replace(",", ".").trim();
    }

    public String getQuantity() {
        return $x("//input[@class='js-cart-line-product-quantity form-control']")
                .shouldBe(visible).getDomAttribute("value");
    }

    public String getTotal() {
        return $x("//div[@class='cart-summary-line cart-total']/span[@class='value']")
                .shouldBe(visible).getText().replace("zł", "").replace(",", ".").trim();
    }

    public String getQuantitySummary() {
        return $x("//span[@class='label js-subtotal']").shouldBe(visible).getText();
    }
}
