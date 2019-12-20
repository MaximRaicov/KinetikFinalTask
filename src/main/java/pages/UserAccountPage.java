package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class UserAccountPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy(className = "ico-account")
    private WebElement myAccountButton;

    public UserAccountPage(final WebDriver driver) {
        super(driver);
    }

}
