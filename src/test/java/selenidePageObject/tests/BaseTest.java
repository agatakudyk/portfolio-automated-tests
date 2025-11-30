package selenidePageObject.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;


public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        open("http://localhost:8080/pl/");
    }

    @AfterAll
    public static void tearDownSuite() {
        Selenide.closeWebDriver();
    }
}
