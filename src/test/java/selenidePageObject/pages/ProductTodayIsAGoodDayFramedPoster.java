package selenidePageObject.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class ProductTodayIsAGoodDayFramedPoster {

    // kliknięcie w button 'Add to cart'
    public void addToCartButton() {
        $x("//button[@data-button-action='add-to-cart']").shouldBe(visible).click();
    }

    // Popup w oknie produktu – kliknięcie w button 'Proceed to checkout'
    public void closeAddToCartPopup() {
        $x("//a[@class='btn btn-primary']/i").shouldBe(visible).click();
    }

    // Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym dodanie produktu
    public boolean isSuccessPopupDisplayed() {
        return $x("//h4[contains(text(),'Product successfully added to your shopping cart')]")
                .shouldBe(visible).isDisplayed();
    }
}
