@mraicov
Feature: Add product to Shopping cart

  Background:
    Given user is on Home page
    And user clicks on 'electronics' Button and move to 'Category' page
    And user clicks on 'cell-phones' Button and move to 'SubCategory' page
    And user clicks on 'htc-one-mini-blue' Button and move to 'Product' page
    And user press on 'addToCart' Button
    And alert message is displayed
    And alert message is closed

  Scenario: Add product to the Shopping cart
    When user press on 'shoppingCart' Button
    And 'ShoppingCart' page is displayed
    Then 'HTC One Mini Blue' product is displayed

  Scenario: Change product quantity from the Shopping cart
    When user press on 'shoppingCart' Button
    And 'ShoppingCart' page is displayed
    And user changes 'quantity' Field with following values:
      | quantityField | 2 |
    And user press on 'updateShoppingCart' Button
    Then 'quantity' Field successfully updated

  Scenario: Price validation for multiple products
    When user press on 'addToCart' Button
    And alert message is displayed
    And alert message is closed
    And user press on 'shoppingCart' Button
    And 'ShoppingCart' page is displayed
    And 'HTC One Mini Blue' product is displayed
    Then total products price is displayed correct

  Scenario: Remove product from the cart
    When user press on 'shoppingCart' Button
    And 'ShoppingCart' page is displayed
    And user press on 'remove' CheckBox
    And user press on 'updateShoppingCart' Button
    Then product is not displayed in Shopping cart