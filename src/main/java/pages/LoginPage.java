package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class LoginPage extends PageObject {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    private WebElement loginButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }
}
