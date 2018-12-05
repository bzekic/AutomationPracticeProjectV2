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

public class CartStepDefs {
    ShopSite shopSite;

    public CartStepDefs() {
        SeleniumDriverConfig driverConfig = new SeleniumDriverConfig( "chrome" );
        shopSite = new ShopSite( driverConfig.getDriver() );
    }

    @Given("^I am signed in as an existing user$")
    public void i_am_signed_in_as_an_existing_user() throws Throwable {
        shopSite.shopMyAccountPage().goToMyAccountPage();
        shopSite.shopSignInPage().inputUserName( "samgrill101@gmail.com" );
        shopSite.shopSignInPage().inputPassword( "engineering19" );
        shopSite.shopSignInPage().clickSubmitButton();
    }

    @And("^I am on the homepage$")
    public void i_am_on_the_homepage() throws Throwable {
        shopSite.shopHomePage().goToHomePage();
    }

    @When("^I have an item added in my cart$")
    public void i_have_an_item_added_in_my_cart() throws Throwable {
        shopSite.shopHomePage().clickAddToBasket();
        shopSite.shopHomePage().continueShopping();
    }

    @When("^I click to the proceed to checkout$")
    public void i_click_to_the_proceed_to_checkout() throws Throwable {
        shopSite.shopHomePage().toCheckoutFromAdd();
        shopSite.shoppingCartPage().clickProceedToCheckoutButton();
    }

    @Then("^I go to the Address confirmation page$")
    public void i_go_to_the_Address_confirmation_page() throws Throwable {
        Assert.assertEquals( shopSite.shopAddressConfirmationPage().getPageURL(), shopSite.getCurrentUrl() );
    }
}