package lesson8Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lesson8PrestashopTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void addToCart() {

        driver.get("https://demo.prestashop.com/#/en/front");

       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id^='framelive']")));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search']")));

        driver.findElement(By.xpath("//input[@aria-label=\"Search\"]"))
                .sendKeys("Mug The adventure begins" + Keys.ENTER);

        driver.findElement(By.xpath("//a[contains(text(),'Mug The adventure begins')]")).click();
        driver.findElement(By.xpath("//button[@data-button-action=\"add-to-cart\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@id=\"myModalLabel\"]")));
        WebElement addTocartElement = driver.findElement(By.xpath("//h4[contains(text(),\"Product successfully added to your shopping cart\")]"));

        String addToCartMessage = getDisplayedText(addTocartElement);
        assertTrue(addToCartMessage.contains("Product successfully added to your shopping cart"));
    }

    private String getDisplayedText(WebElement addTocartElement) {
        String text =addTocartElement.getText();
        List<WebElement> elements = addTocartElement.findElements(By.xpath("./*"));
        for(WebElement el : elements){
            text = text.replaceFirst(el.getText(),"");
        }

        return text;
    }

    @Test
    public void acceptNewsletter() {

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