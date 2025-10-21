package lesson16Homework.pages;

import org.openqa.selenium.By;

import static lesson15Homework.driver.DriverProvider.getDriver;


public class Footer {

    //kliknięcie w link 'Prices drop'
    public void pricesDrop() {
        By pricesDropLinkLocator = By.id("link-product-page-prices-drop-1");
        getDriver().findElement(pricesDropLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Prices drop'
    public boolean isPricesDropPageOpened() {
        By pricesDropPageNameLocator = By.id("js-product-list-header");
        return getDriver().findElement(pricesDropPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'New products'
    public void newProducts() {
        By newProductsLinkLocator = By.id("link-product-page-new-products-1");
        getDriver().findElement(newProductsLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'New products'
    public boolean isNewProductsPageOpened() {
        By newProductsPageNameLocator = By.id("js-product-list-header");
        return getDriver().findElement(newProductsPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Best sellers'
    public void bestSellers() {
        By bestSellersLinkLocator = By.id("link-product-page-best-sales-1");
        getDriver().findElement(bestSellersLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Best sellers'
    public boolean isBestSellersPageOpened() {
        By bestSellersPageNameLocator = By.id("js-product-list-header");
        return getDriver().findElement(bestSellersPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Delivery'
    public void delivery() {
        By deliveryLinkLocator = By.id("link-cms-page-1-2");
        getDriver().findElement(deliveryLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Delivery'
    public boolean isDeliveryPageOpened() {
        By deliveryPageNameLink = By.xpath("//h1[contains(text(),\"Delivery\")]");
        return getDriver().findElement(deliveryPageNameLink).isDisplayed();
    }

    //kliknięcie w link 'Legal Notice'
    public void legalNotice() {
        By legalNoticeLinkLocator = By.id("link-cms-page-2-2");
        getDriver().findElement(legalNoticeLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Legal Notice'
    public boolean isLegalNoticePageOpened() {
        By legalNoticePageNameLocator = By.xpath("//h1[contains(text(),\"Legal Notice\")]");
        return getDriver().findElement(legalNoticePageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Terms and conditions of use'
    public void termsAndConditionsOfUse() {
        By termsAndConditionsOfUseLinkLocator = By.id("link-cms-page-3-2");
        getDriver().findElement(termsAndConditionsOfUseLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Terms and conditions of use'
    public boolean isTermsAndConditionsPageOpened() {
        By termsAndConditionsOfUsePageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(), " + "\"Terms and conditions of use\")]");
        return getDriver().findElement(termsAndConditionsOfUsePageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'About us'
    public void aboutUs() {
        By aboutUsLinkLocator = By.id("link-cms-page-4-2");
        getDriver().findElement(aboutUsLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'About us'
    public boolean isAboutUsPageOpened() {
        By aboutUsPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1[contains(text(), " +
                "\"About us\")]");
        return getDriver().findElement(aboutUsPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Secure payment'
    public void securePayment() {
        By securePaymentLinkLocator = By.id("link-cms-page-5-2");
        getDriver().findElement(securePaymentLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Secure payment'
    public boolean isSecurePaymentPageOpened() {
        By securePaymentPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Secure payment\")]");
        return getDriver().findElement(securePaymentPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Contact us'
    public void contactUs() {
        By contactUsLinkLocator = By.id("link-static-page-contact-2");
        getDriver().findElement(contactUsLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Contact us'
    public boolean isContactUsPageOpened() {
        By contactUsPageNameLocator = By.xpath("//div[@class=\"col-md-9 col-md-offset-3\"]" +
                "/h3[contains(text(),\"Contact us\")]");
        return getDriver().findElement(contactUsPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Sitemap'
    public void sitemap() {
        By sitemapLinkLocator = By.id("link-static-page-sitemap-2");
        getDriver().findElement(sitemapLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Sitemap'
    public boolean isSitemapPageOpened() {
        By sitemapPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1/span[contains(text(),\"Sitemap\")]");
        return getDriver().findElement(sitemapPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Stores'
    public void stores() {
        By storesLinkLocator = By.id("link-static-page-stores-2");
        getDriver().findElement(storesLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Stores'
    public boolean isStoresPageOpened() {
        By ourStoresPageNameLocator = By.xpath("//header[@class=\"page-header\"]/h1");
        return getDriver().findElement(ourStoresPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Personal info'
    public void personalInfo() {
        By personalInfoLinkLocator = By.xpath("//a[@title=\"Personal info\"]");
        getDriver().findElement(personalInfoLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Personal info'
    public boolean isPersonalInfoPageOpened() {
        By personalInfoPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Your personal information\")]");
        return getDriver().findElement(personalInfoPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Orders'
    public void orders() {
        By ordersLinkLocator = By.xpath("//a[@title=\"Orders\"]");
        getDriver().findElement(ordersLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Orders'
    public boolean isOrdersPageOpened() {
        By orderHistoryPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Order history\")]");
        return getDriver().findElement(orderHistoryPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Credit slips'
    public void creditSlips() {
        By creditSlipsLinkLocator = By.xpath("//a[@title=\"Credit slips\"]");
        getDriver().findElement(creditSlipsLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Credit slips'
    public boolean isCreditSlipsPageOpened() {
        By creditSlipsPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Credit slips\")]");
        return getDriver().findElement(creditSlipsPageNameLocator).isDisplayed();
    }

    //kliknięcie w link 'Addresses'
    public void addresses() {
        By addressesLinkLocator = By.xpath("//a[@title=\"Addresses\"]");
        getDriver().findElement(addressesLinkLocator).click();
    }

    //Potwierdzenie otwarcia podstrony 'Addresses'
    public boolean isAddressesPageOpened() {
        By yourAddressesPageNameLocator = By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Your addresses\")]");
        return getDriver().findElement(yourAddressesPageNameLocator).isDisplayed();
    }
}
