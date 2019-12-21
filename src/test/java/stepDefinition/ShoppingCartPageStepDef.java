package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import pages.ShoppingCartPage;
import utils.TakeScreens;

import static org.hamcrest.core.Is.is;
import static utils.AssertUtils.assertThat;
import static utils.AssertUtils.assertTrue;
import static utils.ElementSearchUtils.getElementByName;

@Log4j
public class ShoppingCartPageStepDef extends AbstractStepDef {

    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);

    @Then("^'(.*)' product is displayed$")
    public void productIsDisplayed(String product) {
        waitForPageLoaded();
        assertThat("The product is found", getElementByName("productName").getText(), is(product));
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("total products price is displayed correct")
    public void checkTotalPrice() {
        assertThat("Total product price is matched", getElementByName("productsPrice").
                getText(), is(getElementByName("orderTotalPrice").getText()));
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("product is not displayed in Shopping cart")
    public void shoppingCartIsEmpty() {
        assertTrue("The shopping cart is empty", shoppingCartPage.getShoppingCartIsEmpty().isDisplayed());
        TakeScreens.takeScreenshot(webDriver);
    }

    @Then("^selected '(.*)' from Wishlist is added successfully to ShoppingCart$")
    public void checkProductAddedToCartFromWishList(String expectedItem) {
        assertThat("Selected product is added to ShoppingCart", expectedItem, is(shoppingCartPage.getActualItem().getText()));
        TakeScreens.takeScreenshot(webDriver);
    }

}
