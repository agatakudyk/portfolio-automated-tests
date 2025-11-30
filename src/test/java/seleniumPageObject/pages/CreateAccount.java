package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class CreateAccount {

    //kliknięcie w button 'Save'
    public void saveButton() {
        getDriver().findElement(By.cssSelector(".form-control-submit")).click();
    }

    //kliknięcie w checkbox informacji o przetwarzaniu danych osobowych
    public void customerPrivacyCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"customer_privacy\"]")).click();
    }

    //checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"psgdpr\"]")).click();
    }

    //potwierdzenie pojawienia się komunikatu 'Wypełnij to pole'
    public String getValidationMsg() {
        WebElement nameInput = getDriver().findElement(By.id("field-firstname"));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return  (String) js.executeScript("return arguments[0].validationMessage", nameInput);
    }
}
