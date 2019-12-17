package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class UserAccountPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy(className = "ico-account")
    private WebElement myAccountButton;

    @FindBy(className = "ico-logout")
    private WebElement logoutButton;

    public UserAccountPage(final WebDriver driver) {
        super(driver);
    }
}
