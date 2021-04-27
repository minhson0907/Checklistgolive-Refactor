package android.stepdef;

import android.base.TestBase;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class cardonlineSteps extends TestBase {

    @Then("^I (close|open) the online payment$")
    public void iCloseTheOnlinePayment(String type) throws Throwable {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='1']//android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.ImageView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']//android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.ImageView")).click();
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
}
