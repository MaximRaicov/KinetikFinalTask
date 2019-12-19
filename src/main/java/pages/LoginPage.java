package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class LoginPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//li[contains(text(),'The credentials provided are incorrect')]")
    private WebElement warningMessage;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

}
