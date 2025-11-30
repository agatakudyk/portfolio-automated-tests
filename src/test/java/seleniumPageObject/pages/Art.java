package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static seleniumPageObject.driver.DriverProvider.getDriver;
import static seleniumPageObject.driver.DriverProvider.getWaiter;

public class Art {

    //kliknięcie w pole sortowania
    public void sortByButton() {
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(sortByListLocator));
        getDriver().findElement(sortByListLocator).click();
    }

    //posortowanie według 'Name, A to Z'
    public void sortByNameAZ() {
        WebElement sortBy = getDriver().findElement(By.xpath("//button[@aria-label=\"Sort by selection\"]"));
        getDriver().findElement(By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]")).click();
        getWaiter().until(ExpectedConditions.stalenessOf(sortBy));
    }

    //posortowanie według ‘Price, low to high’
    public void sortByPriceAsc() {
        WebElement sortBy = getDriver().findElement(By.xpath("//button[@aria-label=\"Sort by selection\"]"));

        By sortByPriceAscLocator = By.xpath("//div[@class=\"dropdown-menu\"]" +
                "/a[contains(text(),\"Price, low to high\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(sortByPriceAscLocator));
        getDriver().findElement(sortByPriceAscLocator).click();
        getWaiter().until(ExpectedConditions.stalenessOf(sortBy));

    }

    //wejście w okno produktu 'The Best Is Yet...'
    public void theBestPoster() {
        getDriver().findElement(By.xpath("//img[@alt=\"The best is yet to come' Framed poster\"]")).click();
    }

    public List<WebElement> getProductsbyDescription(){
        return getDriver().findElements(By.xpath("//div[@class=\"product-description\"]/h2/a"));
    }
    public List<WebElement> getProductByPrice(){
        return getDriver().findElements(By.cssSelector("span.price[aria-label='Cena']"));
    }


}
