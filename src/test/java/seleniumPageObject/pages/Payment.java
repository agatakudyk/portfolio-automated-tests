package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class Payment {

    //wybór opcji 'Pay by bank wire'
    public void payByBankWire() {
        getDriver().findElement(By.id("payment-option-2")).click();
    }

    //wybór opcji 'Pay by Check'
    public void payByCheck() {
        getDriver().findElement(By.id("payment-option-1")).click();
    }

    //wybór checkboxa zgody
    public void agreeToTermsCheckbox() {
        getDriver().findElement(By.xpath("//input[@name=\"conditions_to_approve[terms-and-conditions]\"]")).click();
    }

    //kliknięcie w button 'Place Order' (przejście na 'Order confirmation page')
    public void placeOrderButton() {
        getDriver().findElement(By.xpath("//div[@class=\"ps-shown-by-js\"]/button")).click();
    }

}
