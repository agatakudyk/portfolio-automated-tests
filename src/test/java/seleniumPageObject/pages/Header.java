package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class Header {

    //zmiana języka / kliknięcie w dropdown-button
    public void languageDropdownButton() {
        getDriver().findElement(By.xpath("//button[@data-toggle=\"dropdown\"]")).click();
    }

    //wybór opcji 'English' na liście języków
    public void englishLanguageSelectionFromDropdown() {
        getDriver().findElement(By.xpath("//a[@data-iso-code=\"en\"]")).click();
    }

    //asercja - potwierdzenie ustawienia języka angielskiego
    public boolean isEnglishLanguageDisplayed() {
        return getDriver().findElement(By.xpath("//button[@data-toggle=\"dropdown\"]" +
                "/span[contains(text(),\"English\")]")).isDisplayed();
    }

    //Kliknięcie w button 'Sign out'
    public void signout() {
        getDriver().findElement(By.xpath("//a[@class=\"logout hidden-sm-down\"]")).click();
    }

    //kliknięcie w button 'Sign In'
    public void signIn() {
        getDriver().findElement(By.cssSelector(".user-info a")).click();
    }

    //wejście na profil użytkownika
    public void userProfile() {
        getDriver().findElement(By.xpath("//a[@class=\"account\"]/span[@class=\"hidden-sm-down\"]")).click();
    }

    //asercja -  widoczność przycisku 'Sign out'
    public boolean isButtonSignOutDisplayed() {
        return getDriver().findElement(By.xpath("//a[@class=\"logout hidden-sm-down\"]")).isDisplayed();
    }

    //asercja -  widoczność przycisku 'Sign in'
    public boolean isButtonSignInDisplayed() {
        return getDriver().findElement(By.cssSelector(".user-info a")).isDisplayed();
    }
}
