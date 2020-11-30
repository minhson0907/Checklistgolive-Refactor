package android.stepdef;

import android.base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class trainSteps extends TestBase {

    @Then("^I book an (one way|round trip) train from \"([^\"]*)\" to \"([^\"]*)\" with seat type is \"([^\"]*)\"$")
    public void iBookAnOneWayTrainFromToWithSeatTypeIs(String type, String fromTrain, String toTrain, String seatType) throws Exception {
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String s_day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        String e_day = s_day + 1;
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Ga khởi hành']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromTrain + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + toTrain + "']")).click();
        switch (type) {
            case "one way":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Một chiều']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Ngày đi']")).click();
                waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']"));
//                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']")).click();
                waitElement(By.xpath("//android.widget.Button[@text='Xác nhận']"));
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
                break;
            case "round trip":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Khứ hồi']")).click();
                break;
        }
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Hành khách']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout/android.widget.LinearLayout[@index='2']/android.widget.ImageView[@index='2']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xong']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Loại chỗ']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + seatType + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xong']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='TIẾP TỤC']")).click();
    }

    @And("^I choose departing and return time for (one way|round trip) train$")
    public void iChooseDepartingAndReturnTimeForOneWayTrain(String type) throws Exception {
        switch (type) {
            case "one way":
                waitElement(By.xpath("//"+xpath+"[@index='1']/android.widget.LinearLayout[@index='0']"));
                androidDriver.findElement(By.xpath("//"+xpath+"[@index='1']/android.widget.LinearLayout[@index='0']")).click();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='TIẾP TỤC']")).click();
                waitElement(By.xpath("//"+xpath+"[@index='0']/android.widget.LinearLayout[@index='0']"));
                androidDriver.findElement(By.xpath("//"+xpath+"[@index='0']/android.widget.LinearLayout[@index='0']")).click();
                waitElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='12']/android.widget.FrameLayout[@index='0']/android.widget.ImageView"));
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='12']/android.widget.FrameLayout[@index='0']/android.widget.ImageView")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Xong']")).click();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='TIẾP TỤC']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Chỗ đang đặt']"));
                androidDriver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
                break;
        }
    }

    @And("^I fill passenger info as below$")
    public void iFillPassengerInfoAsBelow(DataTable passengerInfo) throws Exception {
        List<List<String>> data = passengerInfo.raw();
        //This is to get the first data of the set (First Row + First Column)
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Họ và tên']")).sendKeys(data.get(0).get(0));
        //This is to get the first data of the set (First Row + Second Column)
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='5']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Số CMND/CCCD/Hộ chiếu/GPLX']")).sendKeys(data.get(0).get(1));

    }

    @And("^I fill contact info as below$")
    public void iFillContactInfoAsBelow(DataTable contactInfo) throws Exception {
        List<List<String>> data = contactInfo.raw();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Số CMND/CCCD/Hộ chiếu/GPLX']")).sendKeys(data.get(0).get(0));
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys(data.get(0).get(1));
    }

    @And("^I continue to book train$")
    public void iContinueToBookTrain() throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Thông báo']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Đồng ý']")).click();
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='THANH TOÁN']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Thông báo']"));
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Không']")).click();
        Thread.sleep(2000);
    }


}
