package selenidePageObject.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;


public class Footer {

    // kliknięcie w link 'Prices drop'
    public void pricesDrop() {
        $("#link-product-page-prices-drop-1").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Prices drop'
    public boolean isPricesDropPageOpened() {
        return $("#js-product-list-header").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'New products'
    public void newProducts() {
        $("#link-product-page-new-products-1").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'New products'
    public boolean isNewProductsPageOpened() {
        return $("#js-product-list-header").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Best sellers'
    public void bestSellers() {
        $("#link-product-page-best-sales-1").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Best sellers'
    public boolean isBestSellersPageOpened() {
        return $("#js-product-list-header").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Delivery'
    public void delivery() {
        $("#link-cms-page-1-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Delivery'
    public boolean isDeliveryPageOpened() {
        return $x("//h1[contains(text(),'Delivery')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Legal Notice'
    public void legalNotice() {
        $("#link-cms-page-2-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Legal Notice'
    public boolean isLegalNoticePageOpened() {
        return $x("//h1[contains(text(),'Legal Notice')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Terms and conditions of use'
    public void termsAndConditionsOfUse() {
        $("#link-cms-page-3-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Terms and conditions of use'
    public boolean isTermsAndConditionsPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'Terms and conditions of use')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'About us'
    public void aboutUs() {
        $("#link-cms-page-4-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'About us'
    public boolean isAboutUsPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'About us')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Secure payment'
    public void securePayment() {
        $("#link-cms-page-5-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Secure payment'
    public boolean isSecurePaymentPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'Secure payment')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Contact us'
    public void contactUs() {
        $("#link-static-page-contact-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Contact us'
    public boolean isContactUsPageOpened() {
        return $x("//div[@class='col-md-9 col-md-offset-3']" +
                "/h3[contains(text(),'Contact us')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Sitemap'
    public void sitemap() {
        $("#link-static-page-sitemap-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Sitemap'
    public boolean isSitemapPageOpened() {
        return $x("//header[@class='page-header']/h1" +
                "/span[contains(text(),'Sitemap')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Stores'
    public void stores() {
        $("#link-static-page-stores-2").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Stores'
    public boolean isStoresPageOpened() {
        return $x("//header[@class='page-header']/h1").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Personal info'
    public void personalInfo() {
        $x("//a[@title='Personal info']").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Personal info'
    public boolean isPersonalInfoPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'Your personal information')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Orders'
    public void orders() {
        $x("//a[@title='Orders']").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Orders'
    public boolean isOrdersPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'Order history')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Credit slips'
    public void creditSlips() {
        $x("//a[@title='Credit slips']").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Credit slips'
    public boolean isCreditSlipsPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'Credit slips')]").shouldBe(visible).isDisplayed();
    }

    // kliknięcie w link 'Addresses'
    public void addresses() {
        $x("//a[@title='Addresses']").shouldBe(visible).click();
    }

    // Potwierdzenie otwarcia podstrony 'Addresses'
    public boolean isAddressesPageOpened() {
        return $x("//header[@class='page-header']" +
                "/h1[contains(text(),'Your addresses')]").shouldBe(visible).isDisplayed();
    }
}
