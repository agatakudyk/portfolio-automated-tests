package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.ElementsCollection;


public class Art {

    // kliknięcie w pole sortowania
    public void sortByButton() {
        $x("//button[@aria-label='Sort by selection']").shouldBe(visible).click();
    }

    //todo posortowanie według 'Name, A to Z'
    public void sortByNameAZ() {
        $x("//button[@aria-label='Sort by selection']").shouldBe(visible).click();
        $x("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]").shouldBe(visible).click();
    }

    //todo posortowanie według 'Price, low to high'
    public void sortByPriceAsc() {
        $x("//button[@aria-label='Sort by selection']").shouldBe(visible).click();
        $x("//div[@class='dropdown-menu']/a[contains(text(),'Price, low to high')]").shouldBe(visible).click();
    }

    // wejście w okno produktu 'The Best Is Yet...'
    public void theBestPoster() {
        $x("//img[@alt=\"The best is yet to come' Framed poster\"]").shouldBe(visible).click();
    }

    // pobranie listy produktów po nazwie
    public ElementsCollection getProductsByDescription() {
        return $$x("//div[@class='product-description']/h2/a").filter(visible);
    }

    // pobranie listy produktów po cenie
    public ElementsCollection getProductsByPrice() {
        return $$x("//div[@class='product-price-and-shipping']/span").filter(visible);
    }
}

