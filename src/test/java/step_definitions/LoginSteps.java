package step_definitions;

import Hooks.Hook;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Sleeper;


public class LoginSteps {



    WebDriver driver;
    LoginPage loginPage;


    @Given("the cookies popup is displayed and the user accepts it")
    public void acceptCookies() {
        driver = Hook.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.acceptCookiesIfPresent();
    }

    @And("the user is on the login page")
    public void navigateToLoginPage() {
        loginPage.navigateToLogin();
    }

    @When("the user enters valid credentials {string} , {string}")
    public void loginWithValidCredentials(String email, String password) throws InterruptedException {
        loginPage.login(email, password);

    }

    @Then("user will be able to see {string}")
    public void validateSuccessfulLogin(String expectedText) {
        Assert.assertEquals(loginPage.getProfileText(), expectedText);
    }

    @Then("login validation message {string}")
    public void validateFailedLogin(String expectedMessage) {
        Assert.assertEquals(loginPage.getValidationMessage(), expectedMessage);
    }
}