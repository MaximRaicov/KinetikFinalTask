package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAccountPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/customer/info";

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "save-info-button")
    private WebElement saveButton;

    public MyAccountPage(final WebDriver driver) {
        super(driver);
    }

}
