package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class YourPersonalInformation {

 //Personal Information - checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        By policyInfoLocator = By.xpath("//input[@name=\"customer_privacy\"]");
        getDriver().findElement(policyInfoLocator).click();
    }

    //Personal Information - checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        By privacyPolicyLocator = By.xpath("//input[@name=\"psgdpr\"]");
        getDriver().findElement(privacyPolicyLocator).click();
    }

    //kliknięcie w button 'Save'
    public void saveButton() {
        By informationSaveButtonLocator = By.xpath(
                "//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]");
        getDriver().findElement(informationSaveButtonLocator).click();
    }
}
