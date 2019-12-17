package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;
import stepDefinition.AbstractStepDef;

public class TestHooks extends AbstractStepDef {

    private WebDriverManager webDriverManager = new WebDriverManager();

    @Before
    public void launchChromeDriver() {
        webDriver = webDriverManager.getDriver();
    }

    @After
    public void afterScenario() {
        webDriverManager.closeDriver();
    }
}

