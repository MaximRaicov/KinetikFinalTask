package stepDefinition;

import pages.PageObject;

public class ScenarioContext {

    private static PageObject currentPage;

    public static PageObject getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(final PageObject currentPageNew) {
        currentPage = currentPageNew;
    }
}
