package stepDefinition;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.ShoppingCartPage;

public class ShoppingCartStepDef extends AbstractStepDef{

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);

    @Then("^selected '(.*)' from Wishlist is added successfully to ShoppingCart$")
    public void clickAddToCartFromWishlist (String expectedItem) {
        Assert.assertEquals("Selected product is not added to ShoppingCart",expectedItem, shoppingCartPage.getActualItem().getText());
    }
}
