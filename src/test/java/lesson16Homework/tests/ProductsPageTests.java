package lesson16Homework.tests;

import lesson16Homework.pages.Accessories;
import lesson16Homework.pages.Art;
import lesson16Homework.pages.ProductTheBestIsYetToCome;
import lesson16Homework.pages.TopMenu;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductsPageTests {

    @Test       //Podstrona Accessories - filtrowanie
    @Order(10)
    public void clearAccessoriesProductsFiltering() {

        step("wejście na stronę ACCESSORIES", () -> {
            TopMenu top = new TopMenu();
            top.accessoriesPageLink();
        });

        step("Accessories page - wybór filtra 'Ceramic'", () -> {
            Accessories accessories = new Accessories();
            accessories.ceramicCompositionFilter();
        });

        step("Accessories page - wybór filtra 'Available'", () -> {
            Accessories accessories = new Accessories();
            accessories.availableFilter();
        });

        step("Accessories page - wyczyszczenie wybranych filtrów", () -> {
            Accessories accessories = new Accessories();
            accessories.allFiltersClear();
        });

        step("Accessories page - potwierdzenie wyczyszczenia filtrów", () -> {
            Accessories accessories = new Accessories();
            Assertions.assertTrue(accessories.isFilterClear());
        });
    }

    @Test    //Podstrona ART - sortowanie
    @Order(11)
    public void sortArtProducts() {

        step("wejście na podstronę ART", () -> {
            TopMenu top = new TopMenu();
            top.artPageLink();
        });

        step("strona ART - kliknięcie w pole sortowania", () -> {
            Art art = new Art();
            art.sortByButton();
        });

        step("strona ART - posortowanie według 'Name, A to Z'", () -> {
            Art art = new Art();
            art.sortByNameAZ();
        });

        step("strona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", () -> {
            Art art = new Art();

            List<String> productsNames = new ArrayList<>();
            for (WebElement product : art.getProductsByDescription()) {
                productsNames.add(product.getText());
            }
            List<String> productsAlphabeticalOrder = productsNames.stream().sorted().toList();

            for (int i = 0; i < productsNames.size(); i++) {
                Assertions.assertEquals(productsAlphabeticalOrder.get(i), productsNames.get(i));
            }
        });

        step("strona ART - kliknięcie w pole sortowania", () -> {
            Art art = new Art();
            art.sortByButton();
        });

        step("strona ART - posortowanie według ‘Price, low to high’", () -> {
            Art art = new Art();
            art.sortByPriceAsc();
        });

        step("Podstrona ART - pobranie z listy elementów i sprawdzenie czy są posortowane", () -> {
            Art art = new Art();
            List<String> productsPrices = new ArrayList<>();
            for (WebElement product : art.getProductsByPrice()) {
                productsPrices.add(product.getText());
            }
            List<String> productsAlphabeticalOrder2 = productsPrices.stream().sorted().toList();

            for (int i = 0; i < productsPrices.size(); i++) {
                Assertions.assertEquals(productsAlphabeticalOrder2.get(i), productsPrices.get(i));
            }
        });
    }


    @Test   //Podstrona ART - dodanie opinii o produkcie
    @Order(12)
    public void successAddPosterReview() {

        step("Podstrona ART - wejście na stronę produktu 'The Best Is Yet To Come Framed Poster'", () -> {
            Art art = new Art();
            art.theBestPoster();
        });

        step("Strona produktu - kliknięcie w button dodania opinii o produkcie", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.productReviewButton();
        });

        step("popup 'Write your review' - wpisanie tytułu komentarza", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.reviewTitle();
        });

        step("WRITE YOUR REVIEW - wpisanie treści komentarza", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.reviewFillIn();
        });

        step("WRITE YOUR REVIEW - kliknięcie w button 'Send'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.sendReviewButton();
        });

        step("Popup REVIEW SENT - potwierdzenie dodania komentarza", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            Assertions.assertTrue(best.isCommentAdded());
        });

        step("Popup REVIEW SENT - zamknięcie okna poprzez kliknięcie w button 'OK'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.okReviewButton();
        });
    }


    @Test    //Strona produktu - zwiększenie ilości produktu i dodanie do koszyka
    @Order(13)
    public void addProductsToCart() {

        step("Strona produktu - zmiana ilości produktu poprzez wpisanie liczby (wyczyść i wpisz wartość)", () -> {
            //zmiana ilości produktu poprzez wpisanie liczby
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.putProductQuantityEnterNumber(4);
        });

        step("Strona produktu - zmiana ilości produktu poprzez kliknięcie w strzałki", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.putProductQuantityIncreaseArrow(3);
        });

        step("Strona produktu - kliknięcie button 'Add to cart'", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            best.addToCartButton();
        });

        step("Popup - sprawdzenie komunikatu potwierdzającego dodanie do koszyka", () -> {
            ProductTheBestIsYetToCome best = new ProductTheBestIsYetToCome();
            Assertions.assertTrue(best.isProductSuccessfullyAdded());
        });
    }
}
