package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class ShippingMethod {

    //kliknięcie w button 'Continue' (przejście do 'Payment')
public void continueButton() {
    By continueButtonShippingMethodLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
    getDriver().findElement(continueButtonShippingMethodLocator).click();
}
}
