package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class OrderHistoryAndDetails {

    //kliknięcie w link 'Details'
    public void detailsLink() {
        getDriver().findElement(By.xpath("//a[@data-link-action=\"view-order-details\"]")).click();
    }
}
