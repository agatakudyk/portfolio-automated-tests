package lesson16Homework.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MyWishlists {

    // wejście na link listy 'My wishlist'
    public void myWishlistLink() {
        $x("//p[@class='wishlist-list-item-title']").shouldBe(visible).click();
    }

    // wejście na link listy 'Ulubione'
    public void ulubioneWishlistLink() {
        $x("//a[@class='wishlist-list-item-link']/p[contains(text(),'Ulubione')]").shouldBe(visible).click();
    }

    // przejście na stronę 'My wishlists'
    public void myWishlistsPage() {
        $x("//nav[@data-depth='4']//a[contains(., 'My wishlists')]").shouldBe(visible).click();
    }

    // kliknięcie w 'Create new list'
    public void createNewList() {
        $x("//div[@class='wishlist-container-header']/a[contains(text(),'Create new list')]")
                .shouldBe(visible).click();
    }

    //Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń
    public void addNameOfNewList(String listName) {
        $x("//input[@placeholder='Add name']").shouldBe(visible).setValue(listName);
    }

    //Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'
    public void createWishlistButton() {
        $x("//button[contains(text(),'Create wishlist')]").shouldBe(visible).click();
    }

    // kliknięcie w trzy kropki
    public void moreActionsButton(String nazwaListy) {
        $x("//p[contains(text(),\""+nazwaListy+"\")]/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]")
                .shouldBe(interactable).click();
    }

    //kliknięcie w 'Rename'
    public void renameWishlist() {
        $x("//p[contains(text(),\"Super lista\")]/..//div[@class=\"wishlist-list-item-right\"]" +
                "/div[@class=\"dropdown-menu show\"]/button[contains(text(),\"Rename\")]").shouldBe(interactable).click();
    }

    //zmiana nazwy listy życzeń
    public void wishlistRenameField() {
        SelenideElement changeNameOfList = $x("//h5[contains(text(),\"Rename wishlist\")]/../..//div/div/input").shouldBe(visible);
        changeNameOfList.clear();
        changeNameOfList.setValue("Lista życzeń");
    }

    //Popup 'Rename wishlist' - kliknięcie w button 'Rename wishlist'
    public void renameWishlistButton() {
        $x("//button[contains(text(),\"Rename wishlist\")]").shouldBe(visible).click();
    }

    //kliknięcie w button 'Share'
    public void shareButton() {
        $x("//button[contains(text(),\"Share\")]").shouldBe(visible).click();
    }

    // kliknięcie w button 'Copy text'
    public void copyTextButton() {
        $x("//button[contains(text(),'Copy text')]").shouldBe(visible).click();
    }

    // usunięcie listy
    public void deleteWishlist() {
        $x("//p[contains(text(),\"Lista życzeń\")]/../div[@class=\"wishlist-list-item-right\"]" +
                "/button/i[contains(text(),\"delete\")]").shouldBe(visible).click();
    }

    // kliknięcie w button 'Delete' w popup
    public void deleteButton() {
        $x("//div[@class='modal-footer']/button[contains(text(),'Delete')]").shouldBe(visible).click();
    }

    // asercja - TOAST 'The list has been properly created'
    public boolean isCreatedMsgDisplayed() {
        return $x("//p[contains(text(),\"The list has been properly created\")]").shouldBe(visible).isDisplayed();
    }

    // asercja - lista o nazwie 'Super lista'
    public boolean isSuperListaDisplayed() {
        return $x("//div[@class='wishlist-list-container']" +
                "//p[contains(text(),'Super lista')]").shouldBe(visible).isDisplayed();
    }

    // TOAST 'List has been renamed'
    public boolean isRenamedListMsgDisplayed() {
        return $x("//p[contains(text(),'List has been renamed')]").shouldBe(visible).isDisplayed();
    }

    // TOAST 'Share link copied!'
    public boolean isCopiedLinkMsgDisplayed() {
        return $x("//p[contains(text(),'Share link copied!')]").shouldBe(visible).isDisplayed();
    }

    // TOAST 'List has been removed'
    public boolean isRemovedListMsgDisplayed() {
        return $x("//p[contains(text(),'List has been removed')]").shouldBe(visible).isDisplayed();
    }

    // pobranie wszystkich elementów wishlist
    public ElementsCollection getWishListElements() {
        return $$("p.wishlist-product-title").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}




