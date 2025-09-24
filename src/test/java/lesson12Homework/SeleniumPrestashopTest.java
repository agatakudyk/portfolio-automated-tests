package lesson12Homework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumPrestashopTest {

    static ChromeDriver driver;  // sterownik przeglądarki

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/pl/");
    }



    //@Test  //1.	Rejestracja: kliknięcie ‘Save’ przy pustym formularzu + walidacja
    @Order(1)
    public void failSignupWithEmptyFieldsTest() {

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
        String msg = (String)js.executeScript("return arguments[0].validationMessage", nameInput);
        Assertions.assertEquals("Wypełnij to pole.", msg);
    }



    //@Test  //2.	Rejestracja: uzupełnienie formularza poprawnymi danymi + walidacja
    @Order(2)
    public void userSuccessSignupTest() {

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
        passwordInputField.sendKeys("password123");

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

    //@Test    //3.Wylogowanie użytkownika + walidacja
    @Order(3)
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

    @Test
    @Order(4)    //4.Logowanie z użyciem błędnych danych + walidacja
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

        //sprawdzenie komunikatu o błędnym logowaniu
        By failMsgLocator = By.xpath("//li[@class=\"alert-danger\"]");
        WebElement failMessage = driver.findElement(failMsgLocator);
        Assertions.assertTrue(failMessage.isDisplayed());
    }

    @Test  //5.	Logowanie / funkcja odzyskiwania hasła + walidacja
    @Order(5)
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

    @Test     //6. Poprawne zalogowanie + walidacja
    @Order(6)
    public void userSuccesLogin() {

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

    @Test //8.	Podstrona ART/filtrowanie: Home Accessories + Ceramic + wyczyść wszystko + walidacja
    @Order(7)
    public void artProductsFiltering() {

        //wejdź w podstronę ACCESSORIES
        By accessoriesPageLocator = By.id("category-6");
        WebElement accessoriesPageLink = driver.findElement(accessoriesPageLocator);
        accessoriesPageLink.click();

        //Filtr - Composition / Ceramic
        By ceramicFilterLocator = By.id("facet_input_11998_0");
        WebElement ceramicFilterCheckbox = driver.findElement(ceramicFilterLocator);
        ceramicFilterCheckbox.click();

        //Wyczyszczenie wybranych filtrów




    }



    //@AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
