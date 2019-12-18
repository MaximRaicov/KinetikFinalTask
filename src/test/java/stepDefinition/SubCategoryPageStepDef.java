package stepDefinition;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.SubCategoryPage;

import static stepDefinition.CategoryPageStepDef.expectedSubCategory;

public class SubCategoryPageStepDef extends AbstractStepDef {

    private SubCategoryPage subCategoryPage = new SubCategoryPage(webDriver);

    @Then("'(.*)' subcategory page is displayed")
    public void subcategoryPageIsDisplayed(String subCategory) {
        waitVisibility(subCategoryPage.getProductGrid());
        Assert.assertEquals(subCategoryPage.getPageTitle().getText(), expectedSubCategory);
    }
}
