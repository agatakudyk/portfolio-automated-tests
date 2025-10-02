package lesson12Homework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.AddHasDebugger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumPrestashopTest {

    static ChromeDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://localhost:8080/pl/");
    }

    //TODO - GOTOWE!
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

    //TODO - GOTOWE!
    //@Test  //Niepoprawna rejestracja przy pomocy pustego formularza
    @Order(2)
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

    //TODO - GOTOWE!
    //@Test  //Poprawna rejestracja użytkownika + wylogowanie
    @Order(3)
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
        mailInputField.sendKeys("testowianka95@wp.pl");

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

    //TODO - GOTOWE!
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

    //TODO - GOTOWE!
    //@Test
    @Order(4)    //Logowanie z użyciem błędnych danych
    public void failLoginWithIncorrectData() {

        //kliknięcie w przycisk logowania
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();

        //uzupełnienie pola email
        By emailLoginLocator = By.id("field-email");
        WebElement emailLoginInputField = driver.findElement(emailLoginLocator);
        emailLoginInputField.sendKeys("blablabla@wp.pl");

        //uzupełnienie hasła
        By passwordLoginLocator = By.id("field-password");
        WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
        passwordLoginInputField.sendKeys("blepassword");

        //kliknięcie w button 'Sign In'
        By loginButtonLocator = By.id("submit-login");
        WebElement loginButtonClick = driver.findElement(loginButtonLocator);
        loginButtonClick.click();

        //sprawdzenie komunikatu o błędnym logowaniu
        By failMsgLocator = By.xpath("//li[@class=\"alert alert-danger\"]");
        WebElement failMessage = driver.findElement(failMsgLocator);
        Assertions.assertTrue(failMessage.isDisplayed());
    }

    //TODO - GOTOWE!
    //@Test  //Logowanie/zresetowanie zapomnianego hasła + walidacja
    @Order(5)
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

    //TODO
    @Test     //Poprawne zalogowanie  + zmiana hasła + wylogowanie +  zalogowanie nowym hasłem
    @Order(6)
    public void userSuccessLogin() {

        //przejście na stronę logowania
        By backToLoginPageLocator = By.xpath("//i[@class=\"material-icons\"]");
        WebElement backToLoginPageLink = driver.findElement(backToLoginPageLocator);
        backToLoginPageLink.click();

        //uzupełnienie pola email
        By emailLoginLocator = By.id("field-email");
        WebElement emailLoginInputField = driver.findElement(emailLoginLocator);
        emailLoginInputField.sendKeys("testowianka95@wp.pl");

        //uzupełnienie hasła
        By passwordLoginLocator = By.id("field-password");
        WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
        passwordLoginInputField.sendKeys("Password123");

        //kliknięcie w button 'Sign In'
        By loginButtonLocator = By.id("submit-login");
        WebElement loginButtonClick = driver.findElement(loginButtonLocator);
        loginButtonClick.click();
//
//        //sprawdzenie poprawności zalogowania użytkownika
//        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
//        WebElement logoutButton = driver.findElement(logoutLocator);
//        Assertions.assertTrue(logoutButton.isDisplayed());
//
//        //Zmiana hasła - wejście w panel zalogowanego uzytkownika
//        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
//        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
//        userProfileLink.click();
//
//        //Zmiana hasła - wejście na podstronę 'Information'
//        By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
//        WebElement informationPage = driver.findElement(informationPageLocator);
//        informationPage.click();
//
//        //wpisanie aktualnego hasła logowania
//        By currentPasswordFieldLocator = By.id("field-password");
//        WebElement currentPasswordField = driver.findElement(currentPasswordFieldLocator);
//        currentPasswordField.sendKeys("Password123");
//
//        //wpisanie nowego hasła logowania
//        By newPasswordFieldLocator = By.xpath("//input[@name=\"new_password\"]");
//        WebElement newPasswordField = driver.findElement(newPasswordFieldLocator);
//        newPasswordField.sendKeys("TestTest123");
//
//        //checkbox akceptacji polityki prywatności
//        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
//        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
//        privacyPolicyCheckbox.click();
//
//        //checkbox informacji o przetwarzaniu danych osobowych
//        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
//        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
//        policyInfoCheckbox.click();
//
//        //kliknięcie buttona 'Save'
//        By informationSaveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit " + "float-xs-right\"]");
//        WebElement informationSaveButton = driver.findElement(informationSaveButtonLocator);
//        informationSaveButton.click();
//
//        //potwierdzenie pojawienia się komunikatu
//        By updatedInformationTextLocator = By.xpath("//ul/li[contains(text()," + "\"Information successfully updated.\")]");
//        WebElement updatedInformationText = driver.findElement(updatedInformationTextLocator);
//        Assertions.assertTrue(updatedInformationText.isDisplayed());
//
//        //Wylogowanie użytkownika z potwierdzeniem poprawności wylogowania
//        userSuccessLogout();
//
//        //uzupełnienie pola email
//        emailLoginInputField.sendKeys("testowianka95@wp.pl");
//
//        //uzupełnienie nowego hasła
//        passwordLoginInputField.sendKeys("Testunio123");
//
//        //kliknięcie w button 'Sign In'
//        loginButtonClick.click();
//
//        //sprawdzenie poprawności logowania
//        Assertions.assertTrue(logoutButton.isDisplayed());
    }

    //todo - trudne
    //@Test //Podstrona Accessories - filtrowanie
    @Order(7)
    public void clearAccessoriesProductsFiltering() {

        //wejdź w podstronę ACCESSORIES
        By accessoriesPageLocator = By.id("category-6");
        WebElement accessoriesPageLink = driver.findElement(accessoriesPageLocator);
        accessoriesPageLink.click();

        //Filtr - Composition / Ceramic
        By ceramicCompositionFilterLocator = By.xpath("//a[contains(text(),\"Ceramic\")]");
        WebElement ceramicCompositionFilterCheckbox = driver.findElement(ceramicCompositionFilterLocator);
        ceramicCompositionFilterCheckbox.click();

        //Filtr - Availability
        By availableFilterLocator = By.xpath("//a[contains(text(),\"Available\")]");
        WebElement availableFilterCheckbox = driver.findElement(availableFilterLocator);
        availableFilterCheckbox.click();

        //Wyczyszczenie wybranych filtrów
        By clearAllFilterLocator = By.xpath("//button[@class=\"btn btn-tertiary js-search-filters-clear-all\"]");
        WebElement clearAllFilterClick = driver.findElement(clearAllFilterLocator);
        clearAllFilterClick.click();

        //TODO: potwiedzenie wyczyszczenia filtrów
    }

    public WebElement waitForElementToBeRefreshedAndClickable(ChromeDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    //todo - trudne
    @Test    //Podstrona ART - sortowanie
    @Order(8)
    public void filterArtProducts() throws InterruptedException {

        //wejdź w podstronę Art
        By artPageLocator = By.id("category-9");
        WebElement artPageLink = driver.findElement(artPageLocator);
        artPageLink.click();

//        //Sortowanie - Name, A to Z
//        By sortByNameAZLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]");
//        WebElement sortByNameAZ = driver.findElement(sortByNameAZLocator);
//        sortByNameAZ.click();
//
//        Thread.sleep(2000);
//
//        //asercja
//
//        //Sortowanie - Name, A to Z
//        By sortByPriceAscLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Price, low to high\")]");
//        WebElement sortByPriceAsc = driver.findElement(sortByPriceAscLocator);
//        sortByPriceAsc.click();
//
//        Thread.sleep(2000);
//
//        //asercja
    }

    //TODO - GOTOWE!
    @Test   //Wybranie produktu ‘The best is yet to come' + dodanie opinii
    @Order(9)
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

    //TODO - GOTOWE!
    @Test    //Dodanie kilku sztuk produktu do koszyka
    @Order(10)
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
    @Order(11)
    public void cartContentValidation() {

        //zamknięcie popup dodania produktu i przejście do koszyka
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
        WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
        closeAddToCartPopupClick.click();

//        //sprawdzenie nazwy produktów
//        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]");
//        WebElement productNameInCart = driver.findElement(productNameInCartLocator);
//        //TODO Assertions

        // porównanie ilości z sekcji produktu i sekcji podsumowania
        // ilość w sekcji produktu
        By numberInItemsSectionLocator = By.xpath("//input[@class='js-cart-line-product-quantity form-control']");
        WebElement numberInItemSection = driver.findElement(numberInItemsSectionLocator);
        int productQuantity = Integer.parseInt(numberInItemSection.getAttribute("value"));
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
        //todo zrobić asercję
    }

    @Test   //Koszyk - zwiększenie ilości produktu
    @Order(12)
    public void increasingNumberOfItems() {

        //wstawienie ilości produktu
        By putProductQuantityInCartLocator = By.xpath("//input[@class=\"js-cart-line-product-quantity form-control\"]");
        WebElement putProductQuantityInCart = driver.findElement(putProductQuantityInCartLocator);
        putProductQuantityInCart.sendKeys(Keys.DELETE);
        putProductQuantityInCart.sendKeys("22");

        //todo asercja

        //zwiększenie liczby produktu klikając w strzałki
        By selectQuantityLocator = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
        WebElement selectQuantityClick = driver.findElement(selectQuantityLocator);
        selectQuantityClick.click();
        selectQuantityClick.click();
        selectQuantityClick.click();

        //todo asercja
    }

    //TODO - GOTOWE!
    @Test    //Formularz adresu – próba zapisania pustego formularza
    @Order(13)
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
        //Assertions.assertEquals("Wypełnij to pole.", msg);
    }

    @Test   //Formularz adresu - zapisanie poprawnie uzupełnionego formularza
    @Order(14)
    public void addressesFormSuccessSave() {

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
        By continueButtonInAddressesFormLocator = By.xpath("//button[@name=\"confirm-addresses\" and contains(., \"Continue\")]");
        WebElement continueButtonInAddressesForm = driver.findElement(continueButtonInAddressesFormLocator);
        continueButtonInAddressesForm.click();

        //todo - jak zrobić asercję? powrót do sekcji i sprawdzenie wyborów?
    }

    @Test
    @Order(15)
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

        //todo - jak zrobić asercję? powrót do sekcji i sprawdzenie wyborów?
    }

    @Test
    @Order(16)
    public void paymentMethodSelection() {

        //Wybór opcji 'Pay by bank wire'
        By payByBankWireRadioButtonLocator = By.id("payment-option-2");
        WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
        payByBankWireRadioButton.click();

        //Zmiana z 'Pay by bank wire' na 'Pay by Check'
        By payByCheckRadioButtonLocator = By.id("payment-option-1");
        WebElement payByCheckRadioButton = driver.findElement(payByCheckRadioButtonLocator);
        payByCheckRadioButton.click();

        //todo - uzupełnij dane czeku
//        //uzupełnienie danych przy płatności czekiem
//        By payeeFieldFillInLocator =
//        WebElement payeeFieldFillIn = driver.findElement();
//        payeeFieldFillIn.

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
    @Order(17)
    public void contactCustomerServiceDepartment() {

        //kliknięcie w link formularza kontaktowego
        By customerServiceDepartmentContactLocator = By.xpath("//a[contains(text(),\"customer service department.\")]");
        WebElement customerServiceDepartmentContact = driver.findElement(customerServiceDepartmentContactLocator);
        customerServiceDepartmentContact.click();

        //kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza
        By sendButtonInContactUsSectionLocator = By.xpath("//input[@class=\"btn btn-primary\"]");
        WebElement sendButtonInContactUsSection = driver.findElement(sendButtonInContactUsSectionLocator);
        sendButtonInContactUsSection.click();

        //Potwierdzenie pojawienia się komunikatu walidacyjnego
        By validationMsgInContactUsSectionLocator = By.xpath("//li[contains(text(),\"The message cannot be blank.\")]");
        WebElement validationMsgInContactUsSection = driver.findElement(validationMsgInContactUsSectionLocator);
        Assertions.assertTrue(validationMsgInContactUsSection.isDisplayed());

        //uzupełnienie treści wiadomości
        By msgFieldInContactUsSectionLocator = By.id("contactform-message");
        WebElement msgFieldInContactUsSection = driver.findElement(msgFieldInContactUsSectionLocator);
        msgFieldInContactUsSection.sendKeys("Chcę otrzymać FV za zamówienie.");

        //kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza
        sendButtonInContactUsSection.click();

        //potwierdzenie pojawienia się komunikatu informacyjnego
        By successMsgInContactUsSectionLocator = By.xpath("//li[contains(text(),\"Your message has been successfully sent to our team.\")]");
        WebElement successMsgInContactUsSection = driver.findElement(successMsgInContactUsSectionLocator);
        Assertions.assertTrue(successMsgInContactUsSection.isDisplayed());
    }

    @Test    //Panel użytkownika/Order history - sprawdzenie szczegółów zamówienia
    @Order(18)
    public void checkOrderDetails() {

        //Wejście w panel zalogowanego uzytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście w sekcję 'Order history and details'
        By orderHistoryAndDetailsLinkLocator = By.id("history-link");
        WebElement orderHistoryAndDetailsLink = driver.findElement(orderHistoryAndDetailsLinkLocator);
        orderHistoryAndDetailsLink.click();

        //todo - sprawdzenie

    }


    @Test    //Panel użytkownika/Details - dodanie wiadomości i potwierdzenie widoczności
    @Order(19)
    public void addMsgInOrderDetailsPage() {

        //Wejście w panel zalogowanego uzytkownika
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
        userProfileLink.click();

        //Wejście w sekcję 'Order history and details'
        By orderHistoryAndDetailsLinkLocator = By.id("history-link");
        WebElement orderHistoryAndDetailsLink = driver.findElement(orderHistoryAndDetailsLinkLocator);
        orderHistoryAndDetailsLink.click();

        //Wejście w pierwsze lepsze 'Details'
        By orderDetailsLinkLocator = By.xpath("//a[@data-link-action=\"view-order-details\"]/i");
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

        //Poprawne dodanie wiadomości - wybór produktu
        By chooseProductInMsgFormLocator = By.xpath("//li[contains(text(),\"The message cannot be blank.\")]");
        WebElement chooseProductField = driver.findElement(chooseProductInMsgFormLocator);
        //todo - wybór opcji

        //Uzupełnienie treści wiadomości
        By fillInMsgTextInFormLocator = By.xpath("//textarea[@name=\"msgText\"]");
        WebElement fillInMsgTextInField = driver.findElement(fillInMsgTextInFormLocator);
        fillInMsgTextInField.sendKeys("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");

        //Kliknięcie 'Send'
        sendButtonInDetailsPage.click();

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
        By cityInAddressFieldLocator = By.id("#field-city");
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

    @Test     //Wishlists - dodanie produktów do wishlists
    @Order(21)
    public void addItemsToStaticWishlists() {

        //Przejcie na stronę główną
        By homepageLinkLocator = By.id("_desktop_logo");
        WebElement homepageLink = driver.findElement(homepageLinkLocator);
        homepageLink.click();

        //Kliknięcie w serduszko dodające do wishlist
        By heartButtonOfHummingbirdLocator = By.xpath("\t//a[contains(text(),\"Hummingbird printed t-shirt\")]/../../../button[@class=\"wishlist-button-add\"]");
        WebElement heartButtonOfHummingbird = driver.findElement(heartButtonOfHummingbirdLocator);
        heartButtonOfHummingbird.click();

        //Popup - kliknięcie w automatycznie utworzony 'My wishlist'
        By myWishlistPopupLocator = By.xpath("//div[@class=\"modal-body\"]/div/ul/li[@class=\"wishlist-list-item\"]");
        WebElement myWishlistPopup = driver.findElement(myWishlistPopupLocator);
        myWishlistPopup.click();

        // TOAST - potwierdzenie pojawienia się komunikatu potwierdzającego
        By productAddedToWishlistMsgLocator = By.xpath("//div[@class=\"wishlist-toast success\"]/p[@class=\"wishlist-toast-text\"]");
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
        WebElement myWishlistLink = driver.findElement(myWishlistLinkLocator);
        myWishlistLink.click();

        //todo - potwierdzenie, że produkt jest
    }


    @Test    //Wishlists - utworzenie nowej wishlisty i dodanie produktu
    @Order(22)
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
        WebElement newWishlistPopup = driver.findElement(newWishlistPopupLocator);
        newWishlistPopup.click();

        //Wpisanie nazwy nowej listy
        By wishlistNameLocator = By.xpath("//input[@id=\"input2\"]");
        WebElement wishlistNameField = driver.findElement(wishlistNameLocator);
        wishlistNameField.sendKeys("Ulubione");

        //Kliknięcie w button 'Create wishlist'
        By createWishlistLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");


    }



    //TODO - GOTOWE!
    //@Test   //Strona główna/Footer -  sprawdzenie działania linków w stopce
    @Order(23)
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


    //@AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
