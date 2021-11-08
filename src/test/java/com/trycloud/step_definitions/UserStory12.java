package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory12 {

    ContactsPage contactsPage = new ContactsPage();
    Faker faker = new Faker();
   String savedName = faker.name().name();

    @When("Click {string} button")
    public void click_button(String button) {
        contactsPage.newContactBtn.click();
    }
    @When("Fill out the contact info like : Title, Phone, email, address , etc")
    public void fill_out_the_contact_info_like_title_phone_email_address_etc() {
        contactsPage.full_name.click();
        contactsPage.full_name.sendKeys(savedName);
        contactsPage.title.click();
        contactsPage.title.sendKeys(faker.name().title());
        contactsPage.email.sendKeys(faker.internet().emailAddress());
        contactsPage.phone.sendKeys(faker.phoneNumber().cellPhone());



    }
    @Then("Verify the contact name is added to the contact list")
    public void verify_the_contact_name_is_added_to_the_contact_list() {
        contactsPage.allContactsBtn.click();
        BrowserUtil.waitFor(2);
        //System.out.println(BrowserUtil.getAllText(contactsPage.contactsList));
        //System.out.println(savedName);
        Assert.assertTrue(BrowserUtil.getAllText(contactsPage.contactsList).contains(savedName));



    }

}
