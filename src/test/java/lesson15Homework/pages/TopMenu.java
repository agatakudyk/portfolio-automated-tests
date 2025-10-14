package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class TopMenu {

    //wejście na stronę ACCESSORIES
    public void accessoriesPageLink() {
        By accessoriesPageLocator = By.id("category-6");
        getDriver().findElement(accessoriesPageLocator).click();
    }



}
