Feature: Selenide POP Prestashop Test
  As a user
  I want to interact with products on the website
  So that I can add items to my cart

  Background:
    Given the website is opened at "http://localhost:8080/pl/"

  # -1- Strona główna - zmiana języka strony z polskiego na angielski
  Scenario: Switch language into English
    When I click on the language dropdown in the header
    And I select "English" from the language list
    Then I should see that the language has been changed to English

# -2- Użytkownik niezarejestrowany – poprawne dodanie i usunięcie produktu z koszyka
  Scenario: Add to cart and delete product as unregistered user
    When I click the wishlist button of "Today is a good day Framed Poster"
    Then I should see a popup message that login is required
    When I close the wishlist popup
    And I open the product page for "Today is a good day Framed Poster"
    And I click the "Add to cart" button
    Then I should see a success popup confirming the product was added
    When I close the add-to-cart popup by clicking "Proceed to checkout"
    Then the shopping cart should contain the product
    When I delete the product from the cart
    Then I should see a message that the cart is empty

# -3- Użytkownik niezarejestrowany - dodanie produktu do koszyka i finalizacja zakupu:
  Scenario: Add product to cart and checkout as unregistered user
    When I return to the homepage from cart
    And I open the product page for "Today is a good day Framed Poster"
    And I add the product to the cart
    And I click "Proceed to checkout" in the popup
    And I proceed to checkout from the cart
    And I fill in my personal information
    And I check the required checkboxes for privacy and terms
    And I click "Continue"
    And I fill in my address information and continue
    And I continue to the shipping method
    And I select shipping method and continue
    And I select payment by bank wire, agree to terms, and place the order
    Then I should see "Your order is confirmed" message

 # -4- Użytkownik niezarejestrowany - uzupełnienie formularza ‘Save time on your next order, sign up now’
  Scenario: Fill in "Save time on..." form as unregistered user
    When I click "Save" on the form without filling in any data
    Then I should see a validation message "Please fill out this field."
    When I fill in my first name, last name, email, and password
    And I check privacy and terms checkboxes
    And I click "Save"
    Then the data should be successfully saved

# -5- Niepoprawna rejestracja:
  Scenario: Fail signup with empty fields
    When I click the signup link on login page
    And I click "Save" without filling in fields
    Then I should see a validation message "Please fill out this field."

# -6- Poprawna rejestracja:
  Scenario: Successful user signup
    When I fill in first name, last name, email, and password
    And I check privacy and terms checkboxes
    And I click "Save"
    Then I should see the "Sign out" button
    When I click "Sign out"
    Then I should see the "Sign in" button

# -7- Niepoprawne logowanie:
  Scenario: Fail login with incorrect data
    When I click "Sign In" in the header
    And I click "Sign In" on login page with empty fields
    Then I should see a validation message "Please fill out this field."
    When I fill in email and password fields
    And I click "Sign In"
    Then I should see "Authentication failed." message

# -8- Reset hasła:
  Scenario: Reset forgotten password
    When I click "Forgot your password?" on login page
    And I fill in my email address
    And I click "Send reset link"
    Then I should see a message confirming that the email has been sent

# -9- Poprawne logowanie:
  Scenario: Successful login and password change
    When I go back to login page
    And I fill in email and current password
    And I click "Sign In"
    Then I should see "Sign out" button
    When I navigate to "Your account" > "Information"
    And I fill in current password and new password
    And I check privacy and terms checkboxes
    And I click "Save"
    Then I should see confirmation that information is updated
    When I log out and login with the new password
    Then I should see "Sign out" button
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
    Then I should see confirmation that review was added
    When I close the review popup by clicking "OK"

# -13- Zwiększenie ilości produktu i dodanie do koszyka:
  Scenario: Add products to cart with quantity changes
    When I set quantity to 4 by typing
    And I increase quantity by 3 using arrows
    And I click "Add to cart"
    Then I should see confirmation that the product was added

# -14- Sprawdzenie zawartości koszyka:
  Scenario: Validate cart content
    When I click "Proceed to checkout"
    Then cart should show correct product name
    And quantity in product section matches summary section
    And total price is calculated correctly

# -15- Zapisanie danych w formularzu adresu:
  Scenario: Addresses form fails with empty fields
    When I proceed to checkout without filling address
    Then I should see validation messages
    When I fill in address, postal code, city
    And I click "Continue"

# -16- Wybór formy dostawy
  Scenario: Shipping method selection
    When I select "My carrier" shipping
    And I add a comment to the order
    And I click "Continue"

# -17- Wybór formy płatności  wybór formy płatności + walidacja
  Scenario: Payment method selection
    When I choose "Pay by bank wire" and "Pay by Check"
    And I agree to terms
    And I click "Place Order"
    Then I should see order confirmation

# -18- Formularz kontaktowy z działem obsługi klienta:
  Scenario: Contact customer service
    When I open customer service page
    And I attempt to send empty message
    Then I should see validation message
    When I fill in the message and click "Send"
    Then I should see confirmation "Your message has been successfully sent"

# -19- Detail:
  Scenario: Add message in order details page
    When I go to "Your account" > "Order history and details"
    And I click "Details" on an order
    And I attempt to send empty message
    Then I should see validation message
    When I fill in a message and click "Send"
    Then I should see "Message successfully sent"

# -20- Reorder - ponowne złożenie zamówienia:
  Scenario: Reorder previous order
    When I click "Reorder" on previous order
    And I edit address and change city
    And I continue to shipping method and select carrier
    And I continue to payment and choose "Pay by bank wire"
    And I agree to terms and place order
    Then I should see order confirmation

# -21- Panel użytkownika/Adres – dodanie nowego adresu, aktualizacja i usunięcie
  Scenario: Add, update and delete user address
    When I go to "Your account" > "Addresses"
    And I create a new address and fill in all fields
    And I click "Save"
    Then I should see "Address successfully added!"
    When I update the address's postal code
    And I click "Save"
    Then I should see "Address successfully updated!"
    When I delete the new address
    Then I should see "Address successfully deleted!"

# -22- Wishlist – dodanie do istniejącej listy:
  Scenario: Add items to static wishlist
    When I add product "Hummingbird printed t-shirt" to wishlist
    And I select existing wishlist
    Then I should see "Product added" toast
    And the product should appear in the wishlist

# -23- Wishlist – utworzenie nowej listy podczas dodawania:
  Scenario: Add items to new wishlist
    When I add product "Mug The Adventure Begins" to wishlist
    And I create a new wishlist named "Ulubione"
    And I select this new wishlist
    Then I should see "Product added" toast
    And the product should appear in the wishlist

# -24- Wishlist – utworzenie listy na podstronie ‘My wishlists’:
  Scenario: Create, rename, share, and delete wishlist
    When I go to "My wishlists" page
    And I create a new wishlist "Super lista"
    Then I should see confirmation toast
    When I rename "Super lista"
    Then I should see confirmation toast for renaming
    When I share the wishlist
    Then I should see "Share link copied!" toast
    When I delete the wishlist
    Then I should see "List has been removed" toast

# -25- Strona główna/Footer   sprawdzenie działania linków w stopce
  Scenario: Verify footer links
    When I click on each footer link: Prices drop, New products, Best sellers, Delivery, Legal Notice, Terms and conditions of use, About us, Secure payment, Contact us, Sitemap, Stores, Personal info, Orders, Credit slips, Addresses
    Then each page should open correctly
    And I log out
    Then I should see "Sign in" button
