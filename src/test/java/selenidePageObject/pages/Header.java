package selenidePageObject.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class Header {

    // zmiana języka / kliknięcie w dropdown-button
    public void languageDropdownButton() {
        $("//button[data-toggle='dropdown']").shouldBe(visible).click();
    }

    // wybór opcji 'English' na liście języków
    public void englishLanguageSelectionFromDropdown() {
        $x("//a[@data-iso-code='en']").shouldBe(visible).click();
    }

    // asercja - potwierdzenie ustawienia języka angielskiego
    public boolean isEnglishLanguageDisplayed() {
        return $x("//button[@data-toggle='dropdown']/span[contains(text(),'English')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w button 'Sign out'
    public void signout() {
        $x("//a[@class='logout hidden-sm-down']").shouldBe(visible).click();
    }

    // kliknięcie w button 'Sign In'
    public void signIn() {
        $(".user-info a").shouldBe(visible).click();
    }

    // wejście na profil użytkownika
    public void userProfile() {
        $x("//a[@class='account']/span[@class='hidden-sm-down']").shouldBe(visible).click();
    }

    // asercja - widoczność przycisku 'Sign out'
    public boolean isButtonSignOutDisplayed() {
        return $x("//a[@class='logout hidden-sm-down']").shouldBe(visible).isDisplayed();
    }

    // asercja - widoczność przycisku 'Sign in'
    public boolean isButtonSignInDisplayed() {
        return $(".user-info a").shouldBe(visible).isDisplayed();
    }
}

