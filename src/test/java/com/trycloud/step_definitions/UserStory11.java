package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.TalkPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory11 {
    TalkPage talkPage = new TalkPage();
    Faker faker = new Faker();

    @When("Search a user from search box on the left")
    public void search_a_user_from_search_box_on_the_left() {
        talkPage.searchFiled.sendKeys("user");
        talkPage.firstUser.click();

    }
    String str="";
    @Then("Write a message")
    public void write_a_message() {
        str = faker.chuckNorris().fact();
    talkPage.messageField.sendKeys(str);
    }
    @Then("Click submit button")
    public void click_submit_button() {
        BrowserUtil.waitFor(2);
        talkPage.submitMessage.click();
        BrowserUtil.waitFor(2);

    }
    @Then("Verify the message is displayed on the conversation log")
    public void verify_the_message_is_displayed_on_the_conversation_log() {
        System.out.println("str = " + str);
        Assert.assertTrue(BrowserUtil.getAllText(talkPage.allMessages).contains(str));
        //Assert.assertTrue(BrowserUtil.listContainsElement(BrowserUtil.getAllText(talkPage.allMessages), str));
    }
}
