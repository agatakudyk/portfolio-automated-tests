package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Cart {

    //Shopping cart - usunięcie produktu z koszyka
    public void deleteCartItem() {
        By trashIconLocator = By.xpath("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]");
        getDriver().findElement(trashIconLocator).click();
    }

    public void homePageLink() {
        By homepageLinkLocator = By.id("_desktop_logo");
        getDriver().findElement(homepageLinkLocator).click();}
}
