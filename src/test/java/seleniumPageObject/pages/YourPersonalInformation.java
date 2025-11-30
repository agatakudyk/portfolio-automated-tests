package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class YourPersonalInformation {

    //Personal Information - checkbox zgody na przetwarzanie danych osobowych
    public void customerPrivacyCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"customer_privacy\"]")).click();
    }

    //Personal Information - checkbox akceptacji regulaminu i polityki prywatności
    public void termsAndConditionsCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"psgdpr\"]")).click();
    }

    //kliknięcie w button 'Save'
    public void saveButton() {
        getDriver().findElement(By.xpath("//button[@class=\"btn btn-primary form-control-submit float-xs-right\"]")).click();
    }

    //asercja - sprawdzenie pojawienia się komunikatu 'Information successfully updated.'
    public boolean isMsgThatInformationUpdated() {
        return getDriver().findElement(By.xpath("//ul/li[contains(text()," +
                "\"Information successfully updated.\")]")).isDisplayed();
    }
}
