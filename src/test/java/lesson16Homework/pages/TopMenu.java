package lesson16Homework.pages;

import static com.codeborne.selenide.Selenide.$;


public class TopMenu {

    // wejście na stronę ACCESSORIES
    public TopMenu openAccessoriesPage() {
        $("#category-6").click();
        return this;
    }

    // wejście na podstronę ART
    public TopMenu openArtPage() {
        $("#category-9").click();
        return this;
    }

    // przejście na stronę główną (Home Page)
    public TopMenu openHomePage() {
        $("#_desktop_logo").click();
        return this;
    }
}
