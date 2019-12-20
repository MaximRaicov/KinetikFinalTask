package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ProductPage;
import pages.SubCategoryPage;
import utils.ScenarioContext;

import static utils.ActionUtils.clickOnElement;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

public class SubCategoryPageStepDef extends AbstractStepDef {

    private SubCategoryPage subCategoryPage = new SubCategoryPage(webDriver);

    @Then("^'(.*)' subcategory is displayed$")
    public void subcategoryPageIsDisplayed(String subCategory) {
        waitVisibility(subCategoryPage.getProductForm());
        Assert.assertEquals("Selected subcategory does not match", subCategoryPage.getPageTitle().getText(), subCategory);
    }
}
