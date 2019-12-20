package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class SearchPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy( css = " .product-grid > .item-grid")
    private WebElement searchProductGrid;

    public SearchPage(final WebDriver driver) {
        super(driver);
    }
}
