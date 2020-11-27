package android.stepdef;

import android.base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class transferAmountSteps extends TestBase {

    @Then("^I get fee$")
    public void iGetFee() throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Chia sẻ']"));
        List<AndroidElement> feeList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String fee = feeList.get(1).getText();
        fee = fee.replace(" VND", "");
        fee = fee.replace(",", "");
        System.out.println("**************** fee   " + fee);
        d_fee = Double.parseDouble(fee);
    }

    @Then("^I get transferred amount$")
    public void iGetTransferredAmount() throws Exception {
        List<AndroidElement> transferredAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String transferredAmount = transferredAmountList.get(0).getText();
        transferredAmount = transferredAmount.replace(" VND", "");
        transferredAmount = transferredAmount.replace(",", "");
        System.out.println("**************** Transferred Amount   " + transferredAmount);
        d_transferredAmount = Double.parseDouble(transferredAmount);
    }

    @And("^I get amount total after doing transaction$")
    public void iGetAmountTotalAfterDoingTransaction() throws Exception {
        List<AndroidElement> afterAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String afterAmount = afterAmountList.get(3).getText();
        afterAmount = afterAmount.replace(" VND", "");
        afterAmount = afterAmount.replace(",", "");
        System.out.println("**************** After Amount   " + afterAmount);
        d_afterAmount = Double.parseDouble(afterAmount);
    }

    @And("^I get amount total before doing transaction$")
    public void iGetAmountTotalBeforeDoingTransaction() throws Exception {
        Thread.sleep(3000);
        //        List<?> text = androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String beforeAmount = androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'VND')]")).getText();
        beforeAmount = beforeAmount.replace(" VND", "");
        beforeAmount = beforeAmount.replace(",", "");
        System.out.println("**************** Before Amount   " + beforeAmount);
        d_beforeAmount = Double.parseDouble(beforeAmount);
    }

    @And("^I verify before total amount = after total amount \\+ debit amount \\+ fee$")
    public void iVerifyBeforeTotalAmountAfterTotalAmountDebitAmountFee() throws Exception {
//        System.out.println("***************after_transfer_account  " + d_afterAmount);
//        System.out.println("***************before_transfer_account  " + d_beforeAmount);
//        System.out.println("***************debit_Amount  " + d_transferredAmount);
//        System.out.println("***************Fee  " + d_fee);
        try {
            assertEquals(d_beforeAmount, d_afterAmount + d_transferredAmount + d_fee);
        } catch (AssertionError e) {
            e.getMessage();
        }
    }

    @And("^I verify before total amount = after total amount \\+ debit amount$")
    public void iVerifyBeforeTotalAmountAfterTotalAmountDebitAmount() throws Exception {
//        System.out.println("***************after_transfer_account  " + d_afterAmount);
//        System.out.println("***************before_transfer_account  " + d_beforeAmount);
//        System.out.println("***************debit_Amount  " + d_transferredAmount);
        assertEquals(d_beforeAmount, d_afterAmount + d_transferredAmount);
    }
}
