package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ResetPage {

    WebDriver driver;
    WebDriverWait wait;


    public ResetPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));    }

    By ForgetPasswordBtn = By.id("forgetPassword");
    By EmailField = By.id("Email");
    By SendBtn = By.id("ForgetButton");
    By Validation = By.xpath("//div[@class='notification-content']");


    public void Navigate_to_Forget_password() {
        wait.until(ExpectedConditions.elementToBeClickable(ForgetPasswordBtn)).click();
    }

    public void Add_Email(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailField)).sendKeys(email);
    }

    public void Send() {
        wait.until(ExpectedConditions.elementToBeClickable(SendBtn)).click();
    }


    public String Validation_Message() {
        String Actual;
        return Actual = wait.until(ExpectedConditions.visibilityOfElementLocated(Validation)).getText();
    }

    public void Email_Assertion(String expected){
        Assert.assertEquals(Validation_Message(),expected);
    }



}
