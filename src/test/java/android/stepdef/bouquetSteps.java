package android.stepdef;

import android.base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import java.util.List;

public class bouquetSteps extends TestBase {

    @Then("^I order a bouquet with name is \"([^\"]*)\"$")
    public void iOrderABouquetWithNameIs(String text) throws Exception {
//        try {
//            if (androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).isDisplayed()) {
//                androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
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



}
