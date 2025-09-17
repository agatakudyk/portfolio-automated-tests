package lesson8Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcceptNewsLetterTest {

    private WebDriver driver;
    private WebDriverWait wait;   //czekanie aż strona się załaduje

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();  //powiększenie okna
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void Prestashop() {

        driver.get("https://demo.prestashop.com/#/en/front");


        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id^='framelive']")));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Your email address']")));


        driver.findElement(By.xpath("//input[@placeholder='Your email address']"))
                .sendKeys("test142@wp.pl");
        driver.findElement(By.xpath("//input[@name='submitNewsletter']")).click();

        String newsletterMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
        ).getText();


        Assertions.assertEquals("You have successfully subscribed to this newsletter.", newsletterMessage);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}