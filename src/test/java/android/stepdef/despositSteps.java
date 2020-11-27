package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class despositSteps extends TestBase {

    @Then("^I choose \"([^\"]*)\" to open online saving account$")
    public void iChooseToOpenOnlineSavingAccount(String name) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + name + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout/android.widget.ImageView")).click();
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
}
