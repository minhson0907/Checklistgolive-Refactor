package android.stepdef;

import android.base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class hotelSteps extends TestBase {

    @And("^I looking for the hotel in \"([^\"]*)\"$")
    public void iLookingForTheHotelAroundMe(String location) throws Exception {
        // Nokia N7.2 popup permission when booking hotel
        try {
            if (androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='0']")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        // SamSung Note8 popup permission when booking hotel
        try {
            if (androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).isDisplayed()) {
                androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        waitElement(By.xpath("//android.widget.TextView[@text='Tên khách sạn hoặc điểm đến']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tên khách sạn hoặc điểm đến']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn điểm đến']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + location + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Tìm kiếm']")).click();
    }

    @Then("^I book a hotel with email info is \"([^\"]*)\"$")
    public void iBookAPopularHotelNearMe(String email) throws Exception {
        waitElement(By.xpath("//"+xpath+"[@index='0']/android.widget.LinearLayout[@index='0']"));
//        androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.LinearLayout[@index='0']")).click();
        androidDriver.findElement(By.xpath("//"+xpath+"[@index='0']/android.widget.LinearLayout[@index='0']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Trả phòng: trước 12:00 - Nhận phòng: sau 14:00']"));
        scrollToUp();
        waitElement(By.xpath("//android.widget.TextView[@text='ĐẶT PHÒNG']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='ĐẶT PHÒNG']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys(email);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='THANH TOÁN']")).click();
    }

    @Then("^I continue to book (hotel|the train|flower)$")
    public void iContinueToBookHotel(String type) throws Exception {
        switch (type) {
            default:
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
        }
    }
}
