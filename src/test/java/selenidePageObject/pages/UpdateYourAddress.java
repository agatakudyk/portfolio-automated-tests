package selenidePageObject.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class UpdateYourAddress {

    // kliknięcie w button 'Save'
    public void saveButton() {
        $x("//button[@class='btn btn-primary form-control-submit float-xs-right']").shouldBe(visible).click();
    }
}