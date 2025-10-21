package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class Cart {

    // usunięcie produktu z koszyka
    public Cart deleteCartItem() {
        $x("//a[@class='remove-from-cart']/i[contains(text(),'delete')]").click();
        return this;
    }

    // powrót na stronę główną
    public Cart homePageLink() {
        $x("//a[@id='_desktop_logo']").click();
        return this;
    }

    // kliknięcie w button 'Proceed to checkout'
    public Cart proceedToCheckoutButton() {
        $x("//a[contains(text(),'Proceed to checkout')]").click();
        return this;
    }

    // asercja - sprawdzenie zgodności nazwy produktu w koszyku
    public boolean isProductInCart() {
        return $x("//div[@class='product-line-info']/a[contains(text(),'Today is a good day Framed poster')]")
                .shouldBe(visible)
                .getText()
                .equals("Today is a good day Framed poster");
    }

    // asercja - potwierdzenie pojawienia się komunikatu, że koszyk jest pusty
    public boolean isMsgThatCartEmpty() {
        return $x("//span[contains(text(),'There are no more items in your cart')]")
                .shouldBe(visible)
                .isDisplayed();
    }

    // asercja - sprawdzenie nazwy produktu
    public String getProductNameInCart() {
        return $x("//div[@class='product-line-info']/a").getText();
    }

    // pobranie ceny jednostkowej
    public String getUnitPrice() {
        return $x("//div[@class='product-line-info product-price h5 ']/div[@class='current-price']")
                .getText()
                .replace("zł", "")
                .replace(",", ".")
                .trim();
    }

    // pobranie ilości produktu
    public String getQuantity() {
        return $x("//input[@class='js-cart-line-product-quantity form-control']").getDomAttribute("value");
    }

    // pobranie całkowitej wartości koszyka
    public String getTotal() {
        return $x("//div[@class='cart-summary-line cart-total']/span[@class='value']")
                .getText()
                .replace("zł", "")
                .replace(",", ".")
                .trim();
    }

    // pobranie ilości w podsumowaniu koszyka
    public String getQuantitySummary() {
        return $x("//span[@class='label js-subtotal']").getText();
    }
}
