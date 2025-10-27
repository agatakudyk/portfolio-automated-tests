package lesson15Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class YourAccount {

    //kliknięcie w link 'Information'
    public void informationLink() {
        getDriver().findElement(By.xpath("//a[@id=\"identity-link\"]")).click();
    }

    //kliknięcie w link 'Order history and details'
    public void orderHistoryAndDetails() {
        getDriver().findElement(By.id("history-link")).click();
    }

    //kliknięcie w link 'Addresses'
    public void addresses() {
        getDriver().findElement(By.xpath("//a[@id=\"addresses-link\"]/span/i")).click();
    }

    //kliknięcie w link 'My wishlists'
    public void myWishlists() {
        getDriver().findElement(By.xpath("//a[@id=\"wishlist-link\"]/span/i")).click();
    }
}
