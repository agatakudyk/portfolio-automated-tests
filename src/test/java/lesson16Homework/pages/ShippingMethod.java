package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class ShippingMethod {

    // kliknięcie w button 'Continue' (przejście do 'Payment')
    public void continueButton() {
        $("button[name='confirmDeliveryOption']").shouldBe(visible).click();
    }

    // wybranie formy dostawy 'My carrier'
    public void prestaShopRadioButton() {
        $("#delivery_option_2").shouldBe(interactable).click();
    }

    // wybranie formy dostawy pierwszej (nazwa ustawiana w Dockerze)
    public void myCarrierRadioButton() {
        $("#delivery_option_1").shouldBe(interactable).click();
    }

    // dodanie komentarza do zamówienia
    public void commentToOrder() {
        $("#delivery_message").shouldBe(visible).setValue("Proszę o zostawienie paczki pod drzwiami.");
    }
}
