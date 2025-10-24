package lesson16Homework.pages;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class YourAddresses {

    // usunięcie nowego adresu
    public void deleteNewAddress() {
        $x("//address[text()[contains(.,\"Janowiec\")]]/../..//span[contains(text(),\"Delete\")]")
                .shouldBe(visible).click();
    }

    // wejście w link 'Edit'
    public void editAddress() {
        $x("//footer[@class='address-footer']/a[@data-link-action='edit-address']").shouldBe(visible).click();
    }

    // kliknięcie w link 'Create new address'
    public void createNewAddressLink() {
        $x("//a[@data-link-action='add-address']").shouldBe(visible).click();
    }

    // kliknięcie w link 'Update'
    public void updateAddress() {
        $x("//address[text()[contains(.,\"Janowiec\")]]/../..//span[contains(text(),\"Update\")]")
                .shouldBe(interactable).click();
    }

    // asercja – komunikat potwierdzający dodanie adresu
    public boolean isAddMsgDisplayed() {
        return $x("//li[contains(text(),'Address successfully added!')]").shouldBe(visible).isDisplayed();
    }

    // asercja – komunikat potwierdzający aktualizację adresu 'Address successfully updated!'
    public boolean isUpdateMsgDisplayed() {
        return $x("//li[contains(text(),'Address successfully updated!')]").shouldBe(visible).isDisplayed();
    }

    // asercja – komunikat potwierdzający usunięcie adresu 'Address successfully deleted!'
    public boolean isDeleteMsgDisplayed() {
        return $x("//li[contains(text(),'Address successfully deleted!')]").shouldBe(visible).isDisplayed();
    }
}
