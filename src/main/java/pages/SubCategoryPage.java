package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SubCategoryPage extends PageObject {

    //TODO: add required url for selected subcategory
    private String pageUrl = "";

    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'HTC One Mini Blue')]")
    private WebElement accessProduct;

    @FindBy(css = " .product-grid")
    private WebElement productGrid;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitle;

    public SubCategoryPage(final WebDriver driver) {
        super(driver);
    }
}
