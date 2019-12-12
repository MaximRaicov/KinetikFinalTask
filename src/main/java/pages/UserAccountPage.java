package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class UserAccountPage extends PageObject {

    @FindBy(className = "ico-account")
    private WebElement myAccountButton;

    public UserAccountPage(final WebDriver driver) {
        super(driver);
    }
}
