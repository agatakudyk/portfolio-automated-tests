package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class Accessories {

    //wybór filtra 'Ceramic'
    public void ceramicCompositionFilter() {
        By ceramicCompositionFilterLocator = By.xpath("//a[contains(text(),\"Ceramic\")]");
        getDriver().findElement(ceramicCompositionFilterLocator).click();

        By ceramicCompositionFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Ceramic\")]/../span/input");
        getWaiter().until(ExpectedConditions.elementToBeSelected(ceramicCompositionFilterCheckboxLocator));
    }

    //wybór filtra 'Available'
    public void availableFilter() {
        By availableFilterLocator = By.xpath("//a[contains(text(),\"Available\")]");
        getDriver().findElement(availableFilterLocator).click();

        By availableFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Available\")]/../span/input");
        getWaiter().until(ExpectedConditions.elementToBeSelected(availableFilterCheckboxLocator));
    }

    //wyczyszczenie wybranych filtrów
    public void allFiltersClear() {
        By clearAllFilterLocator = By.xpath("//button[@class=\"btn btn-tertiary js-search-filters-clear-all\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(clearAllFilterLocator));
        getDriver().findElement(clearAllFilterLocator).click();
    }

    //asercja - potwierdzenie wyczyszczenia filtrów
    public boolean isFilterClear() {
        By activeFiltersLocator = By.xpath("//p[contains(text(),\"Active filters\")]");
        return getDriver().findElement(activeFiltersLocator).isDisplayed();
    }
}
