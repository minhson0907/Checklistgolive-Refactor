package android.stepdef;

import android.base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class uiSteps extends TestBase {

    @And("^I tap on \"([^\"]*)\"$")
    public void iTapOn(String text) throws Exception {
        waitElement(By.xpath("//android.widget.TextView[@text='"+text+"']"));
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).click();
    }

    @And("^I tap on (Tài khoản|Chuyển khoản) at position is \"([^\"]*)\" in left menu$")
    public void iTapOnInLeftMenu(String type, String number) throws Exception {
        switch (type){
            default:
                waitElement(By.xpath("//android.widget.LinearLayout[@index='"+number+"']"));
                androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='"+number+"']")).click();
                break;
        }
    }

    @And("^I back to left menu$")
    public void iBackToLeftMenu() throws Exception {
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='0']"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='0']")).click();
    }


    @And("^I back to left menu from stock market$")
    public void iBackToLeftMenuFromStockMarket() throws Exception {
        waitElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']"));
        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")).click();
    }

    @Then("^I back to left menu from booking$")
    public void iBackToLeftMenuFromBooking() throws Exception{
        waitElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.ImageView"));
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.ImageView")).click();
    }

    @Then("^I tap on \"([^\"]*)\" button on popup$")
    public void iTapOnButtonOnPopup(String text) throws Exception {
        try{
            if (androidDriver.findElement(By.xpath("//android.widget.Button[@text='"+text+"']")).isDisplayed()) {
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='"+text+"']")).click();
            }
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    @And("^I tap on icon star with level is \"([^\"]*)\"$")
    public void iTapOnIconStarWithLevelIs(int level) throws Exception {
        Thread.sleep(1000);
        List<WebElement> starList = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.ImageView[@index='2']"));
        System.out.println("====================== " + starList.size());
        starList.get(level - 1).click();
//        androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='2']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='"+level+"']/android.widget.ImageView[@index='0']")).click();
        Thread.sleep(1000);
    }

    @And("^I send a rating request to HDBank$")
    public void iSendARatingRequestToHDBank() throws Exception {
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Gửi đánh giá']")).click();
        Thread.sleep(1000);
    }

    @And("^I close notice popup$")
    public void iCloseNoticePopup() {
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='ĐÓNG']")).click();
    }

    @Then("^I logout app from left menu$")
    public void iLogoutAppFromLeftMenu() {
        // Tap on icon logout
        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.ImageView")).click();
        // Tap on icon x in text box user name
        List<WebElement> a = (List<WebElement>) androidDriver.findElements(By.xpath("//android.widget.LinearLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='2']"));
        a.get(0).click();
    }

    @And("^I go to left menu$")
    public void iGoToLeftMenu() throws  Exception {
        waitElement(By.xpath("//android.widget.ImageView[@index='1']"));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
    }


}
