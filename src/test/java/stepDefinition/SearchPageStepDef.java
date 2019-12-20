package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.ProductPage;
import pages.SearchPage;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

public class SearchPageStepDef extends AbstractStepDef {

    @Then("^'(.*)' list of items is displayed$")
    public void searchResultsList(String searchItem) {
        Assert.assertTrue(getElementByName("searchProductGrid").findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'" + searchItem + "')]")).isDisplayed());
        getPage(getPageObjectName(SearchPage.class));
    }

    @When("^'(.*)' is selected$")
    public void serach_itemIsSelected(String searchItem) {
        getElementByName("searchProductGrid").findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'" + searchItem + "')]")).click();
        getPage(getPageObjectName(ProductPage.class));
    }
}
