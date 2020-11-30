package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class transferSteps extends TestBase {

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
        waitElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='2']"));
        androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='2']")).click();
        waitElement(By.xpath("//android.widget.EditText[@text='Nhập số tài khoản']"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập số tài khoản']")).sendKeys(accountNumber);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Lưu lại']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chuyển khoản']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chuyển khoản']")).click();
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


    @Then("^I transfer to \"([^\"]*)\" card number, \"([^\"]*)\" amount and \"([^\"]*)\" description$")
    public void iTransferFromToCardNumberAmountAndDescription(String cardNumber, String amount, String description) throws Exception {
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+ fromAccount +"']")).click();
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+fromAccount+"']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số thẻ *']")).sendKeys(cardNumber);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.id("com.vnpay.hdbank:id/content")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I update \"([^\"]*)\" account with type is (Chuyển khoản thông thường|Chuyển khoản tự động)$")
    public void iUpdateAccountWithTypeIs(String accountNumber, String type) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout[@index='2']/android.widget.ImageView[@index='1']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập tên hoặc số tài khoản tìm kiếm']")).sendKeys(accountNumber);
        waitElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='2']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chỉnh sửa']"));
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


}
