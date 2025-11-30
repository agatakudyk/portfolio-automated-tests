package selenidePageObject.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class Home {

    // kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'
    public void wishlistIconOfPosterTodayIsAGoodDay() {
        $x("//a[contains(text(),'Today is a good day Framed')]" +
                "/../../../button[@class='wishlist-button-add']").shouldBe(visible).click();
    }

    // asercja - potwierdzenie pojawienia się popupu z komunikatem walidacyjnym
    public boolean isMsgDisplayedThatLoginRequired() {
        return $x("//p[contains(text(),'You need to be logged in to save products in your wishlist.')]")
                .shouldBe(visible).isDisplayed();
    }

    // kliknięcie w button 'Cancel' w popupie
    public void closeWishlistPopupOfUnregisteredUser() {
        $x("//a[contains(text(),'Sign in')]/../button[contains(text(),'Cancel')]")
                .shouldBe(visible).click();
    }

    // wejście na stronę produktu 'Today is a good day Framed Poster'
    public void enterProductPageOfTodayIsAGoodDayFramedPoster() {
        $x("//a[@class='thumbnail product-thumbnail']/img[@alt='Today is a good day Framed poster']")
                .shouldBe(visible).click();
    }

    // kliknięcie wishlist-button produktu 'Hummingbird printed t-shirt'
    public void wishlistIconOfHummingbirdPrintedTshirt() {
        $x("//a[contains(text(),'Hummingbird printed t-shirt')]" +
                "/../../../button[@class='wishlist-button-add']").shouldBe(visible).click();
    }

    // popup 'Add to wishlist' - kliknięcie w link 'My wishlist'
    public void myWishlistSelection() {
        $x("//div[@class='modal-body']/div/ul/li[@class='wishlist-list-item']").shouldBe(visible).click();
    }

    // kliknięcie wishlist-button produktu 'Mug The adventure begins'
    public void wishlistIconOfMugTheAdventureBegins() {
        $x("//a[contains(text(),'Mug The adventure begins')]/../../../button[@class='wishlist-button-add']")
        .shouldBe(visible).click();
    }

    // popup - kliknięcie w link 'Create new list'
    public void createNewWishlist() {
        $x("//a[@class='wishlist-add-to-new text-primary']").shouldBe(visible).click();
    }

    // wpisanie nazwy nowej listy
    public void wishlistNameFillIn() {
        $x("//input[@id='input2']").shouldBe(visible).setValue("Ulubione");
    }

    // kliknięcie w button 'Create wishlist'
    public void createNewWishListButton() {
        $x("//button[contains(text(),'Create wishlist')]").shouldBe(visible).click();
    }

    // wybranie nowo utworzonej listy
    public void ulubioneNewWishlist() {
        $x("//li[@class='wishlist-list-item']/p[contains(text(),'Ulubione')]").shouldBe(visible).click();
    }

    // TOAST 'Product added' - potwierdzenie pojawienia się komunikatu
    public boolean isAddedMsgDisplayed() {
        return $x("//div[@class='wishlist-toast success']/p[@class='wishlist-toast-text']")
                .shouldBe(visible).isDisplayed();
    }
}
