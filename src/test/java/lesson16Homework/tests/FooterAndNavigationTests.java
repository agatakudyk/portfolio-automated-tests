package lesson16Homework.tests;

import lesson16Homework.pages.Footer;
import lesson16Homework.pages.Header;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FooterAndNavigationTests extends BaseTest{

    @Test   //Home page/Footer - sprawdzenie działania linków w stopce
    @Order(25)
    public void checkFooterLinksClickable() {

        step("Home page/Footer - kliknięcie w link 'Prices drop'", () -> {
            Footer footer = new Footer();
            footer.pricesDrop();
        });

        step("Potwierdzenie otwarcia podstrony 'Prices drop'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isPricesDropPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'New products'", () -> {
            Footer footer = new Footer();
            footer.newProducts();
        });

        step("Potwierdzenie otwarcia podstrony 'New products'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isNewProductsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Best sellers'", () -> {
            Footer footer = new Footer();
            footer.bestSellers();
        });

        step("Potwierdzenie otwarcia podstrony 'Best sellers'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isBestSellersPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Delivery'", () -> {
            Footer footer = new Footer();
            footer.delivery();
        });

        step("Potwierdzenie otwarcia podstrony 'Delivery'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isDeliveryPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Legal Notice'", () -> {
            Footer footer = new Footer();
            footer.legalNotice();
        });

        step("Potwierdzenie otwarcia podstrony 'Legal Notice'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isLegalNoticePageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Terms and conditions of use'", () -> {
            Footer footer = new Footer();
            footer.termsAndConditionsOfUse();
        });

        step("Potwierdzenie otwarcia podstrony 'Terms and conditions of use'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isTermsAndConditionsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'About us'", () -> {
            Footer footer = new Footer();
            footer.aboutUs();
        });

        step("Potwierdzenie otwarcia podstrony 'About us'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isAboutUsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Secure payment'", () -> {
            Footer footer = new Footer();
            footer.securePayment();
        });

        step("Potwierdzenie otwarcia podstrony 'Secure payment'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isSecurePaymentPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Contact us'", () -> {
            Footer footer = new Footer();
            footer.contactUs();
        });

        step("Potwierdzenie otwarcia podstrony 'Contact us'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isContactUsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Sitemap'", () -> {
            Footer footer = new Footer();
            footer.sitemap();
        });

        step("Potwierdzenie otwarcia podstrony 'Sitemap'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isSitemapPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Stores'", () -> {
            Footer footer = new Footer();
            footer.stores();
        });

        step("Potwierdzenie otwarcia podstrony 'Stores'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isStoresPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Personal info'", () -> {
            Footer footer = new Footer();
            footer.personalInfo();
        });

        step("Potwierdzenie otwarcia podstrony 'Personal info'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isPersonalInfoPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Orders'", () -> {
            Footer footer = new Footer();
            footer.orders();
        });

        step("Potwierdzenie otwarcia podstrony 'Orders'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isOrdersPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Credit slips'", () -> {
            Footer footer = new Footer();
            footer.creditSlips();
        });

        step("Potwierdzenie otwarcia podstrony 'Credit slips'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isCreditSlipsPageOpened());
        });

        step("Home page/Footer - kliknięcie w link 'Addresses'", () -> {
            Footer footer = new Footer();
            footer.addresses();
        });

        step("Potwierdzenie otwarcia podstrony 'Addresses'", () -> {
            Footer footer = new Footer();
            Assertions.assertTrue(footer.isAddressesPageOpened());
        });

        step("Header - kliknięcie w button 'Sign out'", () -> {
            Header header = new Header();
            header.signout();
        });

        step("Sprawdzenie pomyślnej rejestracji - widoczność przycisku 'Sign out'", () -> {
            Header header = new Header();
            Assertions.assertTrue(header.isButtonSignInDisplayed());
        });
    }
}
