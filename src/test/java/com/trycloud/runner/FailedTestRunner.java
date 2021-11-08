package com.trycloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//This test Runner has only one purpose => no run the failed scenarios that are stored inside the rerun.txt;
//It DOES NOthing ELSE
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/trycloud/step_definitions",
        features = "@target/rerun.txt"
)

public class FailedTestRunner {


}
