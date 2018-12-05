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

public class HomePageStepDefs {

    private ShopSite shopSite;

    public HomePageStepDefs() {
        SeleniumDriverConfig driverConfig = new SeleniumDriverConfig("chrome");
        shopSite = new ShopSite(driverConfig.getDriver());
    }

    @Given("^I am on the Homepage$")
    public void i_am_on_the_Homepage() throws Throwable {
        shopSite.shopHomePage().goToHomePage();
        Assert.assertEquals(shopSite.shopHomePage().getHomePageURL(), shopSite.getCurrentUrl());
    }

    @When("^I click on the add item button$")
    public void i_click_on_the_add_item_button() throws Throwable {
        shopSite.shopHomePage().clickAddToBasket();
    }

    @And("^I return to the Homepage$")
    public void i_return_to_the_Homepage() throws Throwable {
        shopSite.shopHomePage().continueShopping();
    }

    @Then("^That item is added to the cart$")
    public void that_item_is_added_to_the_cart() throws Throwable {
        Assert.assertNotNull(shopSite.shopHomePage().checkCartItem());
        Assert.assertEquals(shopSite.shopHomePage().getPrice(), shopSite.shopHomePage().getCartPrice());
    }

    @When("^I click on the Proceed To Checkout$")
    public void i_click_on_the_Proceed_To_Checkout() throws Throwable {
        shopSite.shopHomePage().toCheckoutFromAdd();
    }

    @Then("^I am taken to the Checkout$")
    public void i_am_taken_to_the_Checkout() throws Throwable {
        Assert.assertEquals(shopSite.shopShippingConfirmationPage().getPageURL(), shopSite.getCurrentUrl());
    }

    @Given("^I have an item in my cart$")
    public void i_have_an_item_in_my_cart() throws Throwable {
        shopSite.shopHomePage().clickAddToBasket();
        shopSite.shopHomePage().continueShopping();
        Assert.assertNotNull(shopSite.shopHomePage().checkCartItem());
        Assert.assertEquals(shopSite.shopHomePage().getPrice(), shopSite.shopHomePage().getCartPrice());
    }

    @When("^I click on the Check out button$")
    public void i_click_on_the_Check_out_button() throws Throwable {
        shopSite.shopHomePage().toCheckout();
    }
}