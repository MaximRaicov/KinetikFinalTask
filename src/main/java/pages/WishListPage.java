package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class WishListPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/wishlist";

    @FindBy(css = " .cart tbody tr .remove-from-cart input")
    private WebElement removefromcartCheckBox;

    @FindBy(css = " .cart tbody tr .add-to-cart input")
    private WebElement addtocartCheckBox;

    @FindBy(className = "qty-input")
    private WebElement quantityField;

    @FindBy(css = " .wishlist-content form .buttons .update-wishlist-button")
    private WebElement updatecartButton;

    @FindBy(css = " .wishlist-content form .buttons .wishlist-add-to-cart-button")
    private WebElement addtocartButton;

    @FindBy(css  = " .cart tbody tr .product a")
    private WebElement productName;

    @FindBy(css = " .wishlist-page .page-body .no-data")
    private WebElement emptyWishlistMessage;

    @FindBy(css  = ".cart tbody")
    private WebElement checkboxOption;

    @FindBy(css = " .table-wrapper>.cart")
    private WebElement cartTable;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

}
