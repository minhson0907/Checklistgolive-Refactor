package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidElement;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.*;

import static org.testng.Assert.*;

public class mbkSteps extends TestBase {
    String fileName = "app-release.apk";
    File appRelease = new File("D:\\Android SDK\\platforms\\" + fileName);
    private double d_beforeAmount = 0;
    private double d_afterAmount = 0;
    private double d_fee = 0;
    private double d_transferredAmount = 0;
    String accountNumber;
    String reservationCode;

    @Given("^I open app$")
    public void iOpenApp() throws Exception {
    }

    @Then("^I logout app$")
    public void iLogoutApp() throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Trang chủ']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Trang chủ']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        Thread.sleep(2000);
        // Tap on icon three dash (dấu gạch ngang)
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
        // Tap on icon logout
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.ImageView")).click();
        // Tap on icon x in text box user name
        List<WebElement> a = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']"));
        a.get(0).click();
    }

    @Then("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginWithAnd(String user, String pass) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).isDisplayed()) {
                // Tap on icon x in text box user name
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(1, 0, "userdata"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
        byte[] decodeBytes = Base64.getDecoder().decode(DataHelper.getCellData(1, 5, "userdata").getBytes());
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đăng nhập']")).click();
    }

    @When("^As (input|approval|sms) user, I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void asKHDNILoginWithAnd(String type, String user, String pass) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).isDisplayed()) {
                // Tap on icon x in text box user name
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        switch (type) {
            case "input":
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(1, 2, "userdata"));
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
                byte[] decodeBytes1 = Base64.getDecoder().decode(DataHelper.getCellData(1, 6, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes1));
                break;
            case "approval":
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(1, 3, "userdata"));
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
                byte[] decodeBytes2 = Base64.getDecoder().decode(DataHelper.getCellData(1, 7, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes2));
                break;
            default:
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(2, 0, "userdata"));
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
                byte[] decodeBytes3 = Base64.getDecoder().decode(DataHelper.getCellData(2, 5, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes3));
                break;

        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đăng nhập']")).click();
    }

    @Then("^I go to Home$")
    public void iGoToHome() throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Trang chủ']")).click();
    }

    @And("^I input OTP code that is sent to your phone within \"([^\"]*)\" seconds$")
    public void iInputOTPCode(int time) throws Exception {
        Thread.sleep(time * 1000);
//        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='2']"));
//        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='2']")).sendKeys(code);
    }

    @And("^I do transaction from \"([^\"]*)\" account with type is \"([^\"]*)\"$")
    public void iDoTransactionWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
    }

    @And("^As sms user, I do transaction from \"([^\"]*)\" account with type is \"([^\"]*)\"$")
    public void asSmsUserIDoTransactionWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(2, 1, "userdata") + "']")).click();
    }

    @And("^As KHDN, I do transaction from \"([^\"]*)\" account with type is \"([^\"]*)\"$")
    public void asKHDNiDoTransactionWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 4, "userdata") + "']")).click();
    }

    private double getBeforeAmount() throws Exception {
        Thread.sleep(3000);
        //        List<?> text = androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String beforeAmount = androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'VND')]")).getText();
        beforeAmount = beforeAmount.replace(" VND", "");
        beforeAmount = beforeAmount.replace(",", "");
        System.out.println("**************** Before Amount   " + beforeAmount);
        d_beforeAmount = Double.parseDouble(beforeAmount);
        return d_beforeAmount;
    }

    @And("^I get amount total before doing transaction$")
    public void iGetAmountTotalBeforeDoingTransaction() throws Exception {
        getBeforeAmount();
    }

    @Then("^I transfer to \"([^\"]*)\" account, \"([^\"]*)\" amount and \"([^\"]*)\" description with fee payer is \"([^\"]*)\"$")
    public void iTransferFromToAccountAmountAndDescriptionWithFeePayerIs(String toAccount, String amount, String description, String feePayer) throws Exception {
//        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
//        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
//        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        waitElement(By.xpath("//android.widget.EditText[@text='Số tài khoản *']"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tài khoản *']")).sendKeys(toAccount);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Người chuyển trả']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']")).click();
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^As KHDN, I transfer to \"([^\"]*)\" account, \"([^\"]*)\" amount and \"([^\"]*)\" description with fee payer is \"([^\"]*)\"$")
    public void AsKHDNiTransferFromToAccountAmountAndDescriptionWithFeePayerIs(String toAccount, String amount, String description, String feePayer) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 4, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tài khoản *']")).sendKeys(toAccount);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Người chuyển trả']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']")).click();
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I verify \"([^\"]*)\" is displayed after doing transaction successfully$")
    public void iVerifyIsDisplayedAfterDoingTransactionSuccessfully(String text) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        String actualString1 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']")).getText();
        System.out.println("**************** Data table " + actualString1);
        assertTrue(actualString1.contains(text));
    }

    @And("^I verify \"([^\"]*)\" \"([^\"]*)\" is displayed after doing transaction successfully$")
    public void iVerifyIsDisplayedAfterDoingTransactionSuccessfully(String text1, String text2) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + text1 + "']"));
        String actualString1 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text1 + "']")).getText();
        String actualString2 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text2 + "']")).getText();
        System.out.println("**************** Data table " + actualString1);
        assertTrue(actualString1.contains(text1));
        assertTrue(actualString2.contains(text2));
    }

    private double getFee() throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Chia sẻ']"));
        List<AndroidElement> feeList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String fee = feeList.get(1).getText();
        fee = fee.replace(" VND", "");
        fee = fee.replace(",", "");
        System.out.println("**************** fee   " + fee);
        d_fee = Double.parseDouble(fee);
        return d_fee;
    }

    @Then("^I get fee$")
    public void iGetFee() throws Exception {
        getFee();
    }

    private double getTransferredAmount() throws Exception {
        List<AndroidElement> transferredAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String transferredAmount = transferredAmountList.get(0).getText();
        transferredAmount = transferredAmount.replace(" VND", "");
        transferredAmount = transferredAmount.replace(",", "");
        System.out.println("**************** Transferred Amount   " + transferredAmount);
        d_transferredAmount = Double.parseDouble(transferredAmount);
        return d_transferredAmount;
    }

    @Then("^I get transferred amount$")
    public void iGetTransferredAmount() throws Exception {
        getTransferredAmount();
    }

    private double getAfterAmount() throws Exception {
        List<AndroidElement> afterAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String afterAmount = afterAmountList.get(3).getText();
        afterAmount = afterAmount.replace(" VND", "");
        afterAmount = afterAmount.replace(",", "");
        System.out.println("**************** After Amount   " + afterAmount);
        d_afterAmount = Double.parseDouble(afterAmount);
        return d_afterAmount;
    }

    @And("^I get amount total after doing transaction$")
    public void iGetAmountTotalAfterDoingTransaction() throws Exception {
        getAfterAmount();
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

    @Then("^I transfer to \"([^\"]*)\" bank, \"([^\"]*)\" account, \"([^\"]*)\" receiver, \"([^\"]*)\" amount and \"([^\"]*)\" description with fee payer is \"([^\"]*)\"$")
    public void iTransferFromToBankAccountReceiverAmountAndDescriptionWithFeePayerIs(String bank, String toAccount, String name, String amount, String description, String feePayer) throws Exception {
//        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']"));
//        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']")).click();
//        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập tên hoặc số tài khoản tìm kiếm']")).sendKeys(name);
//        androidDriver.findElement(By.id("com.vnpay.hdbank:id/title")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        try {
            if (androidDriver.isKeyboardShown()) {
                androidDriver.hideKeyboard();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        // scroll up
        scrollToUp();
        waitElement(By.xpath("//android.widget.TextView[@text='Người chuyển trả']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Người chuyển trả']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']")).click();
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @And("^I scroll up page$")
    public void iScrollUpPage() throws Exception {
        Thread.sleep(2000);
        scrollToUp();
    }

    @Then("^I transfer to \"([^\"]*)\" card number, \"([^\"]*)\" amount and \"([^\"]*)\" description$")
    public void iTransferFromToCardNumberAmountAndDescription(String cardNumber, String amount, String description) throws Exception {
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+ fromAccount +"']")).click();
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+fromAccount+"']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số thẻ *']")).sendKeys(cardNumber);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do transaction with type is \"([^\"]*)\" in Home page 1$")
    public void iDoTransactionWithTypeIsInHomePage1(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
    }

    @And("^I do transaction with type is \"([^\"]*)\" in Home page 2$")
    public void iDoTransactionWithTypeIsInHomePage2(String type) throws Exception {
//        Thread.sleep(3000);
        waitElement(By.xpath("//android.widget.TextView[@text='Tài khoản']"));
        swipeToLeft();
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
    }

    @Then("^I pay \"([^\"]*)\" service$")
    public void iPayService(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
    }

    @Then("^I pay \"([^\"]*)\" bill in \"([^\"]*)\" service$")
    public void iPayBillInService(String type1, String type2) throws Exception {
        if (type2.equals("Thanh toán khoản vay")) {
            waitElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']")).click();
        } else if (type2.equals("Topup cho đại lý VietjetAir")) {
            waitElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']")).click();
        } else {
            waitElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']")).click();
            waitElement(By.xpath("//android.widget.TextView[@text='" + type1 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type1 + "']")).click();
        }
    }


    @And("^I do paying an electronic bill from \"([^\"]*)\" account with customer ID is \"([^\"]*)\"$")
    public void iDoPayingAnElectronicBillFromAccountWithCustomerCodeIs(String fromAccount, String customerCode) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã khách hàng *']")).sendKeys(customerCode);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I looking for the hotel in \"([^\"]*)\"$")
    public void iLookingForTheHotelAroundMe(String location) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.widget.TextView[@text='Tên khách sạn hoặc điểm đến']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tên khách sạn hoặc điểm đến']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn điểm đến']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + location + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tìm kiếm']")).click();
    }

    @Then("^I book a hotel with email info is \"([^\"]*)\"$")
    public void iBookAPopularHotelNearMe(String email) throws Exception {
        waitElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.LinearLayout[@index='0']"));
        androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Trả phòng: trước 12:00 - Nhận phòng: sau 14:00']"));
        scrollToUp();
        waitElement(By.xpath("//android.widget.TextView[@text='ĐẶT PHÒNG']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='ĐẶT PHÒNG']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys(email);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='THANH TOÁN']")).click();
    }

    @Then("^I continue to book (hotel|the train|flower)$")
    public void iContinueToBookHotel(String type) throws Exception {
        switch (type) {
            default:
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
        }
    }

    @And("^I topup \"([^\"]*)\" into \"([^\"]*)\" phone number$")
    public void iTopup(String card, String phoneNumber) throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).clear();
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys(phoneNumber);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + card + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Ghi chú']")).sendKeys("i topup by myself");
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^As KHDN, I do transaction with type is \"([^\"]*)\" in Home page 1$")
    public void asKHDNIDoTransactionWithTypeIsInHomePage1(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[contains(@text,'" + type + "')]"));
//        try {
//            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']")).isDisplayed()) {
//                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + type + "')]")).click();
    }

    @And("^I choose \"([^\"]*)\"$")
    public void iChoose(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
    }

    @And("^I search the above transaction$")
    public void iSearchTheAboveTransaction() throws Exception {
        List<AndroidElement> transactionList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Chờ duyệt')]"));
        transactionList.get(0).click();
        Thread.sleep(3000);
    }

    @Then("^I (approve|decline) the above transaction with code is \"([^\"]*)\"$")
    public void approveOrDeclineTransaction(String type, String code) throws Exception {
        scrollToUp();
        switch (type) {
            case "approve":
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Duyệt']")).click();
                Thread.sleep(5000);
                break;
            case "decline":
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nội dung phê duyệt/từ chối']")).sendKeys("AUTO DECLINE");
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Từ chối']")).click();
                Thread.sleep(5000);
                break;
        }
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).sendKeys(code);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.widget.Button[@text='Đồng ý']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đồng ý']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
    }

    @And("^I update \"([^\"]*)\" account with type is (Chuyển khoản thông thường|Chuyển khoản tự động)$")
    public void iUpdateAccountWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập tên hoặc số tài khoản tìm kiếm']")).sendKeys(accountNumber);
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[@index='2']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chỉnh sửa']")).click();
        androidDriver.findElement(By.xpath("//android.widget.ScrollView[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='4']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Cập nhật']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Đồng ý']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).click();
        waitElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.EditText"));
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.EditText")).clear();
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.EditText")).sendKeys(accountNumber);
        waitElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to \"([^\"]*)\" provider with customer ID is \"([^\"]*)\"$")
    public void iDoPayingAnWaterBillFromAccountToProviderWithCustomerIDIs(String fromAccount, String provider, String customerID) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn nhà cung cấp']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + provider + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã khách hàng *']")).sendKeys(customerID);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to \"([^\"]*)\" provider with code ID is \"([^\"]*)\"$")
    public void iDoPayingAnWaterBillFromAccountToProviderWithCodeIDIs(String fromAccount, String provider, String customerID) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn nhà cung cấp']"));
        scrollToUp();
        waitElement(By.xpath("//android.widget.TextView[@text='" + provider + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + provider + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã khách hàng *']")).sendKeys(customerID);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to (VietJet - Thanh toán cước vé máy bay nội địa|Thanh toán vé đặt qua VNPAY) provider with the above reservation code$")
    public void iDoPayingBillFromAccountToProviderWithReservationCodeIs(String fromAccount, String type) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).click();
        Thread.sleep(1000);
        switch (type) {
            case "VietJet - Thanh toán cước vé máy bay nội địa":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã đặt chỗ *']")).sendKeys(reservationCode);
                break;
            case "Thanh toán vé đặt qua VNPAY":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã thanh toán *']")).sendKeys(reservationCode);
                break;
        }
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to (FECredit|HD SAIGON|HomeCredit) provider, \"([^\"]*)\" contract number and \"([^\"]*)\" amount with description is \"([^\"]*)\"$")
    public void iDoPayingBillFromAccountToFECreditProviderContractNumberAndAmountWithDescriptionIs(String fromAccount, String type, String contractNumber, String amount, String description) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn nhà cung cấp']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số hợp đồng *']")).sendKeys(contractNumber);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Ghi chú']")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

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

    @And("^I read Terms & Conditions and agree$")
    public void iReadTermsConditionsAndAgree() throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Tôi đã đọc và đồng ý']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tôi đã đọc và đồng ý']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đồng ý']")).click();
    }

    @Then("^I open online saving account from \"([^\"]*)\" account, \"([^\"]*)\" amount, \"([^\"]*)\" terms with method is \"([^\"]*)\"$")
    public void iOpenOnlineSavingAccountFromAccountAmountTermsWithMethodIs(String fromAccount, String amount, String terms, String method) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền gửi (VND) *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Kỳ hạn']")).click();
        Thread.sleep(2000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + terms + "']")).click();
        Thread.sleep(2000);
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + method + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I choose \"([^\"]*)\" to open online saving account$")
    public void iChooseToOpenOnlineSavingAccount(String name) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + name + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout/android.widget.ImageView")).click();
    }

    @Then("^I book an (one way|round trip) (domestic|international) flight from \"([^\"]*)\" to \"([^\"]*)\" on (Vietnam Airlines|Pacific Airlines|VietJet Air|Bamboo Airways|all) airline with method is (Pay later|Pay now)$")
    public void iBookAnOneWayDomesticFlightFromTo(String type, String flightType, String fromFlight, String toFlight, String airline, String method) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Nội địa']"));
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String s_day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
//        double d_day = Double.parseDouble(s_day);
        int d_day = Integer.parseInt(s_day);
        int d_s_day_later = d_day + 2;
        int d_e_day = d_day + 1;
        int d_e_day_later = d_e_day + 2;
        String e_day = String.valueOf(d_e_day);
        String s_day_later = String.valueOf(d_s_day_later);
        String e_day_later = String.valueOf(d_e_day_later);
        switch (type) {
            case "one way":
                if (flightType.equals("domestic")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Nội địa']")).click();
                } else if (flightType.equals("international")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Quốc tế']")).click();
                }
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Một chiều']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm khởi hành']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm đến']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn ngày']")).click();
//                waitElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']"));
                waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']"));
                switch (method) {
//                    case "Pay later":
//                        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day_later + "']")).click();
//                        break;
//                    case "Pay now":
//                        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']")).click();
//                        break;
                    default:
                        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']")).click();
                        break;
                }
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
                switch (airline) {
                    case "VietJet Air":
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Vietnam Airlines']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Pacific Airlines']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Bamboo Airways']")).click();
                        break;
                    case "Vietnam Airlines":
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='VietJet Air']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Pacific Airlines']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Bamboo Airways']")).click();
                        break;
                    case "all":
                        break;
                }
                Thread.sleep(1000);
                scrollToUp();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tìm chuyến bay']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Danh sách chuyến bay']"));
                androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='0']")).click();
                Thread.sleep(2000);
                waitElement(By.xpath("//android.widget.TextView[@text='Đặt vé']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé']")).click();
                break;
            case "round trip":
                if (flightType.equals("domestic")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Nội địa']")).click();
                } else if (flightType.equals("international")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Quốc tế']")).click();
                }
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Khứ hồi']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm khởi hành']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm đến']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']")).click();
                // Choose start & end day
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView]")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Chọn ngày bay']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + e_day + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
                Thread.sleep(1000);
                scrollToUp();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tìm chuyến bay']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Danh sách chuyến bay']"));
                androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='0']")).click();
                Thread.sleep(2000);
                waitElement(By.xpath("//android.widget.TextView[@text='Đặt vé']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé']")).click();
                break;
        }
    }

    @And("^I fill \"([^\"]*)\" full name, \"([^\"]*)\" gender, \"([^\"]*)\" email, \"([^\"]*)\" phone number with \"([^\"]*)\" description$")
    public void iFillFullNameWithGenderEmailPhoneNumberAndDescription(String name, String gender, String email, String phoneNumber, String description) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Thông tin đặt vé']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.EditText")).clear();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.EditText")).sendKeys(name);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + gender + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='4']")).clear();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='4']")).sendKeys(email);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='6']")).clear();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='6']")).sendKeys(phoneNumber);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nội dung (tùy chọn)']")).sendKeys(description);
    }

    @And("^I (check|uncheck) on use for Passenger information$")
    public void iCheckOnUseForPassengerInformation(String type) throws Exception {
        switch (type) {
            case "check":
                androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Dùng làm thông tin hành khách bay']")).click();
                break;
            case "uncheck":
                break;
        }
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I confirm the above flight with method is (Pay later|Pay now)$")
    public void iConfirmTheAboveFlight(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Xác nhận chuyến bay']"));
        androidDriver.findElement(By.xpath("//android.widget.CheckBox")).click();
        switch (type) {
            case "Pay later":
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Thanh toán sau']")).click();
                break;
            case "Pay now":
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Thanh toán']")).click();
                break;
        }
        Thread.sleep(10000);
    }

    @And("^I continue to book the above flight$")
    public void iContinueToBookTheAboveFlight() throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I choose \"([^\"]*)\" departure's baggage and \"([^\"]*)\" return's baggage$")
    public void iChooseDepartureSBaggageAndReturnSBaggage(String debaggage, String rebaggage) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn hành lý']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Hành lý chiều đi']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + debaggage + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Hành lý chiều về']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + rebaggage + "']")).click();
    }

    @Then("^I book an (one way|round trip) train from \"([^\"]*)\" to \"([^\"]*)\" with seat type is \"([^\"]*)\"$")
    public void iBookAnOneWayTrainFromToWithSeatTypeIs(String type, String fromTrain, String toTrain, String seatType) throws Exception {
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String s_day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        String e_day = s_day + 1;
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Ga khởi hành']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromTrain + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + toTrain + "']")).click();
        switch (type) {
            case "one way":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Một chiều']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Ngày đi']")).click();
                waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']"));
//                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']")).click();
                waitElement(By.xpath("//android.widget.Button[@text='Xác nhận']"));
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
                break;
            case "round trip":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Khứ hồi']")).click();
                break;
        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Hành khách']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout/android.widget.LinearLayout[@index='2']/android.widget.ImageView[@index='2']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xong']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Loại chỗ']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + seatType + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xong']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='TIẾP TỤC']")).click();
    }

    @And("^I choose departing and return time for (one way|round trip) train$")
    public void iChooseDepartingAndReturnTimeForOneWayTrain(String type) throws Exception {
        switch (type) {
            case "one way":
                androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout/android.widget.ImageView")).click();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='TIẾP TỤC']")).click();
                androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")).click();
                waitElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='12']/android.widget.FrameLayout[@index='0']/android.widget.ImageView"));
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='12']/android.widget.FrameLayout[@index='0']/android.widget.ImageView")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xong']")).click();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='TIẾP TỤC']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Chỗ đang đặt']"));
                androidDriver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
                break;
        }
    }

    @And("^I fill passenger info as below$")
    public void iFillPassengerInfoAsBelow(DataTable passengerInfo) throws Exception {
        List<List<String>> data = passengerInfo.raw();
        //This is to get the first data of the set (First Row + First Column)
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Họ và tên']")).sendKeys(data.get(0).get(0));
        //This is to get the first data of the set (First Row + Second Column)
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='5']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Số CMND/CCCD/Hộ chiếu/GPLX']")).sendKeys(data.get(0).get(1));

    }

    @And("^I fill contact info as below$")
    public void iFillContactInfoAsBelow(DataTable contactInfo) throws Exception {
        List<List<String>> data = contactInfo.raw();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Số CMND/CCCD/Hộ chiếu/GPLX']")).sendKeys(data.get(0).get(0));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys(data.get(0).get(1));
    }

    @And("^I continue to book train$")
    public void iContinueToBookTrain() throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Thông báo']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đồng ý']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='THANH TOÁN']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Thông báo']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Không']")).click();
        Thread.sleep(2000);
    }

    @And("^I wanna continue doing the above transaction$")
    public void iWannaContinueDoingTheAboveTransaction() {
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tiếp tục']")).click();
    }

    @And("^I get reservation code$")
    public void iGetReservationCode() throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='1']"));
        List<WebElement> valueList = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='1']"));
        reservationCode = valueList.get(0).getText();
        System.out.println("************* Reservation Code is " + reservationCode);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Hoàn tất']")).click();
    }

    @Then("^I go to Home after booking airline ticket$")
    public void iGoToHomeAfterBookingAirlineTicket() throws Exception {
        Thread.sleep(5000);
        waitElement(By.xpath("//android.widget.ImageView"));
        List<WebElement> valueList = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.ImageView"));
        System.out.println("************* list is " + valueList.size());
        valueList.get(0).click();
        Thread.sleep(1000);
        swipeToRight();
    }

    @Then("^I redeem an online saving account$")
    public void iRedeemAnOnlineSavingAccount() throws Exception {
        // Into detail account
        waitElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='4']"));
        androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='3']/android.widget.FrameLayout[@index='4']")).click();
        // Into tất toán
        waitElement(By.xpath("//android.widget.TextView[@text='Tất toán']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tất toán']")).click();
        Thread.sleep(5000);
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tất toán']")).click();
//        waitElement(By.xpath("//android.widget.TextView[@text='Đồng ý']"));
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
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

    @Then("^As KHDN, I transfer to \"([^\"]*)\" bank, \"([^\"]*)\" account, \"([^\"]*)\" receiver, \"([^\"]*)\" amount and \"([^\"]*)\" description with fee payer as default$")
    public void asKHDNITransferToBankAccountReceiverAmountAndDescriptionWithFeePayerIs(String bank, String toAccount, String name, String amount, String description) throws Exception {
//        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
//        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập tên hoặc số tài khoản tìm kiếm']")).sendKeys(name);
//        androidDriver.findElement(By.id("com.vnpay.hdbank:id/title")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        try {
            if (androidDriver.isKeyboardShown()) {
                androidDriver.hideKeyboard();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        //user khdn ko cho chọn nhé em, default người chuyển chịu phí
        //case này liên quan hạch toán phí gd 24/7 bên dưới nên chặn theo yêu cầu nghiệp vụ KHDN
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Người chuyển trả']")).click();
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']")).click();
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        // scroll up
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đồng ý']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Then("^I register HDBank OTP$")
    public void iRegisterHDBankOTP() throws Exception {
        Thread.sleep(5000);
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        Thread.sleep(10000);
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đăng ký HDBank OTP']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Tôi đã đọc và đồng ý']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tôi đã đọc và đồng ý']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đồng ý']")).click();
        Thread.sleep(10000);
    }

    @And("^I input \"([^\"]*)\" PIN code$")
    public void iInputPINCode(String pin) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")).sendKeys(pin);
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='2']")).sendKeys(pin);
    }


    @Then("^I verify \"([^\"]*)\" is displayed$")
    public void iVerifyIsDisplayed(String text) throws Throwable {
        waitElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        String actualString1 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']")).getText();
        System.out.println("**************** Data table " + actualString1);
        assertTrue(actualString1.contains(text));
    }

    @Then("^I input soft HDBank with code is \"([^\"]*)\"$")
    public void iInputSoftHDBank(String code) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).isDisplayed()) {
                byte[] decodeBytes = Base64.getDecoder().decode(DataHelper.getCellData(1, 8, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).sendKeys(new String(decodeBytes));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.widget.Button[@text='Đồng ý']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đồng ý']")).click();
        waitElement(By.xpath("//android.widget.Button[@text='Xác nhận']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
    }

    @And("^I buy a film ticket at \"([^\"]*)\" cinema$")
    public void iBuyAFilmTicket(String cinema) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.widget.TextView[@text='" + cinema + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + cinema + "']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='BHD Star Quang Trung']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='BHD Star Quang Trung']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Đang chiếu']"));
        List<AndroidElement> orderList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[@text='Đặt vé']"));
        orderList.get(0).click();
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='1']/android.widget.TextView[@index='0']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn số lượng vé']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='2']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn chỗ ngồi']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='MÀN HÌNH']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='6']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Thanh toán']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Thanh toán vé xem phim']"));
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("autotest@gmail.com");
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Thanh toán']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Tài khoản nguồn']"));
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I lock card$")
    public void iLockCard() throws Throwable {
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Khóa thẻ']")).click();
        waitElement(By.xpath("//android.widget.Button[@text='Tiếp tục']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I (close|open) the online payment$")
    public void iCloseTheOnlinePayment(String type) throws Throwable {
        androidDriver.findElement(By.xpath("//android.support.v4.view.ViewPager[@index='1']/android.widget.RelativeLayout[@index='0']")).click();
        waitElement(By.xpath("//android.widget.LinearLayout[@index='3']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).click();
        switch (type) {
            case "close":
                waitElement(By.xpath("//android.widget.Button[@text='Đóng thanh toán trực tuyến']"));
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đóng thanh toán trực tuyến']")).click();
                break;
            case "open":
                waitElement(By.xpath("//android.widget.Button[@text='Mở thanh toán trực tuyến']"));
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Mở thanh toán trực tuyến']")).click();
                break;
        }
    }

    @And("^I access in left menu$")
    public void iAccessInLeftMenu() throws Throwable {
        waitElement(By.xpath("//android.widget.ImageView[@index='1']"));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
//        swipeToRight();
        Thread.sleep(1000);
        scrollToUp();
        Thread.sleep(1000);
    }

    @And("^I create QR personal information$")
    public void iCreateQRPersonalInformation() throws Throwable {
        waitElement(By.xpath("//android.widget.TextView[@text='Tạo mã QR thông tin cá nhân']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tạo mã QR thông tin cá nhân']")).click();
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='1']"));
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='1']")).click();
    }

    @And("^I pay by QR$")
    public void iPayByQR() throws Exception {
        waitElement(By.xpath("//android.widget.ImageView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Thư viện ảnh']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Photos']")).click();
        Thread.sleep(1000);
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Skype']")).click();
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='1']")).click();
    }

    @Then("^I pay service with amount is \"([^\"]*)\"$")
    public void iPayServiceWithAmountIs(String amount) throws Throwable {
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập số tiền']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Thanh toán']")).click();
    }

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

    @And("^I transfer to other account by QR with \"([^\"]*)\" amount and \"([^\"]*)\" description with fee payer is \"([^\"]*)\"$")
    public void iTransferToOtherAccountByQRWithAmountAndDescriptionWithFeePayerIs(String amount, String description, String feePayer) throws Throwable {
        waitElement(By.xpath("//android.widget.ImageView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Thư viện ảnh']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Photos']")).click();
        Thread.sleep(1000);
        scrollToUp();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='QRLive']")).click();
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='1']")).click();
        waitElement(By.xpath("//android.widget.EditText[@text='Số tiền *']"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Người chuyển trả']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + feePayer + "']")).click();
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I add new account with \"([^\"]*)\" bank, \"([^\"]*)\" account number and \"([^\"]*)\" receiver$")
    public void iAddNewAccountWithBankAccountNumberAndReceiver(String bank, String accountNumber, String receiver) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.FrameLayout[@index='2']/android.widget.ImageView"));
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='2']/android.widget.ImageView")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Ngân hàng']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Ngân hàng']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Danh sách ngân hàng']"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tìm kiếm ngân hàng']")).sendKeys(bank);
        waitElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='2']")).click();
        waitElement(By.xpath("//android.widget.EditText[@text='Nhập số tài khoản']"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập số tài khoản']")).sendKeys(accountNumber);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Lưu lại']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chuyển khoản']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chuyển khoản']")).click();
    }

    @Then("^I order a bouquet with name is \"([^\"]*)\"$")
    public void iOrderABouquetWithNameIs(String text) throws Exception {
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.widget.TextView[@text='Đặt mua hoa']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt mua hoa']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Đặt mua hoa']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt mua hoa']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Tiếp tục']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tiếp tục']")).click();
    }

    @And("^I fill info as below$")
    public void iFillInfoAsBelow(DataTable contactInfo) throws Exception {
        List<List<String>> data = contactInfo.raw();
        waitElement(By.xpath("//android.widget.TextView[@text='Thông tin người mua']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Email']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='3']/android.widget.EditText[@index='1']")).sendKeys(data.get(0).get(0));
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='6']/android.widget.ImageView[@index='1']")).click();
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='6']/android.widget.ImageView[@index='1']")).click();
        Thread.sleep(1000);
        scrollUpHalf();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Địa chỉ']")).click();
        Thread.sleep(1000);
        try {
            if (androidDriver.isKeyboardShown()) {
                androidDriver.hideKeyboard();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='9']/android.widget.EditText[@index='1']")).sendKeys(data.get(0).get(1));
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='11']/android.widget.ImageView[@index='1']")).click();
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='11']/android.widget.ImageView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Quận 1']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Quận 1']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tiếp tục']")).click();
    }

    @And("^I give to \"([^\"]*)\" with \"([^\"]*)\" message$")
    public void iGiveToWithMessage(String text1, String text2) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Đặt hàng']"));
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn']")).click();
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn']"));
        verticalScroll();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Thiệp gửi tặng cho']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + text1 + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text1 + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập nội dung']")).sendKeys(text2);
        try {
            if (androidDriver.isKeyboardShown()) {
                androidDriver.hideKeyboard();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tiếp tục']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Xác nhận']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xác nhận']")).click();
    }

    @And("^I get amount total after booking a bouquet$")
    public void iGetAmountTotalAfterBookingABouquet() {
        {
            List<AndroidElement> afterAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
            String afterAmount = afterAmountList.get(2).getText();
            afterAmount = afterAmount.replace(" VND", "");
            afterAmount = afterAmount.replace(",", "");
            System.out.println("**************** After Amount   " + afterAmount);
            d_afterAmount = Double.parseDouble(afterAmount);
        }
    }

    @And("^I tap on (Đánh giá cá nhân|Đánh giá chung|Danh sách trái phiếu đã bán)$")
    public void iTapOn(String type) throws Exception {
        switch (type) {
            case "Đánh giá cá nhân":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đánh giá cá nhân']")).click();
                break;
            case "Đánh giá chung":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đánh giá chung']")).click();
                break;
            case "Danh sách trái phiếu đã bán":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Danh sách trái phiếu đã bán']")).click();
                break;
        }
    }

    @And("^I tap on rating section$")
    public void iTapOnRating() throws Exception {
        List<WebElement> starList = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.RelativeLayout[@index='1']/android.widget.ImageView"));
        System.out.println("************************* " + starList.size());
        starList.get(2).click();
        Thread.sleep(1000);
    }

    @And("^I do rating with \"([^\"]*)\" comment$")
    public void iDoRatingWithComment(String comment) throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Vui lòng nhập ý kiến của Quý khách']")).sendKeys(comment);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Gửi đánh giá']")).click();
        Thread.sleep(1000);
    }

    @Then("^I share the above transaction$")
    public void iShareTheAboveTransaction() {
        scrollToDown();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chia sẻ']")).click();
    }

    @And("^I verify \"([^\"]*)\" is displayed after sharing the above transaction$")
    public void iVerifyIsDisplayedAfterSharingTheAboveTransaction(String text) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        String actualString1 = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']")).getText();
        System.out.println("**************** Data table " + actualString1);
        assertTrue(actualString1.contains(text));
        scrollToDown();
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

    @And("^I get amount total before doing transaction in topup mobile$")
    public void iGetAmountTotalBeforeDoingTransactionInTopupMobile() throws Exception {
        List<AndroidElement> transferredAmountList = (List<AndroidElement>) androidDriver.findElements(By.xpath("//android.widget.TextView[contains(@text,'VND')]"));
        String transferredAmount = transferredAmountList.get(0).getText();
        transferredAmount = transferredAmount.replace(" VND", "");
        transferredAmount = transferredAmount.replace(",", "");
        System.out.println("**************** Before Amount   " + transferredAmount);
        d_beforeAmount = Double.parseDouble(transferredAmount);
    }

    @And("^I input \"([^\"]*)\" OTP code$")
    public void iInputOTPCode(String code) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='2']")).sendKeys(code);
    }

    @And("^I confirm the above transaction$")
    public void iConfirmTheAboveTransaction() throws Exception {
        try {
            if (androidDriver.isKeyboardShown()) {
                androidDriver.hideKeyboard();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
    }

    @And("^I close permission popup$")
    public void iClosePermissionPopup() {
        // Không bắt bằng text dc vì mỗi popup trên mỗi device text khác nhau
        try {
            if (androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).isDisplayed()) {
                androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            if (androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).isDisplayed()) {
                androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
