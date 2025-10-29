package lesson17Homework.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelenideActionStepDefinition {
    @Given("the website is opened at {string}")
    public void theWebsiteIsOpenedAt(String arg0) {
    }

    @When("I click on the language dropdown in the header")
    public void iClickOnTheLanguageDropdownInTheHeader() {
    }

    @And("I select {string} from the language list")
    public void iSelectFromTheLanguageList(String arg0) {
    }

    @Then("I should see that the language has been changed to English")
    public void iShouldSeeThatTheLanguageHasBeenChangedToEnglish() {
    }

    @When("I click the wishlist button of {string}")
    public void iClickTheWishlistButtonOf(String arg0) {
    }

    @Then("I should see a popup message that login is required")
    public void iShouldSeeAPopupMessageThatLoginIsRequired() {
    }

    @When("I close the wishlist popup")
    public void iCloseTheWishlistPopup() {
    }

    @And("I open the product page for {string}")
    public void iOpenTheProductPageFor(String arg0) {
    }

    @And("I click the {string} button")
    public void iClickTheButton(String arg0) {
    }

    @Then("I should see a success popup confirming the product was added")
    public void iShouldSeeASuccessPopupConfirmingTheProductWasAdded() {
    }

    @When("I close the add-to-cart popup by clicking {string}")
    public void iCloseTheAddToCartPopupByClicking(String arg0) {
    }

    @Then("the shopping cart should contain the product")
    public void theShoppingCartShouldContainTheProduct() {
    }

    @When("I delete the product from the cart")
    public void iDeleteTheProductFromTheCart() {
    }

    @Then("I should see a message that the cart is empty")
    public void iShouldSeeAMessageThatTheCartIsEmpty() {
    }

    @When("I return to the homepage from cart")
    public void iReturnToTheHomepageFromCart() {
    }

    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
    }

    @And("I click {string} in the popup")
    public void iClickInThePopup(String arg0) {
    }

    @And("I proceed to checkout from the cart")
    public void iProceedToCheckoutFromTheCart() {
    }

    @And("I fill in my personal information")
    public void iFillInMyPersonalInformation() {
    }

    @And("I check the required checkboxes for privacy and terms")
    public void iCheckTheRequiredCheckboxesForPrivacyAndTerms() {
    }

    @And("I click {string}")
    public void iClick(String arg0) {
    }

    @And("I fill in my address information and continue")
    public void iFillInMyAddressInformationAndContinue() {
    }

    @And("I continue to the shipping method")
    public void iContinueToTheShippingMethod() {
    }

    @And("I select shipping method and continue")
    public void iSelectShippingMethodAndContinue() {
    }

    @And("I select payment by bank wire, agree to terms, and place the order")
    public void iSelectPaymentByBankWireAgreeToTermsAndPlaceTheOrder() {
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String arg0) {
    }

    @When("I click {string} on the form without filling in any data")
    public void iClickOnTheFormWithoutFillingInAnyData(String arg0) {
    }

    @Then("I should see a validation message {string}")
    public void iShouldSeeAValidationMessage(String arg0) {
    }

    @When("I fill in my first name, last name, email, and password")
    public void iFillInMyFirstNameLastNameEmailAndPassword() {
    }

    @And("I check privacy and terms checkboxes")
    public void iCheckPrivacyAndTermsCheckboxes() {
    }

    @Then("the data should be successfully saved")
    public void theDataShouldBeSuccessfullySaved() {
    }

    @When("I click the signup link on login page")
    public void iClickTheSignupLinkOnLoginPage() {
    }

    @And("I click {string} without filling in fields")
    public void iClickWithoutFillingInFields(String arg0) {
    }

    @When("I fill in first name, last name, email, and password")
    public void iFillInFirstNameLastNameEmailAndPassword() {
    }

    @Then("I should see the {string} button")
    public void iShouldSeeTheButton(String arg0) {
    }

    @When("I click {string} in the header")
    public void iClickInTheHeader(String arg0) {
    }

    @And("I click {string} on login page with empty fields")
    public void iClickOnLoginPageWithEmptyFields(String arg0) {
    }

    @When("I fill in email and password fields")
    public void iFillInEmailAndPasswordFields() {
    }

    @When("I click {string} on login page")
    public void iClickOnLoginPage(String arg0) {
    }

    @And("I fill in my email address")
    public void iFillInMyEmailAddress() {
    }

    @Then("I should see a message confirming that the email has been sent")
    public void iShouldSeeAMessageConfirmingThatTheEmailHasBeenSent() {
    }

    @When("I go back to login page")
    public void iGoBackToLoginPage() {
    }

    @And("I fill in email and current password")
    public void iFillInEmailAndCurrentPassword() {
    }

    @Then("I should see {string} button")
    public void iShouldSeeButton(String arg0) {
    }

    @When("I navigate to {string} > {string}")
    public void iNavigateTo(String arg0, String arg1) {
    }

    @And("I fill in current password and new password")
    public void iFillInCurrentPasswordAndNewPassword() {
    }

    @Then("I should see confirmation that information is updated")
    public void iShouldSeeConfirmationThatInformationIsUpdated() {
    }

    @When("I log out and login with the new password")
    public void iLogOutAndLoginWithTheNewPassword() {
    }

    @And("I revert to previous password")
    public void iRevertToPreviousPassword() {
    }

    @When("I open the Accessories page")
    public void iOpenTheAccessoriesPage() {
    }

    @And("I select filter {string} and {string}")
    public void iSelectFilterAnd(String arg0, String arg1) {
    }

    @And("I clear all filters")
    public void iClearAllFilters() {
    }

    @Then("I should see that filters are cleared")
    public void iShouldSeeThatFiltersAreCleared() {
    }

    @When("I open the ART page")
    public void iOpenTheARTPage() {
    }

    @And("I sort products by {string}")
    public void iSortProductsBy(String arg0) {
    }

    @Then("products should be sorted alphabetically")
    public void productsShouldBeSortedAlphabetically() {
    }

    @Then("products should be sorted by ascending price")
    public void productsShouldBeSortedByAscendingPrice() {
    }

    @When("I open product {string}")
    public void iOpenProduct(String arg0) {
    }

    @And("I click to add a review")
    public void iClickToAddAReview() {
    }

    @And("I fill in review title and content")
    public void iFillInReviewTitleAndContent() {
    }

    @Then("I should see confirmation that review was added")
    public void iShouldSeeConfirmationThatReviewWasAdded() {
    }

    @When("I close the review popup by clicking {string}")
    public void iCloseTheReviewPopupByClicking(String arg0) {
    }

    @When("I set quantity to {int} by typing")
    public void iSetQuantityToByTyping(int arg0) {
    }

    @And("I increase quantity by {int} using arrows")
    public void iIncreaseQuantityByUsingArrows(int arg0) {
    }

    @Then("I should see confirmation that the product was added")
    public void iShouldSeeConfirmationThatTheProductWasAdded() {
    }

    @Then("cart should show correct product name")
    public void cartShouldShowCorrectProductName() {
    }

    @And("quantity in product section matches summary section")
    public void quantityInProductSectionMatchesSummarySection() {
    }

    @And("total price is calculated correctly")
    public void totalPriceIsCalculatedCorrectly() {
    }

    @When("I proceed to checkout without filling address")
    public void iProceedToCheckoutWithoutFillingAddress() {
    }

    @Then("I should see validation messages")
    public void iShouldSeeValidationMessages() {
    }

    @When("I fill in address, postal code, city")
    public void iFillInAddressPostalCodeCity() {
    }

    @When("I select {string} shipping")
    public void iSelectShipping(String arg0) {
    }

    @And("I add a comment to the order")
    public void iAddACommentToTheOrder() {
    }

    @When("I choose {string} and {string}")
    public void iChooseAnd(String arg0, String arg1) {
    }

    @And("I agree to terms")
    public void iAgreeToTerms() {
    }

    @Then("I should see order confirmation")
    public void iShouldSeeOrderConfirmation() {
    }

    @When("I open customer service page")
    public void iOpenCustomerServicePage() {
    }

    @And("I attempt to send empty message")
    public void iAttemptToSendEmptyMessage() {
    }

    @Then("I should see validation message")
    public void iShouldSeeValidationMessage() {
    }

    @When("I fill in the message and click {string}")
    public void iFillInTheMessageAndClick(String arg0) {
    }

    @Then("I should see confirmation {string}")
    public void iShouldSeeConfirmation(String arg0) {
    }

    @When("I go to {string} > {string}")
    public void iGoTo(String arg0, String arg1) {
    }

    @And("I click {string} on an order")
    public void iClickOnAnOrder(String arg0) {
    }

    @When("I fill in a message and click {string}")
    public void iFillInAMessageAndClick(String arg0) {
    }

    @Then("I should see {string}")
    public void iShouldSee(String arg0) {
    }

    @When("I click {string} on previous order")
    public void iClickOnPreviousOrder(String arg0) {
    }

    @And("I edit address and change city")
    public void iEditAddressAndChangeCity() {
    }

    @And("I continue to shipping method and select carrier")
    public void iContinueToShippingMethodAndSelectCarrier() {
    }

    @And("I continue to payment and choose {string}")
    public void iContinueToPaymentAndChoose(String arg0) {
    }

    @And("I agree to terms and place order")
    public void iAgreeToTermsAndPlaceOrder() {
    }

    @And("I create a new address and fill in all fields")
    public void iCreateANewAddressAndFillInAllFields() {
    }

    @When("I update the address's postal code")
    public void iUpdateTheAddressSPostalCode() {
    }

    @When("I delete the new address")
    public void iDeleteTheNewAddress() {
    }

    @When("I add product {string} to wishlist")
    public void iAddProductToWishlist(String arg0) {
    }

    @And("I select existing wishlist")
    public void iSelectExistingWishlist() {
    }

    @Then("I should see {string} toast")
    public void iShouldSeeToast(String arg0) {
    }

    @And("the product should appear in the wishlist")
    public void theProductShouldAppearInTheWishlist() {
    }

    @And("I create a new wishlist named {string}")
    public void iCreateANewWishlistNamed(String arg0) {
    }

    @And("I select this new wishlist")
    public void iSelectThisNewWishlist() {
    }

    @When("I go to {string} page")
    public void iGoToPage(String arg0) {
    }

    @And("I create a new wishlist {string}")
    public void iCreateANewWishlist(String arg0) {
    }

    @Then("I should see confirmation toast")
    public void iShouldSeeConfirmationToast() {
    }

    @When("I rename {string}")
    public void iRename(String arg0) {
    }

    @Then("I should see confirmation toast for renaming")
    public void iShouldSeeConfirmationToastForRenaming() {
    }

    @When("I share the wishlist")
    public void iShareTheWishlist() {
    }

    @When("I delete the wishlist")
    public void iDeleteTheWishlist() {
    }

    @When("I click on each footer link: Prices drop, New products, Best sellers, Delivery, Legal Notice, Terms and conditions of use, About us, Secure payment, Contact us, Sitemap, Stores, Personal info, Orders, Credit slips, Addresses")
    public void iClickOnEachFooterLinkPricesDropNewProductsBestSellersDeliveryLegalNoticeTermsAndConditionsOfUseAboutUsSecurePaymentContactUsSitemapStoresPersonalInfoOrdersCreditSlipsAddresses() {
    }

    @Then("each page should open correctly")
    public void eachPageShouldOpenCorrectly() {
    }

    @And("I log out")
    public void iLogOut() {
    }
}
