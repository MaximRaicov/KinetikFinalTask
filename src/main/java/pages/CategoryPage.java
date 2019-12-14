package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CategoryPage extends PageObject {

    @FindBy(css = " .category-grid.sub-category-grid>.item-grid")
    private WebElement subCategory;

    //TODO: add required url for selected category
    private String pageUrl = "";

    public CategoryPage(final WebDriver driver) {
        super(driver);
    }
}
