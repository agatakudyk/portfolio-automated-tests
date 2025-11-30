package selenidePageObject.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ProductTheBestIsYetToCome {

    // kliknięcie w button dodania opinii o produkcie
    public void productReviewButton() {
        $x("//div[@class='product-comment-list-item']/button").shouldBe(visible).click();
    }

    // popup 'Write your review' - wpisanie tytułu komentarza
    public void reviewTitle() {
        $("#comment_title").shouldBe(visible).setValue("Moja ocena produktu");
    }

    // popup 'Write your review' - wpisanie treści komentarza
    public void reviewFillIn() {
        $("#comment_content").shouldBe(visible).setValue("To bardzo dobry produkt.");
    }

    // popup 'Write your review' - kliknięcie w button 'Send'
    public void sendReviewButton() {
        $x("//button[@class='btn btn-comment btn-comment-big']").shouldBe(visible).click();
    }

    // review sent popup - kliknięcie w button 'OK'
    public void okReviewButton() {
        $x("//div[contains(text(), 'Your comment has been submitted and will be available once " +
                "approved by a moderator.')]/../div[@class='post-comment-buttons']" +
                "/button[@class='btn btn-comment btn-comment-huge']").shouldBe(visible).click();
    }

    // kliknięcie button 'Add to cart'
    public void addToCartButton() {
        $x("//button[@class='btn btn-primary add-to-cart']").shouldBe(visible).click();
    }

    // popup 'Product successfully added...' - kliknięcie 'Proceed to checkout'
    public void proceedToCheckoutButton() {
        $x("//a[@class='btn btn-primary']/i").shouldBe(visible).click();
    }

    // asercja - potwierdzenie dodania komentarza
    public boolean isCommentAdded() {
        return $x("//div[@id='product-comment-posted-modal-message']").shouldBe(visible).isDisplayed();
    }

    // ustawienie ilości produktu przez wpisanie liczby
    public void putProductQuantityEnterNumber(int quantity) {
        SelenideElement quantityField = $("#quantity_wanted").shouldBe(visible);
        quantityField.clear();
        quantityField.setValue(String.valueOf(quantity));
    }

    // ustawienie ilości produktu przez strzałkę 'increase'
    public void putProductQuantityIncreaseArrow(int quantity) {
        SelenideElement increaseArrow = $x("//i[@class='material-icons touchspin-up']").shouldBe(visible);
        for (int i = 1; i <= quantity; i++) {
            increaseArrow.click();
        }
    }

    // asercja - potwierdzenie dodania produktu do koszyka
    public boolean isProductSuccessfullyAdded() {
        return $x("//h4[contains(text(),'Product successfully added to your shopping cart')]")
                .shouldBe(visible).isDisplayed();
    }
}
