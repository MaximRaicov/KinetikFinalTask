package managers;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String INTERNET_EXPLORER = "webdriver.ie.driver";
    private static final String FIREFOX = "webdriver.gecko.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();//return enum browser name
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createLocalDriver();
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNET_EXPLORER:
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("nativeEvents", false);
                capabilities.setCapability("ignoreProtectedModeSettings", true);
                capabilities.setCapability("ignoreZoomSetting", true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.merge(capabilities);
                System.setProperty(INTERNET_EXPLORER, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
                driver = new InternetExplorerDriver(options);
                break;
            case FIREFOX:
                System.setProperty(FIREFOX, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
                driver = new FirefoxDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);

        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
