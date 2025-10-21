package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;


public class Accessories {

    // wybór filtra 'Ceramic'
    public Accessories selectCeramicFilter() {
        $x("//a[contains(text(),'Ceramic')]").click();
        $x("//a[contains(text(),'Ceramic')]/../span/input").shouldBe(selected);
        return this;
    }

    // wybór filtra 'Available'
    public Accessories selectAvailableFilter() {
        $x("//a[contains(text(),'Available')]").click();
        $x("//a[contains(text(),'Available')]/../span/input").shouldBe(selected);
        return this;
    }

    // wyczyszczenie wszystkich filtrów
    public Accessories clearAllFilters() {
        $x("//button[@class='btn btn-tertiary js-search-filters-clear-all']").click();
        return this;
    }

    // asercja - sprawdzenie, czy filtry zostały wyczyszczone
    public boolean isFilterCleared() {
        return $x("//p[contains(text(),'Active filters')]").is(hidden);
    }
}

