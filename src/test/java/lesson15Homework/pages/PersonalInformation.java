package lesson15Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class PersonalInformation {

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

    public void continueButton() {
        By continueButtonLocator = By.xpath("//section[@id=\"checkout-personal-information-step\"]" +
                "//button[@type=\"submit\"]");
        getDriver().findElement(continueButtonLocator).click();
    }
}
