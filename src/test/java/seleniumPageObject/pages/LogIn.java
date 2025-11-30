package seleniumPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class LogIn {

    //kliknięcie w link rejestracji
    public void signupLink() {
        getDriver().findElement(By.cssSelector("a[data-link-action=\"display-register-form\"]")).click();
    }

    //kliknięcie w button 'Sign In'
    public void signInButton() {
        getDriver().findElement(By.id("submit-login")).click();
    }

    //uzupełnienie pola 'Email / email nieistniejący w bazie
    public void emailField(String emailAddress) {
        getDriver().findElement(By.id("field-email")).sendKeys(emailAddress);
    }

    // uzupełnienie pola 'Password'
    public void passwordField() {
        getDriver().findElement(By.id("field-password")).sendKeys("blepassword");
    }

    //kliknięcie w link 'Forgot your password?'
    public void passwordRecoveryLink() {
        getDriver().findElement(By.xpath(" //div[@class=\"forgot-password\"]/a")).click();
    }

    //asercja - potwierdzenie pojawienia się komunikatu walidacyjnego "Wypełnij pole"
    public String getValidationMsg() {
        WebElement emailInput = getDriver().findElement(By.id("field-email"));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return  (String) js.executeScript("return arguments[0].validationMessage", emailInput);
    }

    //asercja - sprawdzenie komunikatu 'Authentication failed.'
    public boolean isMsgAuthenticationFailedDisplayed() {
        return getDriver().findElement(By.xpath("//li[@class=\"alert alert-danger\"]")).isDisplayed();
    }
}
