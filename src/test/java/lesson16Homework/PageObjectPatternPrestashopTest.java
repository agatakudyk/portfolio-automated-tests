package lesson16Homework;

import lesson15Homework.driver.DriverProvider;
import lesson15Homework.pages.*;
import lesson15Homework.users.RegisteredUser;
import lesson15Homework.users.UnregisteredUserData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PageObjectPatternPrestashopTest {

    @BeforeAll
    public static void beforeAll() {
        open("http://localhost:8080/pl/");
    }

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
            assertTrue(header.isEnglishLanguageDisplayed(), "Język powinien być ustawiony na angielski");
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
            assertTrue(home.isMsgDisplayedThatLoginRequired(), "Powinien pojawić się komunikat wymogu logowania");
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
            assertTrue(productPage.isSuccessPopupDisplayed(), "Powinien pojawić się popup potwierdzający dodanie produktu");
        });

        step("Zamknięcie popupu - kliknięcie w button 'Proceed to checkout'", () -> {
            ProductTodayIsAGoodDayFramedPoster productPage = new ProductTodayIsAGoodDayFramedPoster();
            productPage.closeAddToCartPopupLocator();
        });

        step("Shopping cart - sprawdzenie zgodności nazwy produktu w koszyku", () -> {
            Cart cart = new Cart();
            assertTrue(cart.isProductInCart(), "Produkt powinien znajdować się w koszyku");
        });

        step("Shopping cart - usunięcie produktu z koszyka", () -> {
            Cart cart = new Cart();
            cart.deleteCartItem();
        });

        step("Shopping cart - potwierdzenie, że koszyk jest pusty", () -> {
            Cart cart = new Cart();
            assertTrue(cart.isMsgThatCartEmpty(), "Koszyk powinien być pusty");
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
            productPage.closeAddToCartPopupLocator();
        });

        step("Cart - kliknięcie w button 'Proceed to checkout'", () -> {
            Cart cart = new Cart();
            cart.proceedToCheckoutButton();
        });

        step("Personal Information - uzupełnienie danych osobowych", () -> {
            UnregisteredUserData user = new UnregisteredUserData();
            user.firstName();
            user.lastName();
            user.email();

            PersonalInformation personal = new PersonalInformation();
            personal.customerPrivacyCheckbox();
            personal.termsAndConditionsCheckbox();
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
            assertTrue(confirmation.isMsgThatOrderConfirmed(), "Powinien pojawić się komunikat potwierdzający zamówienie");
        });
    }

    @Test
    @Order(4)
    public void signUpNowFillInFormByUnregisteredUser() {

        step("‘Save time on...' form - kliknięcie w button 'Save' bez uzupełnienia danych", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.saveButtonInForm();
        });

        step("Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            assertEquals("Wypełnij to pole.", confirmation.getValidationMsg());
        });

        step("‘Save time on...' form - uzupełnienie danych użytkownika", () -> {
            UnregisteredUserData unregistered = new UnregisteredUserData();
            unregistered.firstName();
            unregistered.lastName();
            unregistered.email();
            unregistered.password();
        });

        step("‘Save time on...' form - zaznaczenie checkboxów zgody i regulaminu", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.customerPrivacyCheckbox();
            confirmation.termsAndConditionsCheckbox();
        });

        step("Zapisanie danych poprzez kliknięcie w button 'Save'", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.saveButtonInForm();
        });
    }

    @Test  // Niepoprawna rejestracja przy pomocy pustego formularza
    @Order(5)
    public void failSignupWithEmptyFields() {

        step("Login page - kliknięcie w link rejestracji", () -> {
            new LogIn().signupLink();
        });

        step("Create account page - kliknięcie w button 'Save' bez wypełniania pól", () -> {
            new CreateAccount().saveButton();
        });

        step("Create account page/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            assertEquals("Wypełnij to pole.", new CreateAccount().getValidationMsg());
        });
    }

    @Test  // Poprawna rejestracja użytkownika
    @Order(6)
    public void userSuccessSignup() {

        step("Create account - uzupełnienie pola 'First name'", () -> {
            new RegisteredUser().name();
        });

        step("Create account - uzupełnienie pola 'Last name'", () -> {
            new RegisteredUser().lastName();
        });

        step("Create account - uzupełnienie pola 'Email'", () -> {
            new RegisteredUser().email();
        });

        step("Create account - uzupełnienie pola 'Password'", () -> {
            new RegisteredUser().password();
        });

        step("Create Account - kliknięcie w checkbox informacji o przetwarzaniu danych osobowych", () -> {
            new CreateAccount().customerPrivacyCheckbox();
        });

        step("Create Account - kliknięcie w checkbox akceptacji polityki prywatności", () -> {
            new CreateAccount().termsAndConditionsCheckbox();
        });

        step("Create Account - kliknięcie w button 'Save'", () -> {
            new CreateAccount().saveButton();
        });

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", () -> {
            assertTrue(new Header().isButtonSignOutDisplayed());
        });

        step("Header - kliknięcie w button 'Sign out' / wylogowanie użytkownika", () -> {
            new Header().signout();
        });

        step("Sprawdzenie czy wylogowany - widoczność przycisku 'Sign in'", () -> {
            assertTrue(new Header().isButtonSignInDisplayed());
        });
    }

    @Test  // Niepoprawne logowanie z użyciem pustych pól i błędnych danych
    @Order(7)
    public void failLoginWithIncorrectData() {

        step("Header - kliknięcie w button 'Sign In'", () -> {
            new Header().signIn();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            new LogIn().signInButton();
        });

        step("Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu", () -> {
            assertEquals("Wypełnij to pole.", new LogIn().getValidationMsg());
        });

        step("Login page - uzupełnienie pola 'Email'", () -> {
            new LogIn().emailField();
        });

        step("Login page - uzupełnienie pola 'Password'", () -> {
            new LogIn().passwordField();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            new LogIn().signInButton();
        });

        step("Login page - sprawdzenie komunikatu 'Authentication failed.'", () -> {
            assertTrue(new LogIn().isMsgAuthenticationFailedDisplayed());
        });
    }

    @Test  // Login page - zresetowanie zapomnianego hasła
    @Order(8)
    public void loginPasswordReset() {

        step("Login page - kliknięcie w link 'Forgot your password?'", () -> {
            new LogIn().passwordRecoveryLink();
        });

        step("Reset password page - uzupełnienie pola 'Email address'", () -> {
            new PasswordReset().email();
        });

        step("Reset password page - kliknięcie w button 'Send reset link'", () -> {
            new PasswordReset().sendResetLink();
        });

        step("Reset password page - sprawdzenie komunikatu potwierdzającego wysłanie maila", () -> {
            assertTrue(new PasswordReset().isMsgOfSentMsgDisplayed());
        });
    }

    private void backToPreviousPassword() {

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            new Header().userProfile();
        });

        step("Wejście w link 'Information'", () -> {
            new YourAccount().informationLink();
        });

        step("Wpisanie aktualnego hasła logowania", () -> {
            new RegisteredUser().newPassword();
        });

        step("Wpisanie nowego hasła logowania", () -> {
            new RegisteredUser().password();
        });

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", () -> {
            new YourPersonalInformation().termsAndConditionsCheckbox();
        });

        step("Your personal information - checkbox zgody na przetwarzanie danych osobowych", () -> {
            new YourPersonalInformation().customerPrivacyCheckbox();
        });

        step("Kliknięcie buttona 'Save'", () -> {
            new YourPersonalInformation().saveButton();
        });
    }

    @Test       //Podstrona Accessories - filtrowanie
    @Order(10)
    public void clearAccessoriesProductsFiltering() {

        step("Wejście na stronę ACCESSORIES", () -> {
            new TopMenu().accessoriesPageLink();
        });

        step("Accessories page - wybór filtra 'Ceramic'", () -> {
            new Accessories().ceramicCompositionFilter();
        });

        step("Accessories page - wybór filtra 'Available'", () -> {
            new Accessories().availableFilter();
        });

        step("Accessories page - wyczyszczenie wybranych filtrów", () -> {
            new Accessories().allFiltersClear();
        });

        step("Accessories page - potwierdzenie wyczyszczenia filtrów", () -> {
            Assertions.assertFalse(new Accessories().isFilterClear());
        });
    }

    @Test    //Podstrona ART - sortowanie
    @Order(11)
    public void sortArtProducts() {

        step("wejście na podstronę ART", () -> {
            TopMenu top = new TopMenu();
            top.artPageLink();
        });

        step("strona ART - kliknięcie w pole sortowania", () -> {
            Art art = new Art();
            art.sortByButton();
        });

        step("strona ART - posortowanie według 'Name, A to Z'", () -> {
            Art art = new Art();
            art.sortByNameAZ();
        });

        step("strona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", () -> {
            Art art = new Art();

            List<String> productsNames = new ArrayList<>();
            for (WebElement product : art.getproductsbyDescription()) {
                productsNames.add(product.getText());
            }
            List<String> productsAlphabeticalOrder = productsNames.stream().sorted().toList();

            for (int i = 0; i < productsNames.size(); i++) {
                assertEquals(productsNames.get(i), productsAlphabeticalOrder.get(i));
            }
        });

        step("strona ART - kliknięcie w pole sortowania", () -> {
            Art art = new Art();
            art.sortByButton();
        });

        step("strona ART - posortowanie według ‘Price, low to high’", () -> {
            Art art = new Art();
            art.sortByPriceAsc();
        });

        step("Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", () -> {
            Art art = new Art();
            List<String> productsPrices = new ArrayList<>();
            for (WebElement product : art.getProductByPrice()) {
                productsPrices.add(product.getText());
            }
            List<String> productsAlphabeticalOrder2 = productsPrices.stream().sorted().toList();

            for (int i = 0; i < productsPrices.size(); i++) {
                assertEquals(productsPrices.get(i), productsAlphabeticalOrder2.get(i));
            }
        });
    }

    @Test   //Podstrona ART - dodanie opinii o produkcie
    @Order(12)
    public void successAddPosterReview() {

        step("Podstrona ART - wejście na stronę produktu 'The Best Is Yet To Come Framed Poster'", () -> {
            Art art = new Art();
            art.theBestPoster();
        });

        step("Strona produktu - kliknięcie w button dodania opinii o produkcie", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.productReviewButton();
        });

        step("popup 'Write your review' - wpisanie tytułu komentarza", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.reviewTitle();
        });

        step("WRITE YOUR REVIEW - wpisanie treści komentarza", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.reviewFillIn();
        });

        step("WRITE YOUR REVIEW - kliknięcie w button 'Send'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.sendReviewButton();
        });

        step("Popup REVIEW SENT - potwierdzenie dodania komentarza", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            assertTrue(best.isCommentAdded());
        });

        step("Popup REVIEW SENT - zamknięcie okna poprzez kliknięcie w button 'OK'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.okReviewButton();
        });
    }

    @Test    //Strona produktu - zwiększenie ilości produktu i dodanie do koszyka
    @Order(13)
    public void addProductsToCart() {

        step("Strona produktu - zmiana ilości produktu poprzez wpisanie liczby (wyczyść i wpisz wartość)", () -> {
            //zmiana ilości produktu poprzez wpisanie liczby
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.putProductQuantityEnterNumber(4);
        });

        step("Strona produktu - zmiana ilości produktu poprzez kliknięcie w strzałki", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.putProductQuantityIncreaseArrow(3);
        });

        step("Strona produktu - kliknięcie button 'Add to cart'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.addToCartButton();
        });

        step("Popup - sprawdzenie komunikatu potwierdzającego dodanie do koszyka", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            assertTrue(best.isProductSuccessfullyAdded());
        });
    }

    @Test  //Koszyk - sprawdzenie zawartości
    @Order(14)
    public void cartContentValidation() {

        step("Popup - zamknięcie okna poprzez kliknięcie 'Proceed to checkout'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.proceedToCheckoutButton();
        });

        step("Cart - sprawdzenie nazwy produktu", () -> {
            Cart cart = new Cart();
            assertEquals("The best is yet to come' Framed poster", cart.getProductNameInCart());
        });

        step("Shopping cart - porównanie ilości z sekcji produktu i sekcji podsumowania", () -> {
            Cart cart = new Cart();
            // ilość w sekcji produktu
            int productQuantity = Integer.parseInt(Objects.requireNonNull(cart.getQuantity()));
            // ilość w sekcji podsumowania
            String summaryQuantityText = cart.getQuantitySummary();
            int summaryQuantity = Integer.parseInt(summaryQuantityText.replaceAll("\\D+", ""));
            // porównanie ilości z sekcji produktu i sekcji podsumowania
            assertEquals(productQuantity, summaryQuantity);
        });

        step("Shopping cart - sprawdzenie wartości całkowitej", () -> {
            Cart cart = new Cart();
            //cena jednostkowa
            String unitPriceText = cart.getUnitPrice();
            double unitPrice = Double.parseDouble(unitPriceText);
            // ilość w sekcji produktu
            int productQuantity = Integer.parseInt(Objects.requireNonNull(cart.getQuantity()));
            //wartość całkowita z podsumowania
            String totalPriceText = cart.getTotal();
            double totalPrice = Double.parseDouble(totalPriceText);
            //oczekiwana wartość
            double expectedTotal = unitPrice * productQuantity;
            assertEquals(totalPrice, expectedTotal);
        });
    }

    @Test    //Zapisanie danych w formularzu adresu
    @Order(15)
    public void addressesFormFailSaveWithEmptyFields() {

        step("Shopping cart - przejście do adresu klikając button 'Proceed To Checkout'", () -> {
            Cart cart = new Cart();
            cart.proceedToCheckoutButton();
        });

        step("Addresses - kliknięcie w button 'Continue'", () -> {
            Addresses address = new Addresses();
            address.continueButton();
        });

        step("Addresses/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            Addresses address = new Addresses();
            assertEquals("Wypełnij to pole.", address.getValidationMsg());
        });

        step("Addresses - uzupełnienie pola 'Address'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.address();
        });

        step("Addresses - uzupełnienie pola 'Zip/Postal Code'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.postalCode();
        });

        step("Addresses - uzupełnienie pola 'City'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.city();
        });

        step("Addresses - kliknięcie w button 'Continue'", () -> {
            Addresses address = new Addresses();
            address.continueButton();
        });
    }

    @Test   //Shipping method - wybór formy dostawy
    @Order(16)
    public void shippingMethodSuccessSelection() {

        step("Shipping method - wybranie formy dostawy 'My carrier'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.prestaShopRadioButton();
        });

        step("Shipping method - wybranie formy dostawy pierwszej/nazwa ustawiana w Dockerze", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.myCarrierRadioButton();
        });

        step("Shipping method - dodanie komentarza do zamówienia", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.commentToOrder();
        });

        step("Shipping method - kliknięcie w button 'Continue'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.continueButton();
        });
    }

    @Test
    @Order(17)
    public void paymentMethodSuccessSelection() {

        step("Payment - wybór opcji 'Pay by bank wire'", () -> {
            Payment pay = new Payment();
            pay.payByBankWire();
        });

        step("Payment - wybór opcji 'Pay by Check'", () -> {
            Payment pay = new Payment();
            pay.payByCheck();
        });

        step("Payment - wybór checkboxa zgody", () -> {
            Payment pay = new Payment();
            pay.agreeToTermsCheckbox();
        });

        step("Payment - kliknięcie w button 'Place Order'", () -> {
            Payment pay = new Payment();
            pay.placeOrderButton();
        });

        step("Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            assertTrue(confirmation.isMsgThatOrderConfirmed());
        });
    }

    @Test   //Formularz kontaktowy z działem obsługi klienta
    @Order(18)
    public void contactCustomerServiceDepartment() {

        step("Order confirmation page - kliknięcie w link kontaktu z działem obsługi klienta", () -> {
            OrderConfirmation order = new OrderConfirmation();
            order.customerServiceDepartmentContact();
        });

        step("Contact us - kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza", () -> {
            ContactUs contact = new ContactUs();
            contact.sendButton();
        });

        step("Contact us - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            ContactUs contact = new ContactUs();
            assertTrue(contact.isValidationMsgDisplayed());
        });

        step("Contact us - wpisanie treści wiadomości", () -> {
            ContactUs contact = new ContactUs();
            contact.msgFillIn();
        });

        step("Contact us - kliknięcie w button 'Send'", () -> {
            ContactUs contact = new ContactUs();
            contact.sendButton();
        });

        step("Komunikat informacyjny 'Your message has been successfully sent to our team.'", () -> {
            ContactUs contact = new ContactUs();
            assertTrue(contact.isInformationMsgDisplayed());
        });
    }

    @Test    //Details page - dodanie wiadomości
    @Order(19)
    public void addMsgInOrderDetailsPage() {

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("Your account - wejście w sekcję 'Order history and details'", () -> {
            YourAccount account = new YourAccount();
            account.orderHistoryAndDetails();
        });

        step("Kliknięcie w link 'Details'", () -> {
            OrderHistoryAndDetails order = new OrderHistoryAndDetails();
            order.detailsLink();
        });

        step("'Order details' - kliknięcie 'Send' w pustym formularzu 'ADD A MESSAGE'", () -> {
            OrderDetails details = new OrderDetails();
            details.sendButton();
        });

        step("Potwierdzenie pojawienia się komunikatu walidacji 'The message cannot be blank.'", () -> {
            OrderDetails details = new OrderDetails();
            assertTrue(details.isValidationMsgDisplayed());
        });

        step("'Order details' - Uzupełnienie treści wiadomości", () -> {
            OrderDetails details = new OrderDetails();
            details.msgFillIn();
        });

        step("'Order details' - kliknięcie 'Send'", () -> {
            OrderDetails details = new OrderDetails();
            details.sendButton();
        });

        step("potwierdzenie wysłania wiadomości 'Message successfully sent'", () -> {
            OrderDetails details = new OrderDetails();
            assertTrue(details.isInformationMsgDisplayed());
        });
    }

    @Test     //Panel użytkownika/Reorder - ponowne złożenie zamówienia
    @Order(20)
    public void reorderPreviousOrder() {

        step("'Order details' - kliknięcie w link 'Reorder'", () -> {
            OrderDetails details = new OrderDetails();
            details.reorderLink();
        });

        step("Addresses - wejście w link 'Edit'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.editAddress();
        });

        step("Addresses - zmiana nazwy miasta", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newCity();
        });

        step("Addresses - kliknięcie buttona 'Continue'", () -> {
            Addresses addresses = new Addresses();
            addresses.continueButton();
        });

        step("Shipping method - wybór radio buttona 'My carrier'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.prestaShopRadioButton();
        });

        step("Shipping method - kliknięcie w button 'Continue'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.continueButton();
        });

        step("Payment - wybór opcji 'Pay by bank wire'", () -> {
            Payment payment = new Payment();
            payment.payByBankWire();
        });

        step("Payment - wybór checkboxa zgody", () -> {
            Payment payment = new Payment();
            payment.agreeToTermsCheckbox();
        });

        step("Payment - kliknięcie w button 'Place Order'", () -> {
            Payment payment = new Payment();
            payment.placeOrderButton();
        });

        step("Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            assertTrue(confirmation.isMsgThatOrderConfirmed());
        });
    }

    @Test   //Panel użytkownika/Adres – dodanie nowego adresu, aktualizacja i usunięcie
    @Order(21)
    public void addUserAddress() {

        step("Order confirmation page - przejście na stronę 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("'Your account' - przejście na stronę 'Addresses'", () -> {
            YourAccount account = new YourAccount();
            account.addresses();
        });

        step("Your addresses - kliknięcie w link 'Create new address'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.createNewAddressLink();
        });

        step("New address - uzupełnienie pola 'Address'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.createNewAddress();
        });

        step("New address - uzupełnienie pola 'Zip/Postal Code'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.createNewZipPostaCode();
        });

        step("New address - uzupełnienie pola 'City'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.createNewCity();
        });

        step("New address - kliknięcie w button 'Save'", () -> {
            NewAddress newAddress = new NewAddress();
            newAddress.saveButton();
        });

        step("Your addresses - komunikat potwierdzający dodanie adresu 'Address successfully added!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            assertTrue(yourAddress.isAddMsgDisplayed());
        });

        step("Your addresses - kliknięcie w link 'Update'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.updateAddress();
        });

        step("Update your address - zmiana danych w polu 'Zip/Postal Code'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.replaceNewZipPostaCode();
        });

        step("Update your address - kliknięcie w button 'Save'", () -> {
            UpdateYourAddress update = new UpdateYourAddress();
            update.saveButton();
        });

        step("Your addresses - komunikat potwierdzający aktualizację 'Address successfully updated!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            assertTrue(yourAddress.isUpdateMsgDisplayed());
        });

        step("Your addresses - usunięcie nowego adresu", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.deleteNewAddress();
        });

        step("Your addresses - komunikat potwierdzającego usunięcie 'Address successfully deleted!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            assertTrue(yourAddress.isDeleteMsgDisplayed());
        });
    }

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
            assertTrue(home.isAddedMsgDisplayed());
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
            List<WebElement> wishListsElements = myWishlist.getWishListElements();
            List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
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
            assertTrue(home.isAddedMsgDisplayed());
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

        step("Ulubione - sprawdzenie, że produkt jest na liście", () -> {
            MyWishlists myWishlists = new MyWishlists();
            List<WebElement> wishListsElements = myWishlists.getWishListElements();
            List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
            assertTrue(wishListsElementsNames.size() == 1 && wishListsElementsNames.getFirst().equals("Mug The adventure begins"));
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
            myWishlists.addNameOfNewList();
        });

        step("Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.createWishlistButton();
        });

        step("TOAST/'The list has been properly created' - potwierdzenie pojawienia się komunikatu", () -> {
            MyWishlists myWishlists = new MyWishlists();
            assertTrue(myWishlists.isCreatedMsgDisplayed());
        });

        step("potwierdzenie, czy istnieje lista o nazwie 'Super lista'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            assertTrue(myWishlists.isSuperListaDisplayed());
        });

        step("My wishlists - kliknięcie w trzy kropki", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.moreActionsButton();
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
            assertTrue(myWishlists.isRenamedListMsgDisplayed());
        });

        step("My wishlists - kliknięcie w trzy kropki", () -> {
            MyWishlists myWishlists = new MyWishlists();
            myWishlists.moreActionsButton();
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
            assertTrue(myWishlists.isCopiedLinkMsgDisplayed());
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
            assertTrue(myWishlists.isRemovedListMsgDisplayed());
        });
    }

    @Test   //Home page/Footer - sprawdzenie działania linków w stopce
    @Order(25)
    public void checkFooterLinksClickable() {

        step("Home page/Footer - kliknięcie w link 'Prices drop'", () -> {
            Footer footer = new Footer();
            footer.pricesDrop();
        });

        step("Potwierdzenie otwarcia podstrony 'Prices drop'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isPricesDropPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'New products'", () -> {
            Footer footer = new Footer();
            footer.newProducts();
        });

        step("Potwierdzenie otwarcia podstrony 'New products'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isNewProductsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Best sellers'", () -> {
            Footer footer = new Footer();
            footer.bestSellers();
        });

        step("Potwierdzenie otwarcia podstrony 'Best sellers'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isBestSellersPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Delivery'", () -> {
            Footer footer = new Footer();
            footer.delivery();
        });

        step("Potwierdzenie otwarcia podstrony 'Delivery'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isDeliveryPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Legal Notice'", () -> {
            Footer footer = new Footer();
            footer.legalNotice();
        });

        step("Potwierdzenie otwarcia podstrony 'Legal Notice'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isLegalNoticePageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Terms and conditions of use'", () -> {
            Footer footer = new Footer();
            footer.termsAndConditionsOfUse();
        });

        step("Potwierdzenie otwarcia podstrony 'Terms and conditions of use'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isTermsAndConditionsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'About us'", () -> {
            Footer footer = new Footer();
            footer.aboutUs();
        });

        step("Potwierdzenie otwarcia podstrony 'About us'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isAboutUsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Secure payment'", () -> {
            Footer footer = new Footer();
            footer.securePayment();
        });

        step("Potwierdzenie otwarcia podstrony 'Secure payment'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isSecurePaymentPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Contact us'", () -> {
            Footer footer = new Footer();
            footer.contactUs();
        });

        step("Potwierdzenie otwarcia podstrony 'Contact us'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isContactUsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Sitemap'", () -> {
            Footer footer = new Footer();
            footer.sitemap();
        });

        step("Potwierdzenie otwarcia podstrony 'Sitemap'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isSitemapPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Stores'", () -> {
            Footer footer = new Footer();
            footer.stores();
        });

        step("Potwierdzenie otwarcia podstrony 'Stores'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isStoresPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Personal info'", () -> {
            Footer footer = new Footer();
            footer.personalInfo();
        });

        step("Potwierdzenie otwarcia podstrony 'Personal info'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isPersonalInfoPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Orders'", () -> {
            Footer footer = new Footer();
            footer.orders();
        });

        step("Potwierdzenie otwarcia podstrony 'Orders'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isOrdersPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Credit slips'", () -> {
            Footer footer = new Footer();
            footer.creditSlips();
        });

        step("Potwierdzenie otwarcia podstrony 'Credit slips'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isCreditSlipsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Addresses'", () -> {
            Footer footer = new Footer();
            footer.addresses();
        });

        step("Potwierdzenie otwarcia podstrony 'Addresses'", () -> {
            Footer footer = new Footer();
            assertTrue(footer.isAddressesPageOpened());
        });

        step("Header - kliknięcie w button 'Sign out'", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            assertTrue(header.isButtonSignInDisplayed());
        });
    }

    @AfterAll
    public static void tearDownSuite() {
        DriverProvider.quitDriver();
    }
}



