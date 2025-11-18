package lesson16Homework.tests;

import lesson16Homework.pages.*;
import lesson16Homework.users.RegisteredUser;
import lesson16Homework.users.UnregisteredUserData;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserAuthenticationTests {

    @Test
    @Order(4)
    public void signUpNowFillInFormByUnregisteredUser() {

        step("‘Save time on...' form - kliknięcie w button 'Save' bez uzupełnienia danych", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.saveButtonInForm();
        });

        step("Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            assertEquals("Wypełnij to pole.", confirmation.getValidationMsg());
        });

        step("‘Save time on...' form - uzupełnienie danych użytkownika", () -> {
            UnregisteredUserData unregistered = new UnregisteredUserData();
            unregistered.firstName();
            unregistered.lastName();
            unregistered.email();
            unregistered.password();
        });

        step("‘Save time on...' form - zaznaczenie checkboxów zgody i regulaminu", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.customerPrivacyCheckbox();
            confirmation.termsAndConditionsCheckbox();
        });

        step("Zapisanie danych poprzez kliknięcie w button 'Save'", () -> {
            OrderConfirmation confirmation = new OrderConfirmation();
            confirmation.saveButtonInForm();
        });
    }


    @Test  // Niepoprawna rejestracja przy pomocy pustego formularza
    @Order(5)
    public void failSignupWithEmptyFields() {

        step("Login page - kliknięcie w link rejestracji", () -> {
            LogIn login = new LogIn();
            login.signupLink();
        });

        step("Create account page - kliknięcie w button 'Save' bez wypełniania pól", () -> {
            CreateAccount create = new CreateAccount();
            create.saveButton();
        });

        step("Create account page/tooltip dynamiczny - potwierdzenie pojawienia się komunikatu walidacyjnego", () -> {
            CreateAccount create = new CreateAccount();
            Assertions.assertEquals("Wypełnij to pole.", create.getValidationMsg());
        });
    }


    @Test  // Poprawna rejestracja użytkownika
    @Order(6)
    public void userSuccessSignup() {

        step("Create account - uzupełnienie pola 'First name'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.name();
        });

        step("Create account - uzupełnienie pola 'Last name'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.lastName();
        });

        step("Create account - uzupełnienie pola 'Email'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.email();
        });

        step("Create account - uzupełnienie pola 'Password'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Create Account - kliknięcie w checkbox informacji o przetwarzaniu danych osobowych", () -> {
            CreateAccount create = new CreateAccount();
            create.customerPrivacyCheckbox();
        });

        step("Create Account - kliknięcie w checkbox akceptacji polityki prywatności", () -> {
            CreateAccount create = new CreateAccount();
            create.termsAndConditionsCheckbox();
        });

        step("Create Account - kliknięcie w button 'Save'", () -> {
            CreateAccount create = new CreateAccount();
            create.saveButton();
        });

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignOutDisplayed());
        });

        step("Header - kliknięcie w button 'Sign out' / wylogowanie użytkownika", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Sprawdzenie czy wylogowany - widoczność przycisku 'Sign in'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignInDisplayed());
        });
    }


    @Test  // Niepoprawne logowanie z użyciem pustych pól i błędnych danych
    @Order(7)
    public void failLoginWithIncorrectData() {

        step("Header - kliknięcie w button 'Sign In'", () -> {
            Header header = new Header();
            header.signIn();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Tooltip dynamiczny - potwierdzenie pojawienia się komunikatu", () -> {
            LogIn login = new LogIn();
            Assertions.assertEquals("Wypełnij to pole.",login.getValidationMessage());
        });

        step("Login page - uzupełnienie pola 'Email'", () -> {
            LogIn login = new LogIn();
            login.emailField();
        });

        step("Login page - uzupełnienie pola 'Password'", () -> {
            LogIn login = new LogIn();
            login.passwordField();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Login page - sprawdzenie komunikatu 'Authentication failed.'", () -> {
            LogIn login = new LogIn();
            assertTrue(login.isMsgAuthenticationFailedDisplayed());
        });
    }


    @Test  // Login page - zresetowanie zapomnianego hasła
    @Order(8)
    public void loginPasswordReset() {

        step("Login page - kliknięcie w link 'Forgot your password?'", () -> {
            LogIn login = new LogIn();
            login.passwordRecoveryLink();
        });

        step("Reset password page - uzupełnienie pola 'Email address'", () -> {
            PasswordReset reset = new PasswordReset();
            reset.email();
        });

        step("Reset password page - kliknięcie w button 'Send reset link'", () -> {
            PasswordReset reset = new PasswordReset();
            reset.sendResetLink();
        });

        step("Reset password page - sprawdzenie komunikatu potwierdzającego wysłanie maila", () -> {
            PasswordReset reset = new PasswordReset();
            assertTrue(reset.isMsgOfSentMsgDisplayed());
        });
    }


    @Test     //Poprawne zalogowanie  + zmiana hasła + zalogowanie nowym hasłem
    @Order(9)
    public void userSuccessLogin() {

        step("Reset password page - kliknięcie w link 'Back to Login'", () -> {
            PasswordReset reset = new PasswordReset();
            reset.backToLoginPageLink();
        });

        step("Login page - uzupełnienie pola 'Email'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.email();
        });

        step("Login page - uzupełnienie pola 'Password'", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Sprawdzenie pomyślnego zalogowania - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignOutDisplayed());
        });

        step("Your account - kliknięcie w link 'Information'", () -> {
            YourAccount account = new YourAccount();
            account.informationLink();
        });

        step("Your personal information - uzupełnienie pola 'Password' / dotychczasowe hasło", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Your personal information - uzupełnienie pola 'New password' / nowe hasło", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newPassword();
        });

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.termsAndConditionsCheckbox();
        });

        step("Your personal information - checkbox zgody na przetwarzanie danych osobowych", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.customerPrivacyCheckbox();
        });

        step("Your personal information - kliknięcie w button 'Save'", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.saveButton();
        });

        step("Your personal information - potwierdzenie pojawienia się komunikatu", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            Assertions.assertTrue(personal.isMsgThatInformationUpdated());
        });

        step("Header/wyloguj się - kliknięcie w button 'Sign out'", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Login page - uzupełnienie pola email", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.email();
        });

        step("Login page - uzupełnienie nowego hasła", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newLoginPassword();
        });

        step("Login page - kliknięcie w button 'Sign In'", () -> {
            LogIn login = new LogIn();
            login.signInButton();
        });

        step("Sprawdzenie poprawności zalogowania użytkownika - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignOutDisplayed());
        });

        step("Metoda prywatna - przywrócenie starego hasła", this::backToPreviousPassword);
    }


    private void backToPreviousPassword() {

        step("Header - wejście na profil użytkownika 'Your account'", () -> {
            Header header = new Header();
            header.userProfile();
        });

        step("Wejście w link 'Information'", () -> {
            YourAccount account = new YourAccount();
            account.informationLink();
        });

        step("wpisanie aktualnego hasła logowania", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.newPassword();
        });

        step("wpisanie nowego hasła logowania", () -> {
            RegisteredUser registered = new RegisteredUser();
            registered.password();
        });

        step("Your personal information - checkbox akceptacji regulaminu i polityki prywatności", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.termsAndConditionsCheckbox();
        });

        step("our personal information - checkbox zgody na przetwarzanie danych osobowych", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.customerPrivacyCheckbox();
        });

        step("kliknięcie buttona 'Save'", () -> {
            YourPersonalInformation personal = new YourPersonalInformation();
            personal.saveButton();
        });
    }
}
