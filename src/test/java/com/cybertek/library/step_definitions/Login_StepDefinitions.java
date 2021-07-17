package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.login("librarian11@library", "I61FFPPf");
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.login("student31@library", "yOPdSR0u");

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Library";

       Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.loginParamUser(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.loginParamPass(password);
        BrowserUtils.sleep(1);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signIn.click();

    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("there should be {int} users")
    public void there_should_be_users(int userNumber) {
        //int users = userNumber;
        String actualUserNum = dashboardPage.userNum.getText();
        String expectedUserNum = Integer.toString(userNumber);

        Assert.assertEquals(actualUserNum,expectedUserNum);

    }

}
