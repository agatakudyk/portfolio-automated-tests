package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class ProductTheBestIsYetToCome {

    //kliknięcie w button dodania opinii o produkcie
    public void productReviewButton() {
        By reviewButtonLocator = By.xpath("//div[@class=\"product-comment-list-item\"]/button");
        getWaiter().until(ExpectedConditions.elementToBeClickable(reviewButtonLocator));
        getDriver().findElement(reviewButtonLocator).click();
    }

    //popup 'Write your review' - wpisanie tytułu komentarza
    public void reviewTitle(String reviewTitle) {
        By commentTitleLocator = By.id("comment_title");
        getWaiter().until(ExpectedConditions.elementToBeClickable(commentTitleLocator));
        getDriver().findElement(commentTitleLocator).sendKeys(reviewTitle);
    }

    //popup 'Write your review' - wpisanie treści komentarza
    public void reviewFillIn(String reviewContext) {
        getDriver().findElement(By.id("comment_content")).sendKeys(reviewContext);
    }

    //popup 'Write your review' - kliknięcie w button 'Send'
    public void sendReviewButton() {
        getDriver().findElement(By.xpath("//button[@class=\"btn btn-comment btn-comment-big\"]")).click();
    }

    //review sent popup - kliknięcie w button 'OK'
    public void okReviewButton() {
        By okCommentButtonLocator = By.xpath(
                "//div[contains(text(), \"Your comment has been submitted and will be available once " +
                        "approved by a moderator.\")]/../div[@class=\"post-comment-buttons\"]" +
                        "/button[@class=\"btn btn-comment btn-comment-huge\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(okCommentButtonLocator));
        getDriver().findElement(okCommentButtonLocator).click();
    }

    //kliknięcie button 'Add to cart'
    public void addToCartButton() {
        getDriver().findElement(By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]")).click();
    }

    //popup 'Product successfully added...' - kliknięcie 'Proceed to checkout'
    public void proceedToCheckoutButton() {
        getDriver().findElement(By.xpath("//a[@class=\"btn btn-primary\"]/i")).click();
    }

    //asercja - potwierdzenie dodania komentarza
    public boolean isCommentAdded() {
        By addCommentPopupLocator = By.id("product-comment-posted-modal-message");
        getWaiter().until(ExpectedConditions.elementToBeClickable(addCommentPopupLocator));
        return getDriver().findElement(addCommentPopupLocator).isDisplayed();
    }

    public void putProductQuantityEnterNumber(int quantity) {
        WebElement putProductQuantity = getDriver().findElement(By.id("quantity_wanted"));
        putProductQuantity.sendKeys(Keys.CONTROL + "a");
        putProductQuantity.sendKeys(Keys.DELETE);
        putProductQuantity.sendKeys(Integer.toString(quantity));
    }

    public void putProductQuantityIncreaseArrow(int quantity) {
        WebElement selectQuantityClick = getDriver().findElement(By.xpath("//i[@class=\"material-icons touchspin-up\"]"));
        for (int i = 1; i <= quantity; i++) {
            selectQuantityClick.click();
        }
    }

    public boolean isProductSuccessfullyAdded() {
        By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to " +
                "your shopping cart\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
        return getDriver().findElement(addProductPopupLocator).isDisplayed();
    }
}
