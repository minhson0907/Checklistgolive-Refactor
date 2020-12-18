package android.stepdef;

import android.base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class qrpaymentSteps extends TestBase {

    @And("^I transfer to other account by QR with \"([^\"]*)\" amount and \"([^\"]*)\" description with fee payer is \"([^\"]*)\"$")
    public void iTransferToOtherAccountByQRWithAmountAndDescriptionWithFeePayerIs(String amount, String description, String feePayer) throws Throwable {
        waitElement(By.xpath("//android.widget.ImageView[@index='2']"));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
        // SamSung Note8
        try {
            if (androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).isDisplayed()) {
                androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        // Nokia 7.2
        try {
            if (androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).isDisplayed()) {
                androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
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

    @Then("^I pay service with amount is \"([^\"]*)\"$")
    public void iPayServiceWithAmountIs(String amount) throws Throwable {
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nhập số tiền']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Thanh toán']")).click();
    }

    @And("^I create QR personal information$")
    public void iCreateQRPersonalInformation() throws Throwable {
        waitElement(By.xpath("//android.widget.TextView[@text='Tạo mã QR thông tin cá nhân']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tạo mã QR thông tin cá nhân']")).click();
//        // SamSung Note8
//        try {
//            if (androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).isDisplayed()) {
//                androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        // Nokia 7.2
//        try {
//            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).isDisplayed()) {
//                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
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

}
