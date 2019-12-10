package managers;

import dataProviders.ConfigFileReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

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