package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SubCategoryPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy(css = ".product-grid>.item-grid")
    private WebElement productForm;

    @FindBy(css = ".page-title h1")
    private WebElement pageTitle;

    public SubCategoryPage(final WebDriver driver) {
        super(driver);
    }

}
