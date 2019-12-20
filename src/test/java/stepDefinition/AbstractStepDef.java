package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;

public abstract class AbstractStepDef {

    protected static WebDriver webDriver;

    ConfigFileReader fileReader = new ConfigFileReader();

    private WebDriverWait wait;

    void waitVisibility(WebElement element) {
        wait = new WebDriverWait(webDriver, fileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitUntilElementIsClickable(WebElement element) {
        wait = new WebDriverWait(webDriver, fileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void implicitlyWait(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(webDriver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
