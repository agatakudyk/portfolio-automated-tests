package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class YourAddresses {

    //usunięcie nowego adresu
    public void deleteNewAddress() {
        getDriver().findElement(By.xpath("//address[text()[contains(.,\"Janowiec\")]]" +
                "/../..//span[contains(text(),\"Delete\")]")).click();
    }

    //wejście w link 'Edit'
    public void editAddress() {
        getDriver().findElement(By.xpath(
                "//footer[@class=\"address-footer\"]/a[@data-link-action=\"edit-address\"]")).click();
    }

    //kliknięcie w link 'Create new address'
    public void createNewAddressLink() {
        getDriver().findElement(By.xpath("//a[@data-link-action=\"add-address\"]")).click();
    }

    //kliknięcie w link 'Update'
    public void updateAddress() {
        getDriver().findElement(By.xpath("//address[text()[contains(.,\"Janowiec\")]]" +
                "/../..//span[contains(text(),\"Update\")]")).click();
    }

    //asercja -  komunikat potwierdzający dodanie adresu 'Address successfully added!'
    public boolean isAddMsgDisplayed() {
        return getDriver().findElement(By.xpath("//li[contains(text(),\"Address successfully added!\")]")).isDisplayed();
    }

    //asercja - komunikat potwierdzający aktualizację 'Address successfully updated!'
    public boolean isUpdateMsgDisplayed() {
        return getDriver().findElement(By.xpath(
                "//li[contains(text(),\"Address successfully updated!\")]")).isDisplayed();
    }

    //komunikat potwierdzającego usunięcie 'Address successfully deleted!'
    public boolean isDeleteMsgDisplayed() {
        return getDriver().findElement(By.xpath(
                "//li[contains(text(),\"Address successfully deleted!\")]")).isDisplayed();
    }
}
