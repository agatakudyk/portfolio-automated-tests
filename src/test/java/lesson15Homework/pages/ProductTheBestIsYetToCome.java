package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class ProductTheBestIsYetToCome {

    //kliknięcie w button dodania opinii o produkcie
    public void commentButton() {
        By commentButtonLocator = By.xpath("//div[@class=\"product-comment-list-item\"]/button");
        getDriver().findElement(commentButtonLocator).click();
    }


}
