package com.paylinks.step_def;

import com.paylinks.driver.DriverManager;
import com.paylinks.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;

public class LoginSteps {

    DriverManager driverManager = new DriverManager();
    LoginPage loginPage = new LoginPage();

    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() throws Throwable {

        //        validation through url
        String actualUrl = driverManager.getUrl();
        System.out.println(actualUrl);
        assertThat(actualUrl, is(endsWith("login")));

        //        validation through title
        String actualTitle = driverManager.getTitle();
        System.out.println(actualTitle);
        assertThat(actualTitle, is(equalToIgnoringCase("Embark")));
    }

    @When("^I enter incorrect email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_enter_incorrect_email_and_password(String email, String password) throws Throwable {
        loginPage.enterIncorrectEmailAndPassword(email, password);
    }

    @When("^I enter valid email and password for \"([^\"]*)\"$")
    public void i_enter_valid_email_and_passwordFor(String userType) throws Throwable {
        loginPage.enterValidEmailAndPassword(userType);
    }

    @When("^I enter password \"([^\"]*)\" and leave email filed blank$")
    public void i_enter_password_and_leave_email_filed_blank(String password) throws Throwable {
        loginPage.enterValidPassword(password);
    }

    @When("^I enter correct email \"([^\"]*)\" and leave password field blank$")
    public void i_enter_correct_email_and_leave_password_field_blank(String email) throws Throwable {
        loginPage.enterValidEmail(email);
    }

    @When("^I click on log in button$")
    public void i_click_on_log_in_button() throws Throwable {
        loginPage.clickOnLogInButton();
    }

    @Then("^I should see log out icon (is|not) Displayed$")
    public void i_should_see_log_out_icon_is(String state) throws Throwable {
        System.out.println(loginPage.checkLogOutIconIsDisplayed());
        assertThat(loginPage.checkLogOutIconIsDisplayed(), is(state.equals("is") ? true : false));
    }

    @Then("^the url should contain with \"([^\"]*)\"$")
    public void the_url_should_contain_with(String urlEndPoint) throws Throwable {
        String actualUrl = driverManager.getUrl();
        assertThat(actualUrl, containsString(urlEndPoint));
    }

    @Then("^I should be able to see validation message \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeValidationMessage(String expText) throws Throwable {

        switch (expText) {
            case "Your username  required":
                String actualEmailError = loginPage.getEmailOrPasswordRequiredErrorMsg();
                assertThat(actualEmailError, is(equalToIgnoringCase(expText)));
                break;
            case "Your password  required":
                String actualPasswordError = loginPage.getEmailOrPasswordRequiredErrorMsg();
                assertThat(actualPasswordError, is(equalToIgnoringCase(expText)));
                break;
            case "Incorrect username or password":
                String actualValidationError = loginPage.getValidationErrorMsg();
                assertThat(actualValidationError, is(equalToIgnoringCase(expText)));
                break;
            default:
                throw new IllegalAccessException("Unexpected validation error");
        }

    }
}
