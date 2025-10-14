package lesson15Homework.pages;

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
}