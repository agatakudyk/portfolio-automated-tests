package lesson15Homework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverProvider {

    private static WebDriver driver;

    private DriverProvider() {}

    public static WebDriver getDriver() {

        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.get("https://automationexercise.com");
        }
        return driver;
    }

    public static void endTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}