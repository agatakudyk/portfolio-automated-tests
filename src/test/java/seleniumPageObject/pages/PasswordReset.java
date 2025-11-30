package seleniumPageObject.pages;

import org.openqa.selenium.By;

import static seleniumPageObject.driver.DriverProvider.getDriver;


public class PasswordReset {

    //uzupełnienie pola 'Email address'
    public void email() {
        getDriver().findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("test.mail@wp.pl");
    }

    //kliknięcie w button 'Send reset link'
    public void sendResetLink() {
        getDriver().findElement(By.id("send-reset-link")).click();
    }

    //kliknięcie w link 'Back to Login'
    public void backToLoginPageLink() {
        getDriver().findElement(By.xpath("//i[@class=\"material-icons\"]")).click();
    }

    //asercja - sprawdzenie komunikatu potwierdzającego wysłanie maila
    public boolean isMsgOfSentMsgDisplayed() {
        return getDriver().findElement(By.xpath("//li[@class=\"item\"]/p")).isDisplayed();
    }
}