package utils;

import pages.PageObject;

import java.util.HashMap;


public class ScenarioContext {

    private static PageObject currentPage;
    private static HashMap<String, Object> values = new HashMap<>();

    public static PageObject getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(final PageObject currentPageNew) {
        currentPage = currentPageNew;
    }

    public static Object getValue(String key) {
        return values.get(key);
    }

    public static void setValue(String key, Object value) {
        values.put(key, value);
    }

}
