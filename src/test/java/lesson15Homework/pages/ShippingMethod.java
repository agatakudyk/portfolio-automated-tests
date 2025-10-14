package lesson15Homework.pages;

import org.openqa.selenium.By;
import static lesson15Homework.driver.DriverProvider.getDriver;

public class ShippingMethod {

    //kliknięcie w button 'Continue' (przejście do 'Payment')
public void continueButton() {
    By continueButtonShippingMethodLocator = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
    getDriver().findElement(continueButtonShippingMethodLocator).click();
}

//wybranie formy dostawy 'My carrier'
    public void prestaShopRadioButton() {
    By prestaShopRadioButtonLocator = By.id("delivery_option_2");
    getDriver().findElement(prestaShopRadioButtonLocator).click();
    }

    //wybranie formy dostawy pierwszej/nazwa ustawiana w Dockerze
    public void myCarrierRadioButton() {
        By myCarrierRadioButtonLocator = By.id("delivery_option_1");
        getDriver().findElement(myCarrierRadioButtonLocator).click();
    }

    //dodanie komentarza do zamówienia
    public void commentToOrder() {
        By commentToOrderFieldLocator = By.id("delivery_message");
        getDriver().findElement(commentToOrderFieldLocator).sendKeys("Proszę o zostawienie paczki pod drzwiami.");
    }
}
