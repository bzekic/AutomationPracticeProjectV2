package Step_Defs;

import AutomationPracticeProject.Selenium_Config.SeleniumDriverConfig;
import AutomationPracticeProject.ShopSite.ShopSite;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    private ShopSite shopSite;

    public LoginStepDefs() {
        SeleniumDriverConfig driverConfig = new SeleniumDriverConfig("chrome");
        shopSite = new ShopSite(driverConfig.getDriver());
    }

    @Given("^I am on the Sign in page$")
    public void i_am_on_the_Sign_in_page() throws Throwable {
        shopSite.shopSignInPage().goToSignInPage();
    }

    @When("^I input a valid email address (.*)$")
    public void i_input_a_valid_email_address(String email) throws Throwable {
        shopSite.shopSignInPage().inputUserName(email);
    }

    @And("^I input an invalid (.*)$")
    public void i_input_an_invalid(String password) throws Throwable {
        shopSite.shopSignInPage().inputPassword(password);
        shopSite.shopSignInPage().clickSubmitButton();
    }

    @Then("^I receive the corresponding error (.*)$")
    public void i_receive_the_corresponding_error(String error) throws Throwable {
        Assert.assertEquals(error, shopSite.shopSignInPage().getPasswordErrorText());
    }

    @When("^I input a valid password (.*)$")
    public void i_input_a_valid_password(String password) throws Throwable {
        shopSite.shopSignInPage().inputPassword(password);
        shopSite.shopSignInPage().clickSubmitButton();
    }

    @Then("^I am taken to the correct page$")
    public void i_am_taken_to_the_correct_page() throws Throwable {
        Assert.assertEquals(shopSite.shopSignInPage().getLoggedInUrl(),shopSite.getCurrentUrl());
    }
}