package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.ProductPage;
import pages.SubCategoryPage;
import utils.ScenarioContext;

import static utils.ActionUtils.clickOnElement;
import static utils.ElementSearchUtils.getElementByName;

public class SubCategoryPageStepDef extends AbstractStepDef {

    private SubCategoryPage subCategoryPage = new SubCategoryPage(webDriver);

    @Then("^'(.*)' subcategory is displayed$")
    public void subcategoryPageIsDisplayed(String subCategory) {
        waitVisibility(subCategoryPage.getProductForm());
        Assert.assertEquals("Selected subcategory does not match", subCategoryPage.getPageTitle().getText(), subCategory);
    }

    @When("^user clicks on '(.*)' product$")
    public void clickOnProduct(String productName) {
        waitUntilElementIsClickable(subCategoryPage.getProductForm());
        clickOnElement(getElementByName("productForm")
                .findElement(By.cssSelector("a[href='/" + productName + "']")));
        ScenarioContext.setCurrentPage(new ProductPage(webDriver));
    }

}
