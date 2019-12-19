Feature: WishLish functionality

  Background:
    Given user is on Home page
    And user clicks on 'electronics' Button and move to 'Category' page
    And user clicks on 'cell-phones' Button and move to 'SubCategory' page
    And user clicks on 'nokia-lumia-1020' Button and move to 'Product' page
    And user press on 'addToWishlist' Button
    And 'alertMessage' notification is displayed
    And user clicks on 'wishlist' HeaderButton and move to 'WishList' page

#    When user press on 'wishList' Button
#
#  #@aciuvaga
#  Scenario: Add a product to WishList
#    Then product 'Nokia Lumia 1020' is displayed in the WishList
#
#  @aciuvaga
#  Scenario: Change product quantity in the WishList
#    When user press on 'qtyField' Field
#    And user fills in '2'
#    And user presses 'updatecart' button
#    Then updated product quantity is displayed in the WishList
#
#  #@aciuvaga
#  Scenario: Remove a product from WishList
#    When user checks 'removefromcart' checkbox
#    And user presses 'updatecart' button
#    Then product is removed successfully from Wishlist
#
#   #@aciuvaga
#  Scenario: Add a product from WishList to Cart
#    When user checks 'addtocart' checkbox
#    And user presses 'addtocartbutton' button
#    Then selected 'Digital Storm VANQUISH 3 Custom Performance PC' from Wishlist is added successfully to ShoppingCart
