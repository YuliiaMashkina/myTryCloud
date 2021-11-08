package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {

    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "new-contact-button")
    public WebElement newContactBtn;

    @FindBy (id = "contact-fullname")
    public WebElement full_name;

    @FindBy (id = "contact-title")
    public WebElement title;

    @FindBy (xpath = "//input[@inputmode='email']")
    public WebElement email;

    @FindBy (xpath = "//input[@inputmode='tel']")
    public WebElement phone;

    @FindBy (xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactsList;

    @FindBy (xpath = "//span[@title='All contacts']")
    public WebElement allContactsBtn;





    Faker faker = new Faker();
    public void fillTheForm(){
        full_name.sendKeys(faker.name().name());
        title.sendKeys(faker.name().title());
        email.sendKeys(faker.internet().emailAddress());
        phone.sendKeys(faker.phoneNumber().cellPhone());

    }








}
