package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/";

    @FindBy(css = ".bar-notification.success")
    private WebElement alertMessage;

    @FindBy(css = "span.close")
    private WebElement closeAlertMessage;

    @FindBy(id = "add-to-cart-button-19")
    private WebElement addToCartButton;

    @FindBy(id = "add-to-wishlist-button-19")
    private WebElement addToWishButton;

    @FindBy(id = "topcartlink")
    private WebElement shoppingCartButton;

    @FindBy(css = ".header-links a[href='/wishlist']")
    private WebElement wishListButton;

    public ProductPage(final WebDriver driver) {
        super(driver);
    }

}
