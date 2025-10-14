package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class OrderConfirmation {

    //kliknięcie w button 'Save'
    public void saveButtonInForm() {
        By saveButtonLocator = By.xpath("//button[contains(text(),\"Save\")]");
        getDriver().findElement(saveButtonLocator).click();
    }

    //checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        getDriver().findElement(policyInfoLocator).click();
    }

    //checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        getDriver().findElement(privacyPolicyLocator).click();
    }

    //kliknięcie w link kontaktu z działem obsługi klienta
    public void customerServiceDepartmentContact() {
        By customerServiceDepartmentContactLocator = By.xpath(
                "//a[contains(text(),\"customer service department.\")]");
        getDriver().findElement(customerServiceDepartmentContactLocator).click();
    }
}
