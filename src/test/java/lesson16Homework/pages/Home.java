package lesson16Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class Home {

    //kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'
    public void wishlistIconOfPosterTodayIsAGoodDay() {
        By heartButtonOfTodayIsAGoodDayFramedPosterLocator = By.xpath("//a[contains(text(),\"Today is a good day Framed\")]" + "/../../../button[@class=\"wishlist-button-add\"]");
        getDriver().findElement(heartButtonOfTodayIsAGoodDayFramedPosterLocator).click();
    }

    //asercja - potwierdzenie pojawienia się popupu z komunikatem walidacyjnym
    public boolean isMsgDisplayedThatLoginRequired() {
        By loginRequiredMsgLocator = By.xpath("//p[contains(text(),\"You need to be logged in to " +
                "save products in your wishlist.\")]");
        WebElement loginRequiredMsg = getDriver().findElement(loginRequiredMsgLocator);
        return loginRequiredMsg.isDisplayed();
    }

    //kliknięcie w button 'Cancel' w Popupie
    public void closeWishlistPopupOfUnregisteredUser() {
        By cancelPopupButtonLocator = By.xpath("//a[contains(text(),\"Sign in\")]" + "/../button[contains(text(),\"Cancel\")]");
        getDriver().findElement(cancelPopupButtonLocator).click();
    }

    //wejście na stronę produktu 'Today is a good day Framed Poster'
    public void enterProductPageOfTodayIsAGoodDayFramedPoster() {
        By openTodayIsAGoodDayFramedPosterLocator = By.xpath("//a[@class=\"thumbnail product-thumbnail\"]" + "/img[@alt=\"Today is a good day Framed poster\"]");
        getDriver().findElement(openTodayIsAGoodDayFramedPosterLocator).click();
    }

    //kliknięcie wishlist-button produktu 'Hummingbird printed t-shirt'
    public void wishlistIconOfHummingbirdPrintedTshirt() {
        By heartButtonOfHummingbirdLocator = By.xpath("//a[contains(text(),\"Hummingbird printed t-shirt\")]" + "/../../../button[@class=\"wishlist-button-add\"]");
        getDriver().findElement(heartButtonOfHummingbirdLocator).click();
    }

    //popup 'Add to whishlist' - kliknięcie w link 'My wishlist'
    public void myWishlistSelection() {
        By myWishlistPopupLocator = By.xpath("//div[@class=\"modal-body\"]" + "/div/ul/li[@class=\"wishlist-list-item\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(myWishlistPopupLocator));
        getDriver().findElement(myWishlistPopupLocator).click();
    }

    //kliknięcie wishlist-button produktu 'Mug The adventure begins'
    public void wishlistIconOfMugTheAdventureBegins() {
        By heartButtonOfMugTheAdventureLocator = By.xpath("//a[contains(text(),\"Mug The adventure begins\")]" + "/../../../button[@class=\"wishlist-button-add\"]");
        getDriver().findElement(heartButtonOfMugTheAdventureLocator).click();
    }

    //popup - kliknięcie w link 'Create new list'
    public void createNewWishlist() {
        By newWishlistPopupLocator = By.xpath("//a[@class=\"wishlist-add-to-new text-primary\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(newWishlistPopupLocator));
        getDriver().findElement(newWishlistPopupLocator).click();
    }

    //wpisanie nazwy nowej listy
    public void wishlistNameFillIn() {
        By wishlistNameLocator = By.xpath("//input[@id=\"input2\"]");
        getDriver().findElement(wishlistNameLocator).sendKeys("Ulubione");
    }

    //kliknięcie w button 'Create wishlist'
    public void createNewWishListButton() {
        By createNewWishListLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
        getDriver().findElement(createNewWishListLocator).click();
    }

    //wybranie nowo utworzonej listy
    public void ulubioneNewWishlist() {
        By ulubioneNewWishlistLocator = By.xpath("//li[@class=\"wishlist-list-item\"]" + "/p[contains(text(),\"Ulubione\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(ulubioneNewWishlistLocator));
        getDriver().findElement(ulubioneNewWishlistLocator).click();
    }

    //TOAST 'Product added' - potwierdzenie pojawienia się komunikatu
    public boolean isAddedMsgDisplayed() {
        By productAddedToWishlistMsgLocator = By.xpath("//div[@class=\"wishlist-toast success\"]" +
                "/p[@class=\"wishlist-toast-text\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(productAddedToWishlistMsgLocator));
        return getDriver().findElement(productAddedToWishlistMsgLocator).isDisplayed();
    }
}
