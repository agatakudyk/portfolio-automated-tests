package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class Home {

    // kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'
    public Home wishlistIconOfPosterTodayIsAGoodDay() {
        $x("//a[contains(text(),'Today is a good day Framed')]" +
                "/../../../button[@class='wishlist-button-add']").click();
        return this;
    }

    // asercja - potwierdzenie pojawienia się popupu z komunikatem walidacyjnym
    public boolean isMsgDisplayedThatLoginRequired() {
        return $x("//p[contains(text(),'You need to be logged in to save products in your wishlist.')]")
                .shouldBe(visible)
                .isDisplayed();
    }

    // kliknięcie w button 'Cancel' w popupie
    public Home closeWishlistPopupOfUnregisteredUser() {
        $x("//a[contains(text(),'Sign in')]/../button[contains(text(),'Cancel')]").click();
        return this;
    }

    // wejście na stronę produktu 'Today is a good day Framed Poster'
    public Home enterProductPageOfTodayIsAGoodDayFramedPoster() {
        $x("//a[@class='thumbnail product-thumbnail']/img[@alt='Today is a good day Framed poster']").click();
        return this;
    }

    // kliknięcie wishlist-button produktu 'Hummingbird printed t-shirt'
    public Home wishlistIconOfHummingbirdPrintedTshirt() {
        $x("//a[contains(text(),'Hummingbird printed t-shirt')]" +
                "/../../../button[@class='wishlist-button-add']").click();
        return this;
    }

    // popup 'Add to wishlist' - kliknięcie w link 'My wishlist'
    public Home myWishlistSelection() {
        $x("//div[@class='modal-body']/div/ul/li[@class='wishlist-list-item']")
                .shouldBe(visible)
                .click();
        return this;
    }

    // kliknięcie wishlist-button produktu 'Mug The adventure begins'
    public Home wishlistIconOfMugTheAdventureBegins() {
        $x("//a[contains(text(),'Mug The adventure begins')]/../../../button[@class='wishlist-button-add']").click();
        return this;
    }

    // popup - kliknięcie w link 'Create new list'
    public Home createNewWishlist() {
        $x("//a[@class='wishlist-add-to-new text-primary']")
                .shouldBe(visible)
                .click();
        return this;
    }

    // wpisanie nazwy nowej listy
    public Home wishlistNameFillIn() {
        $x("//input[@id='input2']").sendKeys("Ulubione");
        return this;
    }

    // kliknięcie w button 'Create wishlist'
    public Home createNewWishListButton() {
        $x("//button[contains(text(),'Create wishlist')]").click();
        return this;
    }

    // wybranie nowo utworzonej listy
    public Home ulubioneNewWishlist() {
        $x("//li[@class='wishlist-list-item']/p[contains(text(),'Ulubione')]")
                .shouldBe(visible)
                .click();
        return this;
    }

    // TOAST 'Product added' - potwierdzenie pojawienia się komunikatu
    public boolean isAddedMsgDisplayed() {
        return $x("//div[@class='wishlist-toast success']/p[@class='wishlist-toast-text']")
                .shouldBe(visible)
                .isDisplayed();
    }
}
