package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class CategoryPage extends PageObject {

    @FindBy(xpath = "//h2[@class='title']//a[contains(text(),'Cell phones')]")
    private WebElement subCategory;

    public CategoryPage(final WebDriver driver) {
        super(driver);
    }
}
