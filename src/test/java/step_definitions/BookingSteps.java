package step_definitions;

import Hooks.Hook;
import Pages.Booking;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import java.time.Duration;

public class BookingSteps {

    WebDriver driver;
    Booking bookingPage;
    // BASE FLOW
    @And("The user opens virtual clinics and selects a service provider")
    public void open_virtual_clinic() throws InterruptedException {
        driver = Hook.getDriver();
        bookingPage = new Booking(driver);
        Thread.sleep(8000);
        bookingPage.openVirtualClinics();
        bookingPage.selectServiceProvider();

    }

    @And("The user selects a consultant session and an available time slot")
    public void select_provider_and_slot() {
        bookingPage.chooseConsultationSession();
        bookingPage.selectAvailableSlots(2);
    }

    @And("The user selects case {string} , {string}")
    public void select_case(String caseOption, String caseName) {

        if (caseOption.equalsIgnoreCase("Yes")) {
            bookingPage.selectCase(caseName);
        }
        bookingPage.clickProceedOrder();

    }
    // COUPON
    @When("The user applies coupon {string} , {string}")
    public void apply_coupon(String couponOption, String couponValue) {
        if (couponOption.equalsIgnoreCase("Yes")) {
            bookingPage.enterCouponCode(couponValue);
            bookingPage.applyCoupon();
        }
    }

    // WALLET
    @When("The user toggles wallet {string}")
    public void toggle_wallet(String walletOption) {
        if (walletOption.equalsIgnoreCase("Yes")) {
            bookingPage.toggleWallet();
        }
    }

    // PAYMENT
    @When("The user proceeds to payment using {string}")
    public void payment_method(String paymentMethod) throws InterruptedException {
        Thread.sleep(3000);
        bookingPage.setProceedPaymentBtn();
        switch (paymentMethod) {
            case "Card":
                bookingPage.payWithCard("4111111111111111", "123", "0555555555");
                break;

            case "Wallet":
                bookingPage.confirmWalletOnlyPayment();
                break;

            case "Wallet+Card":
                bookingPage.payWithWalletAndCard("4111111111111111", "123", "0555555555");
                break;
        }
    }



    @Then("The booking should be completed successfully")
    public void verify_booking_success() {
        Assert.assertTrue(
                bookingPage.getValidationMessage().contains("Successfully") ||
                        bookingPage.getValidationMessage().contains("تم"),
                "Booking did not complete!"
        );
    }
}
