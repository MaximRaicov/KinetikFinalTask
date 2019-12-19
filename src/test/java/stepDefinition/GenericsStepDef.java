package stepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CategoryPage;
import utils.ScenarioContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static utils.ActionUtils.clickOnElement;
import static utils.ElementSearchUtils.getElementByName;
import static utils.ElementSearchUtils.getPage;

public class GenericsStepDef extends AbstractStepDef {

    @Then("^'(.*)' page is displayed$")
    public void pageIsDisplayed(String pageName) {
        assertThat(String.format("%s page is not displayed", pageName),
                webDriver.getCurrentUrl(),
                is(getPage(pageName.concat("Page")).getPageUrl()));
        waitForPageLoaded();
    }
    @When("^user press on '(.*)' (Button|Field|Checkbox)$")
    public void userPressOnButton(String elementName, String extension) {
        implicitlyWait(5);
        waitUntilElementIsClickable(getElementByName(elementName.concat(extension)));
        clickOnElement(getElementByName(elementName.concat(extension)));
    }

    @And("^user clicks on '(.*)' (Button|HeaderButton) and move to '(.*)' page$")
    public void userClicksOnElementAndMoveToPage(String elementName, String extencion, String pageName) {
        waitForPageLoaded();
        if (extencion.equals("Button"))
            getElementByName(pageName.toLowerCase().concat("Form"))
                    .findElement(By.cssSelector("a[href='/" + elementName + "']")).click();
        if (extencion.equals("HeaderButton")) {
            getElementByName("headerForm").findElement(By.cssSelector("a[href='/" + elementName + "']")).click();
        }
        ScenarioContext.setCurrentPage(getPage(pageName.concat("Page")));
    }
}
