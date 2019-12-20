package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class SearchPage extends PageObject {

    //TODO: add URL for searched product
    private String pageUrl = "";

    public SearchPage(final WebDriver driver) {
        super(driver);
    }

}
