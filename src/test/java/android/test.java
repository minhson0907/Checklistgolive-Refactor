package android;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {"src/test/java/android/feature"},
        glue = "android",
        tags = {"@KHCN-06,@KHCN-07,@KHCN-08,@KHCN-09,@KHCN-10,@KHCN-11,@KHCN-12"},
        plugin = {
                "html:target/result",
                "pretty",
                "json:target/test-classes/reports/result.json"
        },
        monochrome = true
)

public class test extends  AbstractTestNGCucumberTests{
}
