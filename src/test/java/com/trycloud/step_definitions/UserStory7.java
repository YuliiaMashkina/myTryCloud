package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.MainPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStory7 {

    MainPage mainPage = new MainPage();
    FilesPage filesPage = new FilesPage();




    @When("Choose “delete files” option")
    public void choose_delete_files_option() {
        filesPage.performAction("java-collection-hierarchy", "Details");

    }

    @And("Click {string} on the left bottom corner")
    public void clickOnTheLeftBottomCorner(String module) {
        filesPage.clickSubModule(module);
        BrowserUtil.waitFor(2);
    }

    @Then("Verify the deleted file is displayed no the page.")
    public void verify_the_deleted_file_is_displayed_no_the_page() {
        //filesPage.ifItemInDeletedTable("java-collection-hierarchy");
        filesPage.ifItemInDeletedTable(filesPage.fileName);
    }


}
