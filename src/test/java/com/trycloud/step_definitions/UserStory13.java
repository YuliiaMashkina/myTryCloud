package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UserStory13 {

    ContactsPage contactsPage = new ContactsPage();

    @Then("Verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        System.out.println("contactsPage.contactsList.size() = " + contactsPage.contactsList.size());
        Assert.assertTrue(BrowserUtil.getAllText(contactsPage.contactsList).size()>=2);
    }

}
