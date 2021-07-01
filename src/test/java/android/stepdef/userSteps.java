package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Base64;
import java.util.List;

public class userSteps extends TestBase {

    @Then("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginWithAnd(String user, String pass) throws Exception {
//        try {
//            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).isDisplayed()) {
//                // Tap on icon x in text box user name
//                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
//        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(1, 0, "userdata"));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
        byte[] decodeBytes = Base64.getDecoder().decode(DataHelper.getCellData(1, 5, "userdata").getBytes());
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đăng nhập']")).click();
    }

    @When("^As (input|approval|sms) user, I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void asKHDNILoginWithAnd(String type, String user, String pass) throws Exception {
//        try {
//            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).isDisplayed()) {
//                // Tap on icon x in text box user name
//                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
        switch (type) {
            case "input":
//                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
//                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(1, 2, "userdata"));
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
                byte[] decodeBytes1 = Base64.getDecoder().decode(DataHelper.getCellData(1, 6, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes1));
                break;
            case "approval":
//                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
//                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(1, 3, "userdata"));
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
                byte[] decodeBytes2 = Base64.getDecoder().decode(DataHelper.getCellData(1, 7, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes2));
                break;
            default:
//                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).clear();
//                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Tài khoản']")).sendKeys(DataHelper.getCellData(2, 0, "userdata"));
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).clear();
                byte[] decodeBytes3 = Base64.getDecoder().decode(DataHelper.getCellData(2, 5, "userdata").getBytes());
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mật khẩu']")).sendKeys(new String(decodeBytes3));
                break;

        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đăng nhập']")).click();
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

}
