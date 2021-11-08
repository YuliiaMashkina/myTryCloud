package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.MainPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory14 {

    MainPage mainPage = new MainPage();
    FilesPage filesPage = new FilesPage();
    ContactsPage contactsPage = new ContactsPage();
    Faker faker = new Faker();
    int num ;
    String searchedFile = "";

    List<String> files = new ArrayList<>();

    @When("Click magnifier icon on the right top")
    public void click_magnifier_icon_on_the_right_top() {


        mainPage.goToModule("Files");
        BrowserUtil.waitFor(2);
        //System.out.println("BrowserUtil.getAllText(filesPage.allFiles) = " + BrowserUtil.getAllText(filesPage.allFiles));
        files.addAll(BrowserUtil.getAllText(filesPage.allFiles));
        mainPage.goToModule("Contacts");
        BrowserUtil.waitFor(2);
        //System.out.println("BrowserUtil.getAllText(contactsPage.contactsList) = " + BrowserUtil.getAllText(contactsPage.contactsList));
        files.addAll(BrowserUtil.getAllText(contactsPage.contactsList));
        //System.out.println("files = " + files);
        mainPage.magnifierIcon.click();
    }

    @When("Search any existing file or folder or user name")
    public void search_any_existing_file_folder_user_name() {
        num = faker.number().numberBetween(1, files.size()-1);
        //System.out.println("files.get(num) = " + files.get(num));
        searchedFile =  files.get(num);
        mainPage.searchField.sendKeys(files.get(num));
        BrowserUtil.waitFor(2);

    }
    @Then("Verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {
        //System.out.println("searchedFile = " + searchedFile);

        Assert.assertTrue(BrowserUtil.getAllText(mainPage.searchedFiles).contains(searchedFile));
    }

}
