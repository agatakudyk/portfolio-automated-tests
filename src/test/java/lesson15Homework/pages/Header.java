package lesson15Homework.pages;

import org.openqa.selenium.By;

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

    //asercja - potwierdzenie ustawienia języka angielskiego
    public boolean isEnglishLanguageDisplayed() {
        By englishLanguageCheckLocator = By.xpath("//button[@data-toggle=\"dropdown\"]" +
                "/span[contains(text(),\"English\")]");
        return getDriver().findElement(englishLanguageCheckLocator).isDisplayed();
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

    //asercja -  widoczność przycisku 'Sign out'
    public boolean isButtonSignOutDisplayed() {
        By logoutLocator = By.xpath("//a[@class=\"logout hidden-sm-down\"]");
        return getDriver().findElement(logoutLocator).isDisplayed();
    }

    //asercja -  widoczność przycisku 'Sign in'
    public boolean isButtonSignInDisplayed() {
        By signInLocator = By.cssSelector(".user-info a");
        return getDriver().findElement(signInLocator).isDisplayed();
    }
}
