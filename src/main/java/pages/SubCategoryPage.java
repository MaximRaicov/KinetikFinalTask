package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class SubCategoryPage extends PageObject {

    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'HTC One Mini Blue')]")
    private WebElement accessProduct;

    public SubCategoryPage(final WebDriver driver) {
        super(driver);
    }
}
