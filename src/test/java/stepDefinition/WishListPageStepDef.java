package stepDefinition;

import cucumber.api.java.en.Then;
import pages.WishListPage;
import utils.TakeScreens;

import static org.hamcrest.CoreMatchers.is;
import static utils.AssertUtils.assertThat;

public class WishListPageStepDef extends AbstractStepDef {

    private WishListPage wishListPage = new WishListPage(webDriver);

    @Then("^product '(.*)' is displayed in the WishList$")
    public void displayProductWishList(String expectedItem) {
        waitForPageLoaded();
        assertThat("The product is found in the WishList", expectedItem, is(wishListPage.getProductName().getText()));
        TakeScreens.takeScreenshot(webDriver);
    }

    @Then("^product is removed successfully from Wishlist$")
    public void productIsRemovedSuccessfully() {
        waitVisibility(wishListPage.getEmptyWishlistMessage());
        assertThat("Product is removed successfully form WishList", "The wishlist is empty!", is(wishListPage.getEmptyWishlistMessage().getText()));
        TakeScreens.takeScreenshot(webDriver);
    }

}
