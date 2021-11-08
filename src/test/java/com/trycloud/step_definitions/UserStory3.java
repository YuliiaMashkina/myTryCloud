package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.MainPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class UserStory3 {

    MainPage page = new MainPage();
    FilesPage filesPage = new FilesPage();
    @When("user click the {string} module")
    public void user_click_the_module(String moduleName) {
        page.goToModule(moduleName);

    }
    @Then("verify the page tile is {string}")
    public void verify_the_page_tile_is(String string) {
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }



    @When("user click the top left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.selectAllCheckboxBtn.click();

    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        BrowserUtil.waitFor(2);
        Assert.assertTrue(BrowserUtil.isAllSelected(filesPage.eachCheckBox));
    }
}
