package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


public class Home {

    //kliknięcie wishlist-button produktu 'Today is a good day Framed Poster'
    public void wishlistIconOfPosterTodayIsAGoodDay() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Today is a good day Framed\")]" + "/../../../button[@class=\"wishlist-button-add\"]")).click();
    }

    //asercja - potwierdzenie pojawienia się popupu z komunikatem walidacyjnym
    public boolean isMsgDisplayedThatLoginRequired() {
        WebElement loginRequiredMsg = getDriver().findElement(By.xpath("//p[contains(text(),\"You need to be logged in to " +
                "save products in your wishlist.\")]"));
        return loginRequiredMsg.isDisplayed();
    }

    //kliknięcie w button 'Cancel' w Popupie
    public void closeWishlistPopupOfUnregisteredUser() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Sign in\")]" + "/../button[contains(text(),\"Cancel\")]")).click();
    }

    //wejście na stronę produktu 'Today is a good day Framed Poster'
    public void enterProductPageOfTodayIsAGoodDayFramedPoster() {
        getDriver().findElement(By.xpath("//a[@class=\"thumbnail product-thumbnail\"]" + "/img[@alt=\"Today is a good day Framed poster\"]")).click();
    }

    //kliknięcie wishlist-button produktu 'Hummingbird printed t-shirt'
    public void wishlistIconOfHummingbirdPrintedTshirt() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Hummingbird printed t-shirt\")]" + "/../../../button[@class=\"wishlist-button-add\"]")).click();
    }

    //popup 'Add to whishlist' - kliknięcie w link 'My wishlist'
    public void myWishlistSelection() {
        By myWishlistPopupLocator = By.xpath("//div[@class=\"modal-body\"]" + "/div/ul/li[@class=\"wishlist-list-item\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(myWishlistPopupLocator));
        getDriver().findElement(myWishlistPopupLocator).click();
    }

    //kliknięcie wishlist-button produktu 'Mug The adventure begins'
    public void wishlistIconOfMugTheAdventureBegins() {
        getDriver().findElement(By.xpath("//a[contains(text(),\"Mug The adventure begins\")]" + "/../../../button[@class=\"wishlist-button-add\"]")).click();
    }

    //popup - kliknięcie w link 'Create new list'
    public void createNewWishlist() {
        By newWishlistPopupLocator = By.xpath("//a[@class=\"wishlist-add-to-new text-primary\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(newWishlistPopupLocator));
        getDriver().findElement(newWishlistPopupLocator).click();
    }

    //wpisanie nazwy nowej listy
    public void wishlistNameFillIn(String listName) {
        getDriver().findElement(By.xpath("//input[@id=\"input2\"]")).sendKeys(listName);
    }

    //kliknięcie w button 'Create wishlist'
    public void createNewWishListButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),\"Create wishlist\")]")).click();
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
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(productAddedToWishlistMsgLocator));
        return getDriver().findElement(productAddedToWishlistMsgLocator).isDisplayed();
    }
}
