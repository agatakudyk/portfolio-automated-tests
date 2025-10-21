package lesson16Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Payment {

    //wybór opcji 'Pay by bank wire'
    public void payByBankWire() {
        By payByBankWireRadioButtonLocator = By.id("payment-option-2");
        getDriver().findElement(payByBankWireRadioButtonLocator).click();
    }

    //wybór opcji 'Pay by Check'
    public void payByCheck() {
        By payByCheckRadioButtonLocator = By.id("payment-option-1");
        getDriver().findElement(payByCheckRadioButtonLocator).click();
    }

    //wybór checkboxa zgody
    public void agreeToTermsCheckbox() {
        By agreeToTermsCheckboxLocator = By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]");
        getDriver().findElement(agreeToTermsCheckboxLocator).click();
    }

    //kliknięcie w button 'Place Order' (przejście na 'Order confirmation page')
    public void placeOrderButton() {
        By placeOrderButtonInPaymentSectionLocator = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");
        getDriver().findElement(placeOrderButtonInPaymentSectionLocator).click();
    }

}
