package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ShoppingCartPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/cart";

    @FindBy(css = ".remove-from-cart input")
    private WebElement removeCheckBox;

    @FindBy(css = ".qty-input")
    private WebElement quantityField;

    @FindBy(css = ".update-cart-button")
    private WebElement updateShoppingCartButton;

    @FindBy(css = "a.product-name")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='no-data']")
    private WebElement shoppingCartIsEmpty;

    @FindBy(css = ".product-subtotal")
    private WebElement productsPrice;

    @FindBy(css = ".value-summary strong")
    private WebElement orderTotalPrice;

    public ShoppingCartPage(final WebDriver driver) {
        super(driver);
    }

}
