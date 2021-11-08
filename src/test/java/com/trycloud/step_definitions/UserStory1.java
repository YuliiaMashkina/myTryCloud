package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory1 {

        LoginPage page = new LoginPage();
    @Given("user on the login page")
    public void user_on_the_login_page() {
        page.goTo();
    }


    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String pass ) {
        page.login(username, pass);
    }

    @Given("user click login button")
    public void user_click_login_button() {
        page.loginBtn.click();
    }

    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }




    @When("user enter invalid credentials")
    public void user_enter_invalid_credentials() {
        Faker faker = new Faker();
        page.login(faker.name().username(), faker.internet().password());

    }


    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String message) {
        System.out.println("page.errorMsg.getText() = " + page.errorMsg.getText().trim());
        //Assert.assertTrue(message.equals(page.errorMsg.getText()));
        Assert.assertEquals(message, page.errorMsg.getText());
    }
}
