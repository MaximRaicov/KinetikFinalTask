package stepDefinition;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.WishListPage;
import utils.ScenarioContext;

public class WishListPageStepDef extends AbstractStepDef {
    WishListPage wishListPage = new WishListPage(webDriver);

    @Then("^product '(.*)' is displayed in the WishList$")
    public void displayProductWishlist(String expectedItem) {
        waitForPageLoaded();
        Assert.assertEquals("The product is not found in the Wishlist", expectedItem, wishListPage.getProductName().getText());
    }

    @Then("^updated product quantity is displayed in the WishList$")
    public void updatedProductQuantityIsDisplayedInTheWishList() {
        waitVisibility(wishListPage.getQuantityField());
        String actual = wishListPage.getQuantityField().getAttribute("value");
        Assert.assertEquals("Quantity does not match", ScenarioContext.getValue("quantity"), actual);
    }

    @Then("^product is removed successfully from Wishlist$")
    public void productIsRemovedSuccessfully() {
        waitVisibility(wishListPage.getEmptyWishlistMessage());
        Assert.assertEquals("The wishlist is empty!", wishListPage.getEmptyWishlistMessage().getText());
    }
}
