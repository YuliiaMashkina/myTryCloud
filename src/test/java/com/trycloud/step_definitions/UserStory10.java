package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory10 {

    FilesPage filesPage =new FilesPage();
    @When("Click {string} button on the left bottom corner")
    public void click_button_on_the_left_bottom_corner(String string) {
        filesPage.settingsBtn.click();
    }

    @Then("Verify user can click any buttons.")
    public void verify_user_can_click_any_buttons() {
        for (int i = 0; i < filesPage.settingsOptions.size(); i++) {
            BrowserUtil.waitFor(1);
            boolean beforeClick = filesPage.settingsOptions.get(i).isSelected();
            filesPage.clickSettingsOptions.get(i).click();
            BrowserUtil.waitFor(2);
            boolean afterClick = filesPage.settingsOptions.get(i).isSelected();
            BrowserUtil.waitFor(2);
            Assert.assertTrue(beforeClick!=afterClick);
           // result=(beforeClick!=afterClick);
        }

    }


    int storageBefore;
    @When("Check the current storage usage")
    public void check_the_current_storage_usage() {
        String storageInfo = filesPage.storage.getText();
        storageBefore = Integer.parseInt(storageInfo.substring(0, storageInfo.indexOf(" ")));
        System.out.println("storage before = " + storageBefore);
    }
    @Then("Refresh the page")
    public void refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }

    int storageAfter;
    @Then("Verify the storage usage is increased")
    public void verify_the_storage_usage_is_increased() {
        String storageInfo = filesPage.storage.getText();
        storageAfter = Integer.parseInt(storageInfo.substring(0, storageInfo.indexOf(" ")));
        System.out.println("storage before = " + storageAfter);
        Assert.assertTrue(storageBefore<storageAfter);

    }

}
