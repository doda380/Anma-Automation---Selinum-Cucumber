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

    By slotButtons = By.xpath("//div[contains(@class, 'date-wrapper')]//button[@type='button']");

    By dropDownicon = By.xpath("//div[@role='combobox'][.//input[@id='BeneficiaryCaseId']]//i");
    By proceedOrderBtn = By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[2]/div/form/div[6]/button[2]");
    By walletToggleBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[1]/input");
    By couponField = By.id("CouponCode");
    By applyCouponBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[2]/div/form/button");
    By proceedPaymentBtn = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/button");
    By walletBalance = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[1]/div/div[2]/p");
    By finalTotal = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/p/span[1]");
    By totalAmount = By.xpath("//p[contains(@class,'items-center')]//span[contains(@class,'font-bold')]");
    By discountAmount = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/div[2]/div/span[1]");
    By deductedWalletAmount = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/div[2]/div/section[2]/div[3]/div/div[2]/div[3]/div/span[1]");
    By validationMsg = By.xpath("//*[@id=\"main-app\"]/div[4]/div[2]/section/div/div/div[2]/h3");

    // Telr
    By cardNumberField = By.id("creditCardNumber");
    By cvvField = By.id("cardCVV");
    By phoneField = By.id("bill_phone");
    By makePaymentBtn = By.xpath("//*[@id=\"card_btn_row\"]/div[2]/button[1]");
    By cancelPaymentBtn = By.xpath("//*[@id=\"card_btn_row\"]/div[2]/button[2]");
    By acceptPaymentBtn = By.xpath("//input[@name='a' and @value='Accept']");
    By declineTransactionBtn = By.xpath("/html/body/center/div/table/tbody/tr[8]/td[3]/form/input[3]");


    // ---------- ACTIONS ----------

    public void openVirtualClinics() {
        wait.until(ExpectedConditions.elementToBeClickable(virtualClinicsBtn)).click();
    }

    public void selectServiceProvider() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceProviderCard)).click();
    }

    public void chooseConsultationSession() {
        wait.until(ExpectedConditions.elementToBeClickable(consultantSessionBtn)).click();
    }

    public void selectCase(String caseName) {

        wait.until(ExpectedConditions.elementToBeClickable(dropDownicon)).click();

        WebElement caseInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("BeneficiaryCaseId"))
        );
        caseInput.clear();
        caseInput.sendKeys(caseName);

        By caseOption = By.xpath(
                "//div[@role='listbox']//div[contains(@class,'v-list-item')]" +
                        "//div[contains(normalize-space(),'" + caseName + "')]"
        );

        wait.until(ExpectedConditions.elementToBeClickable(caseOption)).click();
    }

    public void selectAvailableSlots(int numberOfSlotsToSelect) {

        List<WebElement> slots = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(slotButtons));

        int selected = 0;

        for (WebElement slot : slots) {
            if (slot.isEnabled()) {
                slot.click();
                selected++;

                if (selected == numberOfSlotsToSelect) {
                    break;
                }
            }
        }
        System.out.println("Slots found = " + slots.size());
        System.out.println("Slots selected = " + selected);
    }


    public void clickProceedOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedOrderBtn)).click();
    }

    public void toggleWallet() {
        wait.until(ExpectedConditions.elementToBeClickable(walletToggleBtn)).click();
    }

    public void enterCouponCode(String coupon) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponField)).sendKeys(coupon);
    }

    public void applyCoupon() {
        wait.until(ExpectedConditions.elementToBeClickable(applyCouponBtn)).click();
    }

    public void setProceedPaymentBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedPaymentBtn)).click();
    }

    public String getWalletBalance() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(walletBalance)).getText();
    }

    public String getFinalTotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(finalTotal)).getText();
    }

    public String getDiscountAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(discountAmount)).getText();
    }

    public String getTotalAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalAmount)).getText();
    }

    public String getDeductedWalletAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deductedWalletAmount)).getText();
    }

    public String getValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(validationMsg)).getText();
    }


    // Wallet state
    public boolean isWalletEnabled() {
        WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(walletToggleBtn));
        return toggle.isSelected();
    }

    // TELR PAYMENT
    public void enterCardNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).sendKeys(number);
    }

    public void enterCVV(String cvv) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvvField)).sendKeys(cvv);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void clickMakePayment() {
        wait.until(ExpectedConditions.elementToBeClickable(makePaymentBtn)).click();
    }


    public void acceptTransaction() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mpi_frame"));
        wait.until(ExpectedConditions.elementToBeClickable(acceptPaymentBtn)).click();
        driver.switchTo().defaultContent();
    }


    public void payWithCard(String card, String cvv, String phone) throws InterruptedException {
        enterCardNumber(card);
        enterCVV(cvv);
        enterPhone(phone);
        clickMakePayment();
        acceptTransaction();
        Thread.sleep(20000);
    }

    public void confirmWalletOnlyPayment() {
        clickProceedOrder();
    }

    public void payWithWalletAndCard(String card, String cvv, String phone) {
        enterCardNumber(card);
        enterCVV(cvv);
        enterPhone(phone);
        clickMakePayment();
    }

}
