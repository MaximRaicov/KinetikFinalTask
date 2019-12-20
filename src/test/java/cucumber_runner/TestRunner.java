package cucumber_runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * before running any test, need to be removed #~ before used tag
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinition", "hooks"},
        features = {"src/test/resources/features"},
        tags = {"~@amiordan", "@mraicov", "~@aciuvaga"},
        plugin = {"pretty", "html:target/cucumber"})
public class TestRunner {

}