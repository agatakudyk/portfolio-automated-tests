package lesson12Homework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test   //Strona główna/Footer -  sprawdzenie działania linków w stopce
    @Order(1)
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
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Legal Notice'
        By legalNoticeLinkLocator = By.id("link-cms-page-2-2");
        WebElement legalNoticeLink = driver.findElement(legalNoticeLinkLocator);
        legalNoticeLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Terms and conditions of use'
        By termsAndConditionsOfUseLinkLocator = By.id("link-cms-page-3-2");
        WebElement termsAndConditionsOfUseLink = driver.findElement(termsAndConditionsOfUseLinkLocator);
        termsAndConditionsOfUseLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'About us'
        By aboutUsLinkLocator = By.id("link-cms-page-4-2");
        WebElement aboutUsLink = driver.findElement(aboutUsLinkLocator);
        aboutUsLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Secure payment'
        By securePaymentLinkLocator = By.id("link-cms-page-5-2");
        WebElement securePaymentLink = driver.findElement(securePaymentLinkLocator);
        securePaymentLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Contact us'
        By contactUsLinkLocator = By.id("link-static-page-contact-2");
        WebElement contactUsLink = driver.findElement(contactUsLinkLocator);
        contactUsLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Sitemap'
        By sitemapLinkLocator = By.id("link-static-page-sitemap-2");
        WebElement sitemapLink = driver.findElement(sitemapLinkLocator);
        sitemapLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Stores'
        By storesLinkLocator = By.id("link-static-page-stores-2");
        WebElement storesLink = driver.findElement(storesLinkLocator);
        storesLink.click();
        //potwierdzenia wejscie na podstronę
        By ourStoresPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1");
        WebElement ourStoresPageName = driver.findElement();
        Assertions.assertTrue(ourStoresPageName.isDisplayed());

        //Kliknięcie w link 'Personal info'
        By personalInfoLinkLocator = By.xpath("//a[@title=\"Personal info\"]");
        WebElement personalInfoLink = driver.findElement(personalInfoLinkLocator);
        personalInfoLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Orders'
        By ordersLinkLocator = By.xpath("//a[@title=\"Orders\"]");
        WebElement ordersLink = driver.findElement(ordersLinkLocator);
        ordersLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Credit slips'
        By creditSlipsLinkLocator = By.xpath("//a[@title=\"Credit slips\"]");
        WebElement creditSlipsLink = driver.findElement(creditSlipsLinkLocator);
        creditSlipsLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w link 'Addresses'
        By addressesLinkLocator = By.xpath("//a[@title=\"Addresses\"]");
        WebElement addressesLink = driver.findElement(addressesLinkLocator);
        addressesLink.click();
        //ToDo potwierdzenie wejścia na podstronę

        //Kliknięcie w maila kontaktowego
        By mailLinkLocator = By.xpath("//a[contains(text(),\"prestashop@123.pl\")]");
        WebElement mailLink = driver.findElement(mailLinkLocator);
        mailLink.click();
        //ToDo potwierdzenie wejścia na podstronę
    }



    @Test   //zmiana języka z polskiego na angielski
    @Order(2)
    public void languageSwitchIntoEnglish() {

        By languageSwitchLocator = By.xpath("//button[@data-toggle=\"dropdown\"]");
        WebElement languageSwitchClick = driver.findElement(languageSwitchLocator);
        languageSwitchClick.click();

        //wybór języka English
        By englishLanguageLocator = By.xpath("//a[@data-iso-code=\"en\"]");
        WebElement englishLanguageSelection = driver.findElement(englishLanguageLocator);
        englishLanguageSelection.click();
    }


    //@Test  //Rejestracja: kliknięcie ‘Save’ przy pustym formularzu + walidacja
    @Order(3)
    public void failSignupWithEmptyFields() {

        //kliknięcie w przycisk logowania
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();

        //kliknięcie w link rejestracji
        By signupLocator = By.cssSelector("a[data-link-action=\"display-register-form\"]");
        WebElement signupLink = driver.findElement(signupLocator);
        signupLink.click();

        // kliknięcie buttona Save, zatwierdzenie formularza
        By saveLocator = By.cssSelector(".form-control-submit");
        WebElement saveButton = driver.findElement(saveLocator);
        saveButton.click();


        By nameInputLocator = By.id("field-firstname");
        WebElement nameInput = driver.findElement(nameInputLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String msg = (String) js.executeScript("return arguments[0].validationMessage", nameInput);
        Assertions.assertEquals("Wypełnij to pole.", msg);
    }


    //@Test  //Rejestracja: uzupełnienie formularza poprawnymi danymi + walidacja
    @Order(3)
    public void userSuccessSignup() {

        //uzupełnienie pola imię
        By nameLocator = By.id("field-firstname");
        WebElement nameInputField = driver.findElement(nameLocator);
        nameInputField.sendKeys("Jan");

        //uzupełnienie pola nazwisko
        By surnameLocator = By.id("field-lastname");
        WebElement surnameInputField = driver.findElement(surnameLocator);
        surnameInputField.sendKeys("Testerski");

        //uzupełnienie pola e-mail
        By mailLocator = By.id("field-email");
        WebElement mailInputField = driver.findElement(mailLocator);
        mailInputField.sendKeys("jan.testerski@wp.pl");

        //uzupełnienie pola hasło
        By passwordLocator = By.id("field-password");
        WebElement passwordInputField = driver.findElement(passwordLocator);
        passwordInputField.sendKeys("Testowo123");

        //checkbox informacji o przetwarzaniu danych osobowych
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
        policyInfoCheckbox.click();

        //akceptacja polityki prywatności
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
        privacyPolicyCheckbox.click();

        // kliknięcie buttona Save, zatwierdzenie formularza
        By saveLocator = By.cssSelector(".form-control-submit");
        WebElement saveButton = driver.findElement(saveLocator);
        saveButton.click();

        //sprawdzenie procesu rejestracji
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        Assertions.assertTrue(logoutButton.isDisplayed());
    }

    //@Test    //Wylogowanie użytkownika + walidacja
    @Order(4)
    public void userSuccessLogout() {

        //kliknięcie buttona wyloguj
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        logoutButton.click();

        //sprawdzenie poprawności wylogowania
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        Assertions.assertTrue(signInButton.isDisplayed());
    }

    //@Test
    @Order(5)    //Logowanie z użyciem błędnych danych + walidacja
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

        //TODO dodac klikcienie w zaloguj sie

        //sprawdzenie komunikatu o błędnym logowaniu
        By failMsgLocator = By.xpath("//li[@class=\"alert alert-danger\"]");
        WebElement failMessage = driver.findElement(failMsgLocator);
        Assertions.assertTrue(failMessage.isDisplayed());
    }

    //@Test  //Logowanie / funkcja odzyskiwania hasła + walidacja
    @Order(6)
    public void loginPasswordRecovery() {

        //kliknięcie w link przywracania hasła
        By passwordRecoveryLocator = By.xpath(" //div[@class=\"forgot-password\"]/a");
        WebElement passwordRecoveryLink = driver.findElement(passwordRecoveryLocator);
        passwordRecoveryLink.click();

        //wpisanie maila do odzyskania hasła
        By recoveryMailLocator = By.xpath("//input[@class=\"form-control\"]");
        WebElement recoveryEmailInputField = driver.findElement(recoveryMailLocator);
        recoveryEmailInputField.sendKeys("abc1.mail@wp.pl");

        //przycisk wyślij
        By passwordRecoveryButtonLocator = By.id("send-reset-link");
        WebElement passwordRecoveryButtonClick = driver.findElement(passwordRecoveryButtonLocator);
        passwordRecoveryButtonClick.click();

        //Potwierdzenie wysłania maila
        By sentMsgLocator = By.xpath("//li[@class=\"item\"]/p");
        WebElement sentMessage = driver.findElement(sentMsgLocator);
        Assertions.assertTrue(sentMessage.isDisplayed());
    }

    //@Test     //Poprawne zalogowanie + walidacja
    @Order(7)
    public void userSuccessLogin() {

        //przejście na stronę logowania
        By backToLoginPageLocator = By.xpath("//i[@class=\"material-icons\"]");
        WebElement backToLoginPageLink = driver.findElement(backToLoginPageLocator);
        backToLoginPageLink.click();

        //uzupełnienie pola email
        By emailLoginLocator = By.id("field-email");
        WebElement emailLoginInputField = driver.findElement(emailLoginLocator);
        emailLoginInputField.sendKeys("jan.testerski@wp.pl");

        //uzupełnienie hasła
        By passwordLoginLocator = By.id("field-password");
        WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
        passwordLoginInputField.sendKeys("password123");

        //kliknięcie buttona zaloguj
        By loginButtonLocator = By.id("submit-login");
        WebElement loginButtonClick = driver.findElement(loginButtonLocator);
        loginButtonClick.click();

        //sprawdzenie poprawności logowania
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        Assertions.assertTrue(logoutButton.isDisplayed());
    }

    //@Test //Podstrona Accessories/filtrowanie: Home Accessories + Ceramic + wyczyść wszystko + walidacja
    @Order(8)
    public void clearAccessoriesProductsFiltering() throws InterruptedException {

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

   // @Test    //Podstrona ART/filtrowanie: Black + walidacja
    @Order(9)
    public void filterArtProducts() {

        //wejdź w podstronę Art
        By artPageLocator = By.id("category-9");
        WebElement artPageLink = driver.findElement(artPageLocator);
        artPageLink.click();

        //wybranie 40x60cm w Dimension
        By graphicDimensionLocator = By.xpath("//a[contains(text(),\"40x60cm\")]");
        WebElement graphicDimensionCheckbox = driver.findElement(graphicDimensionLocator);
        graphicDimensionCheckbox.click();

        //TODO: sprawdzenie działania filtra
    }


    //@Test   //Wybranie produktu ‘The best is yet to come' + dodanie opinii + walidacja
    @Order(10)
    public void successAddPosterReview() {

        //wybranie produktu poster 'The Best Is Yet...'
        By theBestPosterLocator = By.xpath("//div[@class=\"highlighted-informations no-variants\"]");
        //By theBestPosterClick = driver.findElement(theBestPosterLocator);
        //theBestPosterClick.click();

        //dodanie opinii o produkcie
        By commentButtonLocator = By.xpath("//button[@class=\"btn btn-comment btn-comment-big post-product-comment\"]");
        WebElement commentButtonClick = driver.findElement(commentButtonLocator);
        commentButtonClick.click();

        //TODO - zaznacz gwiazdkę

        //dodaj tytuł opinii
        By commentTitleLocator = By.id("comment_title");
        WebElement commentTitleFillIn = driver.findElement(commentTitleLocator);
        commentTitleFillIn.sendKeys("A positive comment");

        //dodaj treść komentarza
        By commentTextLocator = By.id("comment_content");
        WebElement commentTextFillIn = driver.findElement(commentTextLocator);
        commentTextFillIn.sendKeys("Cute home decor to suit any room or home.");

        //przycisk send
        By sendButtonLocator = By.xpath("//button[@class=\"btn btn-comment btn-comment-big\"]");
        WebElement sendButtonClick = driver.findElement(sendButtonLocator);
        sendButtonClick.click();

        //potwierdzenie dodania komentarza
        By addCommentPopupLocator = By.id("product-comment-posted-modal-message");
        WebElement addCommentPopup = driver.findElement(addCommentPopupLocator);
        Assertions.assertTrue(addCommentPopup.isDisplayed());

        //zamknięcie popup
        By okCommentButtonLocator = By.xpath("//div[@class=\"post-comment-buttons\"]/button[@class=\"btn btn-comment-inverse btn-comment-huge refuse-button\"]");
        WebElement okCommentButtonClick = driver.findElement(okCommentButtonLocator);
        okCommentButtonClick.click();
    }

    //@Test    //Dodanie 3x produktu do koszyka  + walidacja
    @Order(11)
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

   // @Test  //Koszyk + walidacja ilości produktów i ceny całkowitejV
    @Order(12)
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

   // @Test    //Formularz adresu – zapisanie poprawnie uzupełnionego formularza
    @Order(15)
    public void addressFormSuccessSend() {

    }

//    @Test       //Wybór dostawy ‘My carrier’ + dodanie komentarza
    @Order(16)
    public void selectDeliveryMethod() {

    }

//    @Test    //wybór formy płatności + walidacja
    @Order(17)
    public void selectPaymentOption() {

    }

//    @Test    //Dokończenie zamówienia
    @Order(18)
    public void successProceedCheckout() {

    }

//    @Test   //Order history + sprawdzenie czy jest dokonane zamówienie
    @Order(19)
    public void viewItemsInOrderHistory() {

    }

    //@Test    //Order history + sprawdzenie szczegółów zamówienia
    @Order(20)
    public void viewOrderDetailsInOrderHistory() {

    }

    //@Test    //Order history + dodanie wiadomości
    @Order(21)
    public void addOrderMessageInOrderHistory() {

    }

    //@Test     //Reorder – edycja adresu + walidacja
   // @Order(22)

    //@AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
