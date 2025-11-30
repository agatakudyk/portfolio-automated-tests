package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class ContactUs {

    //kliknięcie w button 'Send'
    public void sendButton() {
        getDriver().findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
    }

    //wpisanie treści wiadomości
    public void msgFillIn(String message) {
        getDriver().findElement(By.id("contactform-message")).sendKeys(message);
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public boolean isValidationMsgDisplayed() {
        return getDriver().findElement(By.xpath("//li[contains(text(),\"The message cannot be blank.\")]"))
                .isDisplayed();
    }

    //asercja - potwierdzenie komunikatu informacyjnego 'Your message has been successfully sent to our team.'
    public boolean isInformationMsgDisplayed() {
        return getDriver().findElement(By.xpath("//li[contains(text(),\"Your message has " +
                "been successfully sent to our team.\")]"))
                .isDisplayed();
    }
}
