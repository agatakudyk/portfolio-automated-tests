package lesson16Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class OrderDetails {

    //kliknięcie 'Send'
    public void sendButton() {
        By sendButtonInDetailsPageLocator = By.xpath("//*[@name=\"submitMessage\"]");
        getDriver().findElement(sendButtonInDetailsPageLocator).click();
    }

    //Uzupełnienie treści wiadomości
    public void msgFillIn() {
        By fillInMsgTextInFormLocator = By.xpath("//textarea[@name=\"msgText\"]");
        getDriver().findElement(fillInMsgTextInFormLocator).sendKeys("Proszę o wysyłkę możliwie najszybciej. Dziękuję.");
    }

    //kliknięcie w link 'Reorder'
    public void reorderLink() {
        By reorderPageLinkLocator = By.xpath("//a[@class=\"button-primary\" and text()=\"Reorder\"]");
        getDriver().findElement(reorderPageLinkLocator).click();
    }

    //asercja - pojawienia się komunikatu walidacji 'The message cannot be blank.'
    public boolean isValidationMsgDisplayed() {
        By validationMsgInDetailsPageLocator = By.xpath("//li[contains(text(),\"The message cannot be blank.\")]");
        return getDriver().findElement(validationMsgInDetailsPageLocator).isDisplayed();
    }

    //asercja - potwierdzenie wysłania wiadomości 'Message successfully sent'
    public boolean isInformationMsgDisplayed() {
        By sendConfirmationMsgLocator = By.xpath("//li[contains(text(),\"Message successfully sent\")]");
        return getDriver().findElement(sendConfirmationMsgLocator).isDisplayed();
    }
}