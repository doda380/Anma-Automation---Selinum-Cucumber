package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By cookiesBtn = By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[2]/button[1]");
    By loginNavBtn = By.id("NavLoginBtn");
    By username = By.id("UserName");
    By password = By.id("Password");
    By loginBtn = By.id("loginBtn");
    By profileText = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/p");
    By validationMessage = By.cssSelector(".notification-content");

    // Actions
    public void acceptCookiesIfPresent() {
            wait.until(ExpectedConditions.elementToBeClickable(cookiesBtn)).click();
    }

    public void navigateToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginNavBtn)).click();
    }

    public void enterUsername(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(value);
    }

    public void enterPassword(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(value);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }


    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getProfileText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileText)).getText();
    }

    public String getValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessage)).getText();
    }
}