package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class airplaneSteps extends TestBase {

    @Then("^I book an (one way|round trip) (domestic|international) flight from \"([^\"]*)\" to \"([^\"]*)\" on (Vietnam Airlines|Pacific Airlines|VietJet Air|Bamboo Airways|all) airline with method is (Pay later|Pay now)$")
    public void iBookAnOneWayDomesticFlightFromTo(String type, String flightType, String fromFlight, String toFlight, String airline, String method) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Nội địa']"));
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String s_day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
//        double d_day = Double.parseDouble(s_day);
        int d_day = Integer.parseInt(s_day);
        int d_s_day_later = d_day + 2;
        int d_e_day = d_day + 1;
        int d_e_day_later = d_e_day + 2;
        String e_day = String.valueOf(d_e_day);
        String s_day_later = String.valueOf(d_s_day_later);
        String e_day_later = String.valueOf(d_e_day_later);
        switch (type) {
            case "one way":
                if (flightType.equals("domestic")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Nội địa']")).click();
                } else if (flightType.equals("international")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Quốc tế']")).click();
                }
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Một chiều']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm khởi hành']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm đến']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn ngày']")).click();
//                waitElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']"));
                waitElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']"));
                switch (method) {
//                    case "Pay later":
//                        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day_later + "']")).click();
//                        break;
//                    case "Pay now":
//                        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']")).click();
//                        break;
                    default:
                        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='2']/android.view.ViewGroup[@index='2']/android.widget.FrameLayout[@index='3']")).click();
                        break;
                }
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
                switch (airline) {
                    case "VietJet Air":
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Vietnam Airlines']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Pacific Airlines']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Bamboo Airways']")).click();
                        break;
                    case "Vietnam Airlines":
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='VietJet Air']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Pacific Airlines']")).click();
                        androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Bamboo Airways']")).click();
                        break;
                    case "all":
                        break;
                }
                Thread.sleep(1000);
                scrollToUp();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tìm chuyến bay']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Danh sách chuyến bay']"));
                androidDriver.findElement(By.xpath("//"+xpath+"/android.widget.LinearLayout[@index='0']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Đặt vé']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé']")).click();
                break;
            case "round trip":
                if (flightType.equals("domestic")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Nội địa']")).click();
                } else if (flightType.equals("international")) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé máy bay Quốc tế']")).click();
                }
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Khứ hồi']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm khởi hành']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromFlight + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn điểm đến']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + toFlight + "']")).click();
                // Choose start & end day
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView]")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Chọn ngày bay']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + s_day + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + e_day + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Xác nhận']")).click();
                Thread.sleep(1000);
                scrollToUp();
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tìm chuyến bay']")).click();
                waitElement(By.xpath("//android.widget.TextView[@text='Danh sách chuyến bay']"));
                androidDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='0']")).click();
                Thread.sleep(2000);
                waitElement(By.xpath("//android.widget.TextView[@text='Đặt vé']"));
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Đặt vé']")).click();
                break;
        }
    }

    @And("^I fill \"([^\"]*)\" full name, \"([^\"]*)\" gender, \"([^\"]*)\" email, \"([^\"]*)\" phone number with \"([^\"]*)\" description$")
    public void iFillFullNameWithGenderEmailPhoneNumberAndDescription(String name, String gender, String email, String phoneNumber, String description) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Thông tin đặt vé']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.EditText")).clear();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.EditText")).sendKeys(name);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + gender + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='4']")).clear();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='4']")).sendKeys(email);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='6']")).clear();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='6']")).sendKeys(phoneNumber);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Nội dung (tùy chọn)']")).sendKeys(description);
    }

    @And("^I (check|uncheck) on use for Passenger information$")
    public void iCheckOnUseForPassengerInformation(String type) throws Exception {
        switch (type) {
            case "check":
                androidDriver.findElement(By.xpath("//android.widget.CheckBox[@text='Dùng làm thông tin hành khách bay']")).click();
                break;
            case "uncheck":
                break;
        }
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I confirm the above flight with method is (Pay later|Pay now)$")
    public void iConfirmTheAboveFlight(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Xác nhận chuyến bay']"));
        androidDriver.findElement(By.xpath("//android.widget.CheckBox")).click();
        switch (type) {
            case "Pay later":
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Thanh toán sau']")).click();
                break;
            case "Pay now":
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='Thanh toán']")).click();
                break;
        }
        Thread.sleep(10000);
    }

    @And("^I continue to book the above flight$")
    public void iContinueToBookTheAboveFlight() throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @Then("^I choose \"([^\"]*)\" departure's baggage and \"([^\"]*)\" return's baggage$")
    public void iChooseDepartureSBaggageAndReturnSBaggage(String debaggage, String rebaggage) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn hành lý']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Hành lý chiều đi']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + debaggage + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Hành lý chiều về']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + rebaggage + "']")).click();
    }

    @And("^I get reservation code$")
    public void iGetReservationCode() throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='1']"));
        List<WebElement> valueList = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='1']"));
        reservationCode = valueList.get(0).getText();
        System.out.println("************* Reservation Code is " + reservationCode);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Hoàn tất']")).click();
    }

    @Then("^I go to Home after booking airline ticket$")
    public void iGoToHomeAfterBookingAirlineTicket() throws Exception {
        Thread.sleep(5000);
        waitElement(By.xpath("//android.widget.ImageView"));
        List<WebElement> valueList = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.ImageView"));
        System.out.println("************* list is " + valueList.size());
        valueList.get(0).click();
        Thread.sleep(1000);
        swipeToRight();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to (VietJet - Thanh toán cước vé máy bay nội địa|Thanh toán vé đặt qua VNPAY) provider with the above reservation code$")
    public void iDoPayingBillFromAccountToProviderWithReservationCodeIs(String fromAccount, String type) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).click();
        Thread.sleep(1000);
        switch (type) {
            case "VietJet - Thanh toán cước vé máy bay nội địa":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã đặt chỗ *']")).sendKeys(reservationCode);
                break;
            case "Thanh toán vé đặt qua VNPAY":
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
                androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã thanh toán *']")).sendKeys(reservationCode);
                break;
        }
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }
}
