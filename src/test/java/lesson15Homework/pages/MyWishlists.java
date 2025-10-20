package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static lesson15Homework.driver.DriverProvider.getDriver;
import static lesson15Homework.driver.DriverProvider.getWaiter;


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
        By myWishlistsLinkLocator = By.xpath("//nav[@data-depth=\"4\"]//a[contains(., \"My wishlists\")]");
        getDriver().findElement(myWishlistsLinkLocator).click();
    }

    //kliknięcie w 'Create new list
    public void createNewList() {
        By createNewListWishlistLinkLocator = By.xpath("//div[@class=\"wishlist-container-header\"]" +
                "/a[contains(text(),\"Create new list\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(createNewListWishlistLinkLocator));
        getDriver().findElement(createNewListWishlistLinkLocator).click();
    }

    //Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń
    public void addNameOfNewList() {
        By createNameOfNewListWishlistLocator = By.xpath("//input[@placeholder=\"Add name\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(createNameOfNewListWishlistLocator));
        getDriver().findElement(createNameOfNewListWishlistLocator).sendKeys("Super lista");
    }

    //Popup 'Create wishlist' - kliknięcie w button 'Create wishlist'
    public void createWishlistButton() {
        By createWishlistButtonLocator = By.xpath("//button[contains(text(),\"Create wishlist\")]");
        getDriver().findElement(createWishlistButtonLocator).click();
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
        By renameNewCreatedWishlistLocator = By.xpath("//p[contains(text(),\"Super lista\")]" +
                "/..//div[@class=\"wishlist-list-item-right\"]/div[@class=\"dropdown-menu show\"]/button[contains(text(),\"Rename\")]");
        getDriver().findElement(renameNewCreatedWishlistLocator).click();
    }

    //zmiana nazwy listy życzeń
    public void wishlistRenameField() {
        By changeNameOfListWishlistLocator = By.xpath("//h5[contains(text(),\"Rename wishlist\")]/../..//div/div/input");
        getWaiter().until(ExpectedConditions.elementToBeClickable(changeNameOfListWishlistLocator));
        WebElement changeNameOfListWishList = getDriver().findElement(changeNameOfListWishlistLocator);
        changeNameOfListWishList.clear();
        changeNameOfListWishList.sendKeys("Lista życzeń");
    }

    //Popup 'Rename wishlist' - kliknięcie w button 'Rename wishlist'
    public void renameWishlistButton() {
        By renameWishlistButtonLocator = By.xpath("//button[contains(text(),\"Rename wishlist\")]");
        getDriver().findElement(renameWishlistButtonLocator).click();
    }

    //kliknięcie w button 'Share'
    public void shareButton() {
        By shareButtonWishlistLocator = By.xpath("//button[contains(text(),\"Share\")]");
        getDriver().findElement(shareButtonWishlistLocator).click();
    }

    //kliknięcie w button 'Copy text'
    public void copyTextButton() {
        By copyTextButtonOfWishlistLocator = By.xpath("//button[contains(text(),\"Copy text\")]");
        getDriver().findElement(copyTextButtonOfWishlistLocator).click();
    }

    //usunięcie listy
    public void deleteWishlist() {
        By deleteWishlistButtonLocator = By.xpath("//p[contains(text(),\"Lista życzeń\")]" +
                "/../div[@class=\"wishlist-list-item-right\"]/button/i[contains(text(),\"delete\")]");
        getDriver().findElement(deleteWishlistButtonLocator).click();
    }

    //kliknięcie w button 'Delete'
    public void deleteButton() {
        By deleteConfirmLocator = By.xpath("//div[@class=\"modal-footer\"]/button[contains(text(),\"Delete\")]");
        getDriver().findElement(deleteConfirmLocator).click();
    }

    //asercja - TOAST/'The list has been properly created' - potwierdzenie pojawienia się komunikatu
    public boolean isCreatedMsgDisplayed() {
        By wishlistSuccessCreatedMsgLocator = By.xpath("//p[contains(text(),\"The list has been properly created\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(wishlistSuccessCreatedMsgLocator));
        return getDriver().findElement(wishlistSuccessCreatedMsgLocator).isDisplayed();
    }

    //asercja - potwierdzenie, czy istnieje lista o nazwie 'Super lista'
    public boolean isSuperListaDisplayed() {
        By createdNewWishlistNameLocator = By.xpath("//div[@class=\"wishlist-list-container\"]" +
                "//p[contains(text(),\"Super lista\")]");
        WebElement createdNewWishlistName = getDriver().findElement(createdNewWishlistNameLocator);
        return createdNewWishlistName.isDisplayed();
    }

    //TOAST/'List has been renamed' - potwierdzenie pojawienia się komunikatu
    public boolean isRenamedListMsgDisplayed() {
        By successRenamedNewWishlistLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(successRenamedNewWishlistLocator));
        return getDriver().findElement(successRenamedNewWishlistLocator).isDisplayed();
    }

    //TOAST/'Share link copied!' - potwierdzenie pojawienia się komunikatu
    public boolean isCopiedLinkMsgDisplayed() {
        By shareLinkCopiedMsgLocator = By.xpath("//p[@class=\"wishlist-toast-text\"]");
        return getDriver().findElement(shareLinkCopiedMsgLocator).isDisplayed();
    }

    //TOAST/'List has been removed' - potwierdzenie pojawienia się komunikatu
    public boolean isRemovedListMsgDisplayed() {
        By listRemovedConfirmLocator = By.xpath("//p[contains(text(),\"List has been removed\")]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(listRemovedConfirmLocator));
        return getDriver().findElement(listRemovedConfirmLocator).isDisplayed();
    }

    public List<WebElement> getWishListElements(){
        By wishListElementsLocator = By.xpath("//p[@class=\"wishlist-product-title\"]");
        getWaiter().until(ExpectedConditions.elementToBeClickable(wishListElementsLocator));
        return getDriver().findElements(wishListElementsLocator);
    }
}
