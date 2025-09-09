package lesson8Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcceptNewsLetter {


    public void Prestashop() {

        //konfiguracja
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        //otworzenie strony
        driver.get("https://demo.prestashop.com/#/en/front");

        //accept newsletter
        driver.findElement(By.xpath("//input[@aria-labelledby=\"block-newsletter-label\"]")).sendKeys("test142@wp.pl");
        Assertions.assertEquals("You have successfully subscribed to this newsletter.", driver.get());
        void teardown() {
            driver.quit();
        }
    }
}