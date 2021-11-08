package com.trycloud.runner;

//This class has only one purpose=>how and what feature you want to run
//Where are the step definitions
//do we want to generate missing step definitions
//do we want to get json, htlm report;
// do we want to filter the test run according to certain tags

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //use cucumber engine to run this whole class
@CucumberOptions(features = "classpath:features",//"src/test/resources/features"
                  glue = "com/trycloud/step_definitions" ,
                  publish = true, //it will give you public link of your local html report=>to publish your report
                  plugin = { "pretty", "html:target/cucumber_report.html",
                          "rerun:target/rerun.txt"//store the failed scenarios into rerun.txt
                          ,"me.jvt.cucumber.report.PrettyReports:target"}
                  ,dryRun = true
                  ,tags = "@ui" //"@smoke or @salad"

                                )  //to tell where the step definitions are(where is feature file)
                // will run the test without failing or missing step, so you can copy all the
                    // missing step if there is any
public class TestRunner {

}
//I think it was Command+Shift+F and type the tag name to find all tags.