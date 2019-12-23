package stepDefinition;

import static org.hamcrest.CoreMatchers.is;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import pages.HomePage;
import pages.SearchPage;
import utils.TakeScreens;

import static utils.ActionUtils.clickOnElement;
import static utils.AssertUtils.assertThat;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

@Log4j
public class HomePageStepDef extends AbstractStepDef {

    @Given("^user is on Home page$")
    public void userIsOnHomePage() {
        webDriver.navigate().to(fileReader.getApplicationUrl());
        assertThat("Page is displayed", webDriver.getCurrentUrl(), is(getPage(getPageObjectName(HomePage.class)).getPageUrl()));
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("^Search store is populated with '(.*)'$")
    public void populateSearchField(String searchedItem) {
        getElementByName("searchField").sendKeys(searchedItem);
        log.info(String.format("Search store is populated with %s", searchedItem));
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("^'SEARCH' button is pressed$")
    public void searchButtonIsPressed() {
        clickOnElement(getElementByName("searchButton"));
        getPage(getPageObjectName(SearchPage.class));
        log.info("Search button is pressed");
        TakeScreens.takeScreenshot(webDriver);
    }
}
