package lesson15Homework.pages;

import org.openqa.selenium.By;
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
}
