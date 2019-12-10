package hooks;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataProviders.ConfigFileReader;
import managers.WebDriverManager;
import stepDefinition.AbstractStepDef;

public class TestHooks extends AbstractStepDef {

    private ConfigFileReader fileReader;

    private WebDriverManager webDriverManager;

    private static void setDriver(WebDriver driver) {
        webDriver = driver;
    }

    @Before
    public void launchChromeDriver() {
        webDriverManager = new WebDriverManager();
        fileReader = new ConfigFileReader();
        setDriver(webDriverManager.getDriver());
        webDriver.navigate().to(fileReader.getApplicationUrl());
    }

    @After
    public void afterScenario() {
        webDriverManager.closeDriver();
    }
}

