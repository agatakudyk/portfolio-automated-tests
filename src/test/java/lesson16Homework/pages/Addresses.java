package lesson16Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Addresses {

    //kliknięcie w button 'Continue' (przejście do 'Shipping Method')
    public void continueButton() {
        By addreessContinuseLocator = By.xpath("//section[@id=\"checkout-addresses-step\"]" +
                "//button[@type=\"submit\"]");
        getDriver().findElement(addreessContinuseLocator).click();
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public String getValidationMsg() {
        By addressesInputLocator = By.xpath("//input[@name=\"address1\"]");
        WebElement addressesInput = getDriver().findElement(addressesInputLocator);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String msg = (String) js.executeScript("return arguments[0].validationMessage", addressesInput);
        return msg;
    }
}
