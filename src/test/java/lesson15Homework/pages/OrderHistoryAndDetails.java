package lesson15Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class OrderHistoryAndDetails {

    //kliknięcie w link 'Details'
    public void detailsLink() {
        getDriver().findElement(By.xpath("//a[@data-link-action=\"view-order-details\"]")).click();
    }
}
