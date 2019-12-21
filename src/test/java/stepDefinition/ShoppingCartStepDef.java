package stepDefinition;

import static org.hamcrest.CoreMatchers.is;

import cucumber.api.java.en.Then;
import pages.ShoppingCartPage;

import static utils.AssertUtils.assertThat;

public class ShoppingCartStepDef extends AbstractStepDef {

    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);

    @Then("^selected '(.*)' from Wishlist is added successfully to ShoppingCart$")
    public void checkProductAddedToCartFromWishList(String expectedItem) {
        assertThat("Selected product is added to ShoppingCart", expectedItem, is(shoppingCartPage.getActualItem().getText()));
    }
}
