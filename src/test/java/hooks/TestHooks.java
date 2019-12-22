package hooks;

import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import managers.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import stepDefinition.AbstractStepDef;

import java.io.File;

public class TestHooks extends AbstractStepDef {

    private WebDriverManager webDriverManager = new WebDriverManager();

    @Before
    public void launchDriver() {
        PropertyConfigurator.configure(fileReader.getLogConfigPath());
        webDriver = webDriverManager.getDriver();
    }

    @After
    public void afterScenario() {
        webDriverManager.closeDriver();
    }

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath()));
    }
}
