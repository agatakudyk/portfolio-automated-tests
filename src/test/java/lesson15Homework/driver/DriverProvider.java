package lesson15Homework.driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DriverProvider {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverProvider() {
    }

    public static WebDriver getDriver() {

        String browser = ConfigReader.get("browser");
        if (driver == null) {
            switch (browser) {
                case "Chrome":
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.get("timeout"))));
        }
        return driver;
    }

    public static WebDriverWait getWaiter() {
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}