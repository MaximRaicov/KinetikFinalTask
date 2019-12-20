package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.ProductPage;

import static utils.ActionUtils.clickOnElement;

public class ProductPageStepDef extends AbstractStepDef {

    private ProductPage productPage = new ProductPage(webDriver);

    @Then("^alert message is displayed$")
    public void alertMessageIsDisplayed() {
        Assert.assertTrue("The alert message is not displayed", productPage.getAlertMessage().isDisplayed());
    }

    @And("^alert message is closed$")
    public void alertMessageIsClosed() {
        clickOnElement(productPage.getCloseAlertMessage());
        waitForPageLoaded();
    }

}
