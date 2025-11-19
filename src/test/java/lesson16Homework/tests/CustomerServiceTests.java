package lesson16Homework.tests;

import lesson16Homework.pages.*;
import lesson16Homework.users.RegisteredUser;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTests extends BaseTest{

    @Test   //Formularz kontaktowy z działem obsługi klienta
    @Order(18)
    public void contactCustomerServiceDepartment() {

        step("Order confirmation page - kliknięcie w link kontaktu z działem obsługi klienta", () -> {
            OrderConfirmation order = new OrderConfirmation();
            order.customerServiceDepartmentContact();
        });

        step("Contact us - kliknięcie w button 'Send' - próba przesłania niewypełnionego formularza", () -> {
            ContactUs contact = new ContactUs();
            contact.sendButton();
        });

        step("Contact us - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            ContactUs contact = new ContactUs();
            Assertions.assertTrue(contact.isValidationMsgDisplayed());
        });

        step("Contact us - wpisanie treści wiadomości", () -> {
            ContactUs contact = new ContactUs();
            contact.msgFillIn();
        });

        step("Contact us - kliknięcie w button 'Send'", () -> {
            ContactUs contact = new ContactUs();
            contact.sendButton();
        });

        step("Komunikat informacyjny 'Your message has been successfully sent to our team.'", () -> {
            ContactUs contact = new ContactUs();
            Assertions.assertTrue(contact.isInformationMsgDisplayed());
        });
    }

    @Test    //Details page - dodanie wiadomości
    @Order(19)
    public void addMsgInOrderDetailsPage() {

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("Your account - wejście w sekcję 'Order history and details'", () -> {
            YourAccount account = new YourAccount();
            account.orderHistoryAndDetails();
        });

        step("Kliknięcie w link 'Details'", () -> {
            OrderHistoryAndDetails order = new OrderHistoryAndDetails();
            order.detailsLink();
        });

        step("'Order details' - kliknięcie 'Send' w pustym formularzu 'ADD A MESSAGE'", () -> {
            OrderDetails details = new OrderDetails();
            details.sendButton();
        });

        step("Potwierdzenie pojawienia się komunikatu walidacji 'The message cannot be blank.'", () -> {
            OrderDetails details = new OrderDetails();
            Assertions.assertTrue(details.isValidationMsgDisplayed());
        });

        step("'Order details' - Uzupełnienie treści wiadomości", () -> {
            OrderDetails details = new OrderDetails();
            details.msgFillIn();
        });

        step("'Order details' - kliknięcie 'Send'", () -> {
            OrderDetails details = new OrderDetails();
            details.sendButton();
        });

        step("potwierdzenie wysłania wiadomości 'Message successfully sent'", () -> {
            OrderDetails details = new OrderDetails();
            Assertions.assertTrue(details.isInformationMsgDisplayed());
        });
    }

    @Test     //Panel użytkownika/Reorder - ponowne złożenie zamówienia
    @Order(20)
    public void reorderPreviousOrder() {

        step("'Order details' - kliknięcie w link 'Reorder'", () -> {
            OrderDetails details = new OrderDetails();
            details.reorderLink();
        });

        step("Addresses - wejście w link 'Edit'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.editAddress();
        });

        step("Addresses - zmiana nazwy miasta", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newCity();
        });

        step("Addresses - kliknięcie buttona 'Continue'", () -> {
            Addresses addresses = new Addresses();
            addresses.continueButton();
        });

        step("Shipping method - wybór radio buttona 'My carrier'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.prestaShopRadioButton();
        });

        step("Shipping method - kliknięcie w button 'Continue'", () -> {
            ShippingMethod shipping = new ShippingMethod();
            shipping.continueButton();
        });

        step("Payment - wybór opcji 'Pay by bank wire'", () -> {
            Payment payment = new Payment();
            payment.payByBankWire();
        });

        step("Payment - wybór checkboxa zgody", () -> {
            Payment payment = new Payment();
            payment.agreeToTermsCheckbox();
        });

        step("Payment - kliknięcie w button 'Place Order'", () -> {
            Payment payment = new Payment();
            payment.placeOrderButton();
        });

        step("Order confirmation page - sprawdzenie pojawienia się komunikatu potwierdzającego", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            Assertions.assertTrue(confirmation.isMsgThatOrderConfirmed());
        });
    }
}
