@mraicov
Feature: Add product to Shopping cart

  Background:
    Given user is on Home page

  Scenario: Validate access to subcategory
    When User clicks on 'electronics' category from category bar
    And User clicks on 'cell-phones' subcategory
    Then 'Cell phones' subcategory page is displayed