package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;


public class ShippingMethod {

    // kliknięcie w button 'Continue' (przejście do 'Payment')
    public ShippingMethod clickContinueButton() {
        $("button[name='confirmDeliveryOption']").click();
        return this;
    }

    // wybranie formy dostawy 'My carrier'
    public ShippingMethod selectPrestaShopDelivery() {
        $("#delivery_option_2").click();
        return this;
    }

    // wybranie formy dostawy pierwszej (nazwa ustawiana w Dockerze)
    public ShippingMethod selectMyCarrierDelivery() {
        $("#delivery_option_1").click();
        return this;
    }

    // dodanie komentarza do zamówienia
    public ShippingMethod addCommentToOrder() {
        $("#delivery_message").setValue("Proszę o zostawienie paczki pod drzwiami.");
        return this;
    }
}
