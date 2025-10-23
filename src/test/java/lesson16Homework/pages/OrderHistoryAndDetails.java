package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class OrderHistoryAndDetails {

    // kliknięcie w link 'Details'
    public void detailsLink() {
        $x("//a[@data-link-action='view-order-details']").shouldBe(visible).click();
    }
}

