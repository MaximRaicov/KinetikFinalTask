package stepDefinition;

import java.util.Map;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static utils.ActionUtils.clickOnElement;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;

public class GenericStepDef extends AbstractStepDef {

    @Then("^'(.*)' page is displayed$")
    public void pageIsDisplayed(String pageName) {
        assertThat(String.format("%s page is displayed", pageName), webDriver.getCurrentUrl(), is(getPage(pageName.concat("Page")).getPageUrl()));
        waitForPageLoaded();
    }

    @When("^user press on '(.*)' (Button)$")
    public void userPressOnButton(String elementName, String extension) {
        waitUntilElementIsClickable(getElementByName(elementName.concat(extension)));
        clickOnElement(getElementByName(elementName.concat(extension)));
    }

    @When("^user populates fields with following values:$")
    public void userPopulatesFieldsWithValues(Map<String, String> data) {
        waitForPageLoaded();
        data.forEach((key, value) -> getElementByName(key).sendKeys(value));
    }

    @Then("^'(.*)' (Button|Field|Message|)\\s*is displayed$")
    public void userIsSuccessfullyLoggedIn(String elementName, String extension) {
        waitForPageLoaded();
        waitVisibility(getElementByName(elementName.concat(extension)));
        Assert.assertTrue(String.format("%s element is displayed", elementName), getElementByName(elementName.concat(extension)).isDisplayed());
    }
}
