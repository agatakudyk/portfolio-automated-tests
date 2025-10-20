package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;

public class Art {

    //kliknięcie w pole sortowania
    public void sortByButton() {
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(sortByListLocator));
        getDriver().findElement(sortByListLocator).click();
    }

    //posortowanie według 'Name, A to Z'
    public void sortByNameAZ() {
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        WebElement sortBy = getDriver().findElement(sortByListLocator);
        By sortByNameAZLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]");
        getDriver().findElement(sortByNameAZLocator).click();
        getWaiter().until(ExpectedConditions.stalenessOf(sortBy));
    }

    //posortowanie według ‘Price, low to high’
    public void sortByPriceAsc() {
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        WebElement sortBy = getDriver().findElement(sortByListLocator);

        By sortByPriceAscLocator = By.xpath("//div[@class=\"dropdown-menu\"]" +
                "/a[contains(text(),\"Price, low to high\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(sortByPriceAscLocator));
        getDriver().findElement(sortByPriceAscLocator).click();
        getWaiter().until(ExpectedConditions.stalenessOf(sortBy));

    }

    //wejście w okno produktu 'The Best Is Yet...'
    public void theBestPoster() {
        By theBestPosterLocator = By.xpath("//img[@alt=\"The best is yet to come' Framed poster\"]");
        getDriver().findElement(theBestPosterLocator).click();
    }

    public List<WebElement> getproductsbyDescription(){
        By productsListLocator = By.xpath("//div[@class=\"product-description\"]/h2/a");
        return getDriver().findElements(productsListLocator);
    }
    public List<WebElement> getProductByPrice(){
        By productsListLocator = By.xpath("//div[@class=\"product-price-and-shipping\"]/span");
        return getDriver().findElements(productsListLocator);
    }


}
