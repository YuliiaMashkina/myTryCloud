package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    /*    Create a Singleton class called Driver
1. create private no arg constructor
2. create private static field with name obj
     Data type of variable should be WebDriver
3. create public static method
     name : getDriver()
     return type :WebDriver
     param : none
check if obj is null or not
         if yes - create ChromeDriver with all set up
        if no  -- return same obj   */

    private static WebDriver obj;

    private Driver(){
    }


    public static WebDriver getDriver() {
        //read the browser type you want to launch from properties file;
        String browserName = ConfigReader.read("browser");

        //according to browser type set up driver correctly
        if (obj == null) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                //other browsers omitted
                default:
                    obj = null;
                    System.out.println("UNKNOWN BROWSER NAME " + browserName);
                    break;
            }
            return obj;
        } else {
            // System.out.println("we already have an object");
            return obj;
        }


    }

    /** Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quitted driver */
    public static void closeBrowser(){
        // check if we have WebDriver instance or not
        // basically checking if obj is null or not
        // if not null ==> quit the browser
        // make it null , because once quit it can not be used
        if (obj!=null){
            obj.quit();
            obj=null;//so when we ask agin for it , it gives us not quited fresh driver;
        }
    }


}
