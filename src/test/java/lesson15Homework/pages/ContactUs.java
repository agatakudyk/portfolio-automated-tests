package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class ContactUs {

    //kliknięcie w button 'Send'
    public void sendButton() {
        By sendButtonInContactUsSectionLocator = By.xpath("//input[@class=\"btn btn-primary\"]");
        getDriver().findElement(sendButtonInContactUsSectionLocator).click();
    }
}
