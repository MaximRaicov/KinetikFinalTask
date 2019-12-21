package stepDefinition;

import static org.hamcrest.CoreMatchers.is;

import cucumber.api.java.en.Then;
import pages.SubCategoryPage;
import utils.TakeScreens;

import static utils.AssertUtils.assertThat;

public class SubCategoryPageStepDef extends AbstractStepDef {

    private SubCategoryPage subCategoryPage = new SubCategoryPage(webDriver);

    @Then("^'(.*)' subcategory is displayed$")
    public void subcategoryPageIsDisplayed(String subCategory) {
        waitVisibility(subCategoryPage.getProductForm());
        assertThat("Selected subcategory matches", subCategoryPage.getPageTitle().getText(), is(subCategory));
        TakeScreens.takeScreenshot(webDriver);
    }
}
