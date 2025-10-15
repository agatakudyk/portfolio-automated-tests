package lesson15Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Footer {

    //kliknięcie w link 'Prices drop'
    public void pricesDrop() {
        By pricesDropLinkLocator = By.id("link-product-page-prices-drop-1");
        getDriver().findElement(pricesDropLinkLocator).click();
    }

    //kliknięcie w link 'New products'
    public void newProducts() {
        By newProductsLinkLocator = By.id("link-product-page-new-products-1");
        getDriver().findElement(newProductsLinkLocator).click();
    }

    //kliknięcie w link 'Best sellers'
    public void bestSellers() {
        By bestSellersLinkLocator = By.id("link-product-page-best-sales-1");
        getDriver().findElement(bestSellersLinkLocator).click();
    }

    //kliknięcie w link 'Delivery'
    public void delivery() {
        By deliveryLinkLocator = By.id("link-cms-page-1-2");
        getDriver().findElement(deliveryLinkLocator).click();
    }

    //kliknięcie w link 'Legal Notice'
    public void legalNotice() {
        By legalNoticeLinkLocator = By.id("link-cms-page-2-2");
        getDriver().findElement(legalNoticeLinkLocator).click();
    }

    //kliknięcie w link 'Terms and conditions of use'
    public void termsAndConditionsOfUse() {
        By termsAndConditionsOfUseLinkLocator = By.id("link-cms-page-3-2");
        getDriver().findElement(termsAndConditionsOfUseLinkLocator).click();
    }

    //kliknięcie w link 'About us'
    public void aboutUs() {
        By aboutUsLinkLocator = By.id("link-cms-page-4-2");
        getDriver().findElement(aboutUsLinkLocator).click();
    }

    //kliknięcie w link 'Secure payment'
    public void securePayment() {
        By securePaymentLinkLocator = By.id("link-cms-page-5-2");
        getDriver().findElement(securePaymentLinkLocator).click();
    }

    //kliknięcie w link 'Contact us'
    public void contactUs() {
        By contactUsLinkLocator = By.id("link-static-page-contact-2");
        getDriver().findElement(contactUsLinkLocator).click();
    }

    //kliknięcie w link 'Sitemap'
    public void sitemap() {
        By sitemapLinkLocator = By.id("link-static-page-sitemap-2");
        getDriver().findElement(sitemapLinkLocator).click();
    }

    //kliknięcie w link 'Stores'
    public void stores() {
        By storesLinkLocator = By.id("link-static-page-stores-2");
        getDriver().findElement(storesLinkLocator).click();
    }

    //kliknięcie w link 'Personal info'
    public void personalInfo() {
        By personalInfoLinkLocator = By.xpath("//a[@title=\"Personal info\"]");
        getDriver().findElement(personalInfoLinkLocator).click();
    }

    //kliknięcie w link 'Orders'
    public void orders() {
        By ordersLinkLocator = By.xpath("//a[@title=\"Orders\"]");
        getDriver().findElement(ordersLinkLocator).click();
    }

    //kliknięcie w link 'Credit slips'
    public void creditSlips() {
        By creditSlipsLinkLocator = By.xpath("//a[@title=\"Credit slips\"]");
        getDriver().findElement(creditSlipsLinkLocator).click();
    }

    //kliknięcie w link 'Addresses'
    public void addresses() {
    By addressesLinkLocator = By.xpath("//a[@title=\"Addresses\"]");
    getDriver().findElement(addressesLinkLocator).click();
}
}
