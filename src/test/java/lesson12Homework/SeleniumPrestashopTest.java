package lesson12Homework;

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

import static io.qameta.allure.Allure.step;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumPrestashopTest {

    String emailCreateName = "testowianka274@wp.pl";
    static ChromeDriver driver;
    static WebDriverWait wait;


    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://localhost:8080/pl/");
    }


    @Test   //Home page - zmiana języka strony z polskiego na angielski
    @Order(1)
    public void languageSwitchIntoEnglish() {

        step("Home page - kliknięcie w dropdown-button, by rozwinąć listę z językami", ()->{
            By languageDropdownButtonLocator = By.xpath("//button[@data-toggle=\"dropdown\"]");
            WebElement languageSwitchClick = driver.findElement(languageDropdownButtonLocator);
            languageSwitchClick.click();});

        step("Home page/dropdown - kliknięcie opcji 'English' na rozwijanej liście języków", ()->{
            By englishLanguageSwitchLocator = By.xpath("//a[@data-iso-code=\"en\"]");
            WebElement englishLanguageSwitch = driver.findElement(englishLanguageSwitchLocator);
            englishLanguageSwitch.click();});

        step("Home page - potwierdzenie ustawienia języka angielskiego", ()->{
            By englishLanguageCheckLocator = By.xpath("//button[@data-toggle=\"dropdown\"]" +
                    "/span[contains(text(),\"English\")]");
            WebElement englishLanguageCheck = driver.findElement(englishLanguageCheckLocator);
            Assertions.assertTrue(englishLanguageCheck.isDisplayed());});
    }


    @Test     //Użytkownik niezarejestrowany - dodanie produktu do wishlist, dodanie i usunięcie z koszyka
    @Order(2)
    public void addToCartAndDeleteProductByUnregisteredUser() {

        step("Unregistered user - kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'", ()->{
            By heartButtonOfTodayIsAGoodDayFramedPosterLocator = By.xpath(
                    "//a[contains(text(),\"Today is a good day Framed\")]" +
                            "/../../../button[@class=\"wishlist-button-add\"]");
            WebElement heartButtonOfTodayIsAGoodDayPoster = driver.findElement(heartButtonOfTodayIsAGoodDayFramedPosterLocator);
            heartButtonOfTodayIsAGoodDayPoster.click();});

        step("Potwierdzenie pojawienia się popupu z komunikatem walidacyjnym", ()->{
            By loginRequiredMsgLocator = By.xpath("//p[contains(text(),\"You need to be logged in to " +
                    "save products in your wishlist.\")]");
            WebElement loginRequiredMsg = driver.findElement(loginRequiredMsgLocator);
            Assertions.assertTrue(loginRequiredMsg.isDisplayed());});

        step("Zamknięcie okna z komunikatem - kliknięcie w button 'Cancel'", ()->{
            By cancelPopupButtonLocator = By.xpath("//a[contains(text(),\"Sign in\")]" +
                    "/../button[contains(text(),\"Cancel\")]");
            WebElement cancelPopupButton = driver.findElement(cancelPopupButtonLocator);
            cancelPopupButton.click();});

        step("Wejście na stronę produktu 'Today is a good day Framed Poster'", ()->{
            By openTodayIsAGoodDayFramedPosterLocator = By.xpath("//a[@class=\"thumbnail product-thumbnail\"]" +
                    "/img[@alt=\"Today is a good day Framed poster\"]");
            WebElement openTodayIsAGoodDayFramedPoster = driver.findElement(openTodayIsAGoodDayFramedPosterLocator);
            openTodayIsAGoodDayFramedPoster.click();});

        step("Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'", ()->{
            By addToCartButtonLocator = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
            WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
            addToCartButton.click();});

        step("Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym pomyślne dodanie", ()->{
            By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to " +
                    "your shopping cart\")]");
            wait.until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
            WebElement addProductPopup = driver.findElement(addProductPopupLocator);
            Assertions.assertTrue(addProductPopup.isDisplayed());});

        step("Zamknięcie okna popup - kliknięcie w button 'Proceed to checkout'", ()->{
            By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
            WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
            closeAddToCartPopupClick.click();});

        step("Shopping cart - sprawdzenie zgodności nazwy produktu w koszyku", ()->{
            By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]" +
                    "/a[contains(text(),\"Today is a good day Framed poster\")]");
            String productNameInCart = driver.findElement(productNameInCartLocator).getText();
            Assertions.assertEquals("Today is a good day Framed poster", productNameInCart);});

        step("Shopping cart - usunięcie produktu z koszyka", ()->{
            By trashIconLocator = By.xpath("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]");
            WebElement trashIcon = driver.findElement(trashIconLocator);
            trashIcon.click();});

        step("Shopping cart - potwierdzenie pojawienia się komunikatu, że koszyk jest pusty", ()->{
            By emptyCartMsgLocator = By.xpath("//span[contains(text(),\"There are no more items in your cart\")]");
            wait.until(ExpectedConditions.elementToBeClickable(emptyCartMsgLocator));
            WebElement emptyCartMsg = driver.findElement(emptyCartMsgLocator);
            Assertions.assertTrue(emptyCartMsg.isDisplayed());});
    }


    @Test     //Użytkownik niezarejestrowany - dodanie produktu do koszyka i finalizacja zakupu
    @Order(3)
    public void addProductToCartAndCheckoutByUnregisteredUser() {

        step("Shopping cart - przejcie z koszyka na stronę główną", ()->{
            By homepageLinkLocator = By.id("_desktop_logo");
            WebElement homepageLink = driver.findElement(homepageLinkLocator);
            homepageLink.click();});

        step("Home page - wejście w okno produktu 'Today is a good day Framed Poster'", ()->{
            By openTodayIsaGoodDayFramedPosterLocator = By.xpath("//img[@alt=\"Today is a good day Framed poster\"]");
            WebElement openTodayIsaGoodDayFramedPoster = driver.findElement(openTodayIsaGoodDayFramedPosterLocator);
            openTodayIsaGoodDayFramedPoster.click();});

        step("Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'", ()->{
            By addToCartButtonLocator = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
            WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
            addToCartButton.click();});

        step("Zamknięcie okna popup - kliknięcie w button 'Proceed to checkout'", ()->{
            By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]" +
                    "//i[@class=\"material-icons rtl-no-flip\"]");
            wait.until(ExpectedConditions.elementToBeClickable(closeAddToCartPopupLocator));
            WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
            closeAddToCartPopupClick.click();});

        step("Shopping cart - kliknięcie w button 'Proceed to checkout'", ()->{
            By proceedToCheckoutButtonLocator = By.xpath("//a[contains(text(),\"Proceed to checkout\")]");
            WebElement proceedToCheckoutButton = driver.findElement(proceedToCheckoutButtonLocator);
            proceedToCheckoutButton.click();});

        step("Personal Information - uzupełnienie pola 'First name'", ()->{
            By firstNameFieldLocator = By.id("field-firstname");
            WebElement firstNameField = driver.findElement(firstNameFieldLocator);
            firstNameField.sendKeys("Tomasz");});

        step("Personal Information - uzupełnienie pola 'Last name'", ()->{
            By lastNameFieldLocator = By.id("field-lastname");
            WebElement lastNameField = driver.findElement(lastNameFieldLocator);
            lastNameField.sendKeys("Kot");});

        step("Personal Information - uzupełnienie pola 'Email'", ()->{
            By emailFieldLocator = By.id("field-email");
            WebElement emailField = driver.findElement(emailFieldLocator);
            emailField.sendKeys("kot123@wp.pl");});

        step("Personal Information - checkbox zgody na przetwarzanie danych osobowych", ()->{
            By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
            WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
            policyInfoCheckbox.click();});

        step("Personal Information - checkbox akceptacji regulaminu i polityki prywatności", ()->{
            By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
            WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
            privacyPolicyCheckbox.click();});

        step("Personal Information - przejście do 'Addresses' poprzez kliknięcie w button 'Continue'", ()->{
            By continueButtonLocator = By.xpath("//section[@id=\"checkout-personal-information-step\"]" +
                    "//button[@type=\"submit\"]");
            WebElement continueButton = driver.findElement(continueButtonLocator);
            continueButton.click();});

        step("Addresses - uzupełnienie pola 'Address'", ()->{
            By addressFieldLocator = By.id("field-address1");
            WebElement addressField = driver.findElement(addressFieldLocator);
            addressField.sendKeys("ul. Jaskrawa 23");});

        step("Addresses - uzupełnienie pola 'Zip/Postal Code'", ()->{
            By postalCodeFieldLocator = By.id("field-postcode");
            WebElement postalCodeField = driver.findElement(postalCodeFieldLocator);
            postalCodeField.sendKeys("11-788");});

        step("Addresses - uzupełnienie pola 'City'", ()->{
            By cityFieldLocator = By.id("field-city");
            WebElement cityField = driver.findElement(cityFieldLocator);
            cityField.sendKeys("Koszalin");});

        step("Addresses - przejście do 'Shipping Method' poprzez kliknięcie w button 'Continue'", ()->{
            By adreessContinuseLocator = By.xpath("//section[@id=\"checkout-addresses-step\"]" +
                    "//button[@type=\"submit\"]");
            WebElement adreessContinuse = driver.findElement(adreessContinuseLocator);
            adreessContinuse.click();});

        step("Shipping Method - przejście do 'Payment' poprzez kliknięcie w button 'Continue'", ()->{
            By continueButtonShippingMethodLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
            WebElement continueButtonShippingMethod = driver.findElement(continueButtonShippingMethodLocator);
            continueButtonShippingMethod.click();});

        step("Payment - wybór opcji 'Pay by bank wire'", ()->{
            By payByBankWireRadioButtonLocator = By.id("payment-option-2");
            WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
            payByBankWireRadioButton.click();});

        step("Payment -  wybór checkboxa zgody", ()->{
            By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
            WebElement agreeToTermsCheckbox = driver.findElement(agreeToTermsCheckboxLocator);
            agreeToTermsCheckbox.click();});

        step("Payment - przejście na 'Order confirmation page' poprzez kliknięcie w button 'Place Order'", ()->{
            By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
            WebElement placeOrderButtonInPaymentSection = driver.findElement(placeOrderButtonInPaymentSectionLocator);
            placeOrderButtonInPaymentSection.click();});

        step("Order confirmation page - potwierdzenie pojawienia się komunikatu potwierdzającego", ()->{
            By confirmationMsgLocator = By.xpath("//h3[@class=\"h1 card-title\"]/i");
            WebElement confirmationMsg = driver.findElement(confirmationMsgLocator);
            Assertions.assertTrue(confirmationMsg.isDisplayed());});
    }


    @Test     //Order confirmation page - uzupełnienie formularza ‘Save time on your next order, sign up now’
    @Order(4)
    public void signUpNowFillInFormByUnregisteredUser() {

        step("‘Save time on...' form - kliknięcie w button 'Save'", ()->{
            By saveButtonLocator = By.xpath("//button[contains(text(),\"Save\")]");
            WebElement saveButton = driver.findElement(saveButtonLocator);
            saveButton.click();});

        step("Tooltip dynamiczny- potwierdzenie pojawienia się dymka z komunikatem walidacyjnym", ()->{
            By firstNameFieldLocator = By.id("field-firstname");
            WebElement firstNameField = driver.findElement(firstNameFieldLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String msg = (String) js.executeScript("return arguments[0].validationMessage", firstNameField);
            Assertions.assertEquals("Wypełnij to pole.", msg);});

        step("‘Save time on...' form - uzupełnienie pola 'First name'", ()->{
            By firstNameFieldLocator = By.id("field-firstname");
            WebElement firstNmaeField = driver.findElement(firstNameFieldLocator);
            firstNmaeField.sendKeys("Tomasz");});

        step("‘Save time on...' form - uzupełnienie pola 'Last name'", ()->{
            By lastNameFieldLocator = By.id("field-lastname");
            WebElement lastNameField = driver.findElement(lastNameFieldLocator);
            lastNameField.sendKeys("Kot");});

        step("‘Save time on...' form - uzupełnienie pola 'Email'", ()->{
            By emailFieldLocator = By.id("field-email");
            WebElement mailField = driver.findElement(emailFieldLocator);
            mailField.sendKeys("kot123@wp.pl");});

        step("‘Save time on...' form - uzupełnienie pola 'Password'", ()->{
            By passwordFieldLocator = By.id("field-password");
            WebElement passwordField = driver.findElement(passwordFieldLocator);
            passwordField.sendKeys("Mojehaslo123");});

        step("‘Save time on...' form - kliknięcie w checkbox zgody na przetwarzanie danych osobowych", ()->{
            By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
            WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
            policyInfoCheckbox.click();});

        step("‘Save time on...' form - kliknięcie w checkbox akceptacji regulaminu i polityki prywatności", ()->{
            By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
            WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
            privacyPolicyCheckbox.click();});

        step("Zapisanie danych poprzez kliknięcie w button 'Save'", ()->{
            By saveButtonLocator = By.xpath("//button[contains(text(),\"Save\")]");
            WebElement saveButton = driver.findElement(saveButtonLocator);
            saveButton.click();});
    }


    @Test  //Niepoprawna rejestracja przy pomocy pustego formularza
    @Order(5)
    public void failSignupWithEmptyFields() {

        step("Login page - kliknięcie w link rejestracji", ()->{
            By signupLocator = By.cssSelector("a[data-link-action=\"display-register-form\"]");
            WebElement signupLink = driver.findElement(signupLocator);
            signupLink.click();});

        step("Create account page - kliknięcie w button 'Save'", ()->{
            By saveLocator = By.cssSelector(".form-control-submit");
            WebElement saveButton = driver.findElement(saveLocator);
            saveButton.click();});

        step("Create account page/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu", ()->{
            By nameInputLocator = By.id("field-firstname");
            WebElement nameInput = driver.findElement(nameInputLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String msg = (String) js.executeScript("return arguments[0].validationMessage", nameInput);
            Assertions.assertEquals("Wypełnij to pole.", msg);});
    }


    @Test  //Poprawna rejestracja użytkownika
    @Order(6)
    public void userSuccessSignup() {

        step("Create account page - uzupełnienie pola 'First name'", ()->{
            By nameLocator = By.id("field-firstname");
            WebElement nameInputField = driver.findElement(nameLocator);
            nameInputField.sendKeys("Anna");});

        step("Create account page - uzupełnienie pola 'Last name'", ()->{
            By surnameLocator = By.id("field-lastname");
            WebElement surnameInputField = driver.findElement(surnameLocator);
            surnameInputField.sendKeys("Testowianka");});

        step("Create account page - uzupełnienie pola 'Email'", ()->{
            By mailLocator = By.id("field-email");
            WebElement mailInputField = driver.findElement(mailLocator);
            mailInputField.sendKeys(emailCreateName);});

        step("Create Account Page - uzupełnienie pola 'Password'", ()->{
            By passwordLocator = By.id("field-password");
            WebElement passwordInputField = driver.findElement(passwordLocator);
            passwordInputField.sendKeys("Password123");});

        step("Create Account Page - kliknięcie w checkbox informacji o przetwarzaniu danych osobowych", ()->{
            By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
            WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
            policyInfoCheckbox.click();});

        step("Create Account Page - kliknięcie w checkbox akceptacji polityki prywatności", ()->{
            By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
            WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
            privacyPolicyCheckbox.click();});

        step("Create Account Page - kliknięcie w button 'Save'", ()->{
            By saveLocator = By.cssSelector(".form-control-submit");
            WebElement saveButton = driver.findElement(saveLocator);
            saveButton.click();});

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", ()->{
            By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
            WebElement logoutButton = driver.findElement(logoutLocator);
            Assertions.assertTrue(logoutButton.isDisplayed());});

        step("Wylogowanie użytkownika z potwierdzeniem pomyślnego wylogowania", this::userSuccessLogout);
    }


    private void userSuccessLogout() {

        //Kliknięcie w button 'Sign out'
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        WebElement logoutButton = driver.findElement(logoutLocator);
        logoutButton.click();

        //Sprawdzenie pomyślnego wylogowania - widoczność przycisku 'Sign in'
        By signInLocator = By.cssSelector(".user-info a");
        WebElement signInButton = driver.findElement(signInLocator);
        Assertions.assertTrue(signInButton.isDisplayed());
    }


    @Test
    @Order(7)    //Niepoprawne logowanie z użyciem pustych pól i błędnych danych
    public void failLoginWithIncorrectData() {

        step("Header - kliknięcie w button 'Sign In'", ()->{
            By signInLocator = By.cssSelector(".user-info a");
            WebElement signInButton = driver.findElement(signInLocator);
            signInButton.click();});

        step("Login page - kliknięcie w button 'Sign In'", ()->{
            By loginButtonLocator = By.id("submit-login");
            WebElement loginButtonClick = driver.findElement(loginButtonLocator);
            loginButtonClick.click();});

        step("Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu", ()->{
            By emailInputLocator = By.id("field-email");
            WebElement emailInput = driver.findElement(emailInputLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String msg = (String) js.executeScript("return arguments[0].validationMessage", emailInput);
            Assertions.assertEquals("Wypełnij to pole.", msg);});

        step("Login page - uzupełnienie pola 'Email'", ()->{
            By emailInputLocator = By.id("field-email");
            WebElement emailInput = driver.findElement(emailInputLocator);
            emailInput.sendKeys("blablabla@wp.pl");});

        step("Login page - uzupełnienie pola 'Password'", ()->{        //uzupełnienie hasła
            By passwordLoginLocator = By.id("field-password");
            WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
            passwordLoginInputField.sendKeys("blepassword");});

        step("Login page - kliknięcie w button 'Sign In'", ()->{
            By loginButtonLocator = By.id("submit-login");
            WebElement loginButtonClick = driver.findElement(loginButtonLocator);
            loginButtonClick.click();});

        step("Login page - sprawdzenie komunikatu o błędnym uwierzytelnieniu", ()->{
            By failMsgLocator = By.xpath("//li[@class=\"alert alert-danger\"]");
            WebElement failMessage = driver.findElement(failMsgLocator);
            Assertions.assertTrue(failMessage.isDisplayed());
        });
    }

    @Test  //Login page - zresetowanie zapomnianego hasła
    @Order(8)
    public void loginPasswordRecovery() {

        step("Login page - kliknięcie w link 'Forgot your password?'", ()->{
            By passwordRecoveryLocator = By.xpath(" //div[@class=\"forgot-password\"]/a");
            WebElement passwordRecoveryLink = driver.findElement(passwordRecoveryLocator);
            passwordRecoveryLink.click();});

        step("Reset password page - uzupełnienie pola 'Email address'", ()->{
            By recoveryMailLocator = By.xpath("//input[@class=\"form-control\"]");
            WebElement recoveryEmailInputField = driver.findElement(recoveryMailLocator);
            recoveryEmailInputField.sendKeys("test.mail@wp.pl");});

        step("Reset password page - kliknięcie w button 'Send reset link'", ()->{
            By passwordRecoveryButtonLocator = By.id("send-reset-link");
            WebElement passwordRecoveryButtonClick = driver.findElement(passwordRecoveryButtonLocator);
            passwordRecoveryButtonClick.click();});

        step("Reset password page - sprawdzenie komunikatu potwierdzającego wysłanie maila", ()->{
            By sentMsgLocator = By.xpath("//li[@class=\"item\"]/p");
            WebElement sentMessage = driver.findElement(sentMsgLocator);
            Assertions.assertTrue(sentMessage.isDisplayed());});
    }

    @Test     //Poprawne zalogowanie  + zmiana hasła + zalogowanie nowym hasłem
    @Order(9)
    public void userSuccessLogin() {

        step("Reset password page - kliknięcie w link 'Back to Login'", ()->{
            By backToLoginPageLocator = By.xpath("//i[@class=\"material-icons\"]");
            WebElement backToLoginPageLink = driver.findElement(backToLoginPageLocator);
            backToLoginPageLink.click();});

        step("Login page - uzupełnienie pola 'Email'", ()->{
            By emailLoginLocator = By.id("field-email");
            WebElement emailLoginInputField = driver.findElement(emailLoginLocator);
            emailLoginInputField.sendKeys(emailCreateName);});

        step("Login page - uzupełnienie pola 'Password'", ()->{
            By passwordLoginLocator = By.id("field-password");
            WebElement passwordLoginInputField = driver.findElement(passwordLoginLocator);
            passwordLoginInputField.sendKeys("Password123");});

        step("Login page - kliknięcie w button 'Sign In'", ()->{
            By loginButtonLocator = By.id("submit-login");
            WebElement loginButtonClick = driver.findElement(loginButtonLocator);
            loginButtonClick.click();});

        step("Sprawdzenie pomyślnego zalogowania - widoczność przycisku 'Sign out'", ()->{
            By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
            WebElement logoutButton = driver.findElement(logoutLocator);
            Assertions.assertTrue(logoutButton.isDisplayed());});

        step("Your account - kliknięcie w link 'Information'", ()->{
            By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
            WebElement informationPage = driver.findElement(informationPageLocator);
            informationPage.click();});

        step("Your personal information - uzupełnienie pola 'Password' / dotychczasowe hasło", ()->{
            By currentPasswordFieldLocator = By.id("field-password");
            WebElement currentPasswordField = driver.findElement(currentPasswordFieldLocator);
            currentPasswordField.sendKeys("Password123");});

        step("Your personal information - uzupełnienie pola 'New password' / nowe hasło", ()->{
            By newPasswordFieldLocator = By.xpath("//input[@name=\"new_password\"]");
            WebElement newPasswordField = driver.findElement(newPasswordFieldLocator);
            newPasswordField.sendKeys("TestTest123");});

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", ()->{
            By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
            WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
            privacyPolicyCheckbox.click();});

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", ()->{
            By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
            WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
            policyInfoCheckbox.click();});

        step("Your personal information - kliknięcie w button 'Save'", ()->{
            By informationSaveButtonLocator = By.xpath(
                    "//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]");
            WebElement informationSaveButton = driver.findElement(informationSaveButtonLocator);
            informationSaveButton.click();});

        step("Your personal information - potwierdzenie pojawienia się komunikatu", ()->{
            By updatedInformationTextLocator = By.xpath("//ul/li[contains(text()," +
                    "\"Information successfully updated.\")]");
            WebElement updatedInformationText = driver.findElement(updatedInformationTextLocator);
            Assertions.assertTrue(updatedInformationText.isDisplayed());});

        step("Wylogowanie użytkownika z potwierdzeniem poprawności wylogowania", this::userSuccessLogout);

        step("Login page - uzupełnienie pola email", ()->{
            By emailLoginLocatorNew = By.id("field-email");
            WebElement emailLoginInputFieldNew = driver.findElement(emailLoginLocatorNew);
            emailLoginInputFieldNew.sendKeys(emailCreateName);});

        step("Login page - uzupełnienie nowego hasła", ()->{
            By passwordLoginLocatorNew = By.id("field-password");
            WebElement passwordLoginInputFieldNew = driver.findElement(passwordLoginLocatorNew);
            passwordLoginInputFieldNew.sendKeys("TestTest123");});

        step("Login page - kliknięcie w button 'Sign In'", ()->{
            By loginButtonLocatorNew = By.id("submit-login");
            WebElement loginButtonClickNew = driver.findElement(loginButtonLocatorNew);
            loginButtonClickNew.click();});

        step("Sprawdzenie poprawności zalogowania użytkownika - widoczność przycisku 'Sign out", ()->{
            By logoutLocatorNew = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
            WebElement logoutButtonNew = driver.findElement(logoutLocatorNew);
            Assertions.assertTrue(logoutButtonNew.isDisplayed());});

        step("przywrócenie starego hasła", this::backToPreviousPassword);
    }


    private void backToPreviousPassword() {

        step("Wejście w panel zalogowanego uzytkownika", ()->{
            By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
            WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
            userProfileLink.click();});

        step("Wejście na podstronę 'Information'", ()->{
            By informationPageLocator = By.xpath("//a[@id=\"identity-link\"]");
            WebElement informationPage = driver.findElement(informationPageLocator);
            informationPage.click();});

        step("wpisanie aktualnego hasła logowania", ()->{
            By currentPasswordFieldLocator = By.id("field-password");
            WebElement currentPasswordField = driver.findElement(currentPasswordFieldLocator);
            currentPasswordField.sendKeys("TestTest123");});

        step("wpisanie nowego hasła logowania", ()->{
            By newPasswordFieldLocator = By.xpath("//input[@name=\"new_password\"]");
            WebElement newPasswordField = driver.findElement(newPasswordFieldLocator);
            newPasswordField.sendKeys("Password123");});

        step("checkbox akceptacji polityki prywatności", ()->{
            By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
            WebElement privacyPolicyCheckbox = driver.findElement(privacyPolicyLocator);
            privacyPolicyCheckbox.click();});

        step("checkbox informacji o przetwarzaniu danych osobowych", ()->{
            By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
            WebElement policyInfoCheckbox = driver.findElement(policyInfoLocator);
            policyInfoCheckbox.click();});

        step("kliknięcie buttona 'Save'", ()->{
            By informationSaveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit " +
                    "float-xs-right\"]");
            WebElement informationSaveButton = driver.findElement(informationSaveButtonLocator);
            informationSaveButton.click();});
    }


    @Test //Podstrona Accessories - filtrowanie
    @Order(10)
    public void clearAccessoriesProductsFiltering() {

        step("Przejście na podstronę ACCESSORIES", ()->{
            By accessoriesPageLocator = By.id("category-6");
            WebElement accessoriesPageLink = driver.findElement(accessoriesPageLocator);
            accessoriesPageLink.click();});

        step("Accessories page - wybór filtra 'Ceramic'", ()->{
            By ceramicCompositionFilterLocator = By.xpath("//a[contains(text(),\"Ceramic\")]");
            WebElement ceramicCompositionFilterCheckbox = driver.findElement(ceramicCompositionFilterLocator);
            ceramicCompositionFilterCheckbox.click();
            By ceramicCompositionFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Ceramic\")]/../span/input");
            wait.until(ExpectedConditions.elementToBeSelected(ceramicCompositionFilterCheckboxLocator));});

        step("Accessories page - wybór filtra 'Available'", ()->{
            By availableFilterLocator = By.xpath("//a[contains(text(),\"Available\")]");
            WebElement availableFilterCheckbox = driver.findElement(availableFilterLocator);
            availableFilterCheckbox.click();
            By availableFilterCheckboxLocator = By.xpath("//a[contains(text(),\"Available\")]/../span/input");
            wait.until(ExpectedConditions.elementToBeSelected(availableFilterCheckboxLocator));});

        step("Accessories page - wyczyszczenie wybranych filtrów", ()->{
            By clearAllFilterLocator = By.xpath("//button[@class=\"btn btn-tertiary js-search-filters-clear-all\"]");
            WebElement clearAllFilterClick = driver.findElement(clearAllFilterLocator);
            clearAllFilterClick.click();
            wait.until(ExpectedConditions.invisibilityOf(clearAllFilterClick));});

        step("Accessories page - potwierdzenie wyczyszczenia filtrów", ()->{
            By activeFiltersLocator = By.xpath("//p[contains(text(),\"Active filters\")]");
            WebElement activeFilters = driver.findElement(activeFiltersLocator);
            Assertions.assertFalse(activeFilters.isDisplayed());});
    }


    @Test    //Podstrona ART - sortowanie
    @Order(11)
    public void filterArtProducts() throws InterruptedException {

        step("Przejście na podstronę ART", ()->{
            By artPageLocator = By.id("category-9");
            WebElement artPageLink = driver.findElement(artPageLocator);
            artPageLink.click();
            Thread.sleep(1000);});

        step("Podstrona ART - kliknięcie w pole sortowania", ()->{
            By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
            WebElement sorByList = driver.findElement(sortByListLocator);
            sorByList.click();});

        step("Podstrona ART - posortowanie według 'Name, A to Z'", ()->{
            By sortByNameAZLocator = By.xpath("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"Name, A to Z\")]");
            WebElement sortByNameAZ = driver.findElement(sortByNameAZLocator);
            sortByNameAZ.click();
            Thread.sleep(1000);});

        step("Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", ()->{
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
        });

        step("Podstrona ART - kliknięcie w pole sortowania", ()->{
            By sortByListLocator = By.xpath("//button[@aria-label=\"Sort by selection\"]");
            WebElement sortByList = driver.findElement(sortByListLocator);
            sortByList.click();
            Thread.sleep(1000);});

        step("Podstrona ART - posortowanie według ‘Price, low to high’", ()->{
            By sortByPriceAscLocator = By.xpath("//div[@class=\"dropdown-menu\"]" +
                    "/a[contains(text(),\"Price, low to high\")]");
            WebElement sortByPriceAsc = driver.findElement(sortByPriceAscLocator);
            sortByPriceAsc.click();
            Thread.sleep(1000);});

        step("Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", ()->{
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
        });
    }


    @Test   //Podstrona ART - dodanie opinii o produkcie
    @Order(12)
    public void successAddPosterReview() {

        step("Podstrona ART - wejście w okno produktu 'The Best Is Yet...'", ()->{
            By theBestPosterLocator = By.xpath("//img[@alt=\"The best is yet to come' Framed poster\"]");
            WebElement theBestPoster = driver.findElement(theBestPosterLocator);
            theBestPoster.click();});

        step("Strona produktu - kliknięcie w button dodania opinii o produkcie", ()->{
            By commentButtonLocator = By.xpath("//div[@class=\"product-comment-list-item\"]/button");
            WebElement commentButtonClick = driver.findElement(commentButtonLocator);
            wait.until(ExpectedConditions.elementToBeClickable(commentButtonLocator));
            commentButtonClick.click();});

        step("WRITE YOUR REVIEW - wpisanie tytułu komentarza", ()->{
            By commentTitleLocator = By.id("comment_title");
            WebElement commentTitleFillIn = driver.findElement(commentTitleLocator);
            wait.until(ExpectedConditions.elementToBeClickable(commentTitleFillIn));
            commentTitleFillIn.sendKeys("Moja ocena produktu");});

        step("WRITE YOUR REVIEW - wpisanie treści komentarza", ()->{
            By commentTextLocator = By.id("comment_content");
            WebElement commentTextFillIn = driver.findElement(commentTextLocator);
            commentTextFillIn.sendKeys("To bardzo dobry produkt.");});

        step("WRITE YOUR REVIEW - kliknięcie w button 'Send'", ()->{
            By sendButtonLocator = By.xpath("//button[@class=\"btn btn-comment btn-comment-big\"]");
            WebElement sendButtonClick = driver.findElement(sendButtonLocator);
            sendButtonClick.click();});

        step("Popup REVIEW SENT - potwierdzenie dodania komentarza", ()->{
            By addCommentPopupLocator = By.id("product-comment-posted-modal-message");
            WebElement addCommentPopup = driver.findElement(addCommentPopupLocator);
            wait.until(ExpectedConditions.elementToBeClickable(addCommentPopupLocator));
            Assertions.assertTrue(addCommentPopup.isDisplayed());});

        step("Popup REVIEW SENT - zamknięcie okna poprzez kliknięcie w button 'OK'", ()->{
            By okCommentButtonLocator = By.xpath(
                    "//div[contains(text(), \"Your comment has been submitted and will be available once " +
                            "approved by a moderator.\")]/../div[@class=\"post-comment-buttons\"]" +
                            "/button[@class=\"btn btn-comment btn-comment-huge\"]");
            WebElement okCommentButtonClick = driver.findElement(okCommentButtonLocator);
            okCommentButtonClick.click();});
    }


    @Test    //Strona produktu - zwiększenie ilości produktu i dodanie do koszyka
    @Order(13)
    public void addProductsToCart() {

        step("Strona produktu - zmiana ilości produktu poprzez wpisanie liczby (wyczyść i wpisz wartość)", ()->{
            By putProductQuantityLocator = By.id("quantity_wanted");
            WebElement putProductQuantity = driver.findElement(putProductQuantityLocator);
            putProductQuantity.sendKeys(Keys.CONTROL + "a");
            putProductQuantity.sendKeys(Keys.DELETE);
            putProductQuantity.sendKeys("4");});

        step("Strona produktu - zmiana ilości produktu poprzez kliknięcie w strzałki", ()->{
            By selectQuantityLocator = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
            WebElement selectQuantityClick = driver.findElement(selectQuantityLocator);
            selectQuantityClick.click();
            selectQuantityClick.click();
            selectQuantityClick.click();});

        step("Strona produktu - kliknięcie button 'Add to cart'", ()->{
            By addToCartButtonLocator = By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]");
            WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
            addToCartButton.click();});

        step("Popup - sprawdzenie komunikatu potwierdzającego dodanie do koszyka", ()->{
            By addProductPopupLocator = By.xpath("//h4[contains(text(),\"Product successfully added to " +
                    "your shopping cart\")]");
            wait.until(ExpectedConditions.elementToBeClickable(addProductPopupLocator));
            WebElement addProductPopup = driver.findElement(addProductPopupLocator);
            Assertions.assertTrue(addProductPopup.isDisplayed());});
    }


    @Test  //Koszyk - sprawdzenie zawartości
    @Order(14)
    public void cartContentValidation() {

        step("Popup - zamknięcie okna poprzez kliknięcie 'Proceed to checkout'", ()->{
            By closeAddToCartPopupLocator = By.xpath("//a[@class=\"btn btn-primary\"]/i");
            WebElement closeAddToCartPopupClick = driver.findElement(closeAddToCartPopupLocator);
            closeAddToCartPopupClick.click();});

        step("Shopping cart - sprawdzenie nazwy produktu", ()->{
            By productNameInCartLocator = By.xpath("//div[@class=\"product-line-info\"]/a");
            String productNameInCart = driver.findElement(productNameInCartLocator).getText();
            Assertions.assertEquals("The best is yet to come' Framed poster", productNameInCart);});

        step("Shopping cart - porównanie ilości z sekcji produktu i sekcji podsumowania", ()->{
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
            Assertions.assertEquals(productQuantity, summaryQuantity);});

        step("Shopping cart - sprawdzenie wartości całkowitej", ()->{
            //cena jednostkowa
            By unitPriceOfItemLocator = By.xpath("//div[@class=\"product-line-info product-price h5 \"]" +
                    "/div[@class=\"current-price\"]");
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
            Assertions.assertEquals(totalPrice, expectedTotal);});
    }


    @Test    //Zapisanie danych w formularzu adresu
    @Order(15)
    public void addressesFormFailSaveWithEmptyFields() {

        step("Shopping cart - przejście do adresu klikając button 'Proceed To Checkout'", ()->{
            By proceedToCheckoutButtonInCartLocator = By.xpath("//a[@class=\"btn btn-primary\" and " +
                    "text()=\"Proceed to checkout\"]");
            WebElement proceedToCheckoutButtonInCart = driver.findElement(proceedToCheckoutButtonInCartLocator);
            proceedToCheckoutButtonInCart.click();});

        step("Addresses - kliknięcie w button 'Continue'", ()->{
            By continueButtonInAddressesFormLocator = By.xpath("//button[@name=\"confirm-addresses\" and " +
                    "contains(., \"Continue\")]");
            WebElement continueButtonInAddressesForm = driver.findElement(continueButtonInAddressesFormLocator);
            continueButtonInAddressesForm.click();});

        step("Addresses/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego", ()->{
            By addressesInputLocator = By.xpath("//input[@name=\"address1\"]");
            WebElement addressesInput = driver.findElement(addressesInputLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String msg = (String) js.executeScript("return arguments[0].validationMessage", addressesInput);
            Assertions.assertEquals("Wypełnij to pole.", msg);});

        step("Addresses - uzupełnienie pola 'Address'", ()->{
            By addressFieldLocator = By.id("field-address1");
            WebElement addressField = driver.findElement(addressFieldLocator);
            addressField.sendKeys("ul. Prosta 11");});

        step("Addresses - uzupełnienie pola 'Zip/Postal Code'", ()->{
            By postalCodeFieldLocator = By.id("field-postcode");
            WebElement postalCodeField = driver.findElement(postalCodeFieldLocator);
            postalCodeField.sendKeys("11-234");});

        step("Addresses - uzupełnienie pola 'City'", ()->{
            By cityFieldLocal = By.id("field-city");
            WebElement cityField = driver.findElement(cityFieldLocal);
            cityField.sendKeys("Warszawa");});

        step("Addresses - kliknięcie w button 'Continue'", ()->{
            By continueButtonInAddressesFormLocator = By.xpath("//button[@name=\"confirm-addresses\" and " +
                    "contains(., \"Continue\")]");
            WebElement continueButtonInAddressesForm = driver.findElement(continueButtonInAddressesFormLocator);
            continueButtonInAddressesForm.click();});
    }


    @Test   //Shipping method - wybór formy dostawy
    @Order(16)
    public void shippingMethodSuccessSelection() {

        step("Shipping method - wybranie formy dostawy 'My carrier'", ()->{
            By prestaShopRadioButtonLocator = By.id("delivery_option_2");
            WebElement prestaShopRadioButton = driver.findElement(prestaShopRadioButtonLocator);
            prestaShopRadioButton.click();});

        step("Shipping method - wybranie formy dostawy pierwszej/nazwa ustawiana w Dockerze", ()->{
            By myCarrierRadioButtonLocator = By.id("delivery_option_1");
            WebElement myCarrierRadioButton = driver.findElement(myCarrierRadioButtonLocator);
            myCarrierRadioButton.click();});

        step("Shipping method - dodanie komentarza do zamówienia", ()->{
            By commentToOrderFieldLocator = By.id("delivery_message");
            WebElement commentToOrderField = driver.findElement(commentToOrderFieldLocator);
            commentToOrderField.sendKeys("Proszę o zostawienie paczki pod drzwiami.");});

        step("Shipping method - kliknięcie w button 'Continue'", ()->{
            By continueButtonInShippingMethodFormLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
            WebElement continueButtonInShippingMethodForm = driver.findElement(continueButtonInShippingMethodFormLocator);
            continueButtonInShippingMethodForm.click();});
    }


    @Test   //Payment - wybór formy płatności
    @Order(17)
    public void paymentMethodSuccessSelection() {

        step("Payment - wybór opcji 'Pay by bank wire'", ()->{
            By payByBankWireRadioButtonLocator = By.id("payment-option-2");
            WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
            payByBankWireRadioButton.click();});

        step("Payment - wybór opcji 'Pay by Check'", ()->{
            By payByCheckRadioButtonLocator = By.id("payment-option-1");
            WebElement payByCheckRadioButton = driver.findElement(payByCheckRadioButtonLocator);
            payByCheckRadioButton.click();});

        step("Payment - wybór checkboxa zgody", ()->{
            By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
            WebElement agreeToTermsCheckbox = driver.findElement(agreeToTermsCheckboxLocator);
            agreeToTermsCheckbox.click();});

        step("Payment - kliknięcie w button 'Place Order'", ()->{
            By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
            WebElement placeOrderButtonInPaymentSection = driver.findElement(placeOrderButtonInPaymentSectionLocator);
            placeOrderButtonInPaymentSection.click();});

        step("Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego", ()->{
            By confirmationMsgLocator = By.xpath("//h3[@class=\"h1 card-title\"]/i");
            WebElement confirmationMsg = driver.findElement(confirmationMsgLocator);
            Assertions.assertTrue(confirmationMsg.isDisplayed());});
    }


    @Test   //Formularz kontaktowy z działem obsługi klienta
    @Order(18)
    public void contactCustomerServiceDepartment() {

        step("Order confirmation page - kliknięcie w link formularza kontaktowego", ()->{
            By customerServiceDepartmentContactLocator = By.xpath(
                    "//a[contains(text(),\"customer service department.\")]");
            WebElement customerServiceDepartmentContact = driver.findElement(customerServiceDepartmentContactLocator);
            customerServiceDepartmentContact.click();});

        step("Contact us - kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza", ()->{
            By sendButtonInContactUsSectionLocator = By.xpath("//input[@class=\"btn btn-primary\"]");
            WebElement sendButtonInContactUsSection = driver.findElement(sendButtonInContactUsSectionLocator);
            sendButtonInContactUsSection.click();});

        step("Contact us - potwierdzenie pojawienia się komunikatu walidacyjnego", ()->{
            By validationMsgInContactUsSectionLocator = By.xpath(
                    "//li[contains(text(),\"The message cannot be blank.\")]");
            WebElement validationMsgInContactUsSection = driver.findElement(validationMsgInContactUsSectionLocator);
            Assertions.assertTrue(validationMsgInContactUsSection.isDisplayed());});

        step("Contact us - wpisanie treści wiadomości", ()->{
            By msgFieldInContactUsSectionLocator = By.id("contactform-message");
            WebElement msgFieldInContactUsSection = driver.findElement(msgFieldInContactUsSectionLocator);
            msgFieldInContactUsSection.sendKeys("Chcę otrzymać FV za zamówienie.");});

        step("Contact us - kliknięcie w button 'Send'", ()->{
            By sendButtonInContactUsSectionLocator = By.xpath("//input[@class=\"btn btn-primary\"]");
            WebElement sendButtonInContactUsSection = driver.findElement(sendButtonInContactUsSectionLocator);
            sendButtonInContactUsSection.click();});

        step("Contact us - potwierdzenie pojawienia się komunikatu informacyjnego", ()->{
            By successMsgInContactUsSectionLocator = By.xpath("//li[contains(text(),\"Your message has " +
                    "been successfully sent to our team.\")]");
            WebElement successMsgInContactUsSection = driver.findElement(successMsgInContactUsSectionLocator);
            Assertions.assertTrue(successMsgInContactUsSection.isDisplayed());});
    }


    @Test    //Details page - dodanie wiadomości
    @Order(19)
    public void addMsgInOrderDetailsPage() {

        step("Przejście na stronę 'Your account'", ()->{
            By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
            WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
            userProfileLink.click();});

        step("Your account - wejście w sekcję 'Order history and details'", ()->{
            By orderHistoryAndDetailsLinkLocator = By.id("history-link");
            WebElement orderHistoryAndDetailsLink = driver.findElement(orderHistoryAndDetailsLinkLocator);
            orderHistoryAndDetailsLink.click();});

        step("Przejście na stronę 'Order details'", ()->{
            By orderDetailsLinkLocator = By.xpath("//a[@data-link-action=\"view-order-details\"]");
            WebElement orderDetailsLink = driver.findElement(orderDetailsLinkLocator);
            orderDetailsLink.click();});

        step("'Order details' - kliknięcie 'Send' w pustym formularzu 'ADD A MESSAGE'", ()->{
            By sendButtonInDetailsPageLocator = By.xpath("//*[@name=\"submitMessage\"]");
            WebElement sendButtonInDetailsPage = driver.findElement(sendButtonInDetailsPageLocator);
            sendButtonInDetailsPage.click();});

        step("Potwierdzenie pojawienia się komunikatu walidacji", ()->{
            By validationMsgInDetailsPageLocator = By.xpath("//li[contains(text(),\"The message cannot be blank.\")]");
            WebElement validationMsgInDetailsPage = driver.findElement(validationMsgInDetailsPageLocator);
            Assertions.assertTrue(validationMsgInDetailsPage.isDisplayed());});

        step("Uzupełnienie treści wiadomości", ()->{
            By fillInMsgTextInFormLocator = By.xpath("//textarea[@name=\"msgText\"]");
            WebElement fillInMsgTextInField = driver.findElement(fillInMsgTextInFormLocator);
            fillInMsgTextInField.sendKeys("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");});

        step("Kliknięcie 'Send'", ()->{
            By sendButtonInDetailsPageLocator = By.xpath("//*[@name=\"submitMessage\"]");
            WebElement sendButtonInDetailsPage = driver.findElement(sendButtonInDetailsPageLocator);
            sendButtonInDetailsPage.click();});

        step("potwierdzenie wysłania wiadomości", ()->{
            By sendConfirmationMsgLocator = By.xpath("//li[contains(text(),\"Message successfully sent\")]");
            WebElement sendConfirmationMsg = driver.findElement(sendConfirmationMsgLocator);
            Assertions.assertTrue(sendConfirmationMsg.isDisplayed());});
    }


    @Test     //Panel użytkownika/Reorder - ponowne złożenie zamówienia
    @Order(20)
    public void reorderPreviousOrder() {

        step("'Order details' - przejście na stronę 'Reorder'", ()->{
            By reorderPageLinkLocator = By.xpath("//a[@class=\"button-primary\" and text()=\"Reorder\"]");
            WebElement reorderPageLink = driver.findElement(reorderPageLinkLocator);
            reorderPageLink.click();});

        step("Addresses - wejście w link 'Edit'", ()->{
            By editAddressesLinkLocator = By.xpath(
                    "//footer[@class=\"address-footer\"]/a[@data-link-action=\"edit-address\"]");
            WebElement editAddressesLink = driver.findElement(editAddressesLinkLocator);
            editAddressesLink.click();});

        step("Addresses - zmiana nazwy miasta", ()->{
            By cityInAddressFieldLocator = By.id("field-city");
            WebElement cityInAddressField = driver.findElement(cityInAddressFieldLocator);
            cityInAddressField.clear();
            cityInAddressField.sendKeys("Opole");});

        step("Addresses - kliknięcie buttona 'Continue'", ()->{
            By continueButtonInAddressesSectionLocator = By.xpath("//footer[@class=\"form-footer clearfix\"]" +
                    "/button[@class=\"continue btn btn-primary float-xs-right\"]");
            WebElement continueButtonInAddressesSection = driver.findElement(continueButtonInAddressesSectionLocator);
            continueButtonInAddressesSection.click();});

        step("Shipping method - wybór radio buttona 'My carrier'", ()->{
            By prestaShopRadioButtonLocator = By.id("delivery_option_2");
            WebElement prestaShopRadioButton = driver.findElement(prestaShopRadioButtonLocator);
            prestaShopRadioButton.click();});

        step("Shipping method - kliknięcie w button 'Continue'", ()->{
            By continueButtonInShippingMethodFormLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
            WebElement continueButtonInShippingMethodForm = driver.findElement(continueButtonInShippingMethodFormLocator);
            continueButtonInShippingMethodForm.click();});

        step("Payment - wybór opcji 'Pay by bank wire'", ()->{
            By payByBankWireRadioButtonLocator = By.id("payment-option-2");
            WebElement payByBankWireRadioButton = driver.findElement(payByBankWireRadioButtonLocator);
            payByBankWireRadioButton.click();});

        step("Payment - wybór checkboxa zgody", ()->{
            By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
            WebElement agreeToTermsCheckbox = driver.findElement(agreeToTermsCheckboxLocator);
            agreeToTermsCheckbox.click();});

        step("Payment - kliknięcie w button 'Place Order'", ()->{
            By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
            WebElement placeOrderButtonInPaymentSection = driver.findElement(placeOrderButtonInPaymentSectionLocator);
            placeOrderButtonInPaymentSection.click();});

        step("Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego", ()->{
            By confirmationMsgLocator = By.xpath("//h3[@class=\"h1 card-title\"]/i");
            WebElement confirmationMsg = driver.findElement(confirmationMsgLocator);
            Assertions.assertTrue(confirmationMsg.isDisplayed());});
    }


    @Test   //Panel użytkownika/Adres – dodanie nowego adresu, aktualizacja i usunięcie
    @Order(21)
    public void addUserAddress() {

        step("Order confirmation page - przejście na stronę 'Your account'", ()->{
            By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
            WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
            userProfileLink.click();});

        step("'Your account' - przejście na stronę 'Addresses'", ()->{
            By addressesPageLink = By.xpath("//a[@id=\"addresses-link\"]/span/i");
            WebElement addressesPage = driver.findElement(addressesPageLink);
            addressesPage.click();});

        step("Your addresses - kliknięcie w link 'Create new address'", ()->{
            By createNewAddressLinkLocator = By.xpath("//a[@data-link-action=\"add-address\"]");
            WebElement createNewAddressLink = driver.findElement(createNewAddressLinkLocator);
            createNewAddressLink.click();});

        step("New address - uzupełnienie pola 'Address'", ()->{
            By addressFieldLocator = By.id("field-address1");
            WebElement addressField = driver.findElement(addressFieldLocator);
            addressField.sendKeys("ul. Kwiatowa 15");});

        step("New address - uzupełnienie pola 'Zip/Postal Code'", ()->{
            By zipPostaCodeFieldLocator = By.id("field-postcode");
            WebElement zipPostaCodeField = driver.findElement(zipPostaCodeFieldLocator);
            zipPostaCodeField.sendKeys("88-111");});

        step("New address - uzupełnienie pola 'City'", ()->{
            By cityFieldLocator = By.id("field-city");
            WebElement cityField = driver.findElement(cityFieldLocator);
            cityField.sendKeys("Janowiec");});

        step("New address - kliknięcie w button 'Save'", ()->{
            By saveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]");
            WebElement saveButton = driver.findElement(saveButtonLocator);
            saveButton.click();});

        step("Your addresses - sprawdzenie komunikatu potwierdzającego dodania adresu", ()->{
            By addressSuccessfullyAddedMsgLocator = By.xpath("//li[contains(text(),\"Address successfully added!\")]");
            WebElement addressSuccessfullyAddedMsg = driver.findElement(addressSuccessfullyAddedMsgLocator);
            Assertions.assertTrue(addressSuccessfullyAddedMsg.isDisplayed());});

        step("Your addresses - kliknięcie w link 'Update'", ()->{
            By updateNewAddressButtonLocator = By.xpath("//address[text()[contains(.,\"Janowiec\")]]" +
                    "/../..//span[contains(text(),\"Update\")]");
            WebElement updateNewAddressButton = driver.findElement(updateNewAddressButtonLocator);
            updateNewAddressButton.click();});

        step("Update your address - zmiana danych w polu 'Zip/Postal Code'", ()->{
            By zipPostaCodeFieldLocator = By.id("field-postcode");
            WebElement zipPostaCodeField = driver.findElement(zipPostaCodeFieldLocator);
            zipPostaCodeField.clear();
            zipPostaCodeField.sendKeys("02-333");});

        step("Update your address - kliknięcie w button 'Save'", ()->{
            By saveButtonLocator = By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]");
            WebElement saveButton = driver.findElement(saveButtonLocator);
            saveButton.click();});

        step("Your addresses - sprawdzenie komunikatu potwierdzającego aktualizację adresu", ()->{
            By addressSuccessfullyUpdatedMsgLocator = By.xpath(
                    "//li[contains(text(),\"Address successfully updated!\")]");
            WebElement addressSuccessfullyUpdatedMsg = driver.findElement(addressSuccessfullyUpdatedMsgLocator);
            Assertions.assertTrue(addressSuccessfullyUpdatedMsg.isDisplayed());});

        step("Your addresses - usunięcie nowego adresu", ()->{
            By deleteNewAddressButtonLocator = By.xpath("//address[text()[contains(.,\"Janowiec\")]]" +
                    "/../..//span[contains(text(),\"Delete\")]");
            WebElement deleteNewAddressButton = driver.findElement(deleteNewAddressButtonLocator);
            deleteNewAddressButton.click();});

        step("Your addresses - sprawdzenie komunikatu potwierdzającego usunięcie adresu", ()->{
            By addressSuccessfullyDeletedMsgLocator = By.xpath(
                    "//li[contains(text(),\"Address successfully deleted!\")]");
            WebElement addressSuccessfullyDeletedMsg = driver.findElement(addressSuccessfullyDeletedMsgLocator);
            Assertions.assertTrue(addressSuccessfullyDeletedMsg.isDisplayed());});
    }


    @Test     //Wishlists - dodanie produktów do istniejącej wishlist
    @Order(22)
    public void addItemsToStaticWishlists() {

        step("Przejcie na Home page", ()->{
            By homepageLinkLocator = By.id("_desktop_logo");
            WebElement homepageLink = driver.findElement(homepageLinkLocator);
            homepageLink.click();});

        step("Home page - kliknięcie w serduszko dodające do wishlist", ()->{
            By heartButtonOfHummingbirdLocator = By.xpath(
                    "//a[contains(text(),\"Hummingbird printed t-shirt\")]" +
                            "/../../../button[@class=\"wishlist-button-add\"]");
            WebElement heartButtonOfHummingbird = driver.findElement(heartButtonOfHummingbirdLocator);
            heartButtonOfHummingbird.click();});

        step("Popup 'Add to whishlist' - kliknięcie w link 'My wishlist'", ()->{
            By myWishlistPopupLocator = By.xpath("//div[@class=\"modal-body\"]" +
                    "/div/ul/li[@class=\"wishlist-list-item\"]");
            wait.until(ExpectedConditions.elementToBeClickable(myWishlistPopupLocator));
            WebElement myWishlistPopup = driver.findElement(myWishlistPopupLocator);
            myWishlistPopup.click();});

        step("TOAST - potwierdzenie pojawienia się komunikatu potwierdzającego", ()->{
            By productAddedToWishlistMsgLocator = By.xpath("//div[@class=\"wishlist-toast success\"]" +
                    "/p[@class=\"wishlist-toast-text\"]");
            wait.until(ExpectedConditions.elementToBeClickable(productAddedToWishlistMsgLocator));
            WebElement productAddedToWishlistMsg = driver.findElement(productAddedToWishlistMsgLocator);
            Assertions.assertTrue(productAddedToWishlistMsg.isDisplayed());});

        step("Home page - przejście na stronę 'Your account'", ()->{
            By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
            WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
            userProfileLink.click();});

        step("'Your account' - przejście na stronę 'My wishlists'", ()->{
            By myWishlistsPageLocator = By.xpath("//a[@id=\"wishlist-link\"]/span/i");
            WebElement myWishlistsPage = driver.findElement(myWishlistsPageLocator);
            myWishlistsPage.click();});

        step("'My wishlists' - wejście na link 'My wishlist'", ()->{
            By myWishlistLinkLocator = By.xpath("//p[@class=\"wishlist-list-item-title\"]");
            wait.until(ExpectedConditions.elementToBeClickable(myWishlistLinkLocator));
            WebElement myWishlistLink = driver.findElement(myWishlistLinkLocator);
            myWishlistLink.click();});

        step("'My wishlist' - sprawdzenie, że produkt jest na liście", ()->{
            By wishListElementsLocator = By.xpath(
                "//p[@class=\"wishlist-product-title\"]");
            wait.until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
            List<WebElement> wishListsElements = driver.findElements(wishListElementsLocator);
            List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
            Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Hummingbird printed t-shirt"));});
    }


    @Test    //Wishlists - utworzenie nowej wishlisty i dodanie produktu
    @Order(23)
    public void addItemsToNewWishlists() {

        step("Przejcie na Home page", ()->{
            By homepageLinkLocator = By.id("_desktop_logo");
            WebElement homepageLink = driver.findElement(homepageLinkLocator);
            homepageLink.click();});

        step("Home page - kliknięcie w serduszko dodające do wishlist", ()->{
            By heartButtonOfMugTheAdventureLocator = By.xpath("//a[contains(text(),\"Mug The adventure begins\")]" +
                    "/../../../button[@class=\"wishlist-button-add\"]");
            WebElement heartButtonOfMugTheAdventure = driver.findElement(heartButtonOfMugTheAdventureLocator);
            heartButtonOfMugTheAdventure.click();});

        step("Popup 'Add to whishlist' - kliknięcie w link 'Create new list'", ()->{
            By newWishlistPopupLocator = By.xpath("//a[@class=\"wishlist-add-to-new text-primary\"]");
            wait.until(ExpectedConditions.elementToBeClickable(newWishlistPopupLocator));
            WebElement newWishlistPopup = driver.findElement(newWishlistPopupLocator);
            newWishlistPopup.click();});

        step("Popup 'Create wishlist' - wpisanie nazwy nowej listy", ()->{
            By wishlistNameLocator = By.xpath("//input[@id=\"input2\"]");
            WebElement wishlistNameField = driver.findElement(wishlistNameLocator);
            wishlistNameField.sendKeys("Ulubione");});

        step("Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'", ()->{
            By createNewWishListLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
            WebElement createNewWishList = driver.findElement(createNewWishListLocator);
            createNewWishList.click();});

        step("Popup 'Add to whishlist' - wybranie nowo utworzonej listy", ()->{
            By ulubioneNewWishlistLector = By.xpath("//li[@class=\"wishlist-list-item\"]" +
                    "/p[contains(text(),\"Ulubione\")]");
            wait.until(ExpectedConditions.elementToBeClickable(ulubioneNewWishlistLector));
            WebElement ulubioneNewWishlist = driver.findElement(ulubioneNewWishlistLector);
            ulubioneNewWishlist.click();});

        step("TOAST - potwierdzenie pojawienia się komunikatu", ()->{
            By productAddedToWishlistMsgLocator = By.xpath("//p[contains(text(),\"Product added\")]");
            wait.until(ExpectedConditions.elementToBeClickable(productAddedToWishlistMsgLocator));
            WebElement productAddedToWishlistMsg = driver.findElement(productAddedToWishlistMsgLocator);
            Assertions.assertTrue(productAddedToWishlistMsg.isDisplayed());});

        step("Home page - przejście na stronę 'Your account'", ()->{
            By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
            WebElement userProfileLink = driver.findElement(userProfileLinkLocator);
            userProfileLink.click();});

        step("'Your account' - wejście na stronę 'My wishlists'", ()->{
            By myWishlistsPageLocator = By.xpath("//a[@id=\"wishlist-link\"]/span/i");
            WebElement myWishlistsPage = driver.findElement(myWishlistsPageLocator);
            myWishlistsPage.click();});

        step("'My wishlists' - wejście na link listy 'Ulubione'", ()->{
            By ulubioneWishlistLinkLocator = By.xpath("//a[@class=\"wishlist-list-item-link\"]" +
                    "/p[contains(text(),\"Ulubione\")]");
            wait.until(ExpectedConditions.elementToBeClickable(ulubioneWishlistLinkLocator));
            WebElement ulubioneWishlistLink = driver.findElement(ulubioneWishlistLinkLocator);
            ulubioneWishlistLink.click();});

        step("Ulubione - sprawdzenie, że produkt jest na liście", ()->{
            By wishListElementsLocator = By.xpath("//p[@class=\"wishlist-product-title\"]");
            wait.until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
            List<WebElement> wishListsElements = driver.findElements(wishListElementsLocator);
            List<String> wishListsElementsNames = wishListsElements.stream().map(WebElement::getText).toList();
            Assertions.assertTrue(wishListsElementsNames.size()==1 && wishListsElementsNames.getFirst().equals("Mug The adventure begins"));});
    }


    @Test    //Wishlists - utworzenie listy na podstronie ‘My wishlists’, zmiana nazwy i usunięcie
    @Order(24)
    public void createNewWishlists() {

        step("Ulubione - przejście na stronę 'My wishlists'", ()->{
            By myWishlistsLinkLocator = By.xpath("//nav[@data-depth=\"4\"]//a[contains(., \"My wishlists\")]");
            WebElement myWishlistsLink = driver.findElement(myWishlistsLinkLocator);
            myWishlistsLink.click();});

        step("My wishlists - kliknięcie w 'Create new list'", ()->{
            By createNewListWishlistLinkLocator = By.xpath("//div[@class=\"wishlist-container-header\"]" +
                    "/a[contains(text(),\"Create new list\")]");
            wait.until(ExpectedConditions.elementToBeClickable(createNewListWishlistLinkLocator));
            WebElement createNewListWishlistLink = driver.findElement(createNewListWishlistLinkLocator);
            createNewListWishlistLink.click();});

        step("Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń", ()->{
            By createNameOfNewListWishlistLocator = By.xpath("//input[@placeholder=\"Add name\"]");
            wait.until(ExpectedConditions.elementToBeClickable(createNameOfNewListWishlistLocator));
            WebElement createNameOfNewListWishlist = driver.findElement(createNameOfNewListWishlistLocator);
            createNameOfNewListWishlist.sendKeys("Super lista");});

        step("Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'", ()->{
            By createWishlistButtonLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
            WebElement createWishlistButton = driver.findElement(createWishlistButtonLocator);
            createWishlistButton.click();});

        step("TOAST - potwierdzenie pojawienia się komunikatu", ()->{
            By wishlistSuccessCreatedMsgLocator = By.xpath("//p[contains(text(),\"The list has been properly created\")]");
            wait.until(ExpectedConditions.elementToBeClickable(wishlistSuccessCreatedMsgLocator));
            WebElement wishlistSuccessCreatedMsg = driver.findElement(wishlistSuccessCreatedMsgLocator);
            Assertions.assertTrue(wishlistSuccessCreatedMsg.isDisplayed());});

        step("potwierdzenie utworzenia nowej wishlist", ()->{
            By createdNewWishlistNameLocator = By.xpath("//div[@class=\"wishlist-list-container\"]" +
                    "//p[contains(text(),\"Super lista\")]");
            WebElement createdNewWishlistName = driver.findElement(createdNewWishlistNameLocator);
            Assertions.assertTrue(createdNewWishlistName.isDisplayed());});

        step("My wishlists - kliknięcie w trzy kropki", ()->{
            By moreActionLocator = By.xpath("//p[contains(text(),\"Super lista\")]" +
                    "/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]");
            driver.findElement(moreActionLocator).click();});

        step("My wishlists - kliknięcie w 'Rename'", ()->{
            By renameNewCreatedWishlistLocator = By.xpath("//p[contains(text(),\"Super lista\")]" +
                    "/..//div[@class=\"wishlist-list-item-right\"]/div[@class=\"dropdown-menu show\"]/button[contains(text(),\"Rename\")]");
            WebElement renameWishList = driver.findElement(renameNewCreatedWishlistLocator);
            renameWishList.click();});

        step("Popup 'Rename wishlist' - aktualizacja nazwy nowej listy życzeń", ()->{
            By changeNameOfListWishlistLocator = By.xpath("//h5[contains(text(),\"Rename wishlist\")]/../..//div/div/input");
            wait.until(ExpectedConditions.elementToBeClickable(changeNameOfListWishlistLocator));
            WebElement changeNameOfListWishList = driver.findElement(changeNameOfListWishlistLocator);
            changeNameOfListWishList.clear();
            changeNameOfListWishList.sendKeys("Lista życzeń");});

        step("Popup 'Rename wishlist' - kliknięcie w button 'Rename wishlist'", ()->{
            By renameWishlistButtonLocator = By.xpath("//button[contains(text(),\"Rename wishlist\")]");
            WebElement renameWishlistButton = driver.findElement(renameWishlistButtonLocator);
            renameWishlistButton.click();});

        step("TOAST - potwierdzenie pojawienia się komunikatu", ()->{
            By successRenamedNewWishlistLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
            wait.until(ExpectedConditions.elementToBeClickable(successRenamedNewWishlistLocator));
            WebElement successRenamedNewWishlist = driver.findElement(successRenamedNewWishlistLocator);
            Assertions.assertTrue(successRenamedNewWishlist.isDisplayed());});

        step("My wishlists - kliknięcie w trzy kropki", ()->{
            By moreActionLocator = By.xpath("//p[contains(text(),\"Lista życzeń\")]" +
                    "/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]");
            wait.until(ExpectedConditions.elementToBeClickable(moreActionLocator));
            driver.findElement(moreActionLocator).click();});

        step("My wishlists - kliknięcie w button 'Share'", ()->{
            By shareButtonWishlistLocator = By.xpath("//button[contains(text(),\"Share\")]");
            WebElement shareButtonWishlist = driver.findElement(shareButtonWishlistLocator);
            shareButtonWishlist.click();});

        step("Share wishlist - kliknięcie w button 'Copy text'", ()->{
            By copyTextButtonOfWishlistLocator = By.xpath("//button[contains(text(),\"Copy text\")]");
            WebElement copyTextButtonOfWishlist = driver.findElement(copyTextButtonOfWishlistLocator);
            copyTextButtonOfWishlist.click();});

        step("TOAST - potwierdzenie pojawienia się komunikatu", ()->{
            By shareLinkCopiedMsgLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
            WebElement shareLinkCopiedMsg = driver.findElement(shareLinkCopiedMsgLocator);
            Assertions.assertTrue(shareLinkCopiedMsg.isDisplayed());});

        step("My wishlists - usunięcie listy", ()->{
            By deleteWishlistButtonLocator = By.xpath("//p[contains(text(),\"Lista życzeń\")]" +
                    "/../div[@class=\"wishlist-list-item-right\"]/button/i[contains(text(),\"delete\")]");
            WebElement deleteWishlistButton = driver.findElement(deleteWishlistButtonLocator);
            deleteWishlistButton.click();});

        step("Popum 'Delete wishlist' - kliknięcie w button 'Delete'", ()->{
            By deleteConfirmLocator = By.xpath("//div[@class=\"modal-footer\"]/button[contains(text(),\"Delete\")]");
            WebElement deleteConfirm = driver.findElement(deleteConfirmLocator);
            deleteConfirm.click();});

        step("TOAST - potwierdzenie pojawienia się komunikatu", ()->{
            By listRemovedComfirmLocator = By.xpath("//p[contains(text(),\"List has been removed\")]");
            wait.until(ExpectedConditions.elementToBeClickable(listRemovedComfirmLocator));
            WebElement listRemovedComfirm = driver.findElement(listRemovedComfirmLocator);
            Assertions.assertTrue(listRemovedComfirm.isDisplayed());});
    }


    @Test   //Home page/Footer - sprawdzenie działania linków w stopce
    @Order(25)
    public void checkFooterLinksClickable() {

        step("Home page/Footer - kliknięcie w link 'Prices drop'", ()->{
            By pricesDropLinkLocator = By.id("link-product-page-prices-drop-1");
            WebElement pricesDropLink = driver.findElement(pricesDropLinkLocator);
            pricesDropLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Prices drop'", ()->{
            By pricesDropPageNameLocator = By.id("js-product-list-header");
            WebElement pricesDropPageName = driver.findElement(pricesDropPageNameLocator);
            Assertions.assertTrue(pricesDropPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'New products'", ()->{
            By newProductsLinkLocator = By.id("link-product-page-new-products-1");
            WebElement newProductsLink = driver.findElement(newProductsLinkLocator);
            newProductsLink.click();});

        step("Potwierdzenie otwarcia podstrony 'New products'", ()->{
            By newProductsPageNameLocator = By.id("js-product-list-header");
            WebElement newProductsPageName = driver.findElement(newProductsPageNameLocator);
            Assertions.assertTrue(newProductsPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Best sellers'", ()->{
            By bestSellersLinkLocator = By.id("link-product-page-best-sales-1");
            WebElement bestSellersLink = driver.findElement(bestSellersLinkLocator);
            bestSellersLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Best sellers'", ()->{
            By bestSellersPageNameLocator = By.id("js-product-list-header");
            WebElement bestSellersPageName = driver.findElement(bestSellersPageNameLocator);
            Assertions.assertTrue(bestSellersPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Delivery'", ()->{
            By deliveryLinkLocator = By.id("link-cms-page-1-2");
            WebElement deliveryLink = driver.findElement(deliveryLinkLocator);
            deliveryLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Delivery'", ()->{
            By deliveryPageNameLink = By.xpath("//h1[contains(text(),\"Delivery\")]");
            WebElement deliveryPageName = driver.findElement(deliveryPageNameLink);
            Assertions.assertTrue(deliveryPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Legal Notice'", ()->{
            By legalNoticeLinkLocator = By.id("link-cms-page-2-2");
            WebElement legalNoticeLink = driver.findElement(legalNoticeLinkLocator);
            legalNoticeLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Legal Notice'", ()->{
            By legalNoticePageNameLocator = By.xpath("//h1[contains(text(),\"Legal Notice\")]");
            WebElement legalNoticePageName = driver.findElement(legalNoticePageNameLocator);
            Assertions.assertTrue(legalNoticePageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Terms and conditions of use'", ()->{
            By termsAndConditionsOfUseLinkLocator = By.id("link-cms-page-3-2");
            WebElement termsAndConditionsOfUseLink = driver.findElement(termsAndConditionsOfUseLinkLocator);
            termsAndConditionsOfUseLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Terms and conditions of use'", ()->{
            By termsAndConditionsOfUsePageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1[contains(text(), " + "\"Terms and conditions of use\")]");
            WebElement termsAndConditionsOfUsePageName = driver.findElement(termsAndConditionsOfUsePageNameLocator);
            Assertions.assertTrue(termsAndConditionsOfUsePageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'About us'", ()->{
            By aboutUsLinkLocator = By.id("link-cms-page-4-2");
            WebElement aboutUsLink = driver.findElement(aboutUsLinkLocator);
            aboutUsLink.click();});

        step("Potwierdzenie otwarcia podstrony 'About us'", ()->{
            By aboutUsPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text(), " +
                    "\"About us\")]");
            WebElement aboutUsPageName = driver.findElement(aboutUsPageNameLocator);
            Assertions.assertTrue(aboutUsPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Secure payment'", ()->{
            By securePaymentLinkLocator = By.id("link-cms-page-5-2");
            WebElement securePaymentLink = driver.findElement(securePaymentLinkLocator);
            securePaymentLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Secure payment'", ()->{
            By securePaymentPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1[contains(text(),\"Secure payment\")]");
            WebElement securePaymentPageName = driver.findElement(securePaymentPageNameLocator);
            Assertions.assertTrue(securePaymentPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Contact us'", ()->{
            By contactUsLinkLocator = By.id("link-static-page-contact-2");
            WebElement contactUsLink = driver.findElement(contactUsLinkLocator);
            contactUsLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Contact us'", ()->{
            By contactUsPageNameLocator = By.xpath("//div[@class=\"col-md-9 col-md-offset-3\"]" +
                    "/h3[contains(text(),\"Contact us\")]");
            WebElement contactUsPageName = driver.findElement(contactUsPageNameLocator);
            Assertions.assertTrue(contactUsPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Sitemap'", ()->{
            By sitemapLinkLocator = By.id("link-static-page-sitemap-2");
            WebElement sitemapLink = driver.findElement(sitemapLinkLocator);
            sitemapLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Sitemap'", ()->{
            By sitemapPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1/span[contains(text(),\"Sitemap\")]");
            WebElement sitemapPageName = driver.findElement(sitemapPageNameLocator);
            Assertions.assertTrue(sitemapPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Stores'", ()->{
            By storesLinkLocator = By.id("link-static-page-stores-2");
            WebElement storesLink = driver.findElement(storesLinkLocator);
            storesLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Stores'", ()->{
            By ourStoresPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1");
            WebElement ourStoresPageName = driver.findElement(ourStoresPageNameLocator);
            Assertions.assertTrue(ourStoresPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Personal info'", ()->{
            By personalInfoLinkLocator = By.xpath("//a[@title=\"Personal info\"]");
            WebElement personalInfoLink = driver.findElement(personalInfoLinkLocator);
            personalInfoLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Personal info'", ()->{
            By personalInfoPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1[contains(text(),\"Your personal information\")]");
            WebElement personalInfoPageName = driver.findElement(personalInfoPageNameLocator);
            Assertions.assertTrue(personalInfoPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Orders'", ()->{
            By ordersLinkLocator = By.xpath("//a[@title=\"Orders\"]");
            WebElement ordersLink = driver.findElement(ordersLinkLocator);
            ordersLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Orders'", ()->{
            By orderHistoryPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1[contains(text(),\"Order history\")]");
            WebElement orderHistoryPageName = driver.findElement(orderHistoryPageNameLocator);
            Assertions.assertTrue(orderHistoryPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Credit slips'", ()->{
            By creditSlipsLinkLocator = By.xpath("//a[@title=\"Credit slips\"]");
            WebElement creditSlipsLink = driver.findElement(creditSlipsLinkLocator);
            creditSlipsLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Credit slips'", ()->{
            By creditSlipsPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1[contains(text(),\"Credit slips\")]");
            WebElement creditSlipsPageName = driver.findElement(creditSlipsPageNameLocator);
            Assertions.assertTrue(creditSlipsPageName.isDisplayed());});

        step("Home page/Footer - kliknięcie w link 'Addresses'", ()->{
            By addressesLinkLocator = By.xpath("//a[@title=\"Addresses\"]");
            WebElement addressesLink = driver.findElement(addressesLinkLocator);
            addressesLink.click();});

        step("Potwierdzenie otwarcia podstrony 'Addresses'", ()->{
            By yourAddressesPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                    "/h1[contains(text(),\"Your addresses\")]");
            WebElement yourAddressesPageName = driver.findElement(yourAddressesPageNameLocator);
            Assertions.assertTrue(yourAddressesPageName.isDisplayed());});

        step("Podstrona 'Addresses' - wylogowanie użytkownika z potwierdzeniem poprawności wylogowania", ()->{
            userSuccessLogout();});
    }


    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}



