package stepDefinition;

import java.util.Map;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ScenarioContext;

import static utils.ActionUtils.clickOnElement;
import static utils.ActionUtils.sendKeysToField;
import static utils.AssertUtils.assertThat;
import static utils.AssertUtils.assertTrue;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;

public class GenericsStepDef extends AbstractStepDef {

    @Then("^'(.*)' page is displayed$")
    public void pageIsDisplayed(String pageName) {
        assertThat(String.format("%s page is displayed", pageName),
                webDriver.getCurrentUrl(), is(getPage(pageName.concat("Page")).getPageUrl()));
        waitForPageLoaded();
    }

    @When("^user press on '(.*)' (Button|CheckBox)$")
    public void userPressOnButton(String elementName, String extension) {
        implicitlyWait(5);
        waitUntilElementIsClickable(getElementByName(elementName.concat(extension)));
        clickOnElement(getElementByName(elementName.concat(extension)));
    }

    @And("^user clicks on '(.*)' (Button|HeaderButton) and move to '(.*)' page$")
    public void userClicksOnElementAndMoveToPage(String elementName, String extension, String pageName) {
        waitForPageLoaded();
        switch (extension) {
            case "Button":
                clickOnElement(getElementByName(pageName.toLowerCase().concat("Form"))
                        .findElement(By.cssSelector("a[href='/" + elementName + "']")));
                ScenarioContext.setCurrentPage(getPage(pageName.concat("Page")));
                break;
            case "HeaderButton":
                clickOnElement(getElementByName("headerForm")
                        .findElement(By.cssSelector("a[href='/" + elementName + "']")));
                ScenarioContext.setCurrentPage(getPage(pageName.concat("Page")));
                break;
        }
    }

    @When("^user populates fields with following values:$")
    public void userPopulatesFieldsWithFollowingValues(Map<String, String> data) {
        waitForPageLoaded();
        data.forEach((key, value) -> sendKeysToField(getElementByName(key), value));

    }

    @Then("^'(.*)' (Button|Field|Message|)\\s*is displayed$")
    public void elementSuccessfullyDisplayed(String elementName, String extension) {
        waitForPageLoaded();
        waitVisibility(getElementByName(elementName.concat(extension)));
        assertTrue(String.format("%s element is displayed", elementName), getElementByName(elementName.concat(extension)).isDisplayed());
    }
}
