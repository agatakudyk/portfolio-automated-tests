Feature: Selenide POP Prestashop Test
  As a user
  I want to interact with products on the website
  So that I can add items to my cart

  Background:
    Given the website is opened at "http://localhost:8080/pl/"

  # -1- Strona główna - zmiana języka strony z polskiego na angielski
  Scenario: Switch language into English
    When I click on the language dropdown in the header
    And I select English from the language list
    Then I should see that the language has been changed to English

# -2- Użytkownik niezarejestrowany – poprawne dodanie i usunięcie produktu z koszyka
  Scenario: Add to cart and delete product as unregistered user
    When I click the wishlist button of "Today is a good day Framed..."
    Then I should see a popup message that login is required
    When I close the wishlist popup
    And I open the product page for "Today is a good day Framed Poster"
    And I click the "Add to cart" button
    Then I should see a success popup confirming the product was added
    When I close the add-to-cart popup by clicking Proceed to checkout
    Then the shopping cart should contain the product
    When I delete the product from the cart
    Then I should see a message that the cart is empty

# -3- Użytkownik niezarejestrowany - dodanie produktu do koszyka i finalizacja zakupu:
  Scenario: Add product to cart and checkout as unregistered user
    When I return to the homepage from cart
    And I open the product page for "Today is a good day Framed Poster"
    And I add the product to the cart
    And I click Proceed to checkout in the popup
    And I proceed to checkout from the cart
    And I fill in my personal information
    And I check the required checkboxes for privacy and terms
    And I click "Continue"
    And I fill in my address information and continue
    And I continue to the shipping method
    And I select shipping method and continue
    And I select payment by bank wire, agree to terms, and place the order
    Then I should see Your order is confirmed message

 # -4- Użytkownik niezarejestrowany - uzupełnienie formularza ‘Save time on your next order, sign up now’
  Scenario: Fill in "Save time on..." form as unregistered user
    When I click "Save" on the form without filling in any data
    Then I should see a validation message "Wypełnij to pole."
    When I fill in my first name, last name, email, and password
    And I check privacy and terms checkboxes
    And I click "Save"
    Then the data should be successfully saved

# -5- Niepoprawna rejestracja:
  Scenario: Fail signup with empty fields
    When I click the signup link on login page
    And I click Save without filling in fields
    Then I should see a validation message "Wypełnij to pole."

# -6- Poprawna rejestracja:
  Scenario: Successful user signup
    When I fill in first name, last name, email and password
    And I check privacy and terms checkboxes
    And I click "Save"
    Then I should see the "Sign out" button
    When I click "Sign out"
    Then I should see the "Sign in" button

# -7- Niepoprawne logowanie:
  Scenario: Fail login with incorrect data
    When I click Sign In in the header
    And I click Sign In on login page with empty fields
    Then I should see a validation message "Wypełnij to pole."
    When I fill in email and password fields
    And I click "Sign In"
    Then I should see Authentication failed. message

# -8- Reset hasła:
  Scenario: Reset forgotten password
    When I click Forgot your password? on login page
    And I fill in my email address
    And I click "Send reset link"
    Then I should see a message confirming that the email is sent

# -9- Poprawne logowanie:
  Scenario: Successful login and password change
    When I go back to login page
    And I fill in email and current password
    And I click "Sign In"
    Then I should see Sign out button
    When I navigate to Your account > Information
    And I fill in current password and new password
    And I check privacy and terms checkboxes
    And I click "Save"
    Then I should see confirmation that information is updated
    When I log out and login with the new password
    Then I should see Sign out button
    And I revert to previous password

# -10- Filtrowanie na podstronie ACCESSORIES:
  Scenario: Clear accessories product filtering
    When I open the Accessories page
    And I select filter "Ceramic" and "Available"
    And I clear all filters
    Then I should see that filters are cleared

# -11- Sortowanie na podstronie ART:
  Scenario: Sort ART products
    When I open the ART page
    And I sort products by "Name, A to Z"
    Then products should be sorted alphabetically
    When I sort products by "Price, low to high"
    Then products should be sorted by ascending price

# -12- Podstrona ART – dodanie opinii o produkcie:
  Scenario: Add review to poster
    When I open product "The Best Is Yet To Come Framed Poster"
    And I click to add a review
    And I fill in review title and content
    And I click "Send"
    Then I should see confirmation that the review was sent
    When I close the review popup by clicking 'OK'

# -13- Zwiększenie ilości produktu i dodanie do koszyka:
  Scenario: Add products to cart with quantity changes
    When I set product quantity to 4
    And I increase product quantity by using arrows
    And I click "Add to cart"
    Then I should see confirmation that the product was added successfully

# -14- Sprawdzenie zawartości koszyka:
  Scenario: Validate cart content
    When I close the popup by clicking 'Proceed to checkout'
    Then the cart should contain product "The best is yet to come' Framed poster"
    And product quantity should match the summary quantity
    And the total price should equal unit price multiplied by quantity

# -15- Zapisanie danych w formularzu adresu:
  Scenario: Addresses form fails with empty fields
    When I proceed to checkout from the shopping cart
    And I click 'Continue' on the Addresses page
    Then I should see validation message "Wypełnij to pole."
    When I fill in the Address field
    And I fill in the Zip or Postal Code field
    And I fill in the City field
    And I click 'Continue' on the Addresses page

# -16- Wybór formy dostawy
  Scenario: Shipping method selection
    When I select shipping method 'PrestaShop'
    And I select shipping method "My carrier"
    And I add a comment to the order
    And I click "Continue" on the Shipping method page

# -17- Wybór formy płatności  wybór formy płatności + walidacja
  Scenario: Payment method selection
    When I select payment option "Pay by bank wire"
    And I select payment option "Pay by check"
    And I check the agreement checkbox
    And I click "Place Order"
    Then I should see a confirmation message that the order was placed successfully

# -18- Formularz kontaktowy z działem obsługi klienta:
  Scenario: Contact customer service
    When I click the link to contact the customer service department from the order confirmation page
    And I click the "Send" button on the empty contact form
    Then I should see a validation message on the contact form
    When I fill in the message content in the contact form
    And I click the "Send" button
    Then I should see an information message confirming that the message was sent successfully

# -19- Detail:
  Scenario: Add message in order details page
    When I open the user profile from the header
    And I go to the 'Order history and details' section
    And I click the 'Details' link for an order
    And I click the 'Send' button in an empty 'Add a message' form
    Then I should see a validation message saying that the message cannot be blank
    When I fill in the message content in the "Add a message" form
    And I click the "Send" button
    Then I should see a confirmation message saying that the message was successfully sent

# -20- Reorder - ponowne złożenie zamówienia:
  Scenario: Reorder previous order
    When I click the 'Reorder' link in the order details page
    And I click the 'Edit' link in the Addresses section
    And I change the city name
    And I click the "Continue" button on the Addresses page
    And I select the "My carrier" shipping method
    And I click the "Continue" button on the Shipping Method page
    And I choose "Pay by bank wire" as the payment method
    And I check the terms and conditions checkbox
    And I click the "Place Order" button
    Then I should see a confirmation message that the order was successfully placed

# -21- Panel użytkownika/Adres – dodanie nowego adresu, aktualizacja i usunięcie
  Scenario: Add, update and delete user address
    When the user goes to Your account
    And navigates to "Addresses"
    And clicks the Create new address link
    And fills in the Address field
    And clicks the Save button
    Then the message "Address successfully added!" is displayed
    When updates the Address field
    Then the message "Address successfully updated!" is displayed
    When the user deletes the new address

# -22- Wishlist – dodanie do istniejącej listy:
  Scenario: Add items to static wishlist
    When the user clicks the wishlist icon for "Hummingbird printed t-shirt"
    And the user selects My wishlist from the popup
    Then the toast message "Product added" should be displayed
    When the user goes to Your account
    And navigates to "My wishlists"
    And clicks on My wishlist
    Then the product "Hummingbird printed t-shirt" should be on the list

# -23- Wishlist – utworzenie nowej listy podczas dodawania:
  Scenario: Add items to new wishlist
    Given the user is on the Home page
    When the user clicks the wishlist icon for "Mug The adventure begins"
    And the user clicks Create new list in the popup
    And enters the name of the new wishlist "Ulubione"
    And clicks "Create wishlist"
    And selects the newly created wishlist
    Then the toast message "Product added" should be displayed
    When the user goes to Your account
    And navigates to "My wishlists"
    And clicks on the Ulubione wishlist
    Then the product "Mug The adventure begins" should be on the list

# -24- Wishlist – utworzenie listy na podstronie ‘My wishlists’:
  Scenario: Create, rename, share, and delete wishlist
    Given the user is on the 'My wishlists' page
    When the user clicks 'Create new list'
    And enters the name of the new wishlist "Super Lista"
    And clicks "Create wishlist"
    Then the toast message "The list has been properly created" should be displayed
    And the list 'Super lista' should exist
    When the user clicks the actions menu for "Super lista"
    And selects 'Rename'
    And updates the wishlist name
    And clicks "Rename wishlist"
    Then the toast message "List has been renamed" should be displayed
    When the user clicks the actions menu for the wishlist "Lista życzeń"
    And selects 'Share'
    And clicks "Copy text"
    Then the toast message "Share link copied!" should be displayed
    When the user deletes the wishlist
    And confirms deletion
    Then the toast message "List has been removed" should be displayed

# -25- Strona główna/Footer   sprawdzenie działania linków w stopce
  Scenario: Check that all footer links open correct pages
    When I click "Prices drop" link in footer
    Then the "Prices drop" page should open

    When I click "New products" link in footer
    Then the "New products" page should open

    When I click "Best sellers" link in footer
    Then the "Best sellers" page should open

    When I click "Delivery" link in footer
    Then the "Delivery" page should open

    When I click "Legal Notice" link in footer
    Then the "Legal Notice" page should open

    When I click "Terms and conditions of use" link in footer
    Then the "Terms and conditions of use" page should open

    When I click "About us" link in footer
    Then the "About us" page should open

    When I click "Secure payment" link in footer
    Then the "Secure payment" page should open

    When I click "Contact us" link in footer
    Then the "Contact us" page should open

    When I click "Sitemap" link in footer
    Then the "Sitemap" page should open

    When I click "Stores" link in footer
    Then the "Stores" page should open

    When I click "Personal info" link in footer
    Then the "Personal info" page should open

    When I click "Orders" link in footer
    Then the "Orders" page should open

    When I click "Credit slips" link in footer
    Then the "Credit slips" page should open

    When I click "Addresses" link in footer
    Then the "Addresses" page should open

    When I click "Sign out" button in header
    Then the "Sign in" button should be visible
