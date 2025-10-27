package lesson15Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class ShippingMethod {

    //kliknięcie w button 'Continue' (przejście do 'Payment')
    public void continueButton() {
        getDriver().findElement(By.xpath("//button[@name=\"confirmDeliveryOption\"]")).click();
    }

    //wybranie formy dostawy 'My carrier'
    public void prestaShopRadioButton() {
        getDriver().findElement(By.id("delivery_option_2")).click();
    }

    //wybranie formy dostawy pierwszej/nazwa ustawiana w Dockerze
    public void myCarrierRadioButton() {
        getDriver().findElement(By.id("delivery_option_1")).click();
    }

    //dodanie komentarza do zamówienia
    public void commentToOrder(String orderComment) {
        getDriver().findElement(By.id("delivery_message")).sendKeys(orderComment);
    }
}
