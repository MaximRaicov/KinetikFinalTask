package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class PageObject {

    @FindBy(css = ".top-menu:first-child")
    public WebElement categoryForm;

    @FindBy(className = "header-links")
    public WebElement headerForm;

    private WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract String getPageUrl();

}
