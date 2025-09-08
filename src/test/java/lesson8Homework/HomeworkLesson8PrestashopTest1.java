package lesson8Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkLesson8PrestashopTest1 {


    public void Prestashop() {

        //konfiguracja
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        //otworzenie strony
        driver.get("https://demo.prestashop.com/#/en/front");

        //wyszukanie produktu / dodanie do koszyka
        driver.findElement(By.xpath("//input[@aria-label=\"Search\"]")).sendKeys("Mug The best is yet to come");
        driver.findElement(By.cssSelector("js-quick-view")).click();
        driver.findElement(By.xpath("//button[@data-button-action=\"add-to-cart\"]")).click();

        driver.get("Product successfully added to your shopping cart");
        Assertions.assertEquals("Product successfully added to your shopping cart", driver.get());

        void teardown() {
            driver.quit();
        }
    }
}