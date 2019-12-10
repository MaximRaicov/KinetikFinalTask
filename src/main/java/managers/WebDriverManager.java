package managers;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

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
                driver = new InternetExplorerDriver();
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
