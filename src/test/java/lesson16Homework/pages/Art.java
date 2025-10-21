package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


public class Art {

    // kliknięcie w pole sortowania
    public Art clickSortByButton() {
        $x("//button[@aria-label='Sort by selection']").click();
        return this;
    }

    // posortowanie według 'Name, A to Z'
    public Art sortByNameAZ() {
        SelenideElement sortByButton = $x("//button[@aria-label='Sort by selection']");
        $x("//div[@class='dropdown-menu']/a[contains(text(),'Name, A to Z')]").click();
        sortByButton.shouldBe(visible);
        return this;
    }

    // posortowanie według 'Price, low to high'
    public Art sortByPriceAsc() {
        SelenideElement sortByButton = $x("//button[@aria-label='Sort by selection']");
        $x("//div[@class='dropdown-menu']/a[contains(text(),'Price, low to high')]").click();
        sortByButton.shouldBe(visible);
        return this;
    }

    // wejście w okno produktu 'The Best Is Yet...'
    public Art openTheBestPoster() {
        $x("//img[@alt=\"The best is yet to come' Framed poster\"]").click();
        return this;
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

