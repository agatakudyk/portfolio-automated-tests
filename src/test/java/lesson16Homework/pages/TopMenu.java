package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class TopMenu {

    // wejście na stronę ACCESSORIES
    public void accessoriesPageLink() {
        $x("//a[contains(text(),'Accessories']").shouldBe(visible).click();
    }

    // wejście na podstronę ART
    public void artPageLink() {
        $x("//a[contains(text(),'Art']").shouldBe(visible).click();
    }

    // przejście na stronę główną (Home Page)
    public void homePageLogo() {
        $("#_desktop_logo").shouldBe(visible).click();
    }
}
