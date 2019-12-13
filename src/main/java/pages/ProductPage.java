package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class ProductPage extends PageObject {

    @FindBy(xpath = "//input[@id='add-to-cart-button-19']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-19']")
    private WebElement addToWishButton;

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement ShoppingCartLink;

    @FindBy(xpath = "//span[@class='wishlist-label']")
    private WebElement WishListLink;

    public ProductPage(final WebDriver driver) {
        super(driver);
    }
}
