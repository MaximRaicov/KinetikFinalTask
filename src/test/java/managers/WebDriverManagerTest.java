package managers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import dataProviders.ConfigFileReader;

class WebDriverManagerTest {
    WebDriverManager webDriverManager;
    WebDriver driver;
    ConfigFileReader fileReader;

    @Test
    public void getDriver() {
        fileReader = new ConfigFileReader();
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.navigate().to(fileReader.getApplicationUrl());
        webDriverManager.closeDriver();
    }
}