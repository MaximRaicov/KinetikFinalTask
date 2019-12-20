@mraicov
Feature: Access to categories and sub-categories

  Scenario Outline: Validate access to subcategory
    Given user is on Home page
    When user clicks on '<category>' Button and move to 'Category' page
    And user clicks on '<subcategory>' Button and move to 'SubCategory' page
    Then '<subcategoryName>' subcategory is displayed

    Examples:
      | category    | subcategory | subcategoryName |
      | electronics | cell-phones | Cell phones     |
      | apparel     | shoes       | Shoes           |