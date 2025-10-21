package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;


public class UpdateYourAddress {

    // kliknięcie w button 'Save'
    public UpdateYourAddress clickSaveButton() {
        $x("//button[@class='btn btn-primary form-control-submit float-xs-right']").click();
        return this;
    }
}