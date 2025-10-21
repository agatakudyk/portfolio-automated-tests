package lesson16Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class OrderHistoryAndDetails {

    //kliknięcie w link 'Details'
    public void detailsLink() {
        By orderDetailsLinkLocator = By.xpath("//a[@data-link-action=\"view-order-details\"]");
        getDriver().findElement(orderDetailsLinkLocator).click();
    }
}
