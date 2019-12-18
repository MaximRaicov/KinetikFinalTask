package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.java.en.When;
import pages.CategoryPage;

import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

public class GeneralStepDef extends AbstractStepDef {

    @When("User clicks on '(.*)' category from category bar")
    public void clickOnCategory(String categoryName) {

        getElementByName("categoryForm").findElement(By.cssSelector("a[href='/" + categoryName + "']")).click();
        getPage(getPageObjectName(CategoryPage.class));
    }
}
