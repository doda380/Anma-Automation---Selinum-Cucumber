package step_definitions;

import Hooks.Hook;
import Pages.ResetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class ResetPasswordSteps {

    WebDriver driver;
    ResetPage rest;

    @When("the user clicks the Forget Password link")
    public void Forget_password(){
        driver = Hook.getDriver();
        rest = new ResetPage(driver);
       rest.Navigate_to_Forget_password();
    }

    @And("user enter recovery {string}")
    public void Enter_Email_Recovery(String Email){
      rest.Add_Email(Email);
      rest.Send();
    }

    @Then("a confirmation message should appear {string}")
    public void confirmation_message(String expectedText1) {
        rest.Email_Assertion(expectedText1);
    }

    @Then("a validation message should appear {string}")
    public void Email_Recovery_Validation(String expectedText2){
        rest.Email_Assertion(expectedText2);
    }

}
