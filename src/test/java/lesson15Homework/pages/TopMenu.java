package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class TopMenu {

    //wejście na stronę ACCESSORIES
    public void accessoriesPageLink() {
        By accessoriesPageLocator = By.id("category-6");
        getDriver().findElement(accessoriesPageLocator).click();
    }

    //wejście na podstronę ART
    public void artPageLink() {
        By artPageLocator = By.id("category-9");
        getDriver().findElement(artPageLocator).click();
    }


}
