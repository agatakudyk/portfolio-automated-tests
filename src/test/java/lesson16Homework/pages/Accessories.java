package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;


public class Accessories {

    // wybór filtra 'Ceramic'
    public void ceramicCompositionFilter() {
        $x("//a[contains(text(),'Ceramic')]").shouldBe(visible).click();
    }

    // wybór filtra 'Available'
    public void availableFilter() {
        $x("//a[contains(text(),'Available')]").shouldBe(visible).click();
    }

    // wyczyszczenie wszystkich filtrów
    public void allFiltersClear() {
        $x("//button[@class='btn btn-tertiary js-search-filters-clear-all']").shouldBe(visible).click();
    }

    //asercja - sprawdzenie, czy filtry zostały wyczyszczone
    public boolean isFilterClear() {
        return !$x("//p[contains(text(),'Active filters')]").shouldBe(hidden).isDisplayed();
    }
}

