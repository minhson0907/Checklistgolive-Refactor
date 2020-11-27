package android.base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestBase {

    @Before("@UninstallAndroid")
    public void setUpUninstallAndroid(){initUninstallAndroid();}

    @Before("@AndroidInput")
    public void setUpAndroidInput(){AndroidInput();}

    @Before("@AndroidApproval")
    public void setUpAndroidApproval(){AndroidApproval();}

    @After("@UninstallAndroid")
    public void tearDownUninstallAndroid(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        androidDriver.quit();
    }

    @After("@AndroidInput")
    public void tearDownAndroidInput(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        androidDriver.quit();
    }

    @After("@AndroidApproval")
    public void tearDownAndroidApproval(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        androidDriver.quit();
    }

}
