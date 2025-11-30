package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static seleniumPageObject.driver.DriverProvider.getDriver;
import static seleniumPageObject.driver.DriverProvider.getWaiter;


public class MyWishlists {

    //wejście na link listy 'My wishlist'
    public void myWishlistLink() {
        By myWishlistLinkLocator = By.xpath("//p[@class=\"wishlist-list-item-title\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(myWishlistLinkLocator));
        getDriver().findElement(myWishlistLinkLocator).click();
    }

    //wejście na link listy 'Ulubione'
    public void ulubioneWishlistLink() {
        By ulubioneWishlistLinkLocator = By.xpath("//a[@class=\"wishlist-list-item-link\"]" +
                "/p[contains(text(),\"Ulubione\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(ulubioneWishlistLinkLocator));
        getDriver().findElement(ulubioneWishlistLinkLocator).click();
    }

    //przejście na stronę 'My wishlists'
    public void myWishlistsPage() {
        getDriver().findElement(By.xpath("//nav[@data-depth=\"4\"]//a[contains(., \"My wishlists\")]")).click();
    }

    //kliknięcie w 'Create new list
    public void createNewList() {
        By createNewListWishlistLinkLocator = By.xpath("//div[@class=\"wishlist-container-header\"]" +
                "/a[contains(text(),\"Create new list\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(createNewListWishlistLinkLocator));
        getDriver().findElement(createNewListWishlistLinkLocator).click();
    }

    //Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń
    public void addNameOfNewList(String listName) {
        By createNameOfNewListWishlistLocator = By.xpath("//input[@placeholder=\"Add name\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(createNameOfNewListWishlistLocator));
        getDriver().findElement(createNameOfNewListWishlistLocator).sendKeys(listName);
    }

    //Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'
    public void createWishlistButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),\"Create wishlist\")]")).click();
    }

    //kliknięcie w trzy kropki
    public void moreActionsButton() {
        By moreActionLocator = By.xpath("//p[contains(text(),\"Super lista\")]" +
                "/../div[@class=\"wishlist-list-item-right\"]/button[@class=\"wishlist-list-item-actions\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(moreActionLocator));
        getDriver().findElement(moreActionLocator).click();
    }

    //kliknięcie w 'Rename'
    public void renameWishlist() {
        getDriver().findElement(By.xpath("//p[contains(text(),\"Super lista\")]" +
                "/..//div[@class=\"wishlist-list-item-right\"]/div[@class=\"dropdown-menu show\"]/button[contains(text(),\"Rename\")]"))
                .click();
    }

    //zmiana nazwy listy życzeń
    public void wishlistRenameField(String listName) {
        By changeNameOfListWishlistLocator = By.xpath("//h5[contains(text(),\"Rename wishlist\")]/../..//div/div/input");
        getWaiter().until(ExpectedConditions.elementToBeClickable(changeNameOfListWishlistLocator));
        WebElement changeNameOfListWishList = getDriver().findElement(changeNameOfListWishlistLocator);
        changeNameOfListWishList.clear();
        changeNameOfListWishList.sendKeys(listName);
    }

    //Popup 'Rename wishlist' - kliknięcie w button 'Rename wishlist'
    public void renameWishlistButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),\"Rename wishlist\")]")).click();
    }

    //kliknięcie w button 'Share'
    public void shareButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),\"Share\")]")).click();
    }

    //kliknięcie w button 'Copy text'
    public void copyTextButton() {
        getDriver().findElement(By.xpath("//button[contains(text(),\"Copy text\")]")).click();
    }

    //usunięcie listy
    public void deleteWishlist(String listName) {
        getDriver().findElement(By.xpath("//p[contains(text(),\""+listName+"\")]" +
                "/../div[@class=\"wishlist-list-item-right\"]/button/i[contains(text(),\"delete\")]")).click();
    }

    //kliknięcie w button 'Delete'
    public void deleteButton() {
        getDriver().findElement(By.xpath("//div[@class=\"modal-footer\"]/button[contains(text(),\"Delete\")]")).click();
    }

    //asercja - TOAST/'The list has been properly created' - potwierdzenie pojawienia się komunikatu
    public boolean isCreatedMsgDisplayed() {
        By wishlistSuccessCreatedMsgLocator = By.xpath("//p[contains(text(),\"The list has been properly created\")]");
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(wishlistSuccessCreatedMsgLocator));
        return getDriver().findElement(wishlistSuccessCreatedMsgLocator).isDisplayed();
    }

    //asercja - potwierdzenie, czy istnieje lista o nazwie 'Super lista'
    public boolean isSuperListaDisplayed() {
        WebElement createdNewWishlistName = getDriver().findElement(By.xpath("//div[@class=\"wishlist-list-container\"]" +
                "//p[contains(text(),\"Super lista\")]"));
        return createdNewWishlistName.isDisplayed();
    }

    //TOAST/'List has been renamed' - potwierdzenie pojawienia się komunikatu
    public boolean isRenamedListMsgDisplayed() {
        By successRenamedNewWishlistLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(successRenamedNewWishlistLocator));
        return getDriver().findElement(successRenamedNewWishlistLocator).isDisplayed();
    }

    //TOAST/'Share link copied!' - potwierdzenie pojawienia się komunikatu
    public boolean isCopiedLinkMsgDisplayed() {
        return getDriver().findElement(By.xpath("//p[@class=\"wishlist-toast-text\"]")).isDisplayed();
    }

    //TOAST/'List has been removed' - potwierdzenie pojawienia się komunikatu
    public boolean isRemovedListMsgDisplayed() {
        By listRemovedConfirmLocator = By.xpath("//p[contains(text(),\"List has been removed\")]");
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(listRemovedConfirmLocator));
        return getDriver().findElement(listRemovedConfirmLocator).isDisplayed();
    }

    public List<WebElement> getWishListElements() {
        By wishListElementsLocator = By.xpath("//p[@class=\"wishlist-product-title\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
        return getDriver().findElements(wishListElementsLocator);
    }
}
