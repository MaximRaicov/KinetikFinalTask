package pages;

import org.openqa.selenium.WebDriver;

import lombok.Getter;

@Getter
public class RegisterResultPage extends PageObject {

    private String pageUrl = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";

    public RegisterResultPage(final WebDriver driver) {
        super(driver);
    }

}
