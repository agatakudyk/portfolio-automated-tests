package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class Header {

    // zmiana języka / kliknięcie w dropdown-button
    public Header clickLanguageDropdownButton() {
        $x("//button[@data-toggle='dropdown']").click();
        return this;
    }

    // wybór opcji 'English' na liście języków
    public Header selectEnglishLanguageFromDropdown() {
        $x("//a[@data-iso-code='en']").click();
        return this;
    }

    // asercja - potwierdzenie ustawienia języka angielskiego
    public Header verifyEnglishLanguageDisplayed() {
        $x("//button[@data-toggle='dropdown']/span[contains(text(),'English')]").shouldBe(visible);
        return this;
    }

    // kliknięcie w button 'Sign out'
    public Header clickSignOut() {
        $x("//a[@class='logout hidden-sm-down']").click();
        return this;
    }

    // kliknięcie w button 'Sign In'
    public Header clickSignIn() {
        $(".user-info a").click();
        return this;
    }

    // wejście na profil użytkownika
    public Header clickUserProfile() {
        $x("//a[@class='account']/span[@class='hidden-sm-down']").click();
        return this;
    }

    // asercja - widoczność przycisku 'Sign out'
    public Header verifySignOutButtonDisplayed() {
        $x("//a[@class='logout hidden-sm-down']").shouldBe(visible);
        return this;
    }

    // asercja - widoczność przycisku 'Sign in'
    public Header verifySignInButtonDisplayed() {
        $(".user-info a").shouldBe(visible);
        return this;
    }
}

