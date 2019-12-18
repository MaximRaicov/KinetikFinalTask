package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import pages.SubCategoryPage;

import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

public class CategoryPageStepDef extends AbstractStepDef {

    protected static String expectedSubCategory;

    @When("User clicks on '(.*)' subcategory")
    public void clickOnSubCategory(String subCategoryName) {
        WebElement subCategorySelector = webDriver.findElement(By.cssSelector(".title a[href='/" + subCategoryName + "']"));
        waitUntilElementIsClickable(subCategorySelector);
        expectedSubCategory = subCategorySelector.getText();

        getElementByName("subCategory").findElement(By.cssSelector(".title a[href='/" + subCategoryName + "']")).click();
        getPage(getPageObjectName(SubCategoryPage.class));

    }
}
