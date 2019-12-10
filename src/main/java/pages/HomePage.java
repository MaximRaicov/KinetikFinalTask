package pages;

import org.openqa.selenium.WebDriver;

import lombok.Getter;

@Getter
public class HomePage extends PageObject {

       HomePage(final WebDriver driver) {
        super(driver);
    }
}
