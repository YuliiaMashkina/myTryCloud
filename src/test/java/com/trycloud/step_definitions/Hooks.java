package com.trycloud.step_definitions;

import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    //we can set up hook class that contains methods that run @Before each scenario
    //AND @After each scenario
    // or even when we learn tags
    // we can run certain code before and after each scenario that tagged with certain tag

    @Before("@ui")
    public void setUpDriver(){
       // System.out.println("this is @Before inside hook class");
        //set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }
    @After("@ui")
    public void tearDown(Scenario scenario){
        //System.out.println("this is @After inside hook class");
        if (scenario.isFailed()){//checking is scenario is failed or no
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver(); //Driver.getDriver()=>is getting WebDriver instance
            byte [] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "nameOfFailure");
        }
        Driver.closeBrowser();
    }

}
