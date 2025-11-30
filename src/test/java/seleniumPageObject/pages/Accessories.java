package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static seleniumPageObject.driver.DriverProvider.getDriver;
import static seleniumPageObject.driver.DriverProvider.getWaiter;


public class Accessories {

    //wybór filtra 'Ceramic'
    public void ceramicCompositionFilter() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Ceramic\")]")).click();
        getWaiter().until(ExpectedConditions.elementToBeSelected(By.xpath("//a[contains(text(),\"Ceramic\")]/../span/input")));
    }

    //wybór filtra 'Available'
    public void availableFilter() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Available\")]")).click();
        getWaiter().until(ExpectedConditions.elementToBeSelected(By.xpath("//a[contains(text(),\"Available\")]/../span/input")));
    }

    //wyczyszczenie wybranych filtrów
    public void allFiltersClear() {
        By clearAllFilterLocator = By.xpath("//button[@class=\"btn btn-tertiary js-search-filters-clear-all\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(clearAllFilterLocator));
        getDriver().findElement(clearAllFilterLocator).click();
    }

    //asercja - potwierdzenie wyczyszczenia filtrów
    public boolean isFilterClear() {
        return getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),\"Active filters\")]")));
    }
}
