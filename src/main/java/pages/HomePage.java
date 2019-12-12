package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class HomePage extends PageObject {

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]")
    private WebElement category;

    @FindBy(id = "small-searchterms")
    private WebElement searchField;

    @FindBy(className = "button-1 search-box-button")
    private WebElement searchButton;

    public HomePage(final WebDriver driver) {
        super(driver);
    }
}
