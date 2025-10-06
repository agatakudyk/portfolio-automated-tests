package lesson12Homework;

import com.codeborne.selenide.As;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumPrestashopTest {

    String emailCreateName ="testowianka254@wp.pl";
    static ChromeDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://localhost:8080/pl/");
    }

    @Test   //zmiana języka z polskiego na angielski
    @Order(1)
    public void languageSwitchIntoEnglish() {

        By languageDropdownLocator = By.xpath("//button[@data-toggle=\"dropdown\"]");
        WebElement languageSwitchClick = driver.findElement(languageDropdownLocator);
        languageSwitchClick.click();

        //wybór języka English
        By englishLanguageSwitchLocator = By.xpath("//a[@data-iso-code=\"en\"]");
        WebElement englishLanguageSwitch = driver.findElement(englishLanguageSwitchLocator);
        englishLanguageSwitch.click();

        //potwierdzenie ustawienia języka angielskiego
        By englishLanguageCheckLocator = By.xpath("//button[@data-toggle=\"dropdown\"]" + "/span[contains(text(),\"English\")]");
        WebElement englishLanguageCheck = driver.findElement(englishLanguageCheckLocator);
        Assertions.assertTrue(englishLanguageCheck.isDisplayed());
    }

    @Test     //Użytkownik niezarejestrowany - dodanie i usunięcie produktu z koszyka
    @Order(2)
    public void addToCartAndDeleteProductByUnregisteredUser() {

        //UnregisteredUser - próba dodania produktu do whishlist - produkt 'Today is a good day Framed Poster'
        By heartButtonOfTodayIsAGoodDayFramedPosterLocator = By.xpath("//a[contains(text(),\"Today is a good day Framed\")]/../../../button[@class=\"wishlist-button-add\"]");
        WebElement heartButtonOfTodayIsAGoodDayFramedPoster = driver.findElement(heartButtonOfTodayIsAGoodDayFramedPosterLocator);
        heartButtonOfTodayIsAGoodDayFramedPoster.click();

        //potwierdzenie pojawienia się komunikatu
        By loginRequiredMsgLocator = By.xpath("//p[contains(text(),\"You need to be logged in to save products in your wishlist.\")]");
        WebElement loginRequiredMsg = driver.findElement(loginRequiredMsgLocator);
        Assertions.assertTrue(loginRequiredMsg.isDisplayed());

        //Zamknięcie okna - kliknięcie buttona 'Cancel'
        By cancelPopupButtonLocator = By.xpath("//a[contains(text(),\"Sign in\")]/../button[contains(text(),\"Cancel\")]");
        WebElement cancelPopupButton = driver.findElement(cancelPopupButtonLocator);
        cancelPopupButton.click();

        //wejście w produkt 'Today is a good day Framed Poster'
        By openTodayIsAGoodDayFramedPosterLocator = By.xpath("//a[@class=\"thumbnail product-thumbnail\"]/img[@alt=\"Today is a good day Framed poster\"]");
        WebElement openTodayIsAGoodDayFramedPoster = driver.findElement(openTodayIsAGoodDayFramedPosterLocator);
        openTodayIsAGoodDayFramedPoster.click();

        //Kliknij button 'Add to cart'
        By addToCartButtonLocator = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();

        //potwierdzenie dodania do koszyka
        By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to your shopping cart\")]");
        wait.until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
        WebElement addProductPopup = driver.findElement(addProductPopupLocator);
        Assertions.assertTrue(addProductPopup.isDisplayed());

        //zamknięcie popup dodania produktu i przejście do koszyka
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
        WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
        closeAddToCartPopupClick.click();

        //sprawdzenie nazwy produktów
        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]/a[contains(text(),\"Today is a good day Framed poster\")]");
        String productNameInCart = driver.findElement(productNameInCartLocator).getText();
        Assertions.assertEquals("Today is a good day Framed poster", productNameInCart);

        //Usunięcie produktu z koszyka
        By trashIconLocator = By.xpath("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]");
        WebElement trashIcon = driver.findElement(trashIconLocator);
        trashIcon.click();

        //potwierdzenie usunięcia
        By emptyCartMsgLocator = By.xpath("//span[contains(text(),\"There are no more items in your cart\")]");
        wait.until(ExpectedConditions.elementToBeClickable(emptyCartMsgLocator));//TODO zaaczekac az strona sie przeladuje
        WebElement emptyCartMsg = driver.findElement(emptyCartMsgLocator);
        Assertions.assertTrue(emptyCartMsg.isDisplayed());
    }

    @Test     //Użytkownik niezarejestrowany - dodanie do koszyka i finalizacja zakupu
    @Order(3)
    public void addProductToCartAndCheckoutByUnregisteredUser() {

        //Przejcie na stronę główną
        By homepageLinkLocator = By.id("_desktop_logo");
        WebElement homepageLink = driver.findElement(homepageLinkLocator);
        homepageLink.click();

        //wejście w produkt 'Today is a good day Framed Poster'
        By openTodayIsaGoodDayFramedPosterLocator = By.xpath("//img[@alt=\"Today is a good day Framed poster\"]");
        WebElement openTodayIsaGoodDayFramedPoster = driver.findElement(openTodayIsaGoodDayFramedPosterLocator);
        openTodayIsaGoodDayFramedPoster.click();

        //Kliknij button 'Add to cart'
        By addToCartButtonLocator = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();

        //Kliknięcie w button 'Proceed To Checkout' i przejście do koszyka
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]//i[@class=\"material-icons rtl-no-flip\"]");
        wait.until(ExpectedConditions.elementToBeClickable(closeAddToCartPopupLocator));
        WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
        closeAddToCartPopupClick.click();

        //Cart - kliknięcie w button 'Proceed To Checkout'
        By proceedToCheckoutButtonLocator = By.xpath("//a[contains(text(),\"Proceed to checkout\")]");
        WebElement proceedToCheckoutButton = driver.findElement(proceedToCheckoutButtonLocator);
        proceedToCheckoutButton.click();

        //Personal Information - uzupełnienie pola 'First name'
        By firstNameFieldLocator = By.id("field-firstname");
        WebElement firstNameField = driver.findElement(firstNameFieldLocator);
        firstNameField.sendKeys("Tomasz");

        //Personal Information - uzupełnienie pola 'Last name'
        By lastNameFieldLocator = By.id("field-lastname");
        WebElement lastNameField = driver.findElement(lastNameFieldLocator);
        lastNameField.sendKeys("Kot");

        //Personal Information - uzupełnienie pola
        By emailFieldLocator = By.id("field-email");
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("kot123@wp.pl");

        //Personal Information - checkbox informacji o przetwarzaniu danych osobowych
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
        policyInfoCheckbox.click();

        //Personal Information - checkbox akceptacji polityki prywatności
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
        privacyPolicyCheckbox.click();

        //Personal Information - kliknięcie w button 'Continue'
        By continueButtonLocator = By.xpath("//section[@id=\"checkout-personal-information-step\"]//button[@type=\"submit\"]");
        WebElement continueButton = driver.findElement(continueButtonLocator);
        continueButton.click();

       //Addresses - wpisanie adresu użytkownika
        By addressFieldLocator = By.id("field-address1");
        WebElement addressField = driver.findElement(addressFieldLocator);
        addressField.sendKeys("ul. Jaskrawa 23");

        //Addresses - wpisanie Zip/Postal Code
        By postalCodeFieldLocator = By.id("field-postcode");
        WebElement postalCodeField = driver.findElement(postalCodeFieldLocator);
        postalCodeField.sendKeys("11-788");

        //Addresses - uzupełnienie pola 'City'
        By cityFieldLocator = By.id("field-city");
        WebElement cityField = driver.findElement(cityFieldLocator);
        cityField.sendKeys("Koszalin");

        //Addresses - kliknięcie w button 'Continue'
        By adreessContinuseLocator = By.xpath("//section[@id=\"checkout-addresses-step\"]//button[@type=\"submit\"]");
        WebElement adreessContinuse = driver.findElement(adreessContinuseLocator);
        adreessContinuse.click();

        //Shipping Method - kliknięcie w button 'Continue'
        By continueButtonShippingMethodLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
        WebElement continueButtonShippingMethod = driver.findElement(continueButtonShippingMethodLocator);
        continueButtonShippingMethod.click();

        //Wybór opcji 'Pay by bank wire'
        By payByBankWireRadioButtonLocator = By.id("payment-option-2");
        WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
        payByBankWireRadioButton.click();

        //Wybór checkboxa zgody
        By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
        WebElement agreeToTermsCheckbox = driver.findElement(agreeToTermsCheckboxLocator);
        agreeToTermsCheckbox.click();

        //kliknięcie w button 'Place Order'
        By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
        WebElement placeOrderButtonInPaymentSection = driver.findElement(placeOrderButtonInPaymentSectionLocator);
        placeOrderButtonInPaymentSection.click();

        //potwierdzenie pojawienia się komunikatu
        By confirmationMsgLocator = By.xpath("//h3[@class=\"h1 card-title\"]/i");
        WebElement confirmationMsg = driver.findElement(confirmationMsgLocator);
        Assertions.assertTrue(confirmationMsg.isDisplayed());
    }

    @Test     //Uzupełnienie formularza ‘Save time on your next order, sign up now’
    @Order(4)
    public void signUpNowFillInFormByUnregisteredUser() {

        //Uzupełnij pole 'First name'
        By firstNameFieldLocator = By.id("field-firstname");
        WebElement firstNmaeField = driver.findElement(firstNameFieldLocator);
        firstNmaeField.sendKeys("Tomasz");

        //Uzupełnij pole 'Last name'
        By lastNameFieldLocator = By.id("field-lastname");
        WebElement lastNameField = driver.findElement(lastNameFieldLocator);
        lastNameField.sendKeys("Kot");

        //Uzupełnij pole 'Email'
        By emailFieldLocator = By.id("field-email");
        WebElement mailField = driver.findElement(emailFieldLocator);
        mailField.sendKeys("kot123@wp.pl");

        //Uzupełnij pole 'Password'
        By passwordFieldLocator = By.id("field-password");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("Mojehaslo123");

//checkbox informacji o przetwarzaniu danych osobowych
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
        policyInfoCheckbox.click();

        //checkbox akceptacji polityki prywatności
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
        privacyPolicyCheckbox.click();

        //Kliknij w button 'Save'
        By saveButtonLocator = By.xpath("//button[contains(text(),\"Save\")]");
        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
    }

    @Test  //Niepoprawna rejestracja przy pomocy pustego formularza
    @Order(5)
    public void failSignupWithEmptyFields() {

        //kliknięcie w przycisk logowania
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();

        //kliknięcie w link rejestracji
        By signupLocator = By.cssSelector("a[data-link-action=\"display-register-form\"]");
        WebElement signupLink = driver.findElement(signupLocator);
        signupLink.click();

        // kliknięcie buttona Save, zatwierdzenie nieuzupełnionego formularza
        By saveLocator = By.cssSelector(".form-control-submit");
        WebElement saveButton = driver.findElement(saveLocator);
        saveButton.click();

        //potwierdzenie pojawienia się dymka z komunikatem walidacyjnym - tooltip dynamiczny
        By nameInputLocator = By.id("field-firstname");
        WebElement nameInput = driver.findElement(nameInputLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String msg = (String) js.executeScript("return arguments[0].validationMessage", nameInput);
        Assertions.assertEquals("Wypełnij to pole.", msg);
    }

    @Test  //Poprawna rejestracja użytkownika
    @Order(6)
    public void userSuccessSignup() {

        //uzupełnienie pola imię
        By nameLocator = By.id("field-firstname");
        WebElement nameInputField = driver.findElement(nameLocator);
        nameInputField.sendKeys("Anna");

        //uzupełnienie pola nazwisko
        By surnameLocator = By.id("field-lastname");
        WebElement surnameInputField = driver.findElement(surnameLocator);
        surnameInputField.sendKeys("Testowianka");

        //uzupełnienie pola e-mail
        By mailLocator = By.id("field-email");
        WebElement mailInputField = driver.findElement(mailLocator);
        mailInputField.sendKeys(emailCreateName);

        //uzupełnienie pola hasło
        By passwordLocator = By.id("field-password");
        WebElement passwordInputField = driver.findElement(passwordLocator);
        passwordInputField.sendKeys("Password123");

        //checkbox informacji o przetwarzaniu danych osobowych
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
        policyInfoCheckbox.click();

        //checkbox akceptacji polityki prywatności
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
        privacyPolicyCheckbox.click();

        // kliknięcie buttona Save, zatwierdzenie formularza
        By saveLocator = By.cssSelector(".form-control-submit");
        WebElement saveButton = driver.findElement(saveLocator);
        saveButton.click();

        //sprawdzenie poprawnej rejestracji użytkownika
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        Assertions.assertTrue(logoutButton.isDisplayed());

        //Wylogowanie użytkownika z potwierdzeniem poprawności wylogowania
        userSuccessLogout();
    }

    private void userSuccessLogout() {

        //kliknięcie buttona wyloguj
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        logoutButton.click();

        //sprawdzenie poprawności wylogowania
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        Assertions.assertTrue(signInButton.isDisplayed());
    }

    @Test
    @Order(7)    //Logowanie z użyciem błędnych danych
    public void failLoginWithIncorrectData() {

        //kliknięcie w przycisk 'Sign In' (header)
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();

        //Strona logowania - kliknięcie w button 'Sign In' - próba zalogowania przy użyciu pustych pól
        By loginButtonLocator = By.id("submit-login");
        WebElement loginButtonClick = driver.findElement(loginButtonLocator);
        loginButtonClick.click();

        //potwierdzenie pojawienia się tooltipa z komunikatem walidacyjnym (tooltip dynamiczny)
        By emailInputLocator = By.id("field-email");
        WebElement emailInput = driver.findElement(emailInputLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String msg = (String) js.executeScript("return arguments[0].validationMessage", emailInput);
        Assertions.assertEquals("Wypełnij to pole.", msg);

        //uzupełnienie pola email
        emailInput.sendKeys("blablabla@wp.pl");

        //uzupełnienie hasła
        By passwordLoginLocator = By.id("field-password");
        WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
        passwordLoginInputField.sendKeys("blepassword");

        //kliknięcie w button 'Sign In'
        loginButtonClick.click();

        //sprawdzenie komunikatu o błędnym logowaniu
        By failMsgLocator = By.xpath("//li[@class=\"alert alert-danger\"]");
        WebElement failMessage = driver.findElement(failMsgLocator);
        Assertions.assertTrue(failMessage.isDisplayed());
    }

    @Test  //Logowanie/zresetowanie zapomnianego hasła + walidacja
    @Order(8)
    public void loginPasswordRecovery() {

        //kliknięcie w link resetu hasła
        By passwordRecoveryLocator = By.xpath(" //div[@class=\"forgot-password\"]/a");
        WebElement passwordRecoveryLink = driver.findElement(passwordRecoveryLocator);
        passwordRecoveryLink.click();

        //wpisanie maila do resetu hasła
        By recoveryMailLocator = By.xpath("//input[@class=\"form-control\"]");
        WebElement recoveryEmailInputField = driver.findElement(recoveryMailLocator);
        recoveryEmailInputField.sendKeys("test.mail@wp.pl");

        //kliknięcie w button 'Send Reset Link'
        By passwordRecoveryButtonLocator = By.id("send-reset-link");
        WebElement passwordRecoveryButtonClick = driver.findElement(passwordRecoveryButtonLocator);
        passwordRecoveryButtonClick.click();

        //Potwierdzenie wysłania maila
        By sentMsgLocator = By.xpath("//li[@class=\"item\"]/p");
        WebElement sentMessage = driver.findElement(sentMsgLocator);
        Assertions.assertTrue(sentMessage.isDisplayed());
    }

    @Test     //Poprawne zalogowanie  + zmiana hasła + wylogowanie +  zalogowanie nowym hasłem
    @Order(9)
    public void userSuccessLogin() {

        //przejście na stronę logowania
        By backToLoginPageLocator = By.xpath("//i[@class=\"material-icons\"]");
        WebElement backToLoginPageLink = driver.findElement(backToLoginPageLocator);
        backToLoginPageLink.click();

        //uzupełnienie pola email
        By emailLoginLocator = By.id("field-email");
        WebElement emailLoginInputField = driver.findElement(emailLoginLocator);
        emailLoginInputField.sendKeys(emailCreateName);

        //uzupełnienie hasła
        By passwordLoginLocator = By.id("field-password");
        WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
        passwordLoginInputField.sendKeys("Password123");

        //kliknięcie w button 'Sign In'
        By loginButtonLocator = By.id("submit-login");
        WebElement loginButtonClick = driver.findElement(loginButtonLocator);
        loginButtonClick.click();

        //sprawdzenie poprawności zalogowania użytkownika
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        Assertions.assertTrue(logoutButton.isDisplayed());

        //Zmiana hasła - wejście na podstronę 'Information'
        By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
        WebElement informationPage = driver.findElement(informationPageLocator);
        informationPage.click();

        //wpisanie aktualnego hasła logowania
        By currentPasswordFieldLocator = By.id("field-password");
        WebElement currentPasswordField = driver.findElement(currentPasswordFieldLocator);
        currentPasswordField.sendKeys("Password123");

        //wpisanie nowego hasła logowania
        By newPasswordFieldLocator = By.xpath("//input[@name=\"new_password\"]");
        WebElement newPasswordField = driver.findElement(newPasswordFieldLocator);
        newPasswordField.sendKeys("TestTest123");

        //checkbox akceptacji polityki prywatności
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
        privacyPolicyCheckbox.click();

        //checkbox informacji o przetwarzaniu danych osobowych
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
        policyInfoCheckbox.click();

        //kliknięcie buttona 'Save'
        By informationSaveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit " + "float-xs-right\"]");
        WebElement informationSaveButton = driver.findElement(informationSaveButtonLocator);
        informationSaveButton.click();

        //potwierdzenie pojawienia się komunikatu
        By updatedInformationTextLocator = By.xpath("//ul/li[contains(text()," + "\"Information successfully updated.\")]");
        WebElement updatedInformationText = driver.findElement(updatedInformationTextLocator);
        Assertions.assertTrue(updatedInformationText.isDisplayed());

        //Wylogowanie użytkownika z potwierdzeniem poprawności wylogowania
        userSuccessLogout();

        //uzupełnienie pola email
        By emailLoginLocatorNew = By.id("field-email");
        WebElement emailLoginInputFieldNew = driver.findElement(emailLoginLocatorNew);
        emailLoginInputFieldNew.sendKeys(emailCreateName);

        //uzupełnienie hasła
        By passwordLoginLocatorNew = By.id("field-password");
        WebElement passwordLoginInputFieldNew = driver.findElement(passwordLoginLocatorNew);
        passwordLoginInputFieldNew.sendKeys("TestTest123");

        //kliknięcie w button 'Sign In'
        By loginButtonLocatorNew = By.id("submit-login");
        WebElement loginButtonClickNew = driver.findElement(loginButtonLocatorNew);
        loginButtonClickNew.click();

        //sprawdzenie poprawności zalogowania użytkownika
        By logoutLocatorNew = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButtonNew = driver.findElement(logoutLocatorNew);
        Assertions.assertTrue(logoutButtonNew.isDisplayed());

        //przywrócenie starego hasła
        backToPreviousPassword();
    }

    private void backToPreviousPassword() {

        //Wejście w panel zalogowanego uzytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście na podstronę 'Information'
        By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
        WebElement informationPage = driver.findElement(informationPageLocator);
        informationPage.click();

        //wpisanie aktualnego hasła logowania
        By currentPasswordFieldLocator = By.id("field-password");
        WebElement currentPasswordField = driver.findElement(currentPasswordFieldLocator);
        currentPasswordField.sendKeys("TestTest123");

        //wpisanie nowego hasła logowania
        By newPasswordFieldLocator = By.xpath("//input[@name=\"new_password\"]");
        WebElement newPasswordField = driver.findElement(newPasswordFieldLocator);
        newPasswordField.sendKeys("Password123");

        //checkbox akceptacji polityki prywatności
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
        privacyPolicyCheckbox.click();

        //checkbox informacji o przetwarzaniu danych osobowych
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
        policyInfoCheckbox.click();

        //kliknięcie buttona 'Save'
        By informationSaveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit " + "float-xs-right\"]");
        WebElement informationSaveButton = driver.findElement(informationSaveButtonLocator);
        informationSaveButton.click();

    }

    @Test //Podstrona Accessories - filtrowanie
    @Order(10)
    public void clearAccessoriesProductsFiltering() {

        //wejdź w podstronę ACCESSORIES
        By accessoriesPageLocator = By.id("category-6");
        WebElement accessoriesPageLink = driver.findElement(accessoriesPageLocator);
        accessoriesPageLink.click();

        //Filtr - Composition / Ceramic
        By ceramicCompositionFilterLocator = By.xpath("//a[contains(text(),\"Ceramic\")]");
        WebElement ceramicCompositionFilterCheckbox = driver.findElement(ceramicCompositionFilterLocator);
        ceramicCompositionFilterCheckbox.click();

        By ceramicCompositionFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Ceramic\")]/../span/input");
        wait.until(ExpectedConditions.elementToBeSelected(ceramicCompositionFilterCheckboxLocator));

        //Filtr - Availability
        By availableFilterLocator = By.xpath("//a[contains(text(),\"Available\")]");
        WebElement availableFilterCheckbox = driver.findElement(availableFilterLocator);
        availableFilterCheckbox.click();
        By availableFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Available\")]/../span/input");
        wait.until(ExpectedConditions.elementToBeSelected(availableFilterCheckboxLocator));

        //Wyczyszczenie wybranych filtrów
        By clearAllFilterLocator = By.xpath("//button[@class=\"btn btn-tertiary js-search-filters-clear-all\"]");
        WebElement clearAllFilterClick = driver.findElement(clearAllFilterLocator);
        clearAllFilterClick.click();
        wait.until(ExpectedConditions.invisibilityOf(clearAllFilterClick));

        //potwiedzenie wyczyszczenia filtrów
        By activeFiltersLocator = By.xpath("//p[contains(text(),\"Active filters\")]");
        WebElement activeFilters = driver.findElement(activeFiltersLocator);
        Assertions.assertFalse(activeFilters.isDisplayed());
    }


    @Test    //Podstrona ART - sortowanie
    @Order(11)
    public void filterArtProducts() throws InterruptedException {

        //wejdź w podstronę Art
        By artPageLocator = By.id("category-9");
        WebElement artPageLink = driver.findElement(artPageLocator);
        artPageLink.click();
        Thread.sleep(1000);
        By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
        driver.findElement(sortByListLocator).click();

        //Sortowanie - 'Name, A to Z'
        By sortByNameAZLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]");
        WebElement sortByNameAZ = driver.findElement(sortByNameAZLocator);
        sortByNameAZ.click();

        Thread.sleep(1000);

        By productsListLocator = By.xpath("//div[@class=\"product-description\"]/h2/a");
        List<WebElement> productsLists = driver.findElements(productsListLocator);

        List<String>productsNames = new ArrayList<>();
        for(WebElement product : productsLists){
            productsNames.add(product.getText());
        }
        List<String>productsAlphabeticalOrder = productsNames.stream().sorted().toList();

        for(int i=0; i < productsNames.size(); i++){
            Assertions.assertEquals(productsNames.get(i), productsAlphabeticalOrder.get(i));
        }

        //asercja

        driver.findElement(sortByListLocator).click();

        Thread.sleep(1000);

        //Sortowanie - ‘Price, low to high’
        By sortByPriceAscLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Price, low to high\")]");
        WebElement sortByPriceAsc = driver.findElement(sortByPriceAscLocator);
        sortByPriceAsc.click();

        Thread.sleep(1000);

        By productsListLocator2 = By.xpath("//div[@class=\"product-price-and-shipping\"]/span");
        List<WebElement> productsLists2 = driver.findElements(productsListLocator2);

        List<String>productsPrices = new ArrayList<>();
        for(WebElement product : productsLists2){
            productsPrices.add(product.getText());
        }
        List<String>productsAlphabeticalOrder2 = productsPrices.stream().sorted().toList();

        for(int i=0; i < productsPrices.size(); i++){
            Assertions.assertEquals(productsPrices.get(i), productsAlphabeticalOrder2.get(i));
        }
        //asercja
    }

    @Test   //Wybranie produktu + dodanie opinii o produkcie
    @Order(12)
    public void successAddPosterReview() {

        //wybranie produktu poster 'The Best Is Yet...'
        By theBestPosterLocator = By.xpath("//img[@alt=\"The best is yet to come' Framed poster\"]");
        WebElement theBestPoster = driver.findElement(theBestPosterLocator);
        theBestPoster.click();

        //kliknięcie w button dodania opinii o produkcie
        By commentButtonLocator = By.xpath("//div[@class=\"product-comment-list-item\"]/button");
        WebElement commentButtonClick = driver.findElement(commentButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(commentButtonLocator));
        commentButtonClick.click();

        //dodaj tytuł opinii
        By commentTitleLocator = By.id("comment_title");
        WebElement commentTitleFillIn = driver.findElement(commentTitleLocator);
        wait.until(ExpectedConditions.elementToBeClickable(commentTitleFillIn));
        commentTitleFillIn.sendKeys("To bardzo dobry produkt.");

        //dodaj treść komentarza
        By commentTextLocator = By.id("comment_content");
        WebElement commentTextFillIn = driver.findElement(commentTextLocator);
        commentTextFillIn.sendKeys("Cute home decor to suit any room or home.");

        //kliknięcie w button 'send'
        By sendButtonLocator = By.xpath("//button[@class=\"btn btn-comment btn-comment-big\"]");
        WebElement sendButtonClick = driver.findElement(sendButtonLocator);
        sendButtonClick.click();

        //potwierdzenie dodania komentarza
        By addCommentPopupLocator = By.id("product-comment-posted-modal-message");
        WebElement addCommentPopup = driver.findElement(addCommentPopupLocator);
        wait.until(ExpectedConditions.elementToBeClickable(addCommentPopupLocator));
        Assertions.assertTrue(addCommentPopup.isDisplayed());

        //zamknięcie popup - kliknięcie w button 'Ok'
        By okCommentButtonLocator = By.xpath("//div[contains(text(), \"Your comment has been submitted and will be available once approved by a moderator.\")]/../div[@class=\"post-comment-buttons\"]/button[@class=\"btn btn-comment btn-comment-huge\"]");
        WebElement okCommentButtonClick = driver.findElement(okCommentButtonLocator);
        okCommentButtonClick.click();
    }

    @Test    //Dodanie kilku sztuk produktu do koszyka
    @Order(13)
    public void addProductsToCart() {

        //Zmiana ilości produktu poprzez wpisanie liczby (wyczyść i wpisz wartość)
        By putProductQuantityLocator = By.id("quantity_wanted");
        WebElement putProductQuantity = driver.findElement(putProductQuantityLocator);
        putProductQuantity.sendKeys(Keys.CONTROL + "a");
        putProductQuantity.sendKeys(Keys.DELETE);
        putProductQuantity.sendKeys("4");

        //Zmiana ilości produktu poprzez kliknięcie w strzałki
        By selectQuantityLocator = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
        WebElement selectQuantityClick = driver.findElement(selectQuantityLocator);
        selectQuantityClick.click();
        selectQuantityClick.click();
        selectQuantityClick.click();

        //Kliknij button dodaj do koszyka
        By addToCartButtonLocator = By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]");
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();

        //potwierdzenie dodania do koszyka
        By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to your shopping cart\")]");
        wait.until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
        WebElement addProductPopup = driver.findElement(addProductPopupLocator);
        Assertions.assertTrue(addProductPopup.isDisplayed());
    }

    @Test  //Koszyk
    @Order(14)
    public void cartContentValidation() {

        //zamknięcie popup dodania produktu i przejście do koszyka
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
        WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
        closeAddToCartPopupClick.click();

        //sprawdzenie nazwy produktów
        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]/a");
        String productNameInCart = driver.findElement(productNameInCartLocator).getText();
        Assertions.assertEquals("The best is yet to come' Framed poster", productNameInCart);

        // porównanie ilości z sekcji produktu i sekcji podsumowania
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

        //sprawdzenie wartości całkowitej
        //cena jednostkowa
        By unitPriceOfItemLocator = By.xpath("//div[@class=\"product-line-info product-price h5 \"]/div[@class=\"current-price\"]");
        WebElement unitPriceOfItem = driver.findElement(unitPriceOfItemLocator);
        String unitPriceText = unitPriceOfItem.getText().replace("zł", "").replace(",", ".").trim();
        double unitPrice = Double.parseDouble(unitPriceText);
        //wartość całkowita z podsumowania
        By totalPriceLocator = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
        WebElement totalPriceElement = driver.findElement(totalPriceLocator);
        String totalPriceText = totalPriceElement.getText().replace("zł", "").replace(",", ".").trim();
        double totalPrice = Double.parseDouble(totalPriceText);
        //oczekiwana wartość
        double expectedTotal = unitPrice * productQuantity;
    }

    @Test    //Formularz adresu – próba zapisania pustego formularza
    @Order(15)
    public void addressesFormFailSaveWithEmptyFields() {

        //przejście dalej z koszyka do adresu klikając button 'Proceed To Checkout'
        By proceedToCheckoutButtonInCartLocator = By.xpath("//a[@class=\"btn btn-primary\" and text()=\"Proceed to checkout\"]");
        WebElement proceedToCheckoutButtonInCart = driver.findElement(proceedToCheckoutButtonInCartLocator);
        proceedToCheckoutButtonInCart.click();

        //kliknięcie w button 'Continue'
        By continueButtonInAddressesFormLocator = By.xpath("//button[@name=\"confirm-addresses\" and contains(., \"Continue\")]");
        WebElement continueButtonInAddressesForm = driver.findElement(continueButtonInAddressesFormLocator);
        continueButtonInAddressesForm.click();

        //potwierdzenie pojawienia się dymka z komunikatem walidacyjnym - tooltip dynamiczny
        By addressesInputLocator = By.xpath("//input[@name=\"address1\"]");
        WebElement addressesInput = driver.findElement(addressesInputLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String msg = (String) js.executeScript("return arguments[0].validationMessage", addressesInput);
        Assertions.assertEquals("Wypełnij to pole.", msg);

        //uzupełnienie adresu
        By addressFieldLocator = By.id("field-address1");
        WebElement addressField = driver.findElement(addressFieldLocator);
        addressField.sendKeys("ul. Prosta 11");

        //uzupełnienie kodu pocztowego
        By postalCodeFieldLocator = By.id("field-postcode");
        WebElement postalCodeField = driver.findElement(postalCodeFieldLocator);
        postalCodeField.sendKeys("11-234");

        //uzupełnienie miasta
        By cityFieldLocal = By.id("field-city");
        WebElement cityField = driver.findElement(cityFieldLocal);
        cityField.sendKeys("Warszawa");

        //kliknięcie w button 'Continue'
        continueButtonInAddressesForm.click();
    }

    @Test
    @Order(16)
    public void shippingMethodSuccessSelection() {

        //zmiana z 'PrestaShop' na 'My carrier'
        By prestaShopRadioButtonLocator = By.id("delivery_option_2");
        WebElement prestaShopRadioButton = driver.findElement(prestaShopRadioButtonLocator);
        prestaShopRadioButton.click();

        //zmiana z 'My carrier' na 'Prestashop'
        By myCarrierRadioButtonLocator = By.id("delivery_option_1");
        WebElement myCarrierRadioButton = driver.findElement(myCarrierRadioButtonLocator);
        myCarrierRadioButton.click();

        //Dodanie komentarza do zamówienia
        By commentToOrderFieldLocator = By.id("delivery_message");
        WebElement commentToOrderField = driver.findElement(commentToOrderFieldLocator);
        commentToOrderField.sendKeys("Proszę o zostawienie paczki pod drzwiami.");

        //kliknięcie w button 'Continue'
        By continueButtonInShippingMethodFormLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
        WebElement continueButtonInShippingMethodForm = driver.findElement(continueButtonInShippingMethodFormLocator);
        continueButtonInShippingMethodForm.click();

    }

    @Test
    @Order(17)
    public void paymentMethodSuccessSelection() {

        //Wybór opcji 'Pay by bank wire'
        By payByBankWireRadioButtonLocator = By.id("payment-option-2");
        WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
        payByBankWireRadioButton.click();

        //Zmiana z 'Pay by bank wire' na 'Pay by Check'
        By payByCheckRadioButtonLocator = By.id("payment-option-1");
        WebElement payByCheckRadioButton = driver.findElement(payByCheckRadioButtonLocator);
        payByCheckRadioButton.click();

        //Wybór checkboxa zgody
        By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
        WebElement agreeToTermsCheckbox = driver.findElement(agreeToTermsCheckboxLocator);
        agreeToTermsCheckbox.click();

        //kliknięcie w button 'Place Order'
        By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
        WebElement placeOrderButtonInPaymentSection = driver.findElement(placeOrderButtonInPaymentSectionLocator);
        placeOrderButtonInPaymentSection.click();

        //potwierdzenie pojawienia się komunikatu
        By confirmationMsgLocator = By.xpath("//h3[@class=\"h1 card-title\"]/i");
        WebElement confirmationMsg = driver.findElement(confirmationMsgLocator);
        Assertions.assertTrue(confirmationMsg.isDisplayed());
    }

    @Test
    @Order(18)
    public void contactCustomerServiceDepartment() {

        //kliknięcie w link formularza kontaktowego
        By customerServiceDepartmentContactLocator = By.xpath("//a[contains(text(),\"customer service department.\")]");
        WebElement customerServiceDepartmentContact = driver.findElement(customerServiceDepartmentContactLocator);
        customerServiceDepartmentContact.click();

        //kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza
        By sendButtonInContactUsSectionLocator = By.xpath("//input[@class=\"btn btn-primary\"]");
        WebElement sendButtonInContactUsSection = driver.findElement(sendButtonInContactUsSectionLocator);
        sendButtonInContactUsSection.click();

        //potwierdzenie pojawienia się komunikatu walidacyjnego
        By validationMsgInContactUsSectionLocator = By.xpath("//li[contains(text(),\"The message cannot be blank.\")]");
        WebElement validationMsgInContactUsSection = driver.findElement(validationMsgInContactUsSectionLocator);
        Assertions.assertTrue(validationMsgInContactUsSection.isDisplayed());

        //uzupełnienie treści wiadomości
        By msgFieldInContactUsSectionLocator = By.id("contactform-message");
        WebElement msgFieldInContactUsSection = driver.findElement(msgFieldInContactUsSectionLocator);
        msgFieldInContactUsSection.sendKeys("Chcę otrzymać FV za zamówienie.");
        
        //kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza
        WebElement sendButtonInContactUsSectionNew = driver.findElement(sendButtonInContactUsSectionLocator);
        sendButtonInContactUsSectionNew.click();

        //potwierdzenie pojawienia się komunikatu informacyjnego
        By successMsgInContactUsSectionLocator = By.xpath("//li[contains(text(),\"Your message has been successfully sent to our team.\")]");
        WebElement successMsgInContactUsSection = driver.findElement(successMsgInContactUsSectionLocator);
        Assertions.assertTrue(successMsgInContactUsSection.isDisplayed());
    }


    @Test    //Panel użytkownika/Details - dodanie wiadomości i potwierdzenie widoczności
    @Order(19)
    public void addMsgInOrderDetailsPage() {

        //Wejście w panel zalogowanego użytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście w sekcję 'Order history and details'
        By orderHistoryAndDetailsLinkLocator = By.id("history-link");
        WebElement orderHistoryAndDetailsLink = driver.findElement(orderHistoryAndDetailsLinkLocator);
        orderHistoryAndDetailsLink.click();

        //Wejście w 'Details'
        By orderDetailsLinkLocator = By.xpath("//a[@data-link-action=\"view-order-details\"]");
        WebElement orderDetailsLink = driver.findElement(orderDetailsLinkLocator);
        orderDetailsLink.click();

        //Kliknięcie 'Send' - wysłanie nieuzupełnionej wiadomości
        By sendButtonInDetailsPageLocator = By.xpath("//*[@name=\"submitMessage\"]");
        WebElement sendButtonInDetailsPage = driver.findElement(sendButtonInDetailsPageLocator);
        sendButtonInDetailsPage.click();

        //Potwierdzenie pojawienia się komunikatu walidacji
        By validationMsgInDetailsPageLocator = By.xpath("//li[contains(text(),\"The message cannot be blank.\")]");
        WebElement validationMsgInDetailsPage = driver.findElement(validationMsgInDetailsPageLocator);
        Assertions.assertTrue(validationMsgInDetailsPage.isDisplayed());


        //Uzupełnienie treści wiadomości
        By fillInMsgTextInFormLocator = By.xpath("//textarea[@name=\"msgText\"]");
        WebElement fillInMsgTextInField = driver.findElement(fillInMsgTextInFormLocator);
        fillInMsgTextInField.sendKeys("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");

        //Kliknięcie 'Send'
        WebElement sendButtonInDetailsPageNew = driver.findElement(sendButtonInDetailsPageLocator);
        sendButtonInDetailsPageNew.click();

        //potwierdzenie wysłania wiadomości
        By sendConfirmationMsgLocator = By.xpath("//li[contains(text(),\"Message successfully sent\")]");
        WebElement sendConfirmationMsg = driver.findElement(sendConfirmationMsgLocator);
        Assertions.assertTrue(sendConfirmationMsg.isDisplayed());
    }

    @Test     //Panel użytkownika/Reorder - ponowne złożenie zamówienia
    @Order(20)
    public void reorderPreviousOrder() {

        //przejście na stronę 'Reorder'
        By reorderPageLinkLocator = By.xpath("//a[@class=\"button-primary\" and text()=\"Reorder\"]");
        WebElement reorderPageLink = driver.findElement(reorderPageLinkLocator);
        reorderPageLink.click();

        //edycja adresu
        By editAddressesLinkLocator = By.xpath("//footer[@class=\"address-footer\"]/a[@data-link-action=\"edit-address\"]");
        WebElement editAddressesLink = driver.findElement(editAddressesLinkLocator);
        editAddressesLink.click();

        //Zmiana miasta
        By cityInAddressFieldLocator = By.id("field-city");
        WebElement cityInAddressField = driver.findElement(cityInAddressFieldLocator);
        cityInAddressField.clear();
        cityInAddressField.sendKeys("Opole");

        //Kliknięcie buttona 'Continue'
        By continueButtonInAddressesSectionLocator = By.xpath("//footer[@class=\"form-footer clearfix\"]/button[@class=\"continue btn btn-primary float-xs-right\"]");
        WebElement continueButtonInAddressesSection = driver.findElement(continueButtonInAddressesSectionLocator);
        continueButtonInAddressesSection.click();

        //Dostawa - zmiana z 'PrestaShop' na 'My carrier'
        By prestaShopRadioButtonLocator = By.id("delivery_option_2");
        WebElement prestaShopRadioButton = driver.findElement(prestaShopRadioButtonLocator);
        prestaShopRadioButton.click();

        //kliknięcie w button 'Continue'
        By continueButtonInShippingMethodFormLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
        WebElement continueButtonInShippingMethodForm = driver.findElement(continueButtonInShippingMethodFormLocator);
        continueButtonInShippingMethodForm.click();

        //Wybór opcji 'Pay by bank wire'
        By payByBankWireRadioButtonLocator = By.id("payment-option-2");
        WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
        payByBankWireRadioButton.click();

        //Wybór checkboxa zgody
        By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
        WebElement agreeToTermsCheckbox = driver.findElement(agreeToTermsCheckboxLocator);
        agreeToTermsCheckbox.click();

        //kliknięcie w button 'Place Order'
        By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
        WebElement placeOrderButtonInPaymentSection = driver.findElement(placeOrderButtonInPaymentSectionLocator);
        placeOrderButtonInPaymentSection.click();

        //potwierdzenie pojawienia się komunikatu
        By confirmationMsgLocator = By.xpath("//h3[@class=\"h1 card-title\"]/i");
        WebElement confirmationMsg = driver.findElement(confirmationMsgLocator);
        Assertions.assertTrue(confirmationMsg.isDisplayed());
    }

    @Test
    @Order(21)
    public void addUserAddress() {

        //Wejście w panel zalogowanego użytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście na podstronę adresu - 'Addresses'
        By addressesPageLink = By.xpath("//a[@id=\"addresses-link\"]/span/i");
        WebElement addressesPage = driver.findElement(addressesPageLink);
        addressesPage.click();

        //Dodanie nowego adresu - 'Create new address'
        By createNewAddressLinkLocator = By.xpath("//a[@data-link-action=\"add-address\"]");
        WebElement createNewAddressLink = driver.findElement(createNewAddressLinkLocator);
        createNewAddressLink.click();

        //Uzupełnienie pola 'Address'
        By addressFieldLocator = By.id("field-address1");
        WebElement addressField = driver.findElement(addressFieldLocator);
        addressField.sendKeys("ul. Kwiatowa 15");

        //Uzupełnienie pola 'Zip/Postal Code'
        By zipPostaCodeFieldLocator = By.id("field-postcode");
        WebElement zipPostaCodeField = driver.findElement(zipPostaCodeFieldLocator);
        zipPostaCodeField.sendKeys("88-111");

        //Uzupełnienie pola 'City'
        By cityFieldLocator = By.id("field-city");
        WebElement cityField = driver.findElement(cityFieldLocator);
        cityField.sendKeys("Janowiec");

        //Kliknięcie w button 'Save'
        By saveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]");
        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();

        //potwierdzenie dodania adresu
        By addressSuccessfullyAddedMsgLocator = By.xpath("//li[contains(text(),\"Address successfully added!\")]");
        WebElement addressSuccessfullyAddedMsg = driver.findElement(addressSuccessfullyAddedMsgLocator);
        Assertions.assertTrue(addressSuccessfullyAddedMsg.isDisplayed());

        //Aktualizacja nowego adresu - kliknięcie 'Update'
        By updateNewAddressButtonLocator = By.xpath("//address[text()[contains(.,\"Janowiec\")]]/../..//span[contains(text(),\"Update\")]");
        WebElement updateNewAddressButton = driver.findElement(updateNewAddressButtonLocator);
        updateNewAddressButton.click();

        //Zmiana danych w polu 'Zip/Postal Code'
        zipPostaCodeField = driver.findElement(zipPostaCodeFieldLocator);
        zipPostaCodeField.clear();
        zipPostaCodeField.sendKeys("02-333");

        //Kliknięcie w button 'Save'
        saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();

        //potwierdzenie aktualizacji adresu
        By addressSuccessfullyUpdatedMsgLocator = By.xpath("//li[contains(text(),\"Address successfully updated!\")]");
        WebElement addressSuccessfullyUpdatedMsg = driver.findElement(addressSuccessfullyUpdatedMsgLocator);
        Assertions.assertTrue(addressSuccessfullyUpdatedMsg.isDisplayed());

        //Usunięcie nowego adresu
        By deleteNewAddressButtonLocator = By.xpath("//address[text()[contains(.,\"Janowiec\")]]/../..//span[contains(text(),\"Delete\")]");
        WebElement deleteNewAddressButton = driver.findElement(deleteNewAddressButtonLocator);
        deleteNewAddressButton.click();

        //potwierdzenie usunięcia adresu
        By addressSuccessfullyDeletedMsgLocator = By.xpath("//li[contains(text(),\"Address successfully deleted!\")]");
        WebElement addressSuccessfullyDeletedMsg = driver.findElement(addressSuccessfullyDeletedMsgLocator);
        Assertions.assertTrue(addressSuccessfullyDeletedMsg.isDisplayed());
    }


    @Test     //Wishlists - dodanie produktów do istniejącej wishlist
    @Order(22)
    public void addItemsToStaticWishlists() {

        //Przejcie na stronę główną
        By homepageLinkLocator = By.id("_desktop_logo");
        WebElement homepageLink = driver.findElement(homepageLinkLocator);
        homepageLink.click();

        //Kliknięcie w serduszko dodające do wishlist
        By heartButtonOfHummingbirdLocator = By.xpath("//a[contains(text(),\"Hummingbird printed t-shirt\")]/../../../button[@class=\"wishlist-button-add\"]");
        WebElement heartButtonOfHummingbird = driver.findElement(heartButtonOfHummingbirdLocator);
        heartButtonOfHummingbird.click();

        //Popup - kliknięcie w automatycznie utworzony 'My wishlist'
        By myWishlistPopupLocator = By.xpath("//div[@class=\"modal-body\"]/div/ul/li[@class=\"wishlist-list-item\"]");
        wait.until(ExpectedConditions.elementToBeClickable(myWishlistPopupLocator));
        WebElement myWishlistPopup = driver.findElement(myWishlistPopupLocator);
        myWishlistPopup.click();

        // TOAST - potwierdzenie pojawienia się komunikatu potwierdzającego
        By productAddedToWishlistMsgLocator = By.xpath("//div[@class=\"wishlist-toast success\"]/p[@class=\"wishlist-toast-text\"]");
        wait.until(ExpectedConditions.elementToBeClickable(productAddedToWishlistMsgLocator));
        WebElement productAddedToWishlistMsg = driver.findElement(productAddedToWishlistMsgLocator);
        Assertions.assertTrue(productAddedToWishlistMsg.isDisplayed());

        //Wejście w panel zalogowanego użytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście na podstronę 'My wishlists'
        By myWishlistsPageLocator = By.xpath("//a[@id=\"wishlist-link\"]/span/i");
        WebElement myWishlistsPage = driver.findElement(myWishlistsPageLocator);
        myWishlistsPage.click();

        //Wejście na link listy 'My wishlist'
        By myWishlistLinkLocator = By.xpath("//p[@class=\"wishlist-list-item-title\"]");
        wait.until(ExpectedConditions.elementToBeClickable(myWishlistLinkLocator));
        WebElement myWishlistLink = driver.findElement(myWishlistLinkLocator);
        myWishlistLink.click();

        By wishListElementsLocator = By.xpath("//p[@class=\"wishlist-product-title\"]");
        wait.until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
        List<WebElement> wishListsElements = driver.findElements(wishListElementsLocator);
        List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
        Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Hummingbird printed t-shirt"));

    }

    @Test    //Wishlists - utworzenie nowej wishlisty i dodanie produktu
    @Order(23)
    public void addItemsToNewWishlists() {


        //Przejcie na stronę główną
        By homepageLinkLocator = By.id("_desktop_logo");
        WebElement homepageLink = driver.findElement(homepageLinkLocator);
        homepageLink.click();

        //Kliknięcie w serduszko dodające do wishlist
        By heartButtonOfMugTheAdventureLocator = By.xpath("//a[contains(text(),\"Mug The adventure begins\")]/../../../button[@class=\"wishlist-button-add\"]");
        WebElement heartButtonOfMugTheAdventure = driver.findElement(heartButtonOfMugTheAdventureLocator);
        heartButtonOfMugTheAdventure.click();

        //Popup - kliknięcie 'Create new list'
        By newWishlistPopupLocator = By.xpath("//a[@class=\"wishlist-add-to-new text-primary\"]");
        wait.until(ExpectedConditions.elementToBeClickable(newWishlistPopupLocator));
        WebElement newWishlistPopup = driver.findElement(newWishlistPopupLocator);
        newWishlistPopup.click();

        //Wpisanie nazwy nowej listy
        By wishlistNameLocator = By.xpath("//input[@id=\"input2\"]");
        WebElement wishlistNameField = driver.findElement(wishlistNameLocator);
        wishlistNameField.sendKeys("Ulubione");

        //Kliknięcie w button 'Create wishlist'
        By createNewWishListLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
        WebElement createNewWishList = driver.findElement(createNewWishListLocator);
        createNewWishList.click();

        //Popup - wybranie nowo utworzonej listy
        By ulubioneNewWishlistLector = By.xpath("//li[@class=\"wishlist-list-item\"]/p[contains(text(),\"Ulubione\")]");
        wait.until(ExpectedConditions.elementToBeClickable(ulubioneNewWishlistLector));
        WebElement ulubioneNewWishlist = driver.findElement(ulubioneNewWishlistLector);
        ulubioneNewWishlist.click();

        // TOAST - potwierdzenie pojawienia się komunikatu potwierdzającego Product added
        By productAddedToWishlistMsgLocator = By.xpath("//p[contains(text(),\"Product added\")]");
        wait.until(ExpectedConditions.elementToBeClickable(productAddedToWishlistMsgLocator));
        WebElement productAddedToWishlistMsg = driver.findElement(productAddedToWishlistMsgLocator);
        Assertions.assertTrue(productAddedToWishlistMsg.isDisplayed());

        //Wejście w panel zalogowanego użytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście na podstronę 'My wishlists'
        By myWishlistsPageLocator = By.xpath("//a[@id=\"wishlist-link\"]/span/i");
        WebElement myWishlistsPage = driver.findElement(myWishlistsPageLocator);
        myWishlistsPage.click();

        //Wejście na link listy 'Ulubione'
        By ulubioneWishlistLinkLocator = By.xpath("//a[@class=\"wishlist-list-item-link\"]/p[contains(text(),\"Ulubione\")]");
        wait.until(ExpectedConditions.elementToBeClickable(ulubioneWishlistLinkLocator));
        WebElement ulubioneWishlistLink = driver.findElement(ulubioneWishlistLinkLocator);
        ulubioneWishlistLink.click();

        By wishListElementsLocator = By.xpath("//p[@class=\"wishlist-product-title\"]");
        wait.until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
        List<WebElement> wishListsElements = driver.findElements(wishListElementsLocator);
        List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
        Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Mug The adventure begins"));

    }

    @Test    //Wishlists - utworzenie listy na podstronie ‘My wishlists’, zmiana nazwy i usunięcie
    @Order(24)
    public void createNewWishlists() {

        //przejście na podstronę 'My wishlist'
        By myWishlistsLinkLocator = By.xpath("//nav[@data-depth=\"4\"]//a[contains(., \"My wishlists\")]");
        WebElement myWishlistsLink = driver.findElement(myWishlistsLinkLocator);
        myWishlistsLink.click();

        //utworzenie nowej listy życzeń
        By createNewListWishlistLinkLocator = By.xpath("//div[@class=\"wishlist-container-header\"]/a[contains(text(),\"Create new list\")]");
        wait.until(ExpectedConditions.elementToBeClickable(createNewListWishlistLinkLocator));
        WebElement createNewListWishlistLink = driver.findElement(createNewListWishlistLinkLocator);
        createNewListWishlistLink.click();

        //wpisanie nazwy nowej listy życzeń
        By createNameOfNewListWishlistLocator = By.xpath("//input[@placeholder=\"Add name\"]");
        wait.until(ExpectedConditions.elementToBeClickable(createNameOfNewListWishlistLocator));
        WebElement createNameOfNewListWishlist = driver.findElement(createNameOfNewListWishlistLocator);
        createNameOfNewListWishlist.sendKeys("Super lista");

        //kliknięcie w button tworzący listę
        By createWishlistButtonLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
        WebElement createWishlistButton = driver.findElement(createWishlistButtonLocator);
        createWishlistButton.click();

        //TOAST - potwierdzenie pojawienia się komunikatu
        By wishlistSuccessCreatedMsgLocator = By.xpath("//p[contains(text(),\"The list has been properly created\")]");
        wait.until(ExpectedConditions.elementToBeClickable(wishlistSuccessCreatedMsgLocator));
        WebElement wishlistSuccessCreatedMsg = driver.findElement(wishlistSuccessCreatedMsgLocator);
        Assertions.assertTrue(wishlistSuccessCreatedMsg.isDisplayed());

        //potwierdzenie utworzenia nowej wishlist
        By createdNewWishlistNameLocator = By.xpath("//div[@class=\"wishlist-list-container\"]//p[contains(text(),\"Super lista\")]");
        WebElement createdNewWishlistName = driver.findElement(createdNewWishlistNameLocator);
        Assertions.assertTrue(createdNewWishlistName.isDisplayed());

        //trzy kropki
        By moreActionLocator = By.xpath("//p[contains(text(),\"Super lista\")]/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]");
        driver.findElement(moreActionLocator).click();

        //zmiana nazwy nowej listy życzeń
        By renameNewCreatedWishlistLocator = By.xpath("//p[contains(text(),\"Super lista\")]/..//div[@class=\"wishlist-list-item-right\"]/div[@class=\"dropdown-menu show\"]/button[contains(text(),\"Rename\")]");
        WebElement renameWishList = driver.findElement(renameNewCreatedWishlistLocator);
        renameWishList.click();

        By changeNameOfListWishlistLocator = By.xpath("//h5[contains(text(),\"Rename wishlist\")]/../..//div/div/input");
        wait.until(ExpectedConditions.elementToBeClickable(changeNameOfListWishlistLocator));
        WebElement changeNameOfListWishList = driver.findElement(changeNameOfListWishlistLocator);
        //zmiana nazwy listy - wyczyszczenie i wpisanie nowej
        changeNameOfListWishList.clear();
        changeNameOfListWishList.sendKeys("Lista życzeń");

        //kliknięcie w button 'Rename'
        By renameWishlistButtonLocator = By.xpath("//button[contains(text(),\"Rename wishlist\")]");
        WebElement renameWishlistButton = driver.findElement(renameWishlistButtonLocator);
        renameWishlistButton.click();

        //TOAST - potwierdzenie pojawienia się komunikatu
        By successRenamedNewWishlistLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
        wait.until(ExpectedConditions.elementToBeClickable(successRenamedNewWishlistLocator));
        WebElement successRenamedNewWishlist = driver.findElement(successRenamedNewWishlistLocator);
        Assertions.assertTrue(successRenamedNewWishlist.isDisplayed());

        //trzy kropki
        moreActionLocator = By.xpath("//p[contains(text(),\"Lista życzeń\")]/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]");
        wait.until(ExpectedConditions.elementToBeClickable(moreActionLocator));
        driver.findElement(moreActionLocator).click();

        //Udostępnienie listy - kliknięcie w button 'Share'
        By shareButtonWishlistLocator = By.xpath("//button[contains(text(),\"Share\")]");
        WebElement shareButtonWishlist = driver.findElement(shareButtonWishlistLocator);
        shareButtonWishlist.click();

        //Kliknięcie w button 'Copy text'
        By copyTextButtonOfWishlistLocator = By.xpath("//button[contains(text(),\"Copy text\")]");
        WebElement copyTextButtonOfWishlist = driver.findElement(copyTextButtonOfWishlistLocator);
        copyTextButtonOfWishlist.click();

        //TOAST - potwierdzenie pojawienia się komunikatu
        By shareLinkCopiedMsgLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
        WebElement shareLinkCopiedMsg = driver.findElement(shareLinkCopiedMsgLocator);
        Assertions.assertTrue(shareLinkCopiedMsg.isDisplayed());

        //Usunięcie listy
        By deleteWishlistButtonLocator = By.xpath("//p[contains(text(),\"Lista życzeń\")]/../div[@class=\"wishlist-list-item-right\"]/button/i[contains(text(),\"delete\")]");
        WebElement deleteWishlistButton = driver.findElement(deleteWishlistButtonLocator);
        deleteWishlistButton.click();

        By deleteConfirmLocator = By.xpath("//div[@class=\"modal-footer\"]/button[contains(text(),\"Delete\")]");
        WebElement deleteConfirm = driver.findElement(deleteConfirmLocator);
        deleteConfirm.click();

        //TOAST - potwierdzenie pojawienia się komunikatu
        By listRemovedComfirmLocator = By.xpath("//p[contains(text(),\"List has been removed\")]");
        wait.until(ExpectedConditions.elementToBeClickable(listRemovedComfirmLocator));
        WebElement listRemovedComfirm = driver.findElement(listRemovedComfirmLocator);

        Assertions.assertTrue(listRemovedComfirm.isDisplayed());
    }

    @Test   //Strona główna/Footer -  sprawdzenie działania linków w stopce
    @Order(25)
    public void checkFooterLinksClickable() {

        //Kliknięcie w link 'Prices drop'
        By pricesDropLinkLocator = By.id("link-product-page-prices-drop-1");
        WebElement pricesDropLink = driver.findElement(pricesDropLinkLocator);
        pricesDropLink.click();
        //potwierdzenie otwarcia podstrony
        By pricesDropPageNameLocator = By.id("js-product-list-header");
        WebElement pricesDropPageName = driver.findElement(pricesDropPageNameLocator);
        Assertions.assertTrue(pricesDropPageName.isDisplayed());

        //Kliknięcie w link 'New products'
        By newProductsLinkLocator = By.id("link-product-page-new-products-1");
        WebElement newProductsLink = driver.findElement(newProductsLinkLocator);
        newProductsLink.click();
        //potwierdzenie wejścia na podstronę
        By newProductsPageNameLocator = By.id("js-product-list-header");
        WebElement newProductsPageName = driver.findElement(newProductsPageNameLocator);
        Assertions.assertTrue(newProductsPageName.isDisplayed());

        //Kliknięcie w link 'Best sales'
        By bestSalesLinkLocator = By.id("link-product-page-best-sales-1");
        WebElement bestSalesLink = driver.findElement(bestSalesLinkLocator);
        bestSalesLink.click();
        //potwierdzenie wejścia na podstronę
        By bestSellersPageNameLocator = By.id("js-product-list-header");
        WebElement bestSellersPageName = driver.findElement(bestSellersPageNameLocator);
        Assertions.assertTrue(bestSellersPageName.isDisplayed());

        //Kliknięcie w link 'Delivery'
        By deliveryLinkLocator = By.id("link-cms-page-1-2");
        WebElement deliveryLink = driver.findElement(deliveryLinkLocator);
        deliveryLink.click();
        //potwierdzenie wejścia na podstronę
        By deliveryPageNameLink = By.xpath("//h1[contains(text(),\"Delivery\")]");
        WebElement deliveryPageName = driver.findElement(deliveryPageNameLink);
        Assertions.assertTrue(deliveryPageName.isDisplayed());

        //Kliknięcie w link 'Legal Notice'
        By legalNoticeLinkLocator = By.id("link-cms-page-2-2");
        WebElement legalNoticeLink = driver.findElement(legalNoticeLinkLocator);
        legalNoticeLink.click();
        //Potwierdzenie wejścia na podstronę
        By legalNoticePageNameLocator = By.xpath("//h1[contains(text(),\"Legal Notice\")]");
        WebElement legalNoticePageName = driver.findElement(legalNoticePageNameLocator);
        Assertions.assertTrue(legalNoticePageName.isDisplayed());

        //Kliknięcie w link 'Terms and conditions of use'
        By termsAndConditionsOfUseLinkLocator = By.id("link-cms-page-3-2");
        WebElement termsAndConditionsOfUseLink = driver.findElement(termsAndConditionsOfUseLinkLocator);
        termsAndConditionsOfUseLink.click();
        //potwierdzenie wejścia na podstronę
        By termsAndConditionsOfUsePageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text(), " + "\"Terms and conditions of use\")]");
        WebElement termsAndConditionsOfUsePageName = driver.findElement(termsAndConditionsOfUsePageNameLocator);
        Assertions.assertTrue(termsAndConditionsOfUsePageName.isDisplayed());

        //Kliknięcie w link 'About us'
        By aboutUsLinkLocator = By.id("link-cms-page-4-2");
        WebElement aboutUsLink = driver.findElement(aboutUsLinkLocator);
        aboutUsLink.click();
        //potwierdzenie wejścia na podstronę
        By aboutUsPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text(), " + "\"About us\")]");
        WebElement aboutUsPageName = driver.findElement(aboutUsPageNameLocator);
        Assertions.assertTrue(aboutUsPageName.isDisplayed());

        //Kliknięcie w link 'Secure payment'
        By securePaymentLinkLocator = By.id("link-cms-page-5-2");
        WebElement securePaymentLink = driver.findElement(securePaymentLinkLocator);
        securePaymentLink.click();
        //potwierdzenie wejścia na podstronę
        By securePaymentPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text(), " + "\"Secure payment\")]");
        WebElement securePaymentPageName = driver.findElement(securePaymentPageNameLocator);
        Assertions.assertTrue(securePaymentPageName.isDisplayed());

        //Kliknięcie w link 'Contact us'
        By contactUsLinkLocator = By.id("link-static-page-contact-2");
        WebElement contactUsLink = driver.findElement(contactUsLinkLocator);
        contactUsLink.click();
        //potwierdzenie wejścia na podstronę
        By contactUsPageNameLocator = By.xpath("//div[@class=\"col-md-9 col-md-offset-3\"]/h3[contains(text(),\"Contact us\")]");
        WebElement contactUsPageName = driver.findElement(contactUsPageNameLocator);
        Assertions.assertTrue(contactUsPageName.isDisplayed());

        //Kliknięcie w link 'Sitemap'
        By sitemapLinkLocator = By.id("link-static-page-sitemap-2");
        WebElement sitemapLink = driver.findElement(sitemapLinkLocator);
        sitemapLink.click();
        //potwierdzenie wejścia na podstronę
        By sitemapPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1/span[contains(text(), " + "\"Sitemap\")]");
        WebElement sitemapPageName = driver.findElement(sitemapPageNameLocator);
        Assertions.assertTrue(sitemapPageName.isDisplayed());

        //Kliknięcie w link 'Stores'
        By storesLinkLocator = By.id("link-static-page-stores-2");
        WebElement storesLink = driver.findElement(storesLinkLocator);
        storesLink.click();
        //potwierdzenia wejscie na podstronę
        By ourStoresPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1");
        WebElement ourStoresPageName = driver.findElement(aboutUsLinkLocator);
        Assertions.assertTrue(ourStoresPageName.isDisplayed());

        //Kliknięcie w link 'Personal info'
        By personalInfoLinkLocator = By.xpath("//a[@title=\"Personal info\"]");
        WebElement personalInfoLink = driver.findElement(personalInfoLinkLocator);
        personalInfoLink.click();
        //potwierdzenie wejścia na podstronę
        By personalInfoPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text()," + "\"Your personal information\")]");
        WebElement personalInfoPageName = driver.findElement(personalInfoPageNameLocator);
        Assertions.assertTrue(personalInfoPageName.isDisplayed());

        //Kliknięcie w link 'Orders'
        By ordersLinkLocator = By.xpath("//a[@title=\"Orders\"]");
        WebElement ordersLink = driver.findElement(ordersLinkLocator);
        ordersLink.click();
        //potwierdzenie wejścia na podstronę
        By orderHistoryPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text()," + "\"Order history\")]");
        WebElement orderHistoryPageName = driver.findElement(orderHistoryPageNameLocator);
        Assertions.assertTrue(orderHistoryPageName.isDisplayed());

        //Kliknięcie w link 'Credit slips'
        By creditSlipsLinkLocator = By.xpath("//a[@title=\"Credit slips\"]");
        WebElement creditSlipsLink = driver.findElement(creditSlipsLinkLocator);
        creditSlipsLink.click();
        //potwierdzenie wejścia na podstronę
        By creditSlipsPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text()," + "\"Credit slips\")]");
        WebElement creditSlipsPageName = driver.findElement(creditSlipsPageNameLocator);
        Assertions.assertTrue(creditSlipsPageName.isDisplayed());

        //Kliknięcie w link 'Addresses'
        By addressesLinkLocator = By.xpath("//a[@title=\"Addresses\"]");
        WebElement addressesLink = driver.findElement(addressesLinkLocator);
        addressesLink.click();
        //potwierdzenie wejścia na podstronę
        By yourAddressesPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text()," + "\"Your addresses\")]");
        WebElement yourAddressesPageName = driver.findElement(yourAddressesPageNameLocator);
        Assertions.assertTrue(yourAddressesPageName.isDisplayed());

        //Kliknięcie w link 'Wishlist'
        By wishlistLinkLocator = By.xpath("//a[@title=\"My wishlists\"]");
        WebElement wishlistLink = driver.findElement(wishlistLinkLocator);
        wishlistLink.click();
        //potwierdzenie wejścia na podstronę
        By myWishlistsPageNameLocator = By.xpath("//h1[contains(text(),\"My wishlists\")]");
        WebElement myWishlistsPageName = driver.findElement(myWishlistsPageNameLocator);
        Assertions.assertTrue(myWishlistsPageName.isDisplayed());

        //Wylogowanie użytkownika z potwierdzeniem poprawności wylogowania
        userSuccessLogout();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
