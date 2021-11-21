package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class UserStory5 {

    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    int randomN = faker.number().numberBetween(0, filesPage.favoriteFiles.size()-1);
    String fileName = filesPage.favoriteFiles.get(randomN).getText();

    @When("user Click action-icon from any favorite file on the page")
    public void user_click_action_icon_from_any_favorite_file_on_the_page() {
        if (filesPage.favoriteFiles.size()==0){
            filesPage.clickActionIcon();
            filesPage.selectAction("Add to favorites");
        }
        filesPage.clickActionIcon();

        BrowserUtil.waitFor(3);
    }
    @Then("Verify that the file is removed from {string} sub-module’s table.")
    public void verify_that_the_file_is_removed_from_sub_module_s_table(String module) {
        Assert.assertFalse(BrowserUtil.getAllText(filesPage.filesInFavorites).contains(fileName));

    }


    @When("Click the “+” icon on top")
    public void click_the_icon_on_top() {
        BrowserUtil.waitFor(4);
      filesPage.plusBtn.click();
    }

    @Then("Click an {string}")
    public void click(String plusOption) {
        //filesPage.clickUpload(plusOption);
        BrowserUtil.waitFor(2);
        //filesPage.uploadFile.sendKeys("/Users/yuliiamashkina/Desktop/myTryCloud/src/test/resources/files/Screen_Shot_2021-11-01_at_11.47.32.png");
        String projectDir = System.getProperty("user.dir");
        // String path = "/Users/yuliiamashkina/Desktop/myTryCloud/src/test/resources/files/Screen_Shot_2021-11-01_at_11.47.32.png"
        String file = "src/test/resources/files/Screen_Shot_2021-11-01_at_11.47.32.png";
        filesPage.uploadFile.sendKeys(projectDir+"/"+file);
        BrowserUtil.waitFor(3);
    }
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        BrowserUtil.waitFor(2);
        System.out.println("BrowserUtil.getAllText(filesPage.allFiles) = " + BrowserUtil.getAllText(filesPage.allFiles));
        //Assert.assertTrue(BrowserUtil.getAllText(filesPage.allFiles).contains("Screen_Shot_2021"));
        Assert.assertTrue(BrowserUtil.listContainsElement(BrowserUtil.getAllText(filesPage.allFiles),"Screen_Shot_2021"));
    }


}
