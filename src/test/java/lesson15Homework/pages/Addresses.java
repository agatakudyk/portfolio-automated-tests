package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Addresses {

    //kliknięcie w button 'Continue' (przejście do 'Shipping Method')
    public void continueButton() {
        By addreessContinuseLocator = By.xpath("//section[@id=\"checkout-addresses-step\"]" +
                "//button[@type=\"submit\"]");
        getDriver().findElement(addreessContinuseLocator).click();
    }
}
