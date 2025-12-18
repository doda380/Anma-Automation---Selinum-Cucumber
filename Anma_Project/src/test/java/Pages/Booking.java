package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Booking {

    WebDriver driver;
    WebDriverWait wait;

    public Booking(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- LOCATORS ----------
    By virtualClinicsBtn = By.linkText("الفصول والعيادات الافتراضية");
    By serviceProviderCard = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/form/div/div[2]/div/div[2]/a[12]");
    By treatmentSessionBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div[1]/div/div[1]/div[2]/button[1]");
    By consultantSessionBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div[1]/div/div[1]/div[2]/button[2]");
    By timeSlotBtn = By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[2]/div/form/div[3]/div[2]/div[2]/div/div[1]/button");
    By timeSlotsContainer = By.cssSelector("div.date-wrapper");
    By caseField = By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[2]/div/form/div[1]/div[2]/div/div/div/div[1]/div/div[3]/div");
    By options = By.xpath("//div[@role='option']");
    By proceedOrderBtn = By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[2]/div/form/div[6]/button[2]");

    By walletToggleBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[1]/input");
    By couponField = By.id("CouponCode");
    By applyCouponBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[2]/div/form/button");

    By walletBalance = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[1]/div/div[2]/p");
    By finalTotal = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/p/span[1]");
    By totalAmount = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/div[1]/div/span[1]");
    By discountAmount = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/div[2]/div/span[1]");
    By deductedWalletAmount  = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/div[3]/div/span[1]");
    By validationMsg = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/section/div/div/div[2]/h3");

    // Telr
    By cardNumberField = By.id("creditCardNumber");
    By cvvField = By.id("cardCVV");
    By phoneField = By.id("bill_phone");
    By makePaymentBtn = By.xpath("//*[@id=\"card_btn_row\"]/div[2]/button[1]");
    By cancelPaymentBtn = By.xpath("//*[@id=\"card_btn_row\"]/div[2]/button[2]");
    By acceptTransactionBtn = By.name("a");
    By declineTransactionBtn = By.name("r");


    // ---------- ACTIONS ----------

    public void openVirtualClinics() { wait.until(ExpectedConditions.elementToBeClickable(virtualClinicsBtn)).click(); }
    public void selectServiceProvider() { wait.until(ExpectedConditions.elementToBeClickable(serviceProviderCard)).click(); }
    public void chooseConsultationSession() { wait.until(ExpectedConditions.elementToBeClickable(consultantSessionBtn)).click(); }

    public void selectCase(String caseName) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(caseField)
        );

        field.click();
        field.clear();
        field.sendKeys(caseName);

        By option = By.xpath(
                "//div[contains(@class,'v-list-item') and normalize-space()='" + caseName + "']"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(option)).click();
    }
    public void clickProceedOrder() { wait.until(ExpectedConditions.elementToBeClickable(proceedOrderBtn)).click(); }
    public void toggleWallet() { wait.until(ExpectedConditions.elementToBeClickable(walletToggleBtn)).click(); }
    public void enterCouponCode(String coupon) { wait.until(ExpectedConditions.visibilityOfElementLocated(couponField)).sendKeys(coupon); }
    public void applyCoupon() { wait.until(ExpectedConditions.elementToBeClickable(applyCouponBtn)).click(); }

    public String getWalletBalance() { return wait.until(ExpectedConditions.visibilityOfElementLocated(walletBalance)).getText(); }
    public String getFinalTotal() { return wait.until(ExpectedConditions.visibilityOfElementLocated(finalTotal)).getText(); }
    public String getDiscountAmount() { return wait.until(ExpectedConditions.visibilityOfElementLocated(discountAmount)).getText(); }
    public String getTotalAmount() { return wait.until(ExpectedConditions.visibilityOfElementLocated(totalAmount)).getText(); }
    public String getDeductedWalletAmount() { return wait.until(ExpectedConditions.visibilityOfElementLocated(deductedWalletAmount)).getText(); }
    public String getValidationMessage() { return wait.until(ExpectedConditions.visibilityOfElementLocated(validationMsg)).getText(); }




    public void selectNumberOfAvailableSlots(int numberOfSlotsToSelect) {

        WebElement container = wait.until(
                ExpectedConditions.presenceOfElementLocated(timeSlotsContainer)
        );

        List<WebElement> slots = container.findElements(timeSlotBtn);

        int selectedCount = 0;

        for (WebElement slot : slots) {

            if (slot.isDisplayed() && slot.isEnabled()) {

                slot.click();
                selectedCount++;

                if (selectedCount == numberOfSlotsToSelect) {
                    break;
                }
            }
        }
    }

    // Wallet state
    public boolean isWalletEnabled() {
        WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(walletToggleBtn));
        return toggle.isSelected();
    }

    // TELR PAYMENT
    public void enterCardNumber(String number) { wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).sendKeys(number); }
    public void enterCVV(String cvv) { wait.until(ExpectedConditions.visibilityOfElementLocated(cvvField)).sendKeys(cvv); }
    public void enterPhone(String phone) { wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone); }
    public void clickMakePayment() { wait.until(ExpectedConditions.elementToBeClickable(makePaymentBtn)).click(); }

    public void payWithCard(String card, String cvv, String phone) {
        enterCardNumber(card);
        enterCVV(cvv);
        enterPhone(phone);
        clickMakePayment();
    }

    public void confirmWalletOnlyPayment() { clickProceedOrder(); }

    public void payWithWalletAndCard(String card, String cvv, String phone) {
        enterCardNumber(card);
        enterCVV(cvv);
        enterPhone(phone);
        clickMakePayment();
    }

}
