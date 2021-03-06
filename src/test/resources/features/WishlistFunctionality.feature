@aciuvaga
Feature: WishLish functionality

  Background:
    Given user is on Home page
    And user clicks on 'electronics' Button and move to 'Category' page
    And user clicks on 'cell-phones' Button and move to 'SubCategory' page
    And user clicks on 'nokia-lumia-1020' Button and move to 'Product' page
    And user press on 'addToWish' Button
    And alert message is displayed
    And alert message is closed
    When user clicks on 'wishlist' HeaderButton and move to 'WishList' page

  Scenario: Add a product to WishList
    Then product 'Nokia Lumia 1020' is displayed in the WishList

  Scenario: Change product quantity in the WishList
    When user changes 'quantity' Field with following values:
      | quantityField | 5 |
    And user press on 'updatecart' Button
    Then 'quantity' Field successfully updated

  Scenario: Remove a product from WishList
    When user press on 'removefromcart' CheckBox
    And user press on 'updatecart' Button
    Then product is removed successfully from Wishlist

  Scenario: Add a product from WishList to Cart
    When user press on 'addtocart' CheckBox
    And user press on 'addtocart' Button
    Then selected 'Nokia Lumia 1020' from Wishlist is added successfully to ShoppingCart