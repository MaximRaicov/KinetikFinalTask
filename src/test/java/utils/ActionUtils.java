package utils;

import org.openqa.selenium.WebElement;

import stepDefinition.AbstractStepDef;

public class ActionUtils extends AbstractStepDef {

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void clearTextField(WebElement element) {
        element.clear();
    }

    public static void sendKeysToField(WebElement element, String value) {
        element.sendKeys(value);
    }

}