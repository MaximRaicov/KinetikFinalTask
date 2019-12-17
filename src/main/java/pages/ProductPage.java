package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class ProductPage extends PageObject {

    //TODO: add required url for selected product
    private String pageUrl = "";

    @FindBy(xpath = "//input[@id='add-to-cart-button-19']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-19']")
    private WebElement addToWishButton;

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement ShoppingCartButton;

    @FindBy(xpath = "//span[@class='wishlist-label']")
    private WebElement WishListButton;

    public ProductPage(final WebDriver driver) {
        super(driver);
    }
}
