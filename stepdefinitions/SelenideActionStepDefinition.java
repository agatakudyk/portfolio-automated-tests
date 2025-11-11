package lesson17Homework.stepdefinitions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideActionStepDefinition {
    @Given("the website is opened at {string}")
    public void theWebsiteIsOpenedAt(String url) {
        open(url);
    }


    // - 1- Strona główna - zmiana języka strony z polskiego na angielski

    // Home page - kliknięcie w dropdown języka
    @When("I click on the language dropdown in the header")
    public void iClickOnTheLanguageDropdownInTheHeader() {
        $("button[data-toggle='dropdown']").shouldBe(visible).click();
    }

    // Home page - wybór języka 'English' z listy
    @And("I select English from the language list")
    public void iSelectFromTheLanguageList() {
        $("a[data-iso-code='en']").shouldBe(visible).click();
    }

    // Home page - weryfikacja, że język został zmieniony na angielski
    @Then("I should see that the language has been changed to English")
    public void iShouldSeeThatTheLanguageHasBeenChangedToEnglish() {
        Assertions.assertTrue($x("//button[@data-toggle='dropdown']/span[contains(text(),'English')]").shouldBe(visible).isDisplayed());
    }


    // -2- Użytkownik niezarejestrowany – poprawne dodanie i usunięcie produktu z koszyka

    // kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'
    @When("I click the wishlist button of {string}")
    public void iClickTheWishlistButtonOf(String productName) {
        $x("//a[contains(text(),'" + productName + "')]/../../../button[@class='wishlist-button-add']")
                .shouldBe(visible).click();
    }

    // Potwierdzenie pojawienia się popupu z komunikatem walidacyjnym
    @Then("I should see a popup message that login is required")
    public void iShouldSeeAPopupMessageThatLoginIsRequired() {
        Assertions.assertTrue($x("//p[contains(text(),'You need to be logged in to save products in your wishlist.')]")
                .shouldBe(visible).isDisplayed());
    }

    // Zamknięcie okna popup - kliknięcie w button 'Cancel'
    @When("I close the wishlist popup")
    public void iCloseTheWishlistPopup() {
        $x("//a[contains(text(),'Sign in')]/../button[contains(text(),'Cancel')]")
                .shouldBe(visible).click();
    }

    // Wejście na stronę produktu 'Today is a good day Framed Poster'
    @And("I open the product page for {string}")
    public void iOpenTheProductPageFor(String productName) {
        $x("//a[@class='thumbnail product-thumbnail']/img[@alt='" + productName + "']")
                .shouldBe(visible).click();
    }

    // Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'
    @And("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        $x("//button[contains(text(),'" + buttonName + "')]").shouldBe(visible).click();
    }

    // Potwierdzenie pojawienia się popupu z komunikatem potwierdzającym pomyślne dodanie
    @Then("I should see a success popup confirming the product was added")
    public void iShouldSeeASuccessPopupConfirmingTheProductWasAdded() {
        Assertions.assertTrue($x("//h4[contains(text(),'Product successfully added to your shopping cart')]")
                .shouldBe(visible).isDisplayed());
    }

    // Zamknięcie popupu - kliknięcie w button 'Proceed to checkout'
    @When("I close the add-to-cart popup by clicking Proceed to checkout")
    public void iCloseTheAddToCartPopupByClicking() {
        $x("//a[@class='btn btn-primary']/i").shouldBe(visible).click();
    }

    // Shopping cart - sprawdzenie zgodności nazwy produktu w koszyku
    @Then("the shopping cart should contain the product")
    public void theShoppingCartShouldContainTheProduct() {
        Assertions.assertTrue($x("//div[@class=\"product-line-info\"]/a[contains(text(),\"Today is a good day Framed poster\")]")
                .shouldBe(visible).isDisplayed());
    }

    // Shopping cart - usunięcie produktu z koszyka
    @When("I delete the product from the cart")
    public void iDeleteTheProductFromTheCart() {
        $x("//a[@class=\"remove-from-cart\"]/i[contains(text(),\"delete\")]").shouldBe(visible).click();
    }

    // Shopping cart - potwierdzenie, że koszyk jest pusty
    @Then("I should see a message that the cart is empty")
    public void iShouldSeeAMessageThatTheCartIsEmpty() {
        Assertions.assertTrue($x("//span[contains(text(),\"There are no more items in your cart\")]")
                .shouldBe(visible).isDisplayed());
    }


    // -3- Użytkownik niezarejestrowany - dodanie produktu do koszyka i finalizacja zakupu

    // Shopping cart - powrót na stronę główną
    @When("I return to the homepage from cart")
    public void iReturnToTheHomepageFromCart() {
        $("#_desktop_logo").shouldBe(visible).click();
    }

    // Dodanie produktu do koszyka - kliknięcie w button 'Add to cart'
    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        $("button[data-button-action='add-to-cart']").shouldBe(visible).click();
    }

    // Popup w oknie produktu - kliknięcie w button 'Proceed to checkout'
    @And("I click Proceed to checkout in the popup")
    public void iClickInThePopup() {
        $("#blockcart-modal a.btn.btn-primary").shouldBe(visible).click();
    }

    // Cart - kliknięcie w button 'Proceed to checkout'
    @And("I proceed to checkout from the cart")
    public void iProceedToCheckoutFromTheCart() {
        $x("//a[contains(text(),\"Proceed to checkout\")]").shouldBe(visible).click();
    }

    // Personal Information - wpisanie danych użytkownika
    @And("I fill in my personal information")
    public void iFillInMyPersonalInformation() {
        $("#field-firstname").shouldBe(visible).setValue("Tomasz");
        $("#field-lastname").shouldBe(visible).setValue("Kot");
        $("#field-email").shouldBe(visible).setValue("kot123@wp.pl");
    }

    // Personal Information - zaznaczenie wymaganych checkboxów
    @And("I check the required checkboxes for privacy and terms")
    public void iCheckTheRequiredCheckboxesForPrivacyAndTerms() {
        $("input[name='customer_privacy']").shouldBe(interactable).click();
        $("input[name='psgdpr']").shouldBe(interactable).click();
    }



    //Addresses - uzupełnienie danych adresowych
    @And("I fill in my address information and continue")
    public void iFillInMyAddressInformationAndContinue() {
        $("#field-address1").shouldBe(visible).setValue("ul. Jaskrawa 23");
        $("#field-postcode").shouldBe(visible).setValue("11-788");
        $("#field-city").shouldBe(visible).setValue("Koszalin");
    }

    // Kliknięcie w 'continue' - przejście do 'Shipping Method'
    @And("I continue to the shipping method")
    public void iContinueToTheShippingMethod() {
        $x("//section[@id='checkout-addresses-step']//button[@type='submit']").shouldBe(visible).click();
    }

    // Shipping Method - przejście do 'Payment'
    @And("I select shipping method and continue")
    public void iSelectShippingMethodAndContinue() {
        $("button[name='confirmDeliveryOption']").shouldBe(visible).click();
    }

    // Payment - wybór opcji 'Pay by bank wire', zgoda na warunki i finalizacja zamówienia
    @And("I select payment by bank wire, agree to terms, and place the order")
    public void iSelectPaymentByBankWireAgreeToTermsAndPlaceTheOrder() {
        $("#payment-option-2").shouldBe(interactable).click();
        $("input[name='conditions_to_approve[terms-and-conditions]']").shouldBe(interactable).click();
        $("div.ps-shown-by-js > button").shouldBe(interactable).click();
    }

    // Order confirmation - potwierdzenie wyświetlenia komunikatu 'Your order is confirmed'
    @Then("I should see Your order is confirmed message")
    public void iShouldSeeMessage() {
        Assertions.assertEquals("Your order is confirmed", $("//h3.h1.card-title").shouldBe(visible).getText() );
    }


    // Login page - sprawdzenie komunikatu 'Authentication failed.'
    @Then("I should see Authentication failed. message")
    public void iShouldSeeAuthenticationFailedMessage() {
        Assertions.assertEquals($("li.alert.alert-danger").shouldBe(visible).getText(), "Authentication failed.");
    }

    // -4- Użytkownik niezarejestrowany - uzupełnienie formularza ‘Save time on your next order, sign up now’

    // ‘Save time on...' form - kliknięcie w button 'Save' bez uzupełnienia danych
    @When("I click {string} on the form without filling in any data")
    public void iClickOnTheFormWithoutFillingInAnyData(String buttonName) {
        $x("//button[contains(text(),'" + buttonName + "')]").shouldBe(interactable).click();
    }

    // Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego
    @Then("I should see a validation message {string}")
    public void iShouldSeeAValidationMessage(String message) {
        Assertions.assertEquals($("#field-firstname").shouldBe(visible).getAttribute("validationMessage"), message);
    }

    // ‘Save time on...' form - uzupełnienie danych użytkownika
    @When("I fill in my first name, last name, email, and password")
    public void iFillInMyFirstNameLastNameEmailAndPassword() {
        $("#field-firstname").shouldBe(visible).setValue("Tomasz");
        $("#field-lastname").shouldBe(visible).setValue("Kot");
        $("#field-email").shouldBe(visible).setValue("kot123@wp.pl");
        $("#field-password").shouldBe(visible).setValue("Mojehaslo123");
    }

    // Zapisanie danych poprzez kliknięcie w button 'Save'
    @Then("the data should be successfully saved")
    public void theDataShouldBeSuccessfullySaved() {
        $x("//button[contains(text(),'Save')]").shouldBe(interactable).click();
    }


    // -5- Niepoprawna rejestracja

    // Login page - kliknięcie w link rejestracji
    @When("I click the signup link on login page")
    public void iClickTheSignupLinkOnLoginPage() {
        $("a[data-link-action='display-register-form']").shouldBe(visible).click();
    }

    // Create account page - kliknięcie w button 'Save' bez wypełniania pól
    @And("I click Save without filling in fields")
    public void iClickWithoutFillingInFields() {
        $(".form-control-submit").shouldBe(visible).click();
    }


    //  -6- Poprawna rejestracja

    @When("I fill in first name, last name, email and password")
    public void iClickInTheHeader() {
        $("#field-firstname").setValue("Anna");
        $("#field-lastname").setValue("Testowianka");
        $("#field-email").setValue("testowianka345@p.pl");
        $("#field-password").setValue("Password123");
    }


    // Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'
    @When("I should see the {string} button")
    public void iShouldSeeButton(String buttonName) {
        Assertions.assertTrue($x("//a[contains(text(),'" + buttonName + "')]").shouldBe(visible).isDisplayed());
    }




    // -7- Niepoprawne logowanie z użyciem pustych pól i błędnych danych

    // Header - kliknięcie w button 'Sign In'
    @When("I click Sign In in the header")
    public void iClickSignInInHeader() {
        $(".user-info a").shouldBe(visible).click();
    }

    // Login page - kliknięcie w button 'Sign In'
    @And("I click Sign In on login page with empty fields")
    public void iClickSignInOnLoginPageWithEmptyFields() {
        $("#submit-login").shouldBe(visible).click();
    }

    // Login page - uzupełnienie pola 'Email' i 'password'
    @When("I fill in email and password fields")
    public void iFillInEmailAndPasswordFields() {
        $("#field-email").shouldBe(visible).setValue("blablabla@wp.pl");
        $("#field-password").shouldBe(visible).setValue("blepassword");
    }



    // -8- Login page - zresetowanie zapomnianego hasła

    // Login page - kliknięcie w link 'Forgot your password?'
    @When("I click Forgot your password? on login page")
    public void iClickForgotYourPasswordOnLoginPage() {
        $("div.forgot-password > a").shouldBe(visible).click();
    }

    // Reset password page - uzupełnienie pola 'Email address'
    @And("I fill in my email address")
    public void iFillInMyEmailAddress() {
        $("input.form-control").setValue("test.mail@wp.pl");
    }

    // Reset password page - kliknięcie w button 'Send reset link'
    @And("I click {string}")
    public void iClickLink(String buttonText) {
        $x("//a[contains(text(),'" + buttonText + "')]").shouldBe(visible).click();
    }


    // Reset password page - sprawdzenie komunikatu potwierdzającego wysłanie maila
    @Then("I should see a message confirming that the email is sent")
    public void iShouldSeeConfirmationMessageEmailSent() {
        Assertions.assertTrue($x("//li[@class='item']/p").shouldBe(visible).isDisplayed());
    }


// -9- Poprawne zalogowanie  + zmiana hasła + zalogowanie nowym hasłem

    // Reset password page - kliknięcie w link 'Back to Login'
    @When("I go back to login page")
    public void iGoBackToLoginPage() {
        $x("//i[@class='material-icons']").shouldBe(visible).click();
    }

    // Login page - uzupełnienie pola 'Email' i 'Password'
    @And("I fill in email and current password")
    public void iFillInEmailAndCurrentPassword() {
        $("#field-email").setValue("testowianka345@p.pl");
        $("#field-password").setValue("Password123");
    }

    // Sprawdzenie pomyślnego zalogowania - widoczność przycisku 'Sign out'
    @Then("I should see Sign out button")
    public void iShouldSeeSignOutButton() {
        Assertions.assertTrue($("a.logout.hidden-sm-down").shouldBe(visible).isDisplayed());
    }

    // Your account - kliknięcie w link 'Information'
    @When("I navigate to Your account > Information")
    public void iNavigateToYourAccountInformation() {
        $("a#identity-link").shouldBe(visible).click();
    }

    // Your personal information - uzupełnienie pola 'Password' i 'New Password'
    @And("I fill in current password and new password")
    public void iFillInCurrentAndNewPassword() {
        $("#field-password").setValue("Password123");
        $("input[name='new_password']").setValue("TestTest123");
    }

    // Your personal information - checkbox akceptacji regulaminu i zgody na przetwarzanie danych
    @And("I check privacy and terms checkboxes")
    public void iCheckPrivacyAndTermsCheckboxes() {
        $("input[name='customer_privacy']").shouldBe(interactable).click();
        $("input[name='psgdpr']").shouldBe(interactable).click();
    }

    // Your personal information - potwierdzenie pojawienia się komunikatu
    @Then("I should see confirmation that information is updated")
    public void iShouldSeeConfirmationThatInformationIsUpdated() {
    }

    // Header - wylogowanie i zalogowanie nowym hasłem
    @When("I log out and login with the new password")
    public void iLogOutAndLoginWithNewPassword() {
        $("a.logout.hidden-sm-down").shouldBe(visible).click();
        $("#field-email").setValue("testowianka345@p.pl");
        $("input[name='new_password']").setValue("TestTest123");
        $("#submit-login").shouldBe(visible).click();
    }

    // proces przywrócenia starego hasła
    @And("I revert to previous password")
    public void iRevertToPreviousPassword() {
        $("a.account > span.hidden-sm-down").shouldBe(visible).click();
        $("input[name='new_password']").setValue("TestTest123");
        $("#field-password").setValue("Password123");
        $("input[name='customer_privacy']").shouldBe(interactable).click();
        $("input[name='psgdpr']").shouldBe(interactable).click();
        $("button.btn.btn-primary.form-control-submit.float-xs-right").shouldBe(visible).click();
    }


    // -10- Podstrona Accessories - filtrowanie

    // wejście na stronę ACCESSORIES
    @When("I open the Accessories page")
    public void iOpenAccessoriesPage() {
        $("#category-6").shouldBe(visible).click();
    }

    // Accessories page - wybór filtra 'Ceramic' i 'Available'
    @And("I select filter {string} and {string}")
    public void iSelectFilters(String filter1, String filter2) {
        $x("//a[contains(text(),'" + filter1 + "')]").shouldBe(visible).click();
        $x("//a[contains(text(),'" + filter2 + "')]").shouldBe(visible).click();
    }

    // Accessories page - wyczyszczenie wybranych filtrów
    @And("I clear all filters")
    public void iClearAllFilters() {
        $("button.btn.btn-tertiary.js-search-filters-clear-all").shouldBe(visible).click();
    }

    // Accessories page - potwierdzenie wyczyszczenia filtrów
    @Then("I should see that filters are cleared")
    public void iShouldSeeFiltersCleared() {
        Assertions.assertFalse($x("//p[contains(text(),'Active filters')]").shouldBe(hidden).isDisplayed());
    }


    // -11- Sortowanie na podstronie ART

    // wejście na podstronę ART
    @When("I open the ART page")
    public void iOpenTheARTPage() {
        $("#category-9").shouldBe(visible).click();
    }

    // strona ART - kliknięcie w pole sortowania
    @And("I sort products by {string}")
    public void iSortProductsBy(String sortBy) {
        $x("//button[@aria-label='Sort by selection']").shouldBe(visible).click();
        $x("//div[@class=\"dropdown-menu\"]/a[contains(text(),\"" + sortBy + "\")]").shouldBe(interactable).click();
    }

    // Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane
    @Then("products should be sorted alphabetically")
    public void productsShouldBeSortedAlphabetically() {
        // strona ART - posortowanie według 'Name, A to Z'


        List<String> productsNames = new ArrayList<>();
        for (WebElement product : $$x("//div[@class='product-description']/h2/a")) {
            productsNames.add(product.getText());
        }
        List<String> productsAlphabeticalOrder = productsNames.stream().sorted().toList();

        for (int i = 0; i < productsNames.size(); i++) {
            Assertions.assertEquals(productsAlphabeticalOrder.get(i), productsNames.get(i));
        }

    }

    // Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane
    @Then("products should be sorted by ascending price")
    public void productsShouldBeSortedByAscendingPrice() {
        // strona ART - posortowanie według ‘Price, low to high’
        List<String> productsPrices = new ArrayList<>();
        for (WebElement product : $$("div.product-price-and-shipping > span")) {
            productsPrices.add(product.getText());
        }
        List<String> productsAlphabeticalOrder2 = productsPrices.stream().sorted().toList();

        for (int i = 0; i < productsPrices.size(); i++) {
            Assertions.assertEquals(productsAlphabeticalOrder2.get(i), productsPrices.get(i));
        }
    }


    // -12- Podstrona ART – dodanie opinii o produkcie

    // Podstrona ART - wejście na stronę produktu 'The Best Is Yet To Come Framed Poster'
    @When("I open product {string}")
    public void iOpenProduct(String productName) {
        $x("//img[@alt=\"" + productName + "\"]").shouldBe(visible).click();
    }

    // Strona produktu - kliknięcie w button dodania opinii o produkcie
    @And("I click to add a review")
    public void iClickToAddAReview() {
        $x("//div[@class='product-comment-list-item']/button").shouldBe(visible).click();
    }

    // popup 'Write your review' - wpisanie tytułu i treści komentarza
    @And("I fill in review title and content")
    public void iFillInReviewTitleAndContent() {
        $("#comment_title").shouldBe(visible).setValue("Moja ocena produktu");
        $("#comment_content").shouldBe(visible).setValue("To bardzo dobry produkt.");
    }

    @When("I click the 'Send' button")
    public void iClickSendButton() {
        $x("//input[@class=\"btn btn-primary\"]").shouldBe(visible).click();
    }

    // Popup REVIEW SENT - potwierdzenie dodania komentarza
    @Then("I should see confirmation that the review was sent")
    public void iShouldSeeConfirmationThatReviewWasSent() {
        Assertions.assertTrue($("div#product-comment-posted-modal-message").shouldBe(visible).isDisplayed());
    }

    // Popup REVIEW SENT - zamknięcie okna poprzez kliknięcie w button 'OK'
    @And("I close the review popup by clicking 'OK'")
    public void iClickOkToClosePopup() {
        $x("//div[contains(text(), 'Your comment has been submitted and will be available once approved by a moderator.')]" +
                "/../div[@class='post-comment-buttons']/button[@class='btn btn-comment btn-comment-huge']")
                .shouldBe(visible).click();
    }


    // -13- Strona produktu - zwiększenie ilości produktu i dodanie do koszyka

    // Strona produktu - zmiana ilości produktu poprzez wpisanie liczby (wyczyść i wpisz wartość)
    @When("I set product quantity to {int}")
    public void iSetProductQuantityTo(int quantity) {
        SelenideElement quantityField = $("#quantity_wanted").shouldBe(visible);
        quantityField.clear();
        quantityField.setValue(String.valueOf(quantity));
    }

    // Strona produktu - zmiana ilości produktu poprzez kliknięcie w strzałki
    @And("I increase product quantity by {int} using arrows")
    public void iIncreaseProductQuantityByUsingArrows(int quantity) {
        SelenideElement increaseArrow = $("i.material-icons.touchspin-up").shouldBe(visible);
        for (int i = 1; i <= quantity; i++) {
            increaseArrow.click();
        }
    }

    // Strona produktu - kliknięcie button 'Add to cart'
    @And("I click \"Add to cart\"")
    public void iClickAddToCart() {
        $("button.btn.btn-primary.add-to-cart").shouldBe(visible).click();
    }

    // Popup - sprawdzenie komunikatu potwierdzającego dodanie do koszyka
    @Then("I should see confirmation that the product was added successfully")
    public void iShouldSeeConfirmationThatTheProductWasAddedSuccessfully() {
        Assertions.assertTrue($x("//h4[contains(text(),'Product successfully added to your shopping cart')]")
                .shouldBe(visible).isDisplayed());
    }


    // -14- Koszyk - sprawdzenie zawartości koszyka

    // Popup - zamknięcie okna poprzez kliknięcie 'Proceed to checkout'
    @When("I close the popup by clicking 'Proceed to checkout'")
    public void iCloseThePopupByClickingProceedToCheckout() {
        $("a.btn.btn-primary > i").shouldBe(visible).click();
    }

    // Cart - sprawdzenie nazwy produktu
    @Then("the cart should contain product {string}")
    public void theCartShouldContainProduct(String expectedName) {
        Assertions.assertEquals($("div.product-line-info > a").shouldBe(visible).getText(), expectedName);
    }

    // Shopping cart - porównanie ilości z sekcji produktu i sekcji podsumowania
    @Then("product quantity should match the summary quantity")
    public void productQuantityShouldMatchSummaryQuantity() {
        // ilość w sekcji produktu
        int productQuantity = Integer.parseInt(Objects.requireNonNull(
                $("input.js-cart-line-product-quantity.form-control")
                        .shouldBe(visible).getDomAttribute("value")));
        // ilość w sekcji podsumowania
        String summaryQuantityText = $x("//span[@class='label js-subtotal']").shouldBe(visible).getText();
        int summaryQuantity = Integer.parseInt(summaryQuantityText.replaceAll("\\D+", ""));
        // porównanie ilości z sekcji produktu i sekcji podsumowania
        Assertions.assertEquals(productQuantity, summaryQuantity);
    }

    // Shopping cart - sprawdzenie wartości całkowitej
    @Then("the total price should equal unit price multiplied by quantity")
    public void theTotalPriceShouldEqualUnitPriceMultipliedByQuantity() {

        //cena jednostkowa
        String unitPriceText = $("div.product-line-info.product-price.h5 > div.current-price")
                .shouldBe(visible).getText().replace("zł", "").replace(",", ".").trim();
        double unitPrice = Double.parseDouble(unitPriceText);
        // ilość w sekcji produktu
        int productQuantity = Integer.parseInt(Objects.requireNonNull(
                $("input.js-cart-line-product-quantity.form-control")
                .shouldBe(visible).getDomAttribute("value")));
        //wartość całkowita z podsumowania
        String totalPriceText = $("div.cart-summary-line.cart-total > span.value")
                .shouldBe(visible).getText().replace("zł", "").replace(",", ".").trim();
        double totalPrice = Double.parseDouble(totalPriceText);
        //oczekiwana wartość
        double expectedTotal = unitPrice * productQuantity;
        Assertions.assertEquals(totalPrice, expectedTotal);
    }


    // -15- Zapisanie danych w formularzu adresu

    // Shopping cart - przejście do adresu klikając button 'Proceed To Checkout'
    @When("I proceed to checkout from the shopping cart")
    public void iProceedToCheckoutFromTheShoppingCart() {
        $x("//a[contains(text(),\"Proceed to checkout\")]").shouldBe(visible).click();
    }

    // Addresses/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego
    @Then("I should see validation message {string}")
    public void iShouldSeeValidationMessage(String expectedMsg) {
        Assertions.assertEquals($("input[name='address1']").shouldBe(visible).getAttribute("validationMessage"), expectedMsg);
    }

    // Addresses - uzupełnienie pola 'Address'
    @When("I fill in the Address field")
    public void iFillInTheAddressField() {
        $("#field-address1").setValue("ul. Prosta 11");
    }

    // Addresses - uzupełnienie pola 'Zip/Postal Code'
    @When("I fill in the Zip or Postal Code field")
    public void iFillInTheZipOrPostalCodeField() {
        $("#field-postcode").setValue("11-234");
    }

    // Addresses - uzupełnienie pola 'City'
    @When("I fill in the City field")
    public void iFillInTheCityField() {
        $("#field-city").setValue("Warszawa");
    }

    // Addresses - kliknięcie w button 'Continue'
    @When("I click 'Continue' on the Addresses page")
    public void iClickContinueOnTheAddressesPage() {
        $x("//section[@id='checkout-addresses-step']//button[@type='submit']").shouldBe(visible).click();
    }

    // contact us - wpisanie treści wiadomości
    @When("I fill in the message content in the contact form")
    public void iFillInContactMessageContent() {
        $("#contactform-message").shouldBe(visible).setValue("Chcę otrzymać FV za zamówienie.");
    }


    // -16- Wybór formy dostawy

    // Shipping method - wybranie formy dostawy 'My carrier'
    @When("I select shipping method 'PrestaShop'")
    public void iSelectShippingMethodPrestaShop() {
        $("#delivery_option_2").shouldBe(interactable).click();
    }

    // Shipping method - wybranie formy dostawy pierwszej
    @When("I select shipping method \"My carrier\"")
    public void iSelectShippingMethodMyCarrier() {
        $("#delivery_option_1").shouldBe(interactable).click();
    }

    // Shipping method - dodanie komentarza do zamówienia
    @When("I add a comment to the order")
    public void iAddACommentToTheOrder() {
        $("#delivery_message").shouldBe(visible).setValue("Proszę o zostawienie paczki pod drzwiami.");
    }

    // Shipping method - kliknięcie w button 'Continue'
    @When("I click \"Continue\" on the Shipping method page")
    public void iClickContinueOnTheShippingMethodPage() {
        $("button[name='confirmDeliveryOption']").shouldBe(visible).click();
    }


    // -17- Wybór formy płatności  wybór formy płatności + walidacja

    // Payment - wybór opcji 'Pay by bank wire'
    @When("I select payment option \"Pay by bank wire\"")
    public void iSelectPaymentOptionPayByBankWire() {
        $("#payment-option-2").shouldBe(interactable).click();
    }

    // Payment - wybór opcji 'Pay by Check'
    @When("I select payment option \"Pay by check\"")
    public void iSelectPaymentOptionPayByCheck() {
        $("#payment-option-1").shouldBe(interactable).click();
    }

    // Payment - wybór checkboxa zgody
    @When("I check the agreement checkbox")
    public void iCheckTheAgreementCheckbox() {
        $("input[name='conditions_to_approve[terms-and-conditions]']").shouldBe(interactable).click();
    }

    // Payment - kliknięcie w button 'Place Order'
    @When("I click 'Place Order'")
    public void iClickPlaceOrder() {
        $("div.ps-shown-by-js > button").shouldBe(interactable).click();
    }

    // Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego
    @Then("I should see a confirmation message that the order was placed successfully")
    public void iShouldSeeOrderConfirmationMessage() {
        Assertions.assertTrue($("h3.h1.card-title > i").shouldBe(visible).isDisplayed());
    }


    // -18- Formularz kontaktowy z działem obsługi klienta

    // Order confirmation page - kliknięcie w link kontaktu z działem obsługi klienta
    @When("I click the link to contact the customer service department from the order confirmation page")
    public void iClickCustomerServiceDepartmentLink() {
        $x("//a[contains(text(),'customer service department.')]").shouldBe(interactable).click();
    }

    // Contact us - kliknięcie w button 'Send'
    @When("I click the \"Send\" button on the empty contact form")
    public void iClickSendButtonOnEmptyForm() {
        $("input.btn.btn-primary").shouldBe(visible).click();
    }

    @Then("I should see a validation message on the contact form")
    public void iShouldSeeValidationMessageContactForm() {
        Assertions.assertTrue($x("//li[contains(text(),\"The message cannot be blank.\")]").shouldBe(visible).isDisplayed());
    }

    @Then("I should see an information message confirming that the message was sent successfully")
    public void iShouldSeeInformationMessage() {
        Assertions.assertTrue($x("//li[contains(text(),\"Your message has been successfully sent to our team.\")]")
                .shouldBe(visible).isDisplayed());
    }


    // -19- Details page - dodanie wiadomości

    // Header - wejście na profil użytkownika 'Your account'
    @When("I open the user profile from the header")
    public void iOpenUserProfile() {
        $("a.account > span.hidden-sm-down").shouldBe(visible).click();
    }

    // Your account - wejście w sekcję 'Order history and details'
    @When("I go to the 'Order history and details' section")
    public void iGoToOrderHistoryAndDetails() {
        $("a#history-link").shouldBe(visible).click();
    }

    // Kliknięcie w link 'Details'
    @When("I click the 'Details' link for an order")
    public void iClickDetailsLink() {
        $("a[data-link-action='view-order-details']").shouldBe(visible).click();
    }

    // 'Order details' - kliknięcie 'Send' w pustym formularzu 'ADD A MESSAGE'
    @When("I click the 'Send' button in an empty 'Add a message' form")
    public void iClickSendButtonEmptyForm() {
        $("[name='submitMessage']").shouldBe(visible).click();
    }

    // Potwierdzenie pojawienia się komunikatu walidacji 'The message cannot be blank.'
    @Then("I should see a validation message saying that the message cannot be blank")
    public void iShouldSeeValidationMessage() {
        Assertions.assertTrue($x("//li[contains(text(),'The message cannot be blank.')]").shouldBe(visible).isDisplayed());
    }

    // 'Order details' - Uzupełnienie treści wiadomości
    @When("I fill in the message content in the \"Add a message\" form")
    public void iFillInAddMessageContent() {
        $("textarea[name='msgText']").shouldBe(visible).setValue("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");
    }

    // potwierdzenie wysłania wiadomości 'Message successfully sent'
    @Then("I should see a confirmation message saying that the message was successfully sent")
    public void iShouldSeeConfirmationMessageSent() {
        Assertions.assertTrue($x("//li[contains(text(),'Message successfully sent')]").shouldBe(visible).isDisplayed());
    }


    // -20- Reorder - ponowne złożenie zamówienia:

    // 'Order details' - kliknięcie w link 'Reorder'
    @When("I click the 'Reorder' link in the order details page")
    public void iClickReorderLink() {
        $x("//a[@class='button-primary' and text()='Reorder']").shouldBe(visible).click();
    }

    // Addresses - wejście w link 'Edit'
    @When("I click the 'Edit' link in the Addresses section")
    public void iClickEditAddressLink() {
        $("footer.address-footer > a[data-link-action='edit-address']").shouldBe(visible).click();
    }

    // Addresses - zmiana nazwy miasta
    @When("I change the city name")
    public void iChangeCityName() {
        $("#field-city").setValue("Opole");
    }

    // Addresses - kliknięcie buttona 'Continue'
    @When("I click the \"Continue\" button on the Addresses page")
    public void iClickContinueOnAddressesPage() {
        $("section#checkout-addresses-step button[type='submit").shouldBe(visible).click();
    }

    // Shipping method - wybór radio buttona 'My carrier'
    @When("I select the \"My carrier\" shipping method")
    public void iSelectShippingMethod() {
        $("#delivery_option_2").shouldBe(interactable).click();
    }

    // Shipping method - kliknięcie w button 'Continue'
    @When("I click the \"Continue\" button on the Shipping Method page")
    public void iClickContinueOnShippingPage() {
        $("button[name='confirmDeliveryOption']").shouldBe(visible).click();
    }

    // Payment - wybór opcji 'Pay by bank wire'
    @When("I choose \"Pay by bank wire\" as the payment method")
    public void iChoosePayByBankWire() {
        $("#payment-option-2").shouldBe(interactable).click();
    }

    // Payment - wybór checkboxa zgody
    @When("I check the terms and conditions checkbox")
    public void iCheckTermsCheckbox() {
        $("input[name='conditions_to_approve[terms-and-conditions]']").shouldBe(interactable).click();
    }

    // Payment - kliknięcie w button 'Place Order'
    @When("I click the \"Place Order\" button")
    public void iClickPlaceOrderButton() {
        $("div.ps-shown-by-js > button").shouldBe(interactable).click();
    }

    // Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego
    @Then("I should see a confirmation message that the order was successfully placed")
    public void iShouldSeeConfirmationMessage() {
        Assertions.assertTrue($("h3.h1.card-title > i").shouldBe(visible).isDisplayed());
    }


    // -21- Panel użytkownika/Adres – dodanie nowego adresu, aktualizacja i usunięcie

    //Order confirmation page - przejście na stronę 'Your account'
    @When("the user goes to Your account")
    public void goToUserProfile() {
        $("a.account > span.hidden-sm-down").shouldBe(visible).click();
    }

    // 'Your account' - przejście na stronę 'Addresses'
    @When("navigates to {string}")
    public void navigateToPage(String pageName) {
        $x("//a[contains(text(),\"" + pageName + "\")").shouldBe(visible).click();
    }


    // Your addresses - kliknięcie w link 'Create new address'
    @When("clicks the Create new address link")
    public void clickLink() {
        $("a[data-link-action='add-address']").shouldBe(visible).click();
    }

    // New address - uzupełnienie pola 'Address', 'Zip/Postal Code' i 'City'
    @When("fills in the Address field")
    public void fillField() {
        $("#field-address1").setValue("ul. Kwiatowa 15");
        $("#field-postcode").setValue("88-111");
        $("#field-city").setValue("Janowiec");
    }

    // New address - kliknięcie w button 'Save'
    @When("clicks the Save button")
    public void clickButton() {
        $("button.btn.btn-primary.form-control-submit.float-xs-right").click();
    }

    // Your addresses - komunikat potwierdzający dodanie adresu 'Address successfully added!'
    @Then("the message {string} is displayed")
    public void verifyMessageDisplayed(String message) {
        Assertions.assertTrue($x("//li[contains(text(),'" + message + "')]").shouldBe(visible).isDisplayed());
    }

    @When("updates the Address field")
    public void updateField() {
        $x("//address[text()[contains(.,\"Janowiec\")]]" +
                "/../..//span[contains(text(),\"Update\")]").shouldBe(visible).click();
        $("#field-postcode").shouldBe(visible).setValue("02-333");
        $("button.btn.btn-primary.form-control-submit.float-xs-right").should(visible).click();

    }

    // Usunięcie adresu
    @When("the user deletes the new address")
    public void deleteNewAddress() {
        $x("//address[text()[contains(.,\"Janowiec\")]]/../..//span[contains(text(),\"Delete\")]")
                .shouldBe(visible).click();
    }


    // -22- Wishlist – dodanie do istniejącej listy:

    // Home page - kliknięcie w serduszko dodające do wishlist
    @When("the user clicks the wishlist icon for {string}")
    public void clickWishlistIcon(String productName) {
        $x("//a[contains(text(),'" + productName + "')]/../../../button[@class='wishlist-button-add']")
                .shouldBe(visible).click();
    }

    // Popup 'Add to whishlist' - kliknięcie w link 'My wishlist'
    @And("the user selects My wishlist from the popup")
    public void selectWishlistFromPopup() {
        $x("//div[@class='modal-body']/div/ul/li[@class='wishlist-list-item']").shouldBe(visible).click();
    }

    // TOAST 'Product added' - potwierdzenie pojawienia się komunikatu
    @Then("the toast message {string} should be displayed")
    public void toastMessageDisplayed(String expectedMsg) {
        Assertions.assertEquals($("div.wishlist-toast.success > p.wishlist-toast-text")
                .shouldBe(visible).getText(), expectedMsg);
    }



    // 'My wishlists' - wejście na link 'My wishlist'
    @And("clicks on My wishlist")
    public void clicksOnMyWishlist() {
        $("p.wishlist-list-item-title").shouldBe(visible).click();
    }

    // 'My wishlists' - wejście na link listy 'Ulubione'
    @And("clicks on the Ulubione wishlist")
    public void clicksOnWishlist() {
        $x("//a[@class='wishlist-list-item-link']/p[contains(text(),'Ulubione')]").shouldBe(visible).click();
    }

    // 'My wishlist' - sprawdzenie, że produkt jest na liście
    @Then("the product {string} should be on the list")
    public void productShouldBeOnList(String productName) {
        List<SelenideElement> wishListsElements =$$("p.wishlist-product-title")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .stream().toList();
        List<String> wishListsElementsNames = wishListsElements.stream().map(SelenideElement::getText).toList();
        Assertions.assertTrue(wishListsElementsNames.size() == 1 && wishListsElementsNames.getFirst().equals(productName));
    }


    // -23- Wishlist – utworzenie nowej listy podczas dodawania

    // Przejcie na Home page
    @Given("the user is on the Home page")
    public void userIsOnHomePage() {
        $("#_desktop_logo").shouldBe(visible).click();
    }

    // Popup 'Add to whishlist' - kliknięcie w link 'Create new list'
    @And("the user clicks Create new list in the popup")
    public void createNewList() {
        $("a.wishlist-add-to-new.text-primary").shouldBe(visible).click();
    }

    // Home page/Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'
    @And("clicks {string}")
    public void clickCreateWishlist(String buttonName) {
        $x("//button[contains(text(),'" + buttonName + "t')]").shouldBe(visible).click();
    }

    // Popup 'Add to whishlist' - wybranie nowo utworzonej listy
    @And("selects the newly created wishlist")
    public void selectNewWishlist() {
        $x("//li[@class='wishlist-list-item']/p[contains(text(),'Ulubione')]").shouldBe(visible).click();
    }


    // -24- Wishlist – utworzenie listy na podstronie ‘My wishlists’

    // Ulubione - przejście na stronę 'My wishlists'
    @Given("the user is on the My wishlists page")
    public void userIsOnMyWishlistsPage() {
        $x("//nav[@data-depth='4']//a[contains(., 'My wishlists')]").shouldBe(visible).click();
    }

    // My wishlists - kliknięcie w 'Create new list'
    @When("the user clicks Create new list")
    public void clickCreateNewList() {
        $x("//div[@class='wishlist-container-header']/a[contains(text(),'Create new list')]")
                .shouldBe(visible).click();
    }

    // Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń
    @And("enters the name of the new wishlist {string}")
    public void enterNewWishlistName(String listName) {
        $x("").setValue(listName);
    }

    // Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'
    @And("clicks 'Create wishlist'")
    public void clickCreateWishlistButton() {
        $x("//button[contains(text(),'Create wishlist')]").shouldBe(visible).click();
    }

    // TOAST/'The list has been properly created' - potwierdzenie pojawienia się komunikatu
    @Then("the toast message 'The list has been properly created' should be displayed")
    public void toastMessageCreatedDisplayed() {
        Assertions.assertTrue($x("//p[contains(text(),\"The list has been properly created\")]").shouldBe(visible).isDisplayed());
    }

    // potwierdzenie, czy istnieje lista o nazwie 'Super lista'
    @Then("the list 'Super lista' should exist")
    public void checkSuperListaExists() {
        Assertions.assertTrue($x("//div[@class='wishlist-list-container']//p[contains(text(),'Super lista')]")
                .shouldBe(visible).isDisplayed());
    }

    // My wishlists - kliknięcie w trzy kropki
    @When("the user clicks the actions menu for {string}")
    public void clickMoreActionsSuperLista(String nazwaListy) {
        $x("//p[contains(text(),\"" + nazwaListy + "\")]/../div[@class=\"wishlist-list-item-right\"]" +
                "/button[@class=\"wishlist-list-item-actions\"]")
                .shouldBe(interactable).click();
    }

    // My wishlists - kliknięcie w 'Rename'
    @And("selects 'Rename'")
    public void selectRename() {
        $x("//p[contains(text(),\"Super lista\")]/..//div[@class=\"wishlist-list-item-right\"]" +
                "/div[@class=\"dropdown-menu show\"]/button[contains(text(),\"Rename\")]").shouldBe(interactable).click();
    }

    // Popup 'Rename wishlist' - aktualizacja nazwy nowej listy życzeń
    @And("updates the wishlist name")
    public void updateWishlistName() {
        SelenideElement changeNameOfList = $x("//h5[contains(text(),\"Rename wishlist\")]/../..//div/div/input").shouldBe(visible);
        changeNameOfList.clear();
        changeNameOfList.setValue("Lista życzeń");
    }

    // Popup 'Rename wishlist' - kliknięcie w button 'Rename wishlist'
    @And("clicks 'Rename wishlist'")
    public void clickRenameWishlistButton() {
        $x("//button[contains(text(),\"Rename wishlist\")]").shouldBe(visible).click();
    }

    // TOAST/'List has been renamed' - potwierdzenie pojawienia się komunikatu
    @Then("the toast message 'List has been renamed' should be displayed")
    public void toastMessageRenamedDisplayed() {
        Assertions.assertTrue($x("//p[contains(text(),'List has been renamed')]").shouldBe(visible).isDisplayed());
    }

    // My wishlists - kliknięcie w trzy kropki
    @When("the user clicks the actions menu for the wishlist {string}")
    public void clickMoreActionsWishlist(String nazwaListy) {
        $x("//p[contains(text(),\"" + nazwaListy + "\")]/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]")
                .shouldBe(interactable).click();
    }

    // My wishlists - kliknięcie w button 'Share'
    @And("selects 'Share'")
    public void selectShare() {
        $x("//button[contains(text(),\"Share\")]").shouldBe(visible).click();
    }

    // Share wishlist - kliknięcie w button 'Copy text'
    @And("clicks 'Copy text'")
    public void clickCopyText() {
        $x("//button[contains(text(),'Copy text')]").shouldBe(visible).click();
    }

    // TOAST/'Share link copied!' - potwierdzenie pojawienia się komunikatu
    @Then("the toast message 'Share link copied!' should be displayed")
    public void toastMessageCopiedDisplayed() {
        Assertions.assertTrue($x("//p[contains(text(),'Share link copied!')]").shouldBe(visible).isDisplayed());
    }

    // My wishlists - usunięcie listy
    @When("the user deletes the wishlist")
    public void deleteWishlist() {
        $x("//p[contains(text(),\"Lista życzeń\")]/../div[@class=\"wishlist-list-item-right\"]" +
                "/button/i[contains(text(),\"delete\")]").shouldBe(visible).click();
    }

    // Popup 'Delete wishlist' - kliknięcie w button 'Delete'
    @And("confirms deletion")
    public void confirmDeleteWishlist() {
        $x("//div[@class='modal-footer']/button[contains(text(),'Delete')]").shouldBe(visible).click();
    }

    // TOAST/'List has been removed' - potwierdzenie pojawienia się komunikatu
    @Then("the toast message 'List has been removed' should be displayed")
    public void toastMessageRemovedDisplayed() {
        Assertions.assertTrue($x("//p[contains(text(),'List has been removed')]").shouldBe(visible).isDisplayed());
    }


// -25- Strona główna/Footer - sprawdzenie działania linków w stopce

    // Home page/Footer - kliknięcie w link 'Prices drop'
    @When("I click \"Prices drop\" link in footer")
    public void iClickPricesDropInFooter() {
        $("#link-product-page-prices-drop-1").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Prices drop'
    @Then("the \"Prices drop\" page should open")
    public void pricesDropPageShouldOpen() {
        Assertions.assertTrue($("#js-product-list-header").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'New products'
    @When("I click \"New products\" link in footer")
    public void iClickNewProductsInFooter() {
        $("#link-product-page-new-products-1").click();
    }

    // Potwierdzenie otwarcia podstrony 'New products'
    @Then("the \"New products\" page should open")
    public void newProductsPageShouldOpen() {
        Assertions.assertTrue($("#js-product-list-header").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Best sellers'
    @When("I click \"Best sellers\" link in footer")
    public void iClickBestSellersInFooter() {
        $("#link-product-page-best-sales-1").click();
    }

    // Potwierdzenie otwarcia podstrony 'Best sellers'
    @Then("the \"Best sellers\" page should open")
    public void bestSellersPageShouldOpen() {
        Assertions.assertTrue($("#js-product-list-header").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Delivery'
    @When("I click \"Delivery\" link in footer")
    public void iClickDeliveryInFooter() {
        $("#link-cms-page-1-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Delivery'
    @Then("the \"Delivery\" page should open")
    public void deliveryPageShouldOpen() {
        Assertions.assertTrue($x("//h1[contains(text(),'Delivery')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Legal Notice'
    @When("I click \"Legal Notice\" link in footer")
    public void iClickLegalNoticeInFooter() {
        $("#link-cms-page-2-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Legal Notice'
    @Then("the \"Legal Notice\" page should open")
    public void legalNoticePageShouldOpen() {
        Assertions.assertTrue($x("//h1[contains(text(),'Legal Notice')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Terms and conditions of use'
    @When("I click \"Terms and conditions of use\" link in footer")
    public void iClickTermsAndConditionsInFooter() {
        $("#link-cms-page-3-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Terms and conditions of use'
    @Then("the \"Terms and conditions of use\" page should open")
    public void termsAndConditionsPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'Terms and conditions of use')]")
                .shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'About us'
    @When("I click \"About us\" link in footer")
    public void iClickAboutUsInFooter() {
        $("#link-cms-page-4-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'About us'
    @Then("the \"About us\" page should open")
    public void aboutUsPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'About us')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Secure payment'
    @When("I click \"Secure payment\" link in footer")
    public void iClickSecurePaymentInFooter() {
        $("#link-cms-page-5-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Secure payment'
    @Then("the \"Secure payment\" page should open")
    public void securePaymentPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'Secure payment')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Contact us'
    @When("I click \"Contact us\" link in footer")
    public void iClickContactUsInFooter() {
        $("#link-static-page-contact-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Contact us'
    @Then("the \"Contact us\" page should open")
    public void contactUsPageShouldOpen() {
        Assertions.assertTrue($x("//div[@class='col-md-9 col-md-offset-3']/h3[contains(text(),'Contact us')]")
                .shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Sitemap'
    @When("I click \"Sitemap\" link in footer")
    public void iClickSitemapInFooter() {
        $("#link-static-page-sitemap-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Sitemap'
    @Then("the \"Sitemap\" page should open")
    public void sitemapPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1/span[contains(text(),'Sitemap')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Stores'
    @When("I click \"Stores\" link in footer")
    public void iClickStoresInFooter() {
        $("#link-static-page-stores-2").click();
    }

    // Potwierdzenie otwarcia podstrony 'Stores'
    @Then("the \"Stores\" page should open")
    public void storesPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Personal info'
    @When("I click \"Personal info\" link in footer")
    public void iClickPersonalInfoInFooter() {
        $("a[title='Personal info']").click();
    }

    // Potwierdzenie otwarcia podstrony 'Personal info'
    @Then("the \"Personal info\" page should open")
    public void personalInfoPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'Your personal information')]")
                .shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Orders'
    @When("I click \"Orders\" link in footer")
    public void iClickOrdersInFooter() {
        $("a[title='Orders']").click();
    }

    // Potwierdzenie otwarcia podstrony 'Orders'
    @Then("the \"Orders\" page should open")
    public void ordersPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'Order history')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Credit slips'
    @When("I click \"Credit slips\" link in footer")
    public void iClickCreditSlipsInFooter() {
        $("a[title='Credit slips']").click();
    }

    // Potwierdzenie otwarcia podstrony 'Credit slips'
    @Then("the \"Credit slips\" page should open")
    public void creditSlipsPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'Credit slips')]").shouldBe(visible).isDisplayed());
    }

    // Home page/Footer - kliknięcie w link 'Addresses'
    @When("I click \"Addresses\" link in footer")
    public void iClickAddressesInFooter() {
        $("a[title='Addresses']").click();
    }

    // Potwierdzenie otwarcia podstrony 'Addresses'
    @Then("the \"Addresses\" page should open")
    public void addressesPageShouldOpen() {
        Assertions.assertTrue($x("//header[@class='page-header']/h1[contains(text(),'Your addresses')]").shouldBe(visible).isDisplayed());
    }

    // Header - kliknięcie w button 'Sign out'
    @When("I click \"Sign out\" button in header")
    public void iClickSignOutInHeader() {
        $("a.logout.hidden-sm-down").shouldBe(visible).click();
    }

    // Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'
    @Then("the \"Sign in\" button should be visible")
    public void signInButtonShouldBeVisible() {
        Assertions.assertTrue($(".user-info a").shouldBe(visible).isDisplayed());
    }
}
