package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class khdnSteps extends TestBase {

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

    @And("^As KHDN, I do transaction from \"([^\"]*)\" account with type is \"([^\"]*)\"$")
    public void asKHDNiDoTransactionWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 4, "userdata") + "']"));
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 4, "userdata") + "']")).click();
    }

    @And("^As KHDN, I do transaction with type is \"([^\"]*)\" in Home page 1$")
    public void asKHDNIDoTransactionWithTypeIsInHomePage1(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[contains(@text,'" + type + "')]"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + type + "')]")).click();
    }

    @And("^As KHDN, I do paying bill from \"([^\"]*)\" account for \"([^\"]*)\" agent code with amount is \"([^\"]*)\"$")
    public void asKHDNIDoPayingBillFromAccountForAgentCodeWithAmountIs(String fromAccount, String agentCode, String amount) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 4, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã đại lý/Đoàn']")).sendKeys(agentCode);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }
}
