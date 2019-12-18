package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;

import static helpers.Reflection.getPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomePageStepDef extends AbstractStepDef {

    @Given("^user is on Home page$")
    public void userIsOnHomePage() {
        webDriver.navigate().to(fileReader.getApplicationUrl());
        assertThat("Page is displayed", webDriver.getCurrentUrl(), is(getPage(HomePage.class.getSimpleName()).getPageUrl()));
    }

    @Then("^'(.*)' page is displayed$")
    public void pageIsDisplayed(String pageName) {
        assertThat(String.format("%s page is displayed", pageName), webDriver.getCurrentUrl(), is(getPage(pageName.concat("Page")).getPageUrl()));
        waitForPageLoaded();
    }
}
