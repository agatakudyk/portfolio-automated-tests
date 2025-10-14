package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class YourAccount {

    //kliknięcie w link 'Information'
    public void informationLink() {
        By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
        getDriver().findElement(informationPageLocator).click();
    }

    //wejście w sekcję 'Order history and details'
    public void orderHistoryAndDetails() {
        By orderHistoryAndDetailsLinkLocator = By.id("history-link");
        getDriver().findElement(orderHistoryAndDetailsLinkLocator).click();
    }
}
