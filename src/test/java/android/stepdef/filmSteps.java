package android.stepdef;

import android.base.TestBase;
import cucumber.api.java.en.And;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class filmSteps extends TestBase {

    @And("^I buy a film ticket at \"([^\"]*)\" cinema$")
    public void iBuyAFilmTicket(String cinema) throws Exception {
//        try {
//            if (androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).isDisplayed()) {
//                androidDriver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
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
}
