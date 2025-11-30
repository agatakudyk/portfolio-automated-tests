package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class Footer {

    //kliknięcie w link 'Prices drop'
    public void pricesDrop() {
        getDriver().findElement(By.id("link-product-page-prices-drop-1")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Prices drop'
    public boolean isPricesDropPageOpened() {
        return getDriver().findElement(By.id("js-product-list-header")).isDisplayed();
    }

    //kliknięcie w link 'New products'
    public void newProducts() {
        getDriver().findElement(By.id("link-product-page-new-products-1")).click();
    }

    //Potwierdzenie otwarcia podstrony 'New products'
    public boolean isNewProductsPageOpened() {
        return getDriver().findElement(By.id("js-product-list-header")).isDisplayed();
    }

    //kliknięcie w link 'Best sellers'
    public void bestSellers() {
        getDriver().findElement(By.id("link-product-page-best-sales-1")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Best sellers'
    public boolean isBestSellersPageOpened() {
        return getDriver().findElement(By.id("js-product-list-header")).isDisplayed();
    }

    //kliknięcie w link 'Delivery'
    public void delivery() {
        getDriver().findElement(By.id("link-cms-page-1-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Delivery'
    public boolean isDeliveryPageOpened() {
        return getDriver().findElement(By.xpath("//h1[contains(text(),\"Delivery\")]")).isDisplayed();
    }

    //kliknięcie w link 'Legal Notice'
    public void legalNotice() {
        getDriver().findElement(By.id("link-cms-page-2-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Legal Notice'
    public boolean isLegalNoticePageOpened() {
        return getDriver().findElement(By.xpath("//h1[contains(text(),\"Legal Notice\")]")).isDisplayed();
    }

    //kliknięcie w link 'Terms and conditions of use'
    public void termsAndConditionsOfUse() {
        getDriver().findElement(By.id("link-cms-page-3-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Terms and conditions of use'
    public boolean isTermsAndConditionsPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(), " + "\"Terms and conditions of use\")]")).isDisplayed();
    }

    //kliknięcie w link 'About us'
    public void aboutUs() {
        getDriver().findElement(By.id("link-cms-page-4-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'About us'
    public boolean isAboutUsPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]/h1[contains(text(), " +
                "\"About us\")]")).isDisplayed();
    }

    //kliknięcie w link 'Secure payment'
    public void securePayment() {
        getDriver().findElement(By.id("link-cms-page-5-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Secure payment'
    public boolean isSecurePaymentPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Secure payment\")]")).isDisplayed();
    }

    //kliknięcie w link 'Contact us'
    public void contactUs() {
        getDriver().findElement(By.id("link-static-page-contact-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Contact us'
    public boolean isContactUsPageOpened() {
        return getDriver().findElement(By.xpath("//div[@class=\"col-md-9 col-md-offset-3\"]" +
                "/h3[contains(text(),\"Contact us\")]")).isDisplayed();
    }

    //kliknięcie w link 'Sitemap'
    public void sitemap() {
        getDriver().findElement(By.id("link-static-page-sitemap-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Sitemap'
    public boolean isSitemapPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1/span[contains(text(),\"Sitemap\")]")).isDisplayed();
    }

    //kliknięcie w link 'Stores'
    public void stores() {
        getDriver().findElement(By.id("link-static-page-stores-2")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Stores'
    public boolean isStoresPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]/h1")).isDisplayed();
    }

    //kliknięcie w link 'Personal info'
    public void personalInfo() {
        getDriver().findElement(By.xpath("//a[@title=\"Personal info\"]")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Personal info'
    public boolean isPersonalInfoPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Your personal information\")]")).isDisplayed();
    }

    //kliknięcie w link 'Orders'
    public void orders() {
        getDriver().findElement(By.xpath("//a[@title=\"Orders\"]")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Orders'
    public boolean isOrdersPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Order history\")]")).isDisplayed();
    }

    //kliknięcie w link 'Credit slips'
    public void creditSlips() {
        getDriver().findElement(By.xpath("//a[@title=\"Credit slips\"]")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Credit slips'
    public boolean isCreditSlipsPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Credit slips\")]")).isDisplayed();
    }

    //kliknięcie w link 'Addresses'
    public void addresses() {
        getDriver().findElement(By.xpath("//a[@title=\"Addresses\"]")).click();
    }

    //Potwierdzenie otwarcia podstrony 'Addresses'
    public boolean isAddressesPageOpened() {
        return getDriver().findElement(By.xpath("//header[@class=\"page-header\"]" +
                "/h1[contains(text(),\"Your addresses\")]")).isDisplayed();
    }
}
