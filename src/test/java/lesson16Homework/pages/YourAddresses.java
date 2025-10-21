package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class YourAddresses {

    // usunięcie nowego adresu
    public YourAddresses deleteNewAddress() {
        $x("//address[contains(text(),'Janowiec')]/../..//span[contains(text(),'Delete')]").click();
        return this;
    }

    // wejście w link 'Edit'
    public YourAddresses editAddress() {
        $x("//footer[@class='address-footer']/a[@data-link-action='edit-address']").click();
        return this;
    }

    // kliknięcie w link 'Create new address'
    public YourAddresses createNewAddressLink() {
        $x("//a[@data-link-action='add-address']").click();
        return this;
    }

    // kliknięcie w link 'Update'
    public YourAddresses updateAddress() {
        $x("//address[contains(text(),'Janowiec')]/../..//span[contains(text(),'Update')]").click();
        return this;
    }

    // asercja – komunikat potwierdzający dodanie adresu
    public YourAddresses verifyAddMsgDisplayed() {
        $x("//li[contains(text(),'Address successfully added!')]").shouldBe(visible);
        return this;
    }

    // asercja – komunikat potwierdzający aktualizację adresu
    public YourAddresses verifyUpdateMsgDisplayed() {
        $x("//li[contains(text(),'Address successfully updated!')]").shouldBe(visible);
        return this;
    }

    // asercja – komunikat potwierdzający usunięcie adresu
    public YourAddresses verifyDeleteMsgDisplayed() {
        $x("//li[contains(text(),'Address successfully deleted!')]").shouldBe(visible);
        return this;
    }
}
