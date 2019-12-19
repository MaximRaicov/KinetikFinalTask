package stepDefinition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;
import pages.HomePage;

import static utils.ElementSearchUtils.getPage;
import static utils.TestUtils.getPageObjectName;

public class HomePageStepDef extends AbstractStepDef {

    @Given("^user is on Home page$")
    public void userIsOnHomePage() {
        webDriver.navigate().to(fileReader.getApplicationUrl());
        assertThat("Page is displayed", webDriver.getCurrentUrl(), is(getPage(getPageObjectName(HomePage.class)).getPageUrl()));
    }

}
