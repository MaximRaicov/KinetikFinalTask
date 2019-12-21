package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ProductPage;

import static utils.ActionUtils.clickOnElement;
import static utils.AssertUtils.assertTrue;

public class ProductPageStepDef extends AbstractStepDef {

    private ProductPage productPage = new ProductPage(webDriver);

    @Then("^alert message is displayed$")
    public void alertMessageIsDisplayed() {
        assertTrue("The alert message is displayed", productPage.getAlertMessage().isDisplayed());
    }

    @And("^alert message is closed$")
    public void alertMessageIsClosed() {
        clickOnElement(productPage.getCloseAlertMessage());
        waitForPageLoaded();
    }

}
