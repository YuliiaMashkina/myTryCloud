package com.trycloud.pages;


import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage {

   public TalkPage(){
      PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy(xpath = "//input[@placeholder='Search conversations or users']")
   public WebElement searchFiled;

   @FindBy(xpath = "(//ul[@class='conversations']//div//span)[1]")
   public WebElement firstUser;

   @FindBy (xpath = "//div[@role='textbox']")
   public WebElement messageField;

   @FindBy (xpath = "//button[@type='submit']")
   public WebElement submitMessage;

   @FindBy (xpath = "//div[@class='message__main__text']")
   public List<WebElement> allMessages;









}
