Feature: Search functionality

  Background:
    Given user is on Home page

  @aciuvaga
  Scenario Outline: Search a product by keyword
    When Search store is populated with '<search_Item>'
    And 'SEARCH' button is pressed
    Then '<search_Item>' list of items is displayed

    Examples:
      | search_Item |
      | Laptop      |
      | Speaker     |