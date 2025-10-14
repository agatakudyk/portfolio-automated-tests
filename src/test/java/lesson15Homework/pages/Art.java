package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class Art {
    //kliknięcie w pole sortowania
    public void sortBy() {
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        getDriver().findElement(sortByListLocator).click();
    }






}
