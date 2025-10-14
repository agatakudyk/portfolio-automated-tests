package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Header {

    //zmiana języka / kliknięcie w dropdown-button
    public void languageDropdownButton() {
        By languageDropdownButtonLocator = By.xpath("//button[@data-toggle=\"dropdown\"]");
        getDriver().findElement(languageDropdownButtonLocator).click();
    }

    //wybór opcji 'English' na liście języków
    public void englishLanguageSelectionFromDropdown() {
        By englishLanguageSwitchLocator = By.xpath("//a[@data-iso-code=\"en\"]");
        getDriver().findElement(englishLanguageSwitchLocator).click();
    }

    //Kliknięcie w button 'Sign out'
    public void signout() {
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        getDriver().findElement(logoutLocator).click();
    }

    //kliknięcie w button 'Sign In'
    public void signIn() {
        By signInLocator = By.cssSelector(".user-info a");
        getDriver().findElement(signInLocator).click();
    }

    //wejście na profil użytkownika
    public void userProfile() {
        By userProfileLinkLocator = By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]");
        getDriver().findElement(userProfileLinkLocator).click();
    }
}
