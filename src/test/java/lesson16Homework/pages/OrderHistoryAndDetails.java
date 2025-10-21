package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;


public class OrderHistoryAndDetails {

    // kliknięcie w link 'Details'
    public OrderHistoryAndDetails clickDetailsLink() {
        $x("//a[@data-link-action='view-order-details']").click();
        return this;
    }
}

