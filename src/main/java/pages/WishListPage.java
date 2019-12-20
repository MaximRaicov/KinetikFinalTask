package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class WishListPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/wishlist";

    @FindBy(xpath = "//input[@name='removefromcart']")
    private WebElement removeCheckBoxFromWishList;

    @FindBy(xpath = "//input[@name='addtocart']")
    private WebElement addToCartCheckbox;

    @FindBy(xpath = "//input[@name='itemquantity15408']")
    private WebElement qtyField;

    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateButton;

    @FindBy(xpath = "//input[@name='addtocartbutton']")
    private WebElement addToCartButton;

    public WishListPage(final WebDriver driver) {
        super(driver);
    }

}
