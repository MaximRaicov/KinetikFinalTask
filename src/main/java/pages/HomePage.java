package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class HomePage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy(id = "small-searchterms")
    private WebElement searchField;

    @FindBy(css = ".button-1.search-box-button")
    private WebElement searchButton;

    @FindBy(className = "ico-register")
    private WebElement registerButton;

    @FindBy(className = "ico-login")
    private WebElement loginButton;

    public HomePage(final WebDriver driver) {
        super(driver);
    }
}
