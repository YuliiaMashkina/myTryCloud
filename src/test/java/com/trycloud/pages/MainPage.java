package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//ul[@id='appmenu']/li[@data-id]")
    public List <WebElement> modules; //10

    @FindBy (xpath = "//ul[@id='appmenu']/li[@data-id='files']")
    public WebElement filesModule;

    @FindBy (xpath = "//div/a[@class='header-menu__trigger']")
    public WebElement magnifierIcon;

    @FindBy (xpath = "//form/input[@type='search']")
    public WebElement searchField;

    @FindBy (xpath = "//span/h3/span")
    public List <WebElement> searchedFiles; //10
    //span/h3/span






    public void goToFiles(){
        actions.moveToElement(filesModule).perform();
        BrowserUtil.waitFor(3);
    }




    Actions actions = new Actions(Driver.getDriver());
    public void goToModule(String moduleName){
        actions.moveToElement(modules.get(1)).pause(1000)
                .moveToElement(Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//a[@aria-label='"+moduleName+"']")))
                .pause(1000).click().perform();
        BrowserUtil.waitFor(1);

    }




}
