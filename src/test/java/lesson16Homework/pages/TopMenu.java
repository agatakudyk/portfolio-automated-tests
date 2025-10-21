package lesson16Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class TopMenu {

    //wejście na stronę ACCESSORIES
    public void accessoriesPageLink() {
        By accessoriesPageLocator = By.id("category-6");
        getDriver().findElement(accessoriesPageLocator).click();
    }

    //wejście na podstronę ART
    public void artPageLink() {
        By artPageLocator = By.id("category-9");
        getWaiter().until(ExpectedConditions.elementToBeClickable(artPageLocator));
        getDriver().findElement(artPageLocator).click();
    }

    //Przejcie na Home page
    public void homePageLogo() {
        By homepageLinkLocator = By.id("_desktop_logo");
        getDriver().findElement(homepageLinkLocator).click();
    }
}
