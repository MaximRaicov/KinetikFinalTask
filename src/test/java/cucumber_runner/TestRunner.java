package cucumber_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * before running any test, need to be removed #not before used tag
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinition", "hooks"},
        features = {"src/test/resources/features"},
        tags = {"~@amiordan", "~@mraicov", "~@aciuvaga"},
        plugin = {"pretty", "html:target/cucumber"})
public class TestRunner {

}