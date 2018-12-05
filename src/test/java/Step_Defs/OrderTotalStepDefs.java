package Step_Defs;

import AutomationPracticeProject.Selenium_Config.SeleniumDriverConfig;
import AutomationPracticeProject.ShopSite.ShopSite;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OrderTotalStepDefs {

    private ShopSite shopSite;

    public OrderTotalStepDefs() {
        SeleniumDriverConfig driverConfig = new SeleniumDriverConfig("chrome");
        shopSite = new ShopSite(driverConfig.getDriver());
    }

    @Given("^I am an existing user, I am on the homepage and I would like to purchase one item$")
    public void i_am_an_existing_user_I_am_on_the_homepage_and_I_would_like_to_purchase_one_item() throws Throwable {
        shopSite.shopHomePage().goToHomePage();
        Assert.assertEquals(shopSite.shopHomePage().getHomePageURL(), shopSite.getCurrentUrl ());
    }

    @When("^I proceed through the transaction process$")
    public void i_proceed_through_the_transaction_process() throws Throwable {
        shopSite.placeOrder();
    }

    @Then("^I ensure that all totals match up on each page I visit that lists the total order value$")
    public void i_ensure_that_all_totals_much_up_on_each_page_I_visit_that_lists_the_total_order_value() throws Throwable {
        Assert.assertEquals(shopSite.getOrderPrice(), shopSite.getCartTotal());
        Assert.assertEquals(shopSite.getOrderPrice(), shopSite.getPaymentSelectionTotal());
    }

    @When("^I add one item to cart and continue shopping$")
    public void i_add_one_item_to_cart_and_continue_shopping() throws Throwable {
        shopSite.shopHomePage().clickAddToBasket();
        shopSite.shopHomePage().continueShopping();
    }

    @Then("^I ensure that totals match up to what is expected$")
    public void i_ensure_that_totals_match_up_to_what_is_expected() throws Throwable {
        Assert.assertEquals(shopSite.getOrderPrice(), shopSite.getHomePageTotal());
    }
}