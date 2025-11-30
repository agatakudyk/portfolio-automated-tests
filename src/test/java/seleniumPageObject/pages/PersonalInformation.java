package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class PersonalInformation {

    //Personal Information - checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"customer_privacy\"]")).click();
    }

    //Personal Information - checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"psgdpr\"]")).click();
    }

    public void continueButton() {
        getDriver().findElement(By.xpath("//section[@id=\"checkout-personal-information-step\"]" +
                "//button[@type=\"submit\"]")).click();
    }
}
