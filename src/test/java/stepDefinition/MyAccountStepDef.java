package stepDefinition;

import java.util.Map;

import static org.junit.Assert.assertNotEquals;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static utils.ElementSearchUtils.getElementByName;

public class MyAccountStepDef extends AbstractStepDef {

    private String beforeEdit;

    @When("^user changes '(.*)' (Field) with following values:$")
    public void userChangesField(String elementName, String extension, Map<String, String> data) {
        waitForPageLoaded();
        beforeEdit = getElementByName(elementName.concat(extension)).getAttribute("value");
        data.forEach((key, value) -> getElementByName(key).clear());
        data.forEach((key, value) -> getElementByName(key).sendKeys(value));
    }

    @Then("^'(.*)' (Field) successfully updated$")
    public void customerInformationSuccessfullyUpdated(String elementName, String extension) {
        implicitlyWait(5);
        final String afterEdit = getElementByName(elementName.concat(extension)).getAttribute("value");
        assertNotEquals("Edit unsuccessful", afterEdit, beforeEdit);
    }

}
