package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Locale;

public class UserStory9 {

    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    String comment="";

    @Then("Write a comment inside to the input box")
    public void write_a_comment_inside_to_the_input_box() {
       filesPage.commentBtn.click();
        comment=faker.chuckNorris().fact();
       filesPage.commentField.sendKeys(comment);

    }
    @Then("Click the submit button to post it")
    public void click_the_submit_button_to_post_it() {
        filesPage.submitComment.click();
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        BrowserUtil.waitFor(2);
        Assert.assertTrue(BrowserUtil.listContainsElement(BrowserUtil.getAllText(filesPage.allComments),comment));
    }
}
