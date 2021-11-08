package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UserStory6 {

    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    String name = faker.name().title();

    @Then("Click {string}")
    public void click(String action) {
        filesPage.clickPlus(action);

    }
    @Then("Write a folder name")
    public void write_a_folder_name() {
       filesPage.folderInput.sendKeys(name);
    }
    @Then("Click submit icon")
    public void click_submit_icon() {
       filesPage.submitFolder.click();
    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtil.waitFor(2);
        //System.out.println("BrowserUtil.getAllText(filesPage.allFiles) = " + BrowserUtil.getAllText(filesPage.allFiles));
         Assert.assertTrue(BrowserUtil.listContainsElement(BrowserUtil.getAllText(filesPage.allFiles),name));
    }

    @Then("Choose a folder from the page")
    public void chooseAFolderFromThePage() {
       filesPage.chooseAFolder();

    }
}
