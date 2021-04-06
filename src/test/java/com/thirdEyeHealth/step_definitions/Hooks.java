package com.thirdEyeHealth.step_definitions;

import com.thirdEyeHealth.utilies.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {

//    hook before = @BeforeMethod in TestNG
//    hook after = @AfterMethod in TestNG
//    it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//    that is way I use implicitWait here

    @Before
    public void setup(Scenario scenario) {  //
        System.out.println(scenario.getSourceTagNames());
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // hook after = @afterMethod in TestNG
    @After //from cucumber
    public void tearDown(Scenario scenario) {
        //close browser, capture screenshot of the error
        //this is a hook after
        //runs automatically after every test
        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }

     //   Driver.closeDriver();
     //   System.out.println(":::(^_^) End of test execution (*_*):::");
    }
}
