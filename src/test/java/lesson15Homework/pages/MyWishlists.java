package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static lesson15Homework.driver.DriverProvider.getDriver;


public class MyWishlists {

    //wejście na link listy 'My wishlist'
    public void myWishlistLink() {
        By myWishlistLinkLocator = By.xpath("//p[@class=\"wishlist-list-item-title\"]");
        getDriver().findElement(myWishlistLinkLocator).click();
    }

    //wejście na link listy 'Ulubione'
    public void ulubioneWishlistLink() {
        By ulubioneWishlistLinkLocator = By.xpath("//a[@class=\"wishlist-list-item-link\"]" +
                "/p[contains(text(),\"Ulubione\")]");
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
        getDriver().findElement(createNewListWishlistLinkLocator).click();
    }

    //Popup 'Create wishlist' - wpisanie nazwy nowej listy życzeń
    public void addNameOfNewList() {
        By createNameOfNewListWishlistLocator = By.xpath("//input[@placeholder=\"Add name\"]");
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
}
