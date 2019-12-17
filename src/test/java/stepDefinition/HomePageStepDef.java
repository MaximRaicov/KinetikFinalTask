package stepDefinition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;

import static helpers.Reflection.getPage;

public class HomePageStepDef extends AbstractStepDef {

    @Given("^Home page is displayed$")
    public void homePageIsDisplayed() {
        webDriver.navigate().to(fileReader.getApplicationUrl());
        assertThat("Page is displayed", webDriver.getCurrentUrl(), is(getPage("HomePage").getPageUrl()));
    }

    @Given("^'(.*)' page is displayed$")
    public void homePageIsDisplayed(String pageName) {
        assertThat(String.format("%s page is displayed", pageName), webDriver.getCurrentUrl(), is(getPage(pageName.concat("Page")).getPageUrl()));
        waitForPageLoaded();
    }

}
