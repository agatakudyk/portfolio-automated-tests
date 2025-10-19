package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Accessories {

    //wybór filtra 'Ceramic'
    public void ceramicCompositionFilter() {
        By ceramicCompositionFilterLocator = By.xpath("//a[contains(text(),\"Ceramic\")]");
        getDriver().findElement(ceramicCompositionFilterLocator).click();
    }

    //wybór filtra 'Available'
    public void availableFilter() {
        By availableFilterLocator = By.xpath("//a[contains(text(),\"Available\")]");
        getDriver().findElement(availableFilterLocator).click();
    }

    //wyczyszczenie wybranych filtrów
    public void allFiltersClear() {
        By clearAllFilterLocator = By.xpath("//button[@class=\"btn btn-tertiary js-search-filters-clear-all\"]");
        getDriver().findElement(clearAllFilterLocator).click();
    }

    //potwierdzenie wyczyszczenia filtrów
    public boolean isFilterClear() {
        By activeFiltersLocator = By.xpath("//p[contains(text(),\"Active filters\")]");
        WebElement activeFilters = getDriver().findElement(activeFiltersLocator);
        return activeFilters.isDisplayed();
    }
}
