package lesson16Homework.tests;

import lesson16Homework.pages.*;
import lesson16Homework.users.UnregisteredUserData;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnregisteredUserTests extends BaseTest{

    @Test
    @Order(1)
    public void languageSwitchIntoEnglish() {

        step("Home page - kliknięcie w dropdown języka", () -> {
            Header header = new Header();
            header.languageDropdownButton();
        });

        step("Home page - wybór języka 'English' z listy", () -> {
            Header header = new Header();
            header.englishLanguageSelectionFromDropdown();
        });

        step("Home page - weryfikacja, że język został zmieniony na angielski", () -> {
            Header header = new Header();
            assertTrue(header.isEnglishLanguageDisplayed());
        });
    }


    @Test
    @Order(2)
    public void addToCartAndDeleteProductByUnregisteredUser() {

        step("Unregistered user - kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'", () -> {
            Home home = new Home();
            home.wishlistIconOfPosterTodayIsAGoodDay();
        });

        step("Potwierdzenie pojawienia się popupu z komunikatem walidacyjnym", () -> {
            Home home = new Home();
            assertTrue(home.isMsgDisplayedThatLoginRequired());
        });

        step("Zamknięcie okna popup - kliknięcie w button 'Cancel'", () -> {
            Home home = new Home();
            home.closeWishlistPopupOfUnregisteredUser();
        });

        step("Wejście na stronę produktu 'Today is a good day Framed Poster'", () -> {
            Home home = new Home();
            home.enterProductPageOfTodayIsAGoodDayFramedPoster();
        });

        step("Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'", () -> {
            ProductTodayIsAGoodDayFramedPoster productPage = new ProductTodayIsAGoodDayFramedPoster();
            productPage.addToCartButton();
        });

        step("Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym pomyślne dodanie", () -> {
            ProductTodayIsAGoodDayFramedPoster productPage = new ProductTodayIsAGoodDayFramedPoster();
            assertTrue(productPage.isSuccessPopupDisplayed());
        });

        step("Zamknięcie popupu - kliknięcie w button 'Proceed to checkout'", () -> {
            ProductTodayIsAGoodDayFramedPoster productPage = new ProductTodayIsAGoodDayFramedPoster();
            productPage.closeAddToCartPopup();
        });

        step("Shopping cart - sprawdzenie zgodności nazwy produktu w koszyku", () -> {
            Cart cart = new Cart();
            assertTrue(cart.isProductInCart());
        });

        step("Shopping cart - usunięcie produktu z koszyka", () -> {
            Cart cart = new Cart();
            cart.deleteCartItem();
        });

        step("Shopping cart - potwierdzenie, że koszyk jest pusty", () -> {
            Cart cart = new Cart();
            assertTrue(cart.isMsgThatCartEmpty());
        });
    }


    @Test
    @Order(3)
    public void addProductToCartAndCheckoutByUnregisteredUser() {

        step("Shopping cart - powrót na stronę główną", () -> {
            Cart cart = new Cart();
            cart.homePageLink();
        });

        step("Home page - wejście w produkt 'Today is a good day Framed Poster'", () -> {
            Home home = new Home();
            home.enterProductPageOfTodayIsAGoodDayFramedPoster();
        });

        step("Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'", () -> {
            ProductTodayIsAGoodDayFramedPoster productPage = new ProductTodayIsAGoodDayFramedPoster();
            productPage.addToCartButton();
        });

        step("Popup w oknie produktu - kliknięcie w button 'Proceed to checkout'", () -> {
            ProductTodayIsAGoodDayFramedPoster productPage = new ProductTodayIsAGoodDayFramedPoster();
            productPage.closeAddToCartPopup();
        });

        step("Cart - kliknięcie w button 'Proceed to checkout'", () -> {
            Cart cart = new Cart();
            cart.proceedToCheckoutButton();
        });

        step("Personal Information - wpisanie danych użytkownika", () -> {
            UnregisteredUserData user = new UnregisteredUserData();
            user.firstName();
            user.lastName();
            user.email();
        });

        step("Personal Information - zaznaczenie wymaganych checkboxów", () -> {
            PersonalInformation personal = new PersonalInformation();
            personal.customerPrivacyCheckbox();
            personal.termsAndConditionsCheckbox();
        });

        step("Personal Information - kliknięcie w 'Continue'", () -> {
            PersonalInformation personal = new PersonalInformation();
            personal.continueButton();
        });

        step("Addresses - uzupełnienie danych adresowych i przejście do 'Shipping Method'", () -> {
            UnregisteredUserData user = new UnregisteredUserData();
            user.address();
            user.postalCode();
            user.city();

            Addresses addresses = new Addresses();
            addresses.continueButton();
        });

        step("Shipping Method - przejście do 'Payment'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.continueButton();
        });

        step("Payment - wybór opcji 'Pay by bank wire', zgoda na warunki i finalizacja zamówienia", () -> {
            Payment payment = new Payment();
            payment.payByBankWire();
            payment.agreeToTermsCheckbox();
            payment.placeOrderButton();
        });

        step("Order confirmation - potwierdzenie wyświetlenia komunikatu 'Your order is confirmed'", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            Assertions.assertTrue(confirmation.isMsgThatOrderConfirmed());
        });
    }
}
