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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;

import static org.testng.Assert.*;

public class mbkSteps extends TestBase {


    @Given("^I open app$")
    public void iOpenApp() throws Exception {
    }

    @Then("^I go to Home$")
    public void iGoToHome() throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Trang chủ']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Trang chủ']")).click();
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

    @And("^I scroll up page$")
    public void iScrollUpPage() throws Exception {
        Thread.sleep(2000);
        scrollToUp();
    }

    @Then("^I pay \"([^\"]*)\" service$")
    public void iPayService(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
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


    @And("^I wanna continue doing the above transaction$")
    public void iWannaContinueDoingTheAboveTransaction() {
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tiếp tục']")).click();
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

    @And("^I lock card$")
    public void iLockCard() throws Throwable {
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Khóa thẻ']")).click();
        waitElement(By.xpath("//android.widget.Button[@text='Tiếp tục']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
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
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
