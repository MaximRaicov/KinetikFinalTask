package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class SearchPage extends PageObject {

    //TODO: add required url for searched product
    private String pageUrl = "";

    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'HTC One Mini Blue')]")
    private WebElement accessProduct;

    public SearchPage(final WebDriver driver) {
        super(driver);
    }
}
