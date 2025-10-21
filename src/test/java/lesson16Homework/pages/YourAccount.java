package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;


public class YourAccount {

    // kliknięcie w link 'Information'
    public YourAccount openInformationPage() {
        $x("//a[@id='identity-link']").click();
        return this;
    }

    // kliknięcie w link 'Order history and details'
    public YourAccount openOrderHistoryAndDetails() {
        $x("//a[@id='history-link']").click();
        return this;
    }

    // kliknięcie w link 'Addresses'
    public YourAccount openAddressesPage() {
        $x("//a[@id='addresses-link']/span/i").click();
        return this;
    }

    // kliknięcie w link 'My wishlists'
    public YourAccount openMyWishlistsPage() {
        $x("//a[@id='wishlist-link']/span/i").click();
        return this;
    }
}
