package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class ProductTodayIsAGoodDayFramedPoster {

    // kliknięcie w button 'Add to cart'
    public ProductTodayIsAGoodDayFramedPoster clickAddToCartButton() {
        $x("//button[@data-button-action='add-to-cart']").click();
        return this;
    }

    // Popup w oknie produktu – kliknięcie w button 'Proceed to checkout'
    public ProductTodayIsAGoodDayFramedPoster closeAddToCartPopup() {
        $x("//a[@class='btn btn-primary']/i").click();
        return this;
    }

    // Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym dodanie produktu
    public ProductTodayIsAGoodDayFramedPoster verifySuccessPopupDisplayed() {
        $x("//h4[contains(text(),'Product successfully added to your shopping cart')]").shouldBe(visible);
        return this;
    }
}
