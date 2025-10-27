package lesson15Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class OrderDetails {

    //kliknięcie 'Send'
    public void sendButton() {
        getDriver().findElement(By.xpath("//*[@name=\"submitMessage\"]")).click();
    }

    //Uzupełnienie treści wiadomości
    public void msgFillIn(String message) {
        getDriver().findElement(By.xpath("//textarea[@name=\"msgText\"]")).sendKeys(message);
    }

    //kliknięcie w link 'Reorder'
    public void reorderLink() {
        getDriver().findElement(By.xpath("//a[@class=\"button-primary\" and text()=\"Reorder\"]")).click();
    }

    //asercja - pojawienia się komunikatu walidacji 'The message cannot be blank.'
    public boolean isValidationMsgDisplayed() {
        return getDriver().findElement(By.xpath("//li[contains(text(),\"The message cannot be blank.\")]")).isDisplayed();
    }

    //asercja - potwierdzenie wysłania wiadomości 'Message successfully sent'
    public boolean isInformationMsgDisplayed() {
        return getDriver().findElement(By.xpath("//li[contains(text(),\"Message successfully sent\")]")).isDisplayed();
    }
}