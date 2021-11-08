package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory4 {

    FilesPage filesPage = new FilesPage();

    @When("user Click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        filesPage.clickActionIcon();
        BrowserUtil.waitFor(2);

    }

    @And("Choose {string} option")
    public void chooseOption(String iconOption) {
        filesPage.selectAction(iconOption);
        BrowserUtil.waitFor(2);
    }


    @And("Click {string} sub-module on the lest side")
    public void clickSubModuleOnTheLestSide(String subModule) {
        filesPage.clickSubModule(subModule);
        BrowserUtil.waitFor(2);
    }


    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        //System.out.println("filesPage.fileName = " + filesPage.fileName);
       Assert.assertTrue(BrowserUtil.getAllText(filesPage.filesInFavorites).contains(filesPage.fileName));
    }



}
