package stepDefinition;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CategoryPage;
import pages.SubCategoryPage;

import static helpers.Reflection.getElementByName;
import static helpers.Reflection.getPage;
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
