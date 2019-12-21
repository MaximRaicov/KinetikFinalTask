package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import pages.SearchPage;

import static utils.AssertUtils.assertTrue;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

public class SearchPageStepDef extends AbstractStepDef {

    @Then("^'(.*)' list of items is displayed$")
    public void searchResultsList(String searchItem) {
        assertTrue("Search product grid is displayed",
                getElementByName("searchProductGrid").findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'" + searchItem + "')]")).isDisplayed());
        getPage(getPageObjectName(SearchPage.class));
    }
}
