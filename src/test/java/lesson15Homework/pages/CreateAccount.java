package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class CreateAccount {

    //kliknięcie w button 'Save'
    public void saveButton() {
        By saveLocator = By.cssSelector(".form-control-submit");
        getDriver().findElement(saveLocator).click();
    }

    //kliknięcie w checkbox informacji o przetwarzaniu danych osobowych
    public void customerPrivacyCheckbox() {
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        getDriver().findElement(policyInfoLocator).click();
    }

    //checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        getDriver().findElement(privacyPolicyLocator).click();
    }

    //potwierdzenie pojawienia się komunikatu 'Wypełnij to pole'
    public String getValidationMsg() {
        By nameInputLocator = By.id("field-firstname");
        WebElement nameInput = getDriver().findElement(nameInputLocator);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String msg = (String) js.executeScript("return arguments[0].validationMessage", nameInput);
        return msg;
    }
}
