package lesson16Homework.pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MyWishlists {

    // wejście na link listy 'My wishlist'
    public MyWishlists openMyWishlist() {
        $x("//p[@class='wishlist-list-item-title']").click();
        return this;
    }

    // wejście na link listy 'Ulubione'
    public MyWishlists openUlubioneWishlist() {
        $x("//a[@class='wishlist-list-item-link']/p[contains(text(),'Ulubione')]").click();
        return this;
    }

    // przejście na stronę 'My wishlists'
    public MyWishlists openMyWishlistsPage() {
        $x("//nav[@data-depth='4']//a[contains(., 'My wishlists')]").click();
        return this;
    }

    // kliknięcie w 'Create new list'
    public MyWishlists clickCreateNewList() {
        $x("//div[@class='wishlist-container-header']/a[contains(text(),'Create new list')]").click();
        return this;
    }

    // wpisanie nazwy nowej listy życzeń
    public MyWishlists setNameForNewList(String name) {
        $x("//input[@placeholder='Add name']").setValue(name);
        return this;
    }

    // kliknięcie w button 'Create wishlist'
    public MyWishlists clickCreateWishlistButton() {
        $x("//button[contains(text(),'Create wishlist')]").click();
        return this;
    }

    // kliknięcie w trzy kropki
    public MyWishlists clickMoreActionsButton(String listName) {
        $x("//p[contains(text(),'" + listName + "')]/../div[@class='wishlist-list-item-right']" +
                "/button[@class='wishlist-list-item-actions']").click();
        return this;
    }

        // kliknięcie w button 'Copy text'
        public MyWishlists clickCopyTextButton() {
            $("button:contains('Copy text')").click();
            return this;
        }

        // usunięcie listy
        public MyWishlists clickDeleteWishlist(String listName) {
            $x("//p[contains(text(),'" + listName + "')]/../div[@class='wishlist-list-item-right']" +
                    "/button/i[contains(text(),'delete')]").click();
            return this;
        }

        // kliknięcie w button 'Delete' w popup
        public MyWishlists confirmDeleteButton() {
            $x("//div[@class='modal-footer']/button[contains(text(),'Delete')]").click();
            return this;
        }

        // asercja - TOAST 'The list has been properly created'
        public boolean isCreatedMsgDisplayed() {
            return $("p:contains('The list has been properly created')").shouldBe(visible).isDisplayed();
        }

        // asercja - lista o nazwie 'Super lista'
        public boolean isSuperListaDisplayed() {
            return $x("//div[@class='wishlist-list-container']" +
                    "//p[contains(text(),'Super lista')]").shouldBe(visible).isDisplayed();
        }

        // TOAST 'List has been renamed'
        public boolean isRenamedListMsgDisplayed() {
            return $("p.wishlist-toast-text:contains('List has been renamed')").shouldBe(visible).isDisplayed();
        }

        // TOAST 'Share link copied!'
        public boolean isCopiedLinkMsgDisplayed() {
            return $("p.wishlist-toast-text:contains('Share link copied!')").shouldBe(visible).isDisplayed();
        }

        // TOAST 'List has been removed'
        public boolean isRemovedListMsgDisplayed() {
            return $("p:contains('List has been removed')").shouldBe(visible).isDisplayed();
        }

        // pobranie wszystkich elementów wishlist
        public ElementsCollection getWishListElements() {
            return $$("p.wishlist-product-title").filter(visible);
        }
    }




