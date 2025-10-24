package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


public class Art {

    // kliknięcie w pole sortowania
    public void sortByButton() {
        $x("//button[@aria-label='Sort by selection']").shouldBe(visible).click();
    }

    public void sortByNameAZ() {
        $x("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]").shouldBe(interactable).click();
    }

    public void sortByPriceAsc() {
        $x("//div[@class='dropdown-menu']/a[contains(text(),'Price, low to high')]").shouldBe(interactable).click();
    }

    // wejście w okno produktu 'The Best Is Yet...'
    public void theBestPoster() {
        $x("//img[@alt=\"The best is yet to come' Framed poster\"]").shouldBe(visible).click();
    }

    // pobranie listy produktów po nazwie
    public ElementsCollection getProductsByDescription() {
        return $$x("//div[@class='product-description']/h2/a");
    }

    // pobranie listy produktów po cenie
    public ElementsCollection getProductsByPrice() {
        return $$x("//div[@class='product-price-and-shipping']/span");
    }
}

