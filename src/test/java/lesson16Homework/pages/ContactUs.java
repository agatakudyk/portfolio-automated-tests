package lesson16Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class ContactUs {

    //kliknięcie w button 'Send'
    public void sendButton() {
        By sendButtonInContactUsSectionLocator = By.xpath("//input[@class=\"btn btn-primary\"]");
        getDriver().findElement(sendButtonInContactUsSectionLocator).click();
    }

    //wpisanie treści wiadomości
    public void msgFillIn() {
        By msgFieldInContactUsSectionLocator = By.id("contactform-message");
        getDriver().findElement(msgFieldInContactUsSectionLocator).sendKeys("Chcę otrzymać FV za zamówienie.");
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego
    public boolean isValidationMsgDisplayed() {
        By validationMsgInContactUsSectionLocator = By.xpath(
                "//li[contains(text(),\"The message cannot be blank.\")]");
        return getDriver().findElement(validationMsgInContactUsSectionLocator).isDisplayed();
    }

    //asercja - potwierdzenie komunikatu informacyjnego 'Your message has been successfully sent to our team.'
    public boolean isInformationMsgDisplayed() {
        By successMsgInContactUsSectionLocator = By.xpath("//li[contains(text(),\"Your message has " +
                "been successfully sent to our team.\")]");
        return getDriver().findElement(successMsgInContactUsSectionLocator).isDisplayed();
    }
}
