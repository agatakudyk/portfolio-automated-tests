package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;

public class Art {
    //kliknięcie w pole sortowania
    public void sortByButton() {
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        getDriver().findElement(sortByListLocator).click();
    }

    //posortowanie według 'Name, A to Z'
    public void sortByNameAZ() {
        By sortByNameAZLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]");
        getDriver().findElement(sortByNameAZLocator).click();
    }

//posortowanie według ‘Price, low to high’
public void sortByPriceAsc() {
    By sortByPriceAscLocator = By.xpath("//div[@class=\"dropdown-menu\"]" +
            "/a[contains(text(),\"Price, low to high\")]");
    getDriver().findElement(sortByPriceAscLocator).click();
}

//wejście w okno produktu 'The Best Is Yet...'
    public void theBestPoster() {
        By theBestPosterLocator = By.xpath("//img[@alt=\"The best is yet to come' Framed poster\"]");
        getDriver().findElement(theBestPosterLocator).click();
    }


}
