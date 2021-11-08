package com.trycloud.pages;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id = "user")
    public WebElement usernameBox;

    @FindBy (id ="password")
    public WebElement passwordBox;

    @FindBy (id ="submit-form")
    public WebElement loginBtn;

    @FindBy (xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMsg;



    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    public void login(String username, String password){
        this.usernameBox.sendKeys(username);
        this.passwordBox.sendKeys(password);
        //this.loginBtn.click();
    }


}