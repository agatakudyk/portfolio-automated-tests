package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class TopMenu {

    // wejście na stronę ACCESSORIES
    public void accessoriesPageLink() {
        $("#category-6").shouldBe(visible).click();
    }

    // wejście na podstronę ART
    public void artPageLink() {
        $("#category-9").shouldBe(visible).click();
    }

    // przejście na stronę główną (Home Page)
    public void homePageLogo() {
        $("#_desktop_logo").shouldBe(visible).click();
    }
}
