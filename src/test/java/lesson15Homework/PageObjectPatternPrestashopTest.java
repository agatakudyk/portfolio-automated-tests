package lesson15Homework;

import lesson15Homework.driver.DriverProvider;
import lesson15Homework.pages.*;
import lesson15Homework.users.RegisteredUser;
import lesson15Homework.users.UnregisteredUserData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.qameta.allure.Allure.step;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PageObjectPatternPrestashopTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {

        driver = DriverProvider.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://localhost:8080/pl/");
    }


    @Test   //Home page - zmiana języka strony z polskiego na angielski
    @Order(1)
    public void languageSwitchIntoEnglish() {

        step("Home page - zmiana języka / kliknięcie w dropdown-button", () -> {
            Header header = new Header();
            header.languageDropdownButton();
        });

        step("Home page/dropdown - kliknięcie opcji 'English' na rozwijanej liście języków", () -> {
            Header header = new Header();
            header.englishLanguageSelectionFromDropdown();
        });

        step("Home page - potwierdzenie ustawienia języka angielskiego", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isEnglishLanguageDisplayed());
        });
    }


    @Test     //Użytkownik niezarejestrowany - dodanie produktu do wishlist, dodanie produktu do koszyka i usunięcie
    @Order(2)
    public void addToCartAndDeleteProductByUnregisteredUser() {

        step("Unregistered user - kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'", () -> {
            Home home = new Home();
            home.wishlistIconOfPosterTodayIsAGoodDay();
        });

        step("Potwierdzenie pojawienia się popupu z komunikatem walidacyjnym", () -> {
            Home home = new Home();
            Assertions.assertTrue(home.isMsgDisplayedThatLoginRequired());
        });

        step("Zamknięcie okna z komunikatem - kliknięcie w button 'Cancel'", () -> {
            Home home = new Home();
            home.closeWishlistPopupOfUnregisteredUser();
        });

        step("Wejście na stronę produktu 'Today is a good day Framed Poster'", () -> {
            Home home = new Home();
            home.enterProductPageOfTodayIsAGoodDayFramedPoster();
        });

        step("Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'", () -> {
            ProductTodayIsAGoodDayFramedPoster todayIsAGoodDay = new ProductTodayIsAGoodDayFramedPoster();
            todayIsAGoodDay.addToCartButton();
        });

        step("Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym pomyślne dodanie", () -> {
            ProductTodayIsAGoodDayFramedPoster todayIsAGoodDay = new ProductTodayIsAGoodDayFramedPoster();
            Assertions.assertTrue(todayIsAGoodDay.isSuccessPopupDisplayed());
        });


        step("Zamknięcie okna popup - kliknięcie w button 'Proceed to checkout'", () -> {
            ProductTodayIsAGoodDayFramedPoster page = new ProductTodayIsAGoodDayFramedPoster();
            page.closeAddToCartPopupLocator();
        });

        step("Shopping cart - sprawdzenie zgodności nazwy produktu w koszyku", () -> {
            Cart cart = new Cart();
            Assertions.assertTrue(cart.isProductInCart());
        });

        step("Shopping cart - usunięcie produktu z koszyka", () -> {
            Cart cart = new Cart();
            cart.deleteCartItem();
        });

        step("Shopping cart - potwierdzenie pojawienia się komunikatu, że koszyk jest pusty", () -> {
            Cart cart = new Cart();
            Assertions.assertTrue(cart.isMsgThatCartEmpty());
        });
    }


    @Test     //Użytkownik niezarejestrowany - dodanie produktu do koszyka i finalizacja zakupu
    @Order(3)
    public void addProductToCartAndCheckoutByUnregisteredUser() {

        step("Shopping cart - przejcie z koszyka na stronę główną", () -> {
            Cart cart = new Cart();
            cart.homePageLink();
        });

        step("Home page - wejście w okno produktu 'Today is a good day Framed Poster'", () -> {
            Home home = new Home();
            home.enterProductPageOfTodayIsAGoodDayFramedPoster();
        });

        step("Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'", () -> {
            ProductTodayIsAGoodDayFramedPoster page = new ProductTodayIsAGoodDayFramedPoster();
            page.addToCartButton();
        });

        step("Popup w oknie produktu - kliknięcie w button 'Proceed to checkout'", () -> {
            ProductTodayIsAGoodDayFramedPoster poster = new ProductTodayIsAGoodDayFramedPoster();
            poster.closeAddToCartPopupLocator();
        });

        step("Cart - kliknięcie w button 'Proceed to checkout'", () -> {
            Cart cart = new Cart();
            cart.proceedToCheckoutButton();
        });

        step("Personal Information - uzupełnienie pola 'First name'", () -> {
            UnregisteredUserData unregisteredUser = new UnregisteredUserData();
            unregisteredUser.firstName();
        });

        step("Personal Information - uzupełnienie pola 'Last name'", () -> {
            UnregisteredUserData unregisteredUser = new UnregisteredUserData();
            unregisteredUser.lastName();
        });

        step("Personal Information - uzupełnienie pola 'Email'", () -> {
            UnregisteredUserData unregisteredUser = new UnregisteredUserData();
            unregisteredUser.email();
        });

        step("Personal Information - checkbox zgody na przetwarzanie danych osobowych", () -> {
            PersonalInformation personal = new PersonalInformation();
            personal.customerPrivacyCheckbox();
        });

        step("Personal Information - checkbox akceptacji regulaminu i polityki prywatności", () -> {
            PersonalInformation personal = new PersonalInformation();
            personal.termsAndConditionsCheckbox();
        });

        step("Personal Information - przejście do 'Addresses' poprzez kliknięcie w button 'Continue'", () -> {
            PersonalInformation personal = new PersonalInformation();
            personal.continueButton();
        });

        step("Addresses - uzupełnienie pola 'Address'", () -> {
            UnregisteredUserData unregisteredUser = new UnregisteredUserData();
            unregisteredUser.address();
        });

        step("Addresses - uzupełnienie pola 'Zip/Postal Code'", () -> {
            UnregisteredUserData unregisteredUser = new UnregisteredUserData();
            unregisteredUser.postalCode();
        });

        step("Addresses - uzupełnienie pola 'City'", () -> {
            UnregisteredUserData unregisteredUser = new UnregisteredUserData();
            unregisteredUser.city();
        });

        step("Addresses - przejście do 'Shipping Method' poprzez kliknięcie w button 'Continue'", () -> {
            Addresses addresses = new Addresses();
            addresses.continueButton();
        });

        step("Shipping Method - przejście do 'Payment' poprzez kliknięcie w button 'Continue'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.continueButton();
        });

        step("Payment - wybór opcji 'Pay by bank wire'", () -> {
            Payment payment = new Payment();
            payment.payByBankWire();
        });

        step("Payment -  wybór checkboxa zgody", () -> {
            Payment payment = new Payment();
            payment.agreeToTermsCheckbox();
        });

        step("Payment - przejście na 'Order confirmation page' poprzez kliknięcie w button 'Place Order'", () -> {
            Payment payment = new Payment();
            payment.placeOrderButton();
        });

        step("Order confirmation - wyświetlenie komunikatu potwierdzającego 'Your order is confirmed'", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            Assertions.assertTrue(confirmation.isMsgThatOrderConfirmed());
        });
    }


    @Test     //Order confirmation - uzupełnienie formularza ‘Save time on your next order, sign up now’
    @Order(4)
    public void signUpNowFillInFormByUnregisteredUser() {

        step("‘Save time on...' form - kliknięcie w button 'Save'", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.saveButtonInForm();
        });

        step("Tooltip dynamiczny- potwierdzenie pojawienia się dymka z komunikatem walidacyjnym", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            Assertions.assertEquals("Wypełnij to pole.", confirmation.getValidationMsg());
        });

        step("‘Save time on...' form - uzupełnienie pola 'First name'", () -> {
            UnregisteredUserData unregistered = new UnregisteredUserData();
            unregistered.firstName();
        });

        step("‘Save time on...' form - uzupełnienie pola 'Last name'", () -> {
            UnregisteredUserData unregistered = new UnregisteredUserData();
            unregistered.lastName();
        });

        step("‘Save time on...' form - uzupełnienie pola 'Email'", () -> {
            UnregisteredUserData unregistered = new UnregisteredUserData();
            unregistered.email();
        });

        step("‘Save time on...' form - uzupełnienie pola 'Password'", () -> {
            UnregisteredUserData unregistered = new UnregisteredUserData();
            unregistered.password();
        });

        step("‘Save time on...' form - kliknięcie w checkbox zgody na przetwarzanie danych osobowych", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.customerPrivacyCheckbox();
        });

        step("‘Save time on...' form - kliknięcie w checkbox akceptacji regulaminu i polityki prywatności", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.termsAndConditionsCheckbox();
        });

        step("Zapisanie danych poprzez kliknięcie w button 'Save'", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.saveButtonInForm();
        });
    }


    @Test  //Niepoprawna rejestracja przy pomocy pustego formularza
    @Order(5)
    public void failSignupWithEmptyFields() {

        step("Login page - kliknięcie w link rejestracji", () -> {
            LogIn login = new LogIn();
            login.signupLink();
        });

        step("Create account page - kliknięcie w button 'Save'", () -> {
            CreateAccount create = new CreateAccount();
            create.saveButton();
        });

        step("Create account page/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu", () -> {
            CreateAccount create = new CreateAccount();
            Assertions.assertEquals("Wypełnij to pole.", create.getValidationMsg());
        });
    }


    @Test  //Poprawna rejestracja użytkownika
    @Order(6)
    public void userSuccessSignup() {

        step("Create account - uzupełnienie pola 'First name'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.name();
        });

        step("Create account - uzupełnienie pola 'Last name'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.lastName();
        });

        step("Create account - uzupełnienie pola 'Email'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.email();
        });

        step("Create Account - uzupełnienie pola 'Password'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Create Account - kliknięcie w checkbox informacji o przetwarzaniu danych osobowych", () -> {
            CreateAccount create = new CreateAccount();
            create.customerPrivacyCheckbox();
        });

        step("Create Account - kliknięcie w checkbox akceptacji polityki prywatności", () -> {
            CreateAccount create = new CreateAccount();
            create.termsAndConditionsCheckbox();
        });

        step("Create Account - kliknięcie w button 'Save'", () -> {
            CreateAccount create = new CreateAccount();
            create.saveButton();
        });

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignOutDisplayed());
        });

        step("Header - kliknięcie w button 'Sign out' / wylogowanie użytkownika ", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Sprawdzenie czy wylogowany - widoczność przycisku 'Sign in'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignInDisplayed());
        });
    }


    //Niepoprawne logowanie z użyciem pustych pól i błędnych danych
    @Test
    @Order(7)
    public void failLoginWithIncorrectData() {

        step("Header - kliknięcie w button 'Sign In'", () -> {
            Header header = new Header();
            header.signIn();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu", () -> {
            LogIn login = new LogIn();
            Assertions.assertEquals("Wypełnij to pole.", login.getValidationMsg());
        });

        step("Login page - uzupełnienie pola 'Email'", () -> {
            LogIn login = new LogIn();
            login.emailField();
        });

        step("Login page - uzupełnienie pola 'Password'", () -> {
            LogIn login = new LogIn();
            login.passwordField();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Login page - sprawdzenie komunikatu 'Authentication failed.'", () -> {
            LogIn login = new LogIn();
            Assertions.assertTrue(login.isMsgAuthenticationFailedDisplayed());
        });
    }


    @Test  //Login page - zresetowanie zapomnianego hasła
    @Order(8)
    public void loginPasswordReset() {

        step("Login page - kliknięcie w link 'Forgot your password?'", () -> {
            LogIn login = new LogIn();
            login.passwordRecoveryLink();
        });

        step("Reset password page - uzupełnienie pola 'Email address'", () -> {
            PasswordReset reset = new PasswordReset();
            reset.email();
        });

        step("Reset password page - kliknięcie w button 'Send reset link'", () -> {
            PasswordReset reset = new PasswordReset();
            reset.sendResetLink();
        });

        step("Reset password page - sprawdzenie komunikatu potwierdzającego wysłanie maila", () -> {
            PasswordReset reset = new PasswordReset();
            Assertions.assertTrue(reset.isMsgOfSentMsgDisplayed());
        });
    }


    @Test     //Poprawne zalogowanie  + zmiana hasła + zalogowanie nowym hasłem
    @Order(9)
    public void userSuccessLogin() {

        step("Reset password page - kliknięcie w link 'Back to Login'", () -> {
            PasswordReset reset = new PasswordReset();
            reset.backToLoginPageLink();
        });

        step("Login page - uzupełnienie pola 'Email'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.email();
        });

        step("Login page - uzupełnienie pola 'Password'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Sprawdzenie pomyślnego zalogowania - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignOutDisplayed());
        });

        step("Your account - kliknięcie w link 'Information'", () -> {
            YourAccount account = new YourAccount();
            account.informationLink();
        });

        step("Your personal information - uzupełnienie pola 'Password' / dotychczasowe hasło", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Your personal information - uzupełnienie pola 'New password' / nowe hasło", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newPassword();
        });

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.termsAndConditionsCheckbox();
        });

        step("Your personal information - checkbox zgody na przetwarzanie danych osobowych", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.customerPrivacyCheckbox();
        });

        step("Your personal information - kliknięcie w button 'Save'", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.saveButton();
        });

        step("Your personal information - potwierdzenie pojawienia się komunikatu", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            Assertions.assertTrue(personal.isMsgThatInformationUpdated());
        });

        step("Header/wyloguj się - kliknięcie w button 'Sign out'", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Login page - uzupełnienie pola email", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.email();
        });

        step("Login page - uzupełnienie nowego hasła", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newPassword();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Sprawdzenie poprawności zalogowania użytkownika - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignOutDisplayed());
        });

        step("Metoda prywatna - przywrócenie starego hasła", this::backToPreviousPassword);
    }


    private void backToPreviousPassword() {

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("Wejście w link 'Information'", () -> {
            YourAccount account = new YourAccount();
            account.informationLink();
        });

        step("wpisanie aktualnego hasła logowania", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newPassword();
        });

        step("wpisanie nowego hasła logowania", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.termsAndConditionsCheckbox();
        });

        step("our personal information - checkbox zgody na przetwarzanie danych osobowych", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.customerPrivacyCheckbox();
        });

        step("kliknięcie buttona 'Save'", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.saveButton();
        });
    }


    @Test       //Podstrona Accessories - filtrowanie
    @Order(10)
    public void clearAccessoriesProductsFiltering() {

        step("wejście na stronę ACCESSORIES", () -> {
            TopMenu top = new TopMenu();
            top.accessoriesPageLink();
        });

        step("Accessories page - wybór filtra 'Ceramic'", () -> {
            Accessories accessories = new Accessories();
            accessories.ceramicCompositionFilter();

            //TODO
//            By ceramicCompositionFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Ceramic\")]/../span/input");
//            wait.until(ExpectedConditions.elementToBeSelected(ceramicCompositionFilterCheckboxLocator));
        });

        step("Accessories page - wybór filtra 'Available'", () -> {
            Accessories accessories = new Accessories();
            accessories.availableFilter();

            //todo By availableFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Available\")]/../span/input");
            //todo wait.until(ExpectedConditions.elementToBeSelected(availableFilterCheckboxLocator));});
        });

        step("Accessories page - wyczyszczenie wybranych filtrów", () -> {
            Accessories accessories = new Accessories();
            accessories.allFiltersClear();
        });

        step("Accessories page - potwierdzenie wyczyszczenia filtrów", () -> {
            Accessories accessories = new Accessories();
            Assertions.assertFalse(accessories.isFilterClear());
        });
    }


    @Test    //Podstrona ART - sortowanie
    @Order(11)
    public void sortArtProducts() throws InterruptedException {

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
        // todo Thread.sleep(1000);});

//        step("strona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", ()->{
//            By productsListLocator = By.xpath("//div[@class=\"product-description\"]/h2/a");
//            List<WebElement> productsLists = driver.findElements(productsListLocator);
//
//            List<String>productsNames = new ArrayList<>();
//            for(WebElement product : productsLists){
//                productsNames.add(product.getText());
//            }
//            List<String>productsAlphabeticalOrder = productsNames.stream().sorted().toList();
//
//            for(int i=0; i < productsNames.size(); i++){
//                Assertions.assertEquals(productsNames.get(i), productsAlphabeticalOrder.get(i));
//            }
//        });

        step("strona ART - kliknięcie w pole sortowania", () -> {
            Art art = new Art();
            art.sortByButton();
        });

        step("strona ART - posortowanie według ‘Price, low to high’", () -> {
            Art art = new Art();
            art.sortByPriceAsc();
        });

//        step("Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", ()->{
//            By productsListLocator2 = By.xpath("//div[@class=\"product-price-and-shipping\"]/span");
//            List<WebElement> productsLists2 = driver.findElements(productsListLocator2);
//
//            List<String>productsPrices = new ArrayList<>();
//            for(WebElement product : productsLists2){
//                productsPrices.add(product.getText());
//            }
//            List<String>productsAlphabeticalOrder2 = productsPrices.stream().sorted().toList();
//
//            for(int i=0; i < productsPrices.size(); i++){
//                Assertions.assertEquals(productsPrices.get(i), productsAlphabeticalOrder2.get(i));
//            }
//        });
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
            Assertions.assertTrue(best.isCommentAdded());
        });

        step("Popup REVIEW SENT - zamknięcie okna poprzez kliknięcie w button 'OK'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.okReviewButton();
        });
    }


    @Test    //Strona produktu - zwiększenie ilości produktu i dodanie do koszyka
    @Order(13)
    public void addProductsToCart() {

//        step("Strona produktu - zmiana ilości produktu poprzez wpisanie liczby (wyczyść i wpisz wartość)", ()->{
//            //zmiana ilości produktu poprzez wpisanie liczby
//            public void putProductQuantity() {
//                By putProductQuantityLocator = By.id("quantity_wanted");
//                getDriver().findElement(putProductQuantityLocator);
//                putProductQuantity.sendKeys(Keys.CONTROL + "a");
//                putProductQuantity.sendKeys(Keys.DELETE);
//                putProductQuantity.sendKeys("4");
//            }
//            });

//        step("Strona produktu - zmiana ilości produktu poprzez kliknięcie w strzałki", ()->{
//            By selectQuantityLocator = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
//            WebElement selectQuantityClick = driver.findElement(selectQuantityLocator);
//            selectQuantityClick.click();
//            selectQuantityClick.click();
//            selectQuantityClick.click();});

        step("Strona produktu - kliknięcie button 'Add to cart'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.addToCartButton();
        });

//        step("Popup - sprawdzenie komunikatu potwierdzającego dodanie do koszyka", ()->{
//            By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to " +
//                    "your shopping cart\")]");
//            wait.until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
//            WebElement addProductPopup = driver.findElement(addProductPopupLocator);
//            Assertions.assertTrue(addProductPopup.isDisplayed());});
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
            Assertions.assertEquals("The best is yet to come' Framed poster", cart.getProductNameInCart());
        });

        step("Shopping cart - porównanie ilości z sekcji produktu i sekcji podsumowania", () -> {
            // ilość w sekcji produktu
            By numberInItemsSectionLocator = By.xpath("//input[@class='js-cart-line-product-quantity form-control']");
            WebElement numberInItemSection = driver.findElement(numberInItemsSectionLocator);
            int productQuantity = Integer.parseInt(numberInItemSection.getDomAttribute("value"));
            // ilość w sekcji podsumowania
            By numberInPurchaseSummarySectionLocator = By.xpath("//span[@class='label js-subtotal']");
            WebElement numberInPurchaseSummarySection = driver.findElement(numberInPurchaseSummarySectionLocator);
            String summaryQuantityText = numberInPurchaseSummarySection.getText();
            int summaryQuantity = Integer.parseInt(summaryQuantityText.replaceAll("\\D+", ""));
            // porównanie ilości z sekcji produktu i sekcji podsumowania
            Assertions.assertEquals(productQuantity, summaryQuantity);
        });

        step("Shopping cart - sprawdzenie wartości całkowitej", () -> {
            //cena jednostkowa
            By unitPriceOfItemLocator = By.xpath("//div[@class=\"product-line-info product-price h5 \"]" + "/div[@class=\"current-price\"]");
            WebElement unitPriceOfItem = driver.findElement(unitPriceOfItemLocator);
            String unitPriceText = unitPriceOfItem.getText().replace("zł", "").replace(",", ".").trim();
            double unitPrice = Double.parseDouble(unitPriceText);
            // ilość w sekcji produktu
            By numberInItemsSectionLocator = By.xpath("//input[@class='js-cart-line-product-quantity form-control']");
            WebElement numberInItemSection = driver.findElement(numberInItemsSectionLocator);
            int productQuantity = Integer.parseInt(numberInItemSection.getDomAttribute("value"));
            //wartość całkowita z podsumowania
            By totalPriceLocator = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
            WebElement totalPriceElement = driver.findElement(totalPriceLocator);
            String totalPriceText = totalPriceElement.getText().replace("zł", "").replace(",", ".").trim();
            double totalPrice = Double.parseDouble(totalPriceText);
            //oczekiwana wartość
            double expectedTotal = unitPrice * productQuantity;
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
            Assertions.assertEquals("Wypełnij to pole.", address.getValidationMsg());
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
            Assertions.assertTrue(confirmation.isMsgThatOrderConfirmed());
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
            Assertions.assertTrue(contact.isValidationMsgDisplayed());
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
            Assertions.assertTrue(contact.isInformationMsgDisplayed());
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
            Assertions.assertTrue(details.isValidationMsgDisplayed());
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
            Assertions.assertTrue(details.isInformationMsgDisplayed());
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
            Assertions.assertTrue(confirmation.isMsgThatOrderConfirmed());
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
            Assertions.assertTrue(yourAddress.isAddMsgDisplayed());
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
            Assertions.assertTrue(yourAddress.isUpdateMsgDisplayed());
        });

        step("Your addresses - usunięcie nowego adresu", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.deleteNewAddress();
        });

        step("Your addresses - komunikat potwierdzającego usunięcie 'Address successfully deleted!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            Assertions.assertTrue(yourAddress.isDeleteMsgDisplayed());
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

//        step("'My wishlist' - sprawdzenie, że produkt jest na liście", ()->{
//            By wishListElementsLocator = By.xpath(
//                "//p[@class=\"wishlist-product-title\"]");
//            wait.until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
//            List<WebElement> wishListsElements = driver.findElements(wishListElementsLocator);
//            List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
//            Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Hummingbird printed t-shirt"));
//        });
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

//        step("Ulubione - sprawdzenie, że produkt jest na liście", ()->{
//            By wishListElementsLocator = By.xpath("//p[@class=\"wishlist-product-title\"]");
//            wait.until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
//            List<WebElement> wishListsElements = driver.findElements(wishListElementsLocator);
//            List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
//            Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Mug The adventure begins"));
//        });
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
            Assertions.assertTrue(myWishlists.isCreatedMsgDisplayed());
        });

        step("potwierdzenie, czy istnieje lista o nazwie 'Super lista'", () -> {
            MyWishlists myWishlists = new MyWishlists();
            Assertions.assertTrue(myWishlists.isSuperListaDisplayed());
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
            Assertions.assertTrue(myWishlists.isRenamedListMsgDisplayed());
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


    @Test   //Home page/Footer - sprawdzenie działania linków w stopce
    @Order(25)
    public void checkFooterLinksClickable() {

        step("Home page/Footer - kliknięcie w link 'Prices drop'", () -> {
            Footer footer = new Footer();
            footer.pricesDrop();
        });

        step("Potwierdzenie otwarcia podstrony 'Prices drop'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isPricesDropPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'New products'", () -> {
            Footer footer = new Footer();
            footer.newProducts();
        });

        step("Potwierdzenie otwarcia podstrony 'New products'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isNewProductsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Best sellers'", () -> {
            Footer footer = new Footer();
            footer.bestSellers();
        });

        step("Potwierdzenie otwarcia podstrony 'Best sellers'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isBestSellersPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Delivery'", () -> {
            Footer footer = new Footer();
            footer.delivery();
        });

        step("Potwierdzenie otwarcia podstrony 'Delivery'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isDeliveryPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Legal Notice'", () -> {
            Footer footer = new Footer();
            footer.legalNotice();
        });

        step("Potwierdzenie otwarcia podstrony 'Legal Notice'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isLegalNoticePageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Terms and conditions of use'", () -> {
            Footer footer = new Footer();
            footer.termsAndConditionsOfUse();
        });

        step("Potwierdzenie otwarcia podstrony 'Terms and conditions of use'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isTermsAndConditionsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'About us'", () -> {
            Footer footer = new Footer();
            footer.aboutUs();
        });

        step("Potwierdzenie otwarcia podstrony 'About us'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isAboutUsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Secure payment'", () -> {
            Footer footer = new Footer();
            footer.securePayment();
        });

        step("Potwierdzenie otwarcia podstrony 'Secure payment'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isSecurePaymentPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Contact us'", () -> {
            Footer footer = new Footer();
            footer.contactUs();
        });

        step("Potwierdzenie otwarcia podstrony 'Contact us'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isContactUsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Sitemap'", () -> {
            Footer footer = new Footer();
            footer.sitemap();
        });

        step("Potwierdzenie otwarcia podstrony 'Sitemap'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isSitemapPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Stores'", () -> {
            Footer footer = new Footer();
            footer.stores();
        });

        step("Potwierdzenie otwarcia podstrony 'Stores'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isStoresPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Personal info'", () -> {
            Footer footer = new Footer();
            footer.personalInfo();
        });

        step("Potwierdzenie otwarcia podstrony 'Personal info'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isPersonalInfoPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Orders'", () -> {
            Footer footer = new Footer();
            footer.orders();
        });

        step("Potwierdzenie otwarcia podstrony 'Orders'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isOrdersPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Credit slips'", () -> {
            Footer footer = new Footer();
            footer.creditSlips();
        });

        step("Potwierdzenie otwarcia podstrony 'Credit slips'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isCreditSlipsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Addresses'", () -> {
            Footer footer = new Footer();
            footer.addresses();
        });

        step("Potwierdzenie otwarcia podstrony 'Addresses'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isAddressesPageOpened());
        });

        step("Header - kliknięcie w button 'Sign out'", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignInDisplayed());
        });
    }


    @AfterAll
    public static void tearDownSuite() {
        DriverProvider.quitDriver();
    }
}



