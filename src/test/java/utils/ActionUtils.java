package utils;

import org.openqa.selenium.WebElement;

import stepDefinition.AbstractStepDef;

public class ActionUtils extends AbstractStepDef {

    public static void clickOnElement(WebElement element) {
        element.click();
    }

}
