package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class OrderConfirmation {

    //kliknięcie w button 'Save'
    public void saveButtonInForm() {
        getDriver().findElement(By.xpath("//button[contains(text(),\"Save\")]")).click();
    }

    //checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"customer_privacy\"]")).click();
    }

    //checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"psgdpr\"]")).click();
    }

    //kliknięcie w link kontaktu z działem obsługi klienta
    public void customerServiceDepartmentContact() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"customer service department.\")]")).click();
    }

    //asercja - potwierdzenie pojawienia się komunikatu potwierdzającego 'Your order is confirmed'
    public boolean isMsgThatOrderConfirmed() {
        return getDriver().findElement(By.xpath("//h3[@class=\"h1 card-title\"]/i")).isDisplayed();
    }

    //asercja - potwierdzenie pojawienia się dymka z komunikatem walidacyjnym
    public String getValidationMsg() {
        WebElement firstNameField = getDriver().findElement(By.id("field-firstname"));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return  (String) js.executeScript("return arguments[0].validationMessage", firstNameField);
    }
}
