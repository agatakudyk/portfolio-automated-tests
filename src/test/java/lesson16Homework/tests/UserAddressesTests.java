package lesson16Homework.tests;

import lesson16Homework.pages.*;
import lesson16Homework.users.RegisteredUser;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserAddressesTests {

    @Test   //Panel użytkownika/Adres – dodanie nowego adresu, aktualizacja i usunięcie
    @Order(21)
    public void addUserAddress() {

        step("Order confirmation page - przejście na stronę 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("'Your account' - przejście na stronę 'Addresses'", () -> {
            YourAccount account = new YourAccount();
            account.addresses();
        });

        step("Your addresses - kliknięcie w link 'Create new address'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.createNewAddressLink();
        });

        step("New address - uzupełnienie pola 'Address'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.createNewAddress();
        });

        step("New address - uzupełnienie pola 'Zip/Postal Code'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.createNewZipPostaCode();
        });

        step("New address - uzupełnienie pola 'City'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.createNewCity();
        });

        step("New address - kliknięcie w button 'Save'", () -> {
            NewAddress newAddress = new NewAddress();
            newAddress.saveButton();
        });

        step("Your addresses - komunikat potwierdzający dodanie adresu 'Address successfully added!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            Assertions.assertTrue(yourAddress.isAddMsgDisplayed());
        });

        step("Your addresses - kliknięcie w link 'Update'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.updateAddress();
        });

        step("Update your address - zmiana danych w polu 'Zip/Postal Code'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.replaceNewZipPostaCode();
        });

        step("Update your address - kliknięcie w button 'Save'", () -> {
            UpdateYourAddress update = new UpdateYourAddress();
            update.saveButton();
        });

        step("Your addresses - komunikat potwierdzający aktualizację 'Address successfully updated!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            Assertions.assertTrue(yourAddress.isUpdateMsgDisplayed());
        });

        step("Your addresses - usunięcie nowego adresu", () -> {
            YourAddresses yourAddress = new YourAddresses();
            yourAddress.deleteNewAddress();
        });

        step("Your addresses - komunikat potwierdzającego usunięcie 'Address successfully deleted!'", () -> {
            YourAddresses yourAddress = new YourAddresses();
            Assertions.assertTrue(yourAddress.isDeleteMsgDisplayed());
        });
    }
}
