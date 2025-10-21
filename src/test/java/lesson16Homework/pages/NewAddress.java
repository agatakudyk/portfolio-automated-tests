package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;

public class NewAddress {

    // kliknięcie w button 'Save'
    public void saveButton() {
        $x("//button[@class='btn btn-primary form-control-submit float-xs-right']").click();
    }
}
