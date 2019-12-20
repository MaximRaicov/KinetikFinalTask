package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.ShoppingCartPage;
import utils.ScenarioContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static utils.ElementSearchUtils.getElementByName;

public class ShoppingCartPageStepDef extends AbstractStepDef {

    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);

    @Then("^'(.*)' product is displayed$")
    public void productIsDisplayed(String product) {
        waitForPageLoaded();
        assertEquals("The product is not found", getElementByName("productName").getText(), product);
    }

    @Then("^product quantity changed correct$")
    public void checkProductQty() {
        String actualValue = getElementByName("quantityField").getAttribute("value");
        assertEquals("The product quantity doesn't matched", ScenarioContext.getValue("quantity"), actualValue);
    }

    @When("^user fills in '(.*)'$")
    public void fillIn(String itemsQty) {
        getElementByName("quantityField").clear();
        waitUntilElementIsClickable(shoppingCartPage.getQuantityField());
        getElementByName("quantityField").sendKeys(itemsQty);
        ScenarioContext.setValue("quantity", itemsQty);
    }

    @When("total products price is displayed correct")
    public void checkTotalPrice() {
        Assert.assertThat("Total product price is not matched", getElementByName("productsPrice").
                getText(), is(getElementByName("orderTotalPrice").getText()));
    }

    @When("product is not displayed in Shopping cart")
    public void shoppingCartIsEmpty() {
        Assert.assertTrue("The shopping cart is not empty", shoppingCartPage.getShoppingCartIsEmpty().isDisplayed());
    }

}
