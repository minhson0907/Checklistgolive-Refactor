package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class transferTypeSteps extends TestBase {

    @And("^I do transaction from \"([^\"]*)\" account with type is \"([^\"]*)\"$")
    public void iDoTransactionWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']"));
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + accountNumber + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
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
}
