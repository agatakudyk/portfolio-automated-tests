package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class ProductTheBestIsYetToCome {

    //kliknięcie w button dodania opinii o produkcie
    public void productReviewButton() {
        By reviewButtonLocator = By.xpath("//div[@class=\"product-comment-list-item\"]/button");
        getDriver().findElement(reviewButtonLocator).click();
    }

    //popup 'Write your review' - wpisanie tytułu komentarza
    public void reviewTitle() {
        By commentTitleLocator = By.id("comment_title");
        getDriver().findElement(commentTitleLocator).sendKeys("Moja ocena produktu");
    }

    //popup 'Write your review' - wpisanie treści komentarza
    public void reviewFillIn() {
        By commentTextLocator = By.id("comment_content");
        getDriver().findElement(commentTextLocator).sendKeys("To bardzo dobry produkt.");
    }

    //popup 'Write your review' - kliknięcie w button 'Send'
    public void sendReviewButton() {
        By sendButtonLocator = By.xpath("//button[@class=\"btn btn-comment btn-comment-big\"]");
        getDriver().findElement(sendButtonLocator).click();
    }
    //review sent popup - kliknięcie w button 'OK'
    public void okReviewButton() {
        By okCommentButtonLocator = By.xpath(
                "//div[contains(text(), \"Your comment has been submitted and will be available once " +
                        "approved by a moderator.\")]/../div[@class=\"post-comment-buttons\"]" +
                        "/button[@class=\"btn btn-comment btn-comment-huge\"]");
        getDriver().findElement(okCommentButtonLocator).click();
    }

//kliknięcie button 'Add to cart'
    public void addToCartButton() {
        By addToCartButtonLocator = By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]");
        getDriver().findElement(addToCartButtonLocator).click();
    }

    //popup 'Product successfully added...' - kliknięcie 'Proceed to checkout'
    public void proceedToCheckoutButton() {
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
        getDriver().findElement(closeAddToCartPopupLocator).click();
    }
}
