package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class paymentAmountSteps extends TestBase {


    @And("^I get amount total before doing transaction in topup mobile$")
    public void iGetAmountTotalBeforeDoingTransactionInTopupMobile() throws Exception {
        List<AndroidElement> transferredAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String transferredAmount = transferredAmountList.get(0).getText();
        transferredAmount = transferredAmount.replace(" VND", "");
        transferredAmount = transferredAmount.replace(",", "");
        System.out.println("**************** Before Amount   " + transferredAmount);
        d_beforeAmount = Double.parseDouble(transferredAmount);
    }

    @And("^I get transferred amount (in payment service|when booking train ticket|when booking bouquet)$")
    public void iGetTransferredAmountInPaymentService(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Chia sẻ']"));
        switch (type) {
            default:
                List<AndroidElement> transferredAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
                String transferredAmount = transferredAmountList.get(0).getText();
                transferredAmount = transferredAmount.replace(" VND", "");
                transferredAmount = transferredAmount.replace(",", "");
                System.out.println("**************** Transferred Amount   " + transferredAmount);
                d_transferredAmount = Double.parseDouble(transferredAmount);
        }
    }

    @Then("^I get amount total after doing transaction for topup (VietJetAir|mobile)$")
    public void iGetAmountTotalAfterDoingTransactionForTopupVietJetAir(String type) throws Exception {
        switch (type) {
            default:
                List<AndroidElement> afterAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
                String afterAmount = afterAmountList.get(1).getText();
                afterAmount = afterAmount.replace(" VND", "");
                afterAmount = afterAmount.replace(",", "");
                System.out.println("**************** After Amount   " + afterAmount);
                d_afterAmount = Double.parseDouble(afterAmount);
        }
    }

    @And("^I get amount total before doing transaction for topup VietJetAir$")
    public void iGetAmountTotalBeforeDoingTransactionForTopupVietJetAir() throws Exception{
        Thread.sleep(3000);
        //        List<?> text = androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String beforeAmount = androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'VND')]")).getText();
        beforeAmount = beforeAmount.replace(" VND", "");
        beforeAmount = beforeAmount.replace(",", "");
        System.out.println("**************** Before Amount   " + beforeAmount);
        d_beforeAmount = Double.parseDouble(beforeAmount);
    }

    @And("^I verify before total amount = after total amount \\+ topup VJA amount$")
    public void iVerifyBeforeTotalAmountAfterTotalAmountTopupVJAAmount() {
        System.out.println("***************after_transfer_amount  " + d_afterAmount);
        System.out.println("***************before_transfer_amount  " + d_beforeAmount);
        System.out.println("***************debit_Amount  " + d_transferredAmount);
        assertEquals(d_beforeAmount, d_afterAmount + d_transferredAmount);
    }
}
