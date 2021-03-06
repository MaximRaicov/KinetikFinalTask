package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import utils.ScenarioContext;
import utils.TakeScreens;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static utils.ActionUtils.*;
import static utils.AssertUtils.assertThat;
import static utils.AssertUtils.assertTrue;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;

@Log4j
public class GenericsStepDef extends AbstractStepDef {

    private String beforeEdit;

    @When("^user changes '(.*)' (Field) with following values:$")
    public void userChangesField(String elementName, String extension, Map<String, String> data) {
        waitForPageLoaded();
        beforeEdit = getElementByName(elementName.concat(extension)).getAttribute("value");
        data.forEach((key, value) -> clearTextField(getElementByName(key)));
        data.forEach((key, value) -> sendKeysToField(getElementByName(key), value));
        log.info(String.format("User changes %s field with following values: %s", elementName, data));
        TakeScreens.takeScreenshot(webDriver);
    }

    @Then("^'(.*)' (Field) successfully updated$")
    public void customerInformationSuccessfullyUpdated(String elementName, String extension) {
        implicitlyWait(5);
        final String afterEdit = getElementByName(elementName.concat(extension)).getAttribute("value");
        assertThat(String.format("Field successfully updated, before edit value: %s\nafter edit value: %s",
                beforeEdit, afterEdit), afterEdit, is(not(beforeEdit)));
        TakeScreens.takeScreenshot(webDriver);
    }

    @Then("^'(.*)' page is displayed$")
    public void pageIsDisplayed(String pageName) {
        assertThat(String.format("%s page is displayed", pageName),
                webDriver.getCurrentUrl(), is(getPage(pageName.concat("Page")).getPageUrl()));
        waitForPageLoaded();
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("^user press on '(.*)' (Button|CheckBox)$")
    public void userPressButtonCheckbox(String elementName, String extension) {
        switch (extension) {
            case "Button":
                waitUntilElementIsClickable(getElementByName(elementName.concat(extension)));
                clickOnElement(getElementByName(elementName.concat(extension)));
                break;
            case "CheckBox":
                while (!getElementByName(elementName.concat(extension)).isSelected()) {
                    waitUntilElementIsClickable(getElementByName(elementName.concat(extension)));
                    clickOnElement(getElementByName(elementName.concat(extension)));
                }
                break;
        }
        log.info(String.format("User press on %s %s", elementName, extension));
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("^user clicks on '(.*)' (Button|HeaderButton) and move to '(.*)' page$")
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
        log.info(String.format("User clicks on %s and move to %s page", elementName, pageName));
        TakeScreens.takeScreenshot(webDriver);
    }

    @When("^user populates fields with following values:$")
    public void userPopulatesFieldsWithFollowingValues(Map<String, String> data) {
        waitForPageLoaded();
        data.forEach((key, value) -> sendKeysToField(getElementByName(key), value));
        log.info(String.format("User populates fields with following values: %s", data));
        TakeScreens.takeScreenshot(webDriver);
    }

    @Then("^'(.*)' (Button|Field|Message|)\\s*is displayed$")
    public void elementSuccessfullyDisplayed(String elementName, String extension) {
        waitForPageLoaded();
        waitVisibility(getElementByName(elementName.concat(extension)));
        assertTrue(String.format("%s element is displayed", elementName), getElementByName(elementName.concat(extension)).isDisplayed());
        TakeScreens.takeScreenshot(webDriver);
    }

}
