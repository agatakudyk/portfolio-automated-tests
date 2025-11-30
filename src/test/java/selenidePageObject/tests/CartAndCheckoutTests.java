package selenidePageObject.tests;

import selenidePageObject.pages.*;
import selenidePageObject.users.RegisteredUser;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartAndCheckoutTests extends BaseTest{

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
            Cart cart = new Cart();
            // ilość w sekcji produktu
            int productQuantity = Integer.parseInt(Objects.requireNonNull(cart.getQuantity()));
            // ilość w sekcji podsumowania
            String summaryQuantityText = cart.getQuantitySummary();
            int summaryQuantity = Integer.parseInt(summaryQuantityText.replaceAll("\\D+", ""));
            // porównanie ilości z sekcji produktu i sekcji podsumowania
            Assertions.assertEquals(productQuantity, summaryQuantity);
        });

        step("Shopping cart - sprawdzenie wartości całkowitej", () -> {
            Cart cart = new Cart();
            //cena jednostkowa
            String unitPriceText = cart.getUnitPrice();
            double unitPrice = Double.parseDouble(unitPriceText);
            // ilość w sekcji produktu
            int productQuantity = Integer.parseInt(Objects.requireNonNull(cart.getQuantity()));
            //wartość całkowita z podsumowania
            String totalPriceText = cart.getTotal();
            double totalPrice = Double.parseDouble(totalPriceText);
            //oczekiwana wartość
            double expectedTotal = unitPrice * productQuantity;
            Assertions.assertEquals(totalPrice, expectedTotal);
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
}
