package android.stepdef;

import android.base.TestBase;
import android.utils.DataHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

public class paymentTypeSteps extends TestBase {

    @And("^I do transaction with type is \"([^\"]*)\" in Home page 1$")
    public void iDoTransactionWithTypeIsInHomePage1(String type) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
    }

    @And("^I do transaction with type is \"([^\"]*)\" in Home page 2$")
    public void iDoTransactionWithTypeIsInHomePage2(String type) throws Exception {
//        Thread.sleep(3000);
        waitElement(By.xpath("//android.widget.TextView[@text='Tài khoản']"));
        swipeToLeft();
        waitElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
    }

    @Then("^I pay \"([^\"]*)\" bill in \"([^\"]*)\" service$")
    public void iPayBillInService(String type1, String type2) throws Exception {
        if (type2.equals("Thanh toán khoản vay")) {
            waitElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']")).click();
        } else if (type2.equals("Topup cho đại lý VietjetAir")) {
            waitElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']")).click();
        } else {
            waitElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type2 + "']")).click();
            waitElement(By.xpath("//android.widget.TextView[@text='" + type1 + "']"));
            androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type1 + "']")).click();
        }
    }

    @And("^I do paying bill from \"([^\"]*)\" account to (FECredit|HD SAIGON|HomeCredit) provider, \"([^\"]*)\" contract number and \"([^\"]*)\" amount with description is \"([^\"]*)\"$")
    public void iDoPayingBillFromAccountToFECreditProviderContractNumberAndAmountWithDescriptionIs(String fromAccount, String type, String contractNumber, String amount, String description) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Chọn nhà cung cấp']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số hợp đồng *']")).sendKeys(contractNumber);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Số tiền *']")).sendKeys(amount);
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Ghi chú']")).sendKeys(description);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do paying an electronic bill from \"([^\"]*)\" account with customer ID is \"([^\"]*)\"$")
    public void iDoPayingAnElectronicBillFromAccountWithCustomerCodeIs(String fromAccount, String customerCode) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã khách hàng *']")).sendKeys(customerCode);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to \"([^\"]*)\" provider with code ID is \"([^\"]*)\"$")
    public void iDoPayingAnWaterBillFromAccountToProviderWithCodeIDIs(String fromAccount, String provider, String customerID) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn nhà cung cấp']"));
        scrollToUp();
        waitElement(By.xpath("//android.widget.TextView[@text='" + provider + "']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + provider + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã khách hàng *']")).sendKeys(customerID);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I do paying bill from \"([^\"]*)\" account to \"([^\"]*)\" provider with customer ID is \"([^\"]*)\"$")
    public void iDoPayingAnWaterBillFromAccountToProviderWithCustomerIDIs(String fromAccount, String provider, String customerID) throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView")).click();
        Thread.sleep(1000);
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + fromAccount + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + DataHelper.getCellData(1, 1, "userdata") + "']")).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")).click();
        waitElement(By.xpath("//android.widget.TextView[@text='Chọn nhà cung cấp']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + provider + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Mã khách hàng *']")).sendKeys(customerID);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

    @And("^I topup \"([^\"]*)\" into \"([^\"]*)\" phone number$")
    public void iTopup(String card, String phoneNumber) throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).clear();
        androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys(phoneNumber);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='" + card + "']")).click();
        androidDriver.findElement(By.xpath("//android.widget.EditText[@text='Ghi chú']")).sendKeys("i topup by myself");
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Tiếp tục']")).click();
    }

}
