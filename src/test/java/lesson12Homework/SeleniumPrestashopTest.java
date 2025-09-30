package lesson12Homework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    //@Test    //Dodanie 3x produktu do koszyka  + walidacja
    @Order(10)
    public void addProductsToCart() {

        //Wybór 3 produktów
        By selectQuantityLocator = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
        WebElement selectQuantityClick = driver.findElement(selectQuantityLocator);
        selectQuantityClick.click();
        selectQuantityClick.click();
        selectQuantityClick.click();

        //Kliknij button dodaj do koszyka
        By addToCartButtonLocator = By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]");
        WebElement addTocartButtonClick = driver.findElement(addToCartButtonLocator);
        addTocartButtonClick.click();

        //potwierdzenie dodania do koszyka
        By addProductPopupLocator = By.id("myModalLabel");
        WebElement addProductPopup = driver.findElement(addProductPopupLocator);
        Assertions.assertTrue(addProductPopup.isDisplayed());
    }

    // @Test  //Koszyk + walidacja ilości produktów i ceny całkowitej
    @Order(11)
    public void cartContentValidation() {

        //zamknięcie popup dodania produktu i przejście do koszyka
        By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
        WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
        closeAddToCartPopupClick.click();

        //sprawdzenie nazwy produktów
        By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]");
        WebElement productNameInCart = driver.findElement(productNameInCartLocator);
        //TODO Assertions

        //porównanie ilości produktu z sekcji produktu i sekcji podsumowania zakupów
        //pobranie ilości z sekcji produktu
        By numberInItemsSectionLocator = By.xpath("//input[@class=\"js-cart-line-product-quantity form-control\"]");
        WebElement numberInItemSection = driver.findElement(numberInItemsSectionLocator);
        //pobranie ilości z sekcji podsumowania
        By numberInPurchaseSummarySection = By.xpath("//span[@class=\"label js-subtotal\"]");
        Assertions.assertEquals(numberInItemSection, numberInPurchaseSummarySection);

        //sprawdzenie wartości całkowitej
        //pobranie wartości całkowitej
        By totalItemsValueLocator = By.xpath("//div[@id=\"cart-subtotal-products\"]/span[@class=\"value\"]");
        WebElement totalItemsValue = driver.findElement(totalItemsValueLocator);
        //pobranie ceny jednostkowej
        By itemUnitPriceLocator = By.xpath("//span[@class=\"price\"]");
        WebElement itemUnitPrice = driver.findElement(itemUnitPriceLocator);
        //obliczenie
        //double expectedTotalPrice = numberInItemSection * itemUnitPrice;
        //sprawdzenie wartości całkowitej
        //Assertions.assertEquals(expectedTotalPrice,totalItemsValue);
    }

    //@Test   //Koszyk + zwiększenie ilości + walidacja ilości produktów i ceny całkowitej
    @Order(13)
    public void increasingNumberOfItems() {

        //zwiększenie liczby produktu w koszyku
        By selectQuantityLocator = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
        WebElement selectQuantityClick = driver.findElement(selectQuantityLocator);
        selectQuantityClick.click();
        selectQuantityClick.click();
        selectQuantityClick.click();
    }

    //@Test    //Formularz adresu – zapisanie pustego formularza + walidacja
    @Order(14)
    public void addressFormFailSendWithEmptyFields() {

    }

    //TODO - GOTOWE!
    //@Test   //Strona główna/Footer -  sprawdzenie działania linków w stopce
    @Order(27)
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
