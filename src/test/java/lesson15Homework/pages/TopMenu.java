package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class TopMenu {

    //wejście na stronę ACCESSORIES
    public void accessoriesPageLink() {
        getDriver().findElement(By.id("category-6")).click();
    }

    //wejście na podstronę ART
    public void artPageLink() {
        By artPageLocator = By.id("category-9");
        getWaiter().until(ExpectedConditions.elementToBeClickable(artPageLocator));
        getDriver().findElement(artPageLocator).click();
    }

    //Przejcie na Home page
    public void homePageLogo() {
        getDriver().findElement(By.id("_desktop_logo")).click();
    }
}
