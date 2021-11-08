package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    public FilesPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div/a[@class='button new']")
    public WebElement plusBtn;

    @FindBy (xpath = "//div[@class='newFileMenu popovermenu bubble menu open menu-left']//ul//li//span[2]")
    public List<WebElement> plusOptions;


    /*@FindBy(css = "#file_upload_start")
    public WebElement uploadFile;*/

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFile;

    @FindBy (xpath = "//tbody//tr//span[@class='icon icon-more']")
    public List<WebElement> allAction_icons;

    @FindBy (xpath = "//div[@id='rightClickMenus']//span[2]")
    public List<WebElement> action_iconOptions;

    //tbody//tr[@data-file='HelloWorld']//span[@class='icon icon-more']
    //tbody//tr[@data-id='11741']//span[@class='icon icon-more']

    //div[@id='rightClickMenus']//span[2][.='Details']

    @FindBy (xpath = "//tfoot/tr[@class='summary']")
    public WebElement endOfTable;

    @FindBy (id = "trashbin")
    public WebElement deletedFilesBtn;

    @FindBy (xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckboxBtn;


    @FindBy (xpath = "//td[@class='selection']/input")
    public List <WebElement> eachCheckBox;

    @FindBy(xpath = "//td//a//span[@class='nametext']")
    public List<WebElement> allFiles;

    @FindBy(xpath = "//div/ul[@class='with-icon']/li[@data-id]")
    public List<WebElement> subModules;


    @FindBy(xpath = "//td[@class='filename']//span[@class='nametext']")
    public List<WebElement> filesInFavorites;

    @FindBy(xpath = "//tr//td/a//div[@class]/span[@class='icon icon-starred']")
    public List<WebElement> favoriteFiles;
    /**
     * new folder
     */

    @FindBy (css = "#view13-input-folder")
    public WebElement folderInput;

    @FindBy (xpath = "//form[@class='filenameform']/input[@type='submit']")
    public WebElement submitFolder;

    @FindBy(xpath = "//tbody/tr[@data-type='dir']")
    public List<WebElement> listOfFolders;



    /**
     * new comment
     */
    @FindBy(xpath = "//a[@id='commentsTabView']")
    public WebElement commentBtn;

    @FindBy(xpath = "//form/div[@class='message']")
    public WebElement commentField;

    @FindBy(xpath = "//form[@class='newCommentForm']/input")
    public WebElement submitComment;

    @FindBy(xpath = "//ul[@class='comments']/li/div[2]")
    public List<WebElement> allComments;

    /**
     *Settings configs
     */
    @FindBy(xpath = "//div/div/button[@class='settings-button']")
    public WebElement settingsBtn;

    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
    public List<WebElement> settingsOptions;

    @FindBy(xpath = "//div[@id='app-settings-content']//label[contains(.,'Show')]")
    public List<WebElement> clickSettingsOptions;

    @FindBy(css = "#quota")
    public WebElement storage;






















    Actions actions = new Actions (Driver.getDriver());

    public void gotoUpload(String function){
        plusBtn.click();
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//span[@class='displayname' and .='"+function+"']")))
                .pause(1000).click().perform();
    }

    public void performAction(String fileName, String action){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true)" ,  endOfTable  );

        Driver.getDriver().findElement(By.xpath("  //tbody//tr[contains(@data-file,'"+fileName+"')]//span[@class='icon icon-more']")).click();
        //tbody//tr[contains(@data-file,'"+fileName+"')]//span[@class='icon icon-more']

        BrowserUtil.waitFor(3);

        WebElement target = Driver.getDriver().findElement(By.xpath("//div[@id='rightClickMenus']//li//span[.='"+action+"']"));

     actions.moveToElement( target )
              .pause(2000).click().perform();
        jse.executeScript("arguments[0].click();", Driver.getDriver().findElement(By.xpath("//div[@id='rightClickMenus']//span[.='Details']")));

        BrowserUtil.waitFor(3);

    }

    public boolean ifItemInDeletedTable(String fileName){
       WebElement target =  Driver.getDriver().findElement(By.xpath("//tbody/tr[contains(@data-file, '"+fileName+"')]"));
       return target.isDisplayed();
    }



    Faker faker = new Faker();
    int random;
    public String fileName="";
    public void clickActionIcon(){
     random= faker.number().numberBetween(0, allAction_icons.size()-1);
     allAction_icons.get(random).click();
     fileName = allFiles.get(random).getText();
    }


 public void selectAction(String action){
     Driver.getDriver().findElement(By.xpath("//div[@class='fileActionsMenu popovermenu bubble open menu']/ul/li/a//span[contains(.,'"+action+"')]")).click();
 }

 public void clickSubModule(String module){
     Driver.getDriver().findElement(By.xpath("//div/ul[@class='with-icon']/li[@data-id]/a[contains(.,'"+module+"')]")).click();
 }

 public boolean fileInFavorites(){
        boolean result = false;
     for (WebElement eachFile : filesInFavorites) {
         if (eachFile.getText().contains(fileName)){
             result=true;
             break;
         }
     }

        return result;
 }

 public void clickPlus(String action){
     for (WebElement option : plusOptions) {
         if (option.getText().equals(action)){
            WebElement opt= Driver.getDriver().findElement(By.xpath("//div[@class='newFileMenu popovermenu bubble menu open menu-left']//ul//li//span[contains (., '"+action+"')]"));
            opt.click();
        }
     }
 }


 public void chooseAFolder(){
    listOfFolders.get(faker.number().numberBetween(0, listOfFolders.size()-1)).click();
 }

 public void clickLeftModule(String subModule){
        Driver.getDriver().findElement(By.xpath("//ul[@class='with-icon']/li[@data-id]/a[contains(., '"+subModule+"')]")).click();
 }

 public boolean clickAllSettingBoxes(){
        boolean result = true;
     for (WebElement option : settingsOptions) {
         if (!option.isEnabled()){
             result = false;
             break;
         }
     }
     return result;
 }







}
