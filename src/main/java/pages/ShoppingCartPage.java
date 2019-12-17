package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Getter;

@Getter
public class ShoppingCartPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/cart";

    @FindBy(xpath = "//input[@id='removefromcart15404']")
    private WebElement removeCheckboxFromCart;

    @FindBy(xpath = "//input[@id='itemquantity15404']")
    private WebElement qtyFiled;

    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateButton;

    public ShoppingCartPage(final WebDriver driver) {
        super(driver);
    }
}
