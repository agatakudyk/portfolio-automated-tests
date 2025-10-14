package lesson15Homework.pages;

import org.openqa.selenium.By;
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
}
