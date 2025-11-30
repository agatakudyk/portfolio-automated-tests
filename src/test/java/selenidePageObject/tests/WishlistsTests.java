package selenidePageObject.tests;

import com.codeborne.selenide.SelenideElement;
import selenidePageObject.pages.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WishlistsTests extends BaseTest{

    @Test     //Wishlists - dodanie produktów do istniejącej wishlist
    @Order(22)
    public void addItemsToStaticWishlists() {

        step("Przejcie na Home page", () -> {
            TopMenu top = new TopMenu();
            top.homePageLogo();
        });

        step("Home page - kliknięcie w serduszko dodające do wishlist", () -> {
            Home home = new Home();
            home.wishlistIconOfHummingbirdPrintedTshirt();
        });

        step("Popup 'Add to whishlist' - kliknięcie w link 'My wishlist'", () -> {
            Home home = new Home();
            home.myWishlistSelection();
        });

        step("TOAST 'Product added' - potwierdzenie pojawienia się komunikatu", () -> {
            Home home = new Home();
            Assertions.assertTrue(home.isAddedMsgDisplayed());
        });

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("'Your account' - przejście na stronę 'My wishlists'", () -> {
            YourAccount account = new YourAccount();
            account.myWishlists();
        });

        step("'My wishlists' - wejście na link 'My wishlist'", () -> {
            MyWishlists myWishlist = new MyWishlists();
            myWishlist.myWishlistLink();
        });

        step("'My wishlist' - sprawdzenie, że produkt jest na liście", () -> {
            MyWishlists myWishlist = new MyWishlists();
            List<SelenideElement> wishListsElements = myWishlist.getWishListElements().stream().toList();
            List<String> wishListsElementsNames = wishListsElements.stream().map(SelenideElement::getText).toList();
            assertTrue(wishListsElementsNames.size() == 1 && wishListsElementsNames.getFirst().equals("Hummingbird printed t-shirt"));
        });
    }

    @Test    //Wishlists - utworzenie nowej wishlisty i dodanie produktu
    @Order(23)
    public void addItemsToNewWishlists() {

        step("Przejcie na Home page", () -> {
            TopMenu top = new TopMenu();
            top.homePageLogo();
        });

        step("Home page - kliknięcie w serduszko dodające do wishlist", () -> {
            Home home = new Home();
            home.wishlistIconOfMugTheAdventureBegins();
        });

        step("Popup 'Add to whishlist' - kliknięcie w link 'Create new list'", () -> {
            Home home = new Home();
            home.createNewWishlist();
        });

        step("Home page/Popup 'Create wishlist' - wpisanie nazwy nowej listy", () -> {
            Home home = new Home();
            home.wishlistNameFillIn();
        });

        step("Home page/Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'", () -> {
            Home home = new Home();
            home.createNewWishListButton();
        });

        step("Popup 'Add to whishlist' - wybranie nowo utworzonej listy", () -> {
            Home home = new Home();
            home.ulubioneNewWishlist();
        });

        step("Home page/TOAST - potwierdzenie pojawienia się komunikatu 'Product added'", () -> {
            Home home = new Home();
            Assertions.assertTrue(home.isAddedMsgDisplayed());
        });

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("'Your account' - wejście na stronę 'My wishlists'", () -> {
            YourAccount account = new YourAccount();
            account.myWishlists();
        });

        step("'My wishlists' - wejście na link listy 'Ulubione'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.ulubioneWishlistLink();
        });

        step("Ulubione - sprawdzenie, że produkt jest na liście", ()->{
            MyWishlists myWishlists = new MyWishlists();
            List<SelenideElement> wishListsElements = myWishlists.getWishListElements().stream().toList();
            List<String> wishListsElementsNames = wishListsElements.stream().map(SelenideElement::getText).toList();
            Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Mug The adventure begins"));
        });
    }

    @Test   //Wishlists - utworzenie listy na podstronie ‘My wishlists’, zmiana nazwy i usunięcie
    @Order(24)
    public void createNewWishlists() {

        step("Ulubione - przejście na stronę 'My wishlists'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.myWishlistsPage();
        });

        step("My wishlists - kliknięcie w 'Create new list'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.createNewList();
        });

        step("Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.addNameOfNewList("Super lista");
        });

        step("Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.createWishlistButton();
        });

        step("TOAST/'The list has been properly created' - potwierdzenie pojawienia się komunikatu", () -> {
            MyWishlists myWishlists = new MyWishlists();
            Assertions.assertTrue(myWishlists.isCreatedMsgDisplayed());
        });

        step("potwierdzenie, czy istnieje lista o nazwie 'Super lista'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            Assertions.assertTrue(myWishlists.isSuperListaDisplayed());
        });

        step("My wishlists - kliknięcie w trzy kropki", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.moreActionsButton("Super lista");
        });

        step("My wishlists - kliknięcie w 'Rename'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.renameWishlist();
        });

        step("Popup 'Rename wishlist' - aktualizacja nazwy nowej listy życzeń", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.wishlistRenameField();
        });

        step("Popup 'Rename wishlist' - kliknięcie w button 'Rename wishlist'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.renameWishlistButton();
        });

        step("TOAST/'List has been renamed' - potwierdzenie pojawienia się komunikatu", () -> {
            MyWishlists myWishlists = new MyWishlists();
            Assertions.assertTrue(myWishlists.isRenamedListMsgDisplayed());
        });

        step("My wishlists - kliknięcie w trzy kropki", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.moreActionsButton("Lista życzeń");
        });

        step("My wishlists - kliknięcie w button 'Share'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.shareButton();
        });

        step("Share wishlist - kliknięcie w button 'Copy text'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.copyTextButton();
        });

        step("TOAST/'Share link copied!' - potwierdzenie pojawienia się komunikatu", () -> {
            MyWishlists myWishlists = new MyWishlists();
            Assertions.assertTrue(myWishlists.isCopiedLinkMsgDisplayed());
        });

        step("My wishlists - usunięcie listy", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.deleteWishlist();
        });

        step("Popup 'Delete wishlist' - kliknięcie w button 'Delete'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.deleteButton();
        });

        step("TOAST/'List has been removed' - potwierdzenie pojawienia się komunikatu", () -> {
            MyWishlists myWishlists = new MyWishlists();
            Assertions.assertTrue(myWishlists.isRemovedListMsgDisplayed());
        });
    }
}
