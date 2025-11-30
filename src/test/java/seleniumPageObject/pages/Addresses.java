package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class Addresses {

    //kliknięcie w button 'Continue' (przejście do 'Shipping Method')
    public void continueButton() {
        getDriver().findElement(By.xpath("//section[@id=\"checkout-addresses-step\"]" +
                "//button[@type=\"submit\"]")).click();
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public String getValidationMsg() {
        WebElement addressesInput = getDriver().findElement(By.xpath("//input[@name=\"address1\"]"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (String) js.executeScript("return arguments[0].validationMessage", addressesInput);
    }
}
