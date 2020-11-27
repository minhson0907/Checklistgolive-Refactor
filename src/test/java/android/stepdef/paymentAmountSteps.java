package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class paymentAmountSteps extends TestBase {

    @Then("^I verify \"([^\"]*)\" is displayed if bill is not paid or \"([^\"]*)\" is displayed if bill has been paid$")
    public void iVerifyIsDisplayedIfBillIsNotPaidOrIsDisplayedIfBillHasBeenPaid(String text1, String text2) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).isDisplayed()) {
                String actualString1 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text2 + "']")).getText();
                System.out.println("**************** Data table " + actualString1);
                assertTrue(actualString1.contains(text2));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.ImageView[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.ImageView[@index='1']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + text1 + "']"));
                String actualString1 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text1 + "']")).getText();
                System.out.println("**************** Data table " + actualString1);
                assertTrue(actualString1.contains(text1));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

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
                Thread.sleep(1000);
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

//    @And("^I get amount total before doing transaction$")
//    public void iGetAmountTotalBeforeDoingTransaction() throws Exception {
//        Thread.sleep(3000);
//        //        List<?> text = androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
//        String beforeAmount = androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'VND')]")).getText();
//        beforeAmount = beforeAmount.replace(" VND", "");
//        beforeAmount = beforeAmount.replace(",", "");
//        System.out.println("**************** Before Amount   " + beforeAmount);
//        d_beforeAmount = Double.parseDouble(beforeAmount);
//    }

    @And("^I do paying bill from \"([^\"]*)\" account for \"([^\"]*)\" agent code with amount is \"([^\"]*)\"$")
    public void iDoPayingBillFromAccountForAgentCodeAmountWithDescriptionIs(String fromAccount, String agentCode, String amount) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã đại lý/Đoàn']")).sendKeys(agentCode);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I pay card from \"([^\"]*)\" to \"([^\"]*)\" with amount is \"([^\"]*)\"$")
    public void iPayCardFromToWithAmountIs(String fromAccount, String toAccount, String amount) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Thanh toán thẻ']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Thanh toán thẻ']")).click();
        // Choose AccountFrom
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        // Input AccountTo
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập tài khoản thẻ']")).sendKeys(toAccount);
        // Input amount
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập số tiền']")).sendKeys(amount);
        // Tap on Continue btn
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();

    }

}
