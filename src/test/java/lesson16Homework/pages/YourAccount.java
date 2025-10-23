package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class YourAccount {

    // kliknięcie w link 'Information'
    public void informationLink() {
        $x("//a[@id='identity-link']").shouldBe(visible).click();
    }

    // kliknięcie w link 'Order history and details'
    public void orderHistoryAndDetails() {
        $x("//a[@id='history-link']").shouldBe(visible).click();
    }

    // kliknięcie w link 'Addresses'
    public void addresses() {
        $x("//a[@id='addresses-link']/span/i").shouldBe(visible).click();
    }

    // kliknięcie w link 'My wishlists'
    public void myWishlists() {
        $x("//a[@id='wishlist-link']/span/i").shouldBe(visible).click();
    }
}
