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

public class OrderHistoryStepDefs {

    private ShopSite shopSite;
    private String orderReference = null;

    public OrderHistoryStepDefs() {
        SeleniumDriverConfig driverConfig = new SeleniumDriverConfig("chrome");
    shopSite = new ShopSite(driverConfig.getDriver());

    }
    @Given("^I have placed an order$")
    public void i_have_placed_an_order() throws Throwable {
        shopSite.placeOrder();
    }

    @And("^The order went through correctly$")
    public void the_order_went_through_correctly() throws Throwable {
        Assert.assertNotNull(shopSite.getOrderPrice());
    }

    @When("^I go to the Order History Page$")
    public void i_go_to_the_Order_History_Page() throws Throwable {
        shopSite.shopOrderHistoryPage().goToOrderHistoryPage();
        Assert.assertEquals(shopSite.getCurrentUrl(), shopSite.shopOrderHistoryPage().getPageURL());
    }

    @Then("^I see the details of the order I have just placed$")
    public void i_see_the_details_of_the_order_I_have_just_placed() throws Throwable {
        shopSite.shopOrderHistoryPage().getOrderPrice();
        shopSite.shopOrderHistoryPage().getOrderReference();
        Assert.assertNotNull(shopSite.shopOrderHistoryPage().getOrderDate());
        Assert.assertEquals(shopSite.getOrderPrice(), shopSite.shopOrderHistoryPage().getOrderPrice() );
        orderReference = shopSite.shopOrderHistoryPage().getOrderReference();
        Assert.assertNotNull(orderReference);
    }
}