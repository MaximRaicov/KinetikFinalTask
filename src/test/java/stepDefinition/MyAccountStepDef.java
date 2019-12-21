package stepDefinition;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import utils.TakeScreens;

import static utils.ActionUtils.clearTextField;
import static utils.ActionUtils.sendKeysToField;
import static utils.AssertUtils.assertThat;
import static utils.ElementSearchUtils.getElementByName;

@Log4j
public class MyAccountStepDef extends AbstractStepDef {

    private String beforeEdit;

    @When("^user changes '(.*)' (Field) with following values:$")
    public void userChangesField(String elementName, String extension, Map<String, String> data) {
        waitForPageLoaded();
        beforeEdit = getElementByName(elementName.concat(extension)).getAttribute("value");
        data.forEach((key, value) -> clearTextField(getElementByName(key)));
        data.forEach((key, value) -> sendKeysToField(getElementByName(key), value));
        log.info(String.format("User changes %s field with following values: %s", elementName,data));
        TakeScreens.takeScreenshot(webDriver);
    }

    @Then("^'(.*)' (Field) successfully updated$")
    public void customerInformationSuccessfullyUpdated(String elementName, String extension) {
        implicitlyWait(5);
        final String afterEdit = getElementByName(elementName.concat(extension)).getAttribute("value");
        assertThat(String.format("Field successfully updated, before edit value: %s\nafter edit value: %s",
                beforeEdit, afterEdit), afterEdit, is(not(beforeEdit)));
        log.info(String.format("%s field successfully updated", elementName));
        TakeScreens.takeScreenshot(webDriver);
    }

}
