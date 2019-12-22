package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import lombok.extern.log4j.Log4j;
import pages.ProductPage;
import utils.TakeScreens;

import static utils.ActionUtils.clickOnElement;
import static utils.AssertUtils.assertTrue;

@Log4j
public class ProductPageStepDef extends AbstractStepDef {

    private ProductPage productPage = new ProductPage(webDriver);

    @Then("^alert message is displayed$")
    public void alertMessageIsDisplayed() {
        assertTrue("The alert message is displayed", productPage.getAlertMessage().isDisplayed());
        TakeScreens.takeScreenshot(webDriver);
    }

    @And("^alert message is closed$")
    public void alertMessageIsClosed() {
        clickOnElement(productPage.getCloseAlertMessage());
        waitForPageLoaded();
        log.info("Alert message is closed");
        TakeScreens.takeScreenshot(webDriver);
    }
}
