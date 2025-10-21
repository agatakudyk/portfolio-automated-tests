package lesson16Homework.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ProductTheBestIsYetToCome {

    // kliknięcie w button dodania opinii o produkcie
    public ProductTheBestIsYetToCome clickProductReviewButton() {
        $x("//div[@class='product-comment-list-item']/button").click();
        return this;
    }

    // popup 'Write your review' - wpisanie tytułu komentarza
    public ProductTheBestIsYetToCome enterReviewTitle() {
        $("#comment_title").setValue("Moja ocena produktu");
        return this;
    }

    // popup 'Write your review' - wpisanie treści komentarza
    public ProductTheBestIsYetToCome enterReviewText() {
        $("#comment_content").setValue("To bardzo dobry produkt.");
        return this;
    }

    // popup 'Write your review' - kliknięcie w button 'Send'
    public ProductTheBestIsYetToCome clickSendReviewButton() {
        $x("//button[@class='btn btn-comment btn-comment-big']").click();
        return this;
    }
    // review sent popup - kliknięcie w button 'OK'
    public ProductTheBestIsYetToCome clickOkReviewButton() {
        $x("//div[contains(text(), 'Your comment has been submitted and will be available once approved by a moderator.')]" +
                "/../div[@class='post-comment-buttons']/button[@class='btn btn-comment btn-comment-huge']").click();
        return this;
    }

    // kliknięcie button 'Add to cart'
    public ProductTheBestIsYetToCome clickAddToCartButton() {
        $x("//button[@class='btn btn-primary add-to-cart']").click();
        return this;
    }

    // popup 'Product successfully added...' - kliknięcie 'Proceed to checkout'
    public ProductTheBestIsYetToCome clickProceedToCheckoutButton() {
        $x("//a[@class='btn btn-primary']/i").click();
        return this;
    }

    // asercja - potwierdzenie dodania komentarza
    public ProductTheBestIsYetToCome verifyCommentAdded() {
        $x("//div[@id='product-comment-posted-modal-message']").shouldBe(visible);
        return this;
    }

    // ustawienie ilości produktu przez wpisanie liczby
    public ProductTheBestIsYetToCome setProductQuantity(int quantity) {
        SelenideElement quantityField = $("#quantity_wanted");
        quantityField.clear();
        quantityField.setValue(String.valueOf(quantity));
        return this;
    }

    // ustawienie ilości produktu przez strzałkę 'increase'
    public ProductTheBestIsYetToCome increaseProductQuantityByArrow(int quantity) {
        SelenideElement increaseArrow = $x("//i[@class='material-icons touchspin-up']");
        for (int i = 1; i <= quantity; i++) {
            increaseArrow.click();
        }
        return this;
    }

    // asercja - potwierdzenie dodania produktu do koszyka
    public ProductTheBestIsYetToCome verifyProductSuccessfullyAdded() {
        $x("//h4[contains(text(),'Product successfully added to your shopping cart')]").shouldBe(visible);
        return this;
    }
}
