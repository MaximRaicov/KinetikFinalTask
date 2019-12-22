package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CategoryPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy(css = ".sub-category-grid>.item-grid")
    private WebElement subcategoryForm;

    public CategoryPage(final WebDriver driver) {
        super(driver);
    }

}
