package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.PageObject;
import stepDefinition.AbstractStepDef;

public class ElementSearchUtils extends AbstractStepDef {

    public static PageObject getPage(String pageName) {
        Class<?> clazz;
        PageObject pageObject = null;
        try {
            clazz = Class.forName("pages.".concat(pageName));
            Constructor<?> explicitConstructor = clazz.getConstructor(WebDriver.class);
            pageObject = (PageObject) explicitConstructor.newInstance(webDriver);
            ScenarioContext.setCurrentPage(pageObject);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return pageObject;
    }

    public static WebElement getElementByName(String elementName) {
        WebElement webElement = null;
        Field field = null;
        try {
            field = ScenarioContext.getCurrentPage().getClass().getDeclaredField(elementName);
            field.setAccessible(true);
            webElement = (WebElement) field.get(ScenarioContext.getCurrentPage());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            try {
                field = ScenarioContext.getCurrentPage().getClass().getSuperclass().getDeclaredField(elementName);
                field.setAccessible(true);
                webElement = (WebElement) field.get(ScenarioContext.getCurrentPage());
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (field != null) {
                field.setAccessible(false);
            }
        }
        return webElement;
    }
}
