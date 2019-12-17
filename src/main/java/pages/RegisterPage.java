package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class RegisterPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/register?returnUrl=%2F";

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    private WebElement registerText;

    @FindBy(className = "result")
    private WebElement registrationResult;

    @FindBy(xpath = "//p[contains(text(),'Password must meet the following rules:')]")
    private WebElement registerWarning;

    public RegisterPage(final WebDriver driver) {
        super(driver);
    }
}
