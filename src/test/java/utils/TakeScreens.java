package utils;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TakeScreens {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    private static LocalDateTime now = LocalDateTime.now();
    private static String nowTime = dtf.format(now);

    /**
     *  Copy taken screenshot from source location to destination location
     */

    /**
     * This attach the specified screenshot to the test
     */
    public static void takeScreenshot(WebDriver driver) {
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        try {
            File fileSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + timestamp + ".png");
            Files.copy(fileSource, destinationPath);
            Reporter.addScreenCaptureFromPath(destinationPath.toString());
        } catch (IOException e) {
            System.out.println("Error while taking screenshot " + e.getMessage());
        }
    }
    /**
     * Copy taken screenshot from source location to destination location
     */
    /**
     * This attach the specified screenshot to the test
     */
    public static void takeFullScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("./Screenshots/" + nowTime + "/" + timestamp + "_" + screenshotName + ".png"));
            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + timestamp + "_" + screenshotName + ".png");
            ImageIO.write(screenshot.getImage(), "PNG", destinationPath);
            Reporter.addScreenCaptureFromPath(destinationPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
