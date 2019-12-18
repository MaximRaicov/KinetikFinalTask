Feature: Create new user

  Background:
    Given user is on Home page

  Scenario Outline: Check user can register with valid credentials
    When User press on Register link
    Then Register page is displayed
    When User populates <firstName>, <lastName>, <email>, <password>, <confirmPassword> fields
    And User press on Register button
    Then User is successfully registered
    Examples:
      | firstName | lastName | email          | password | confirmPassword |
      | Test1     | Test1    | test1@test.com | 123456   | 123456          |
      | Test2     | Test2    | test2@test.com | 123456   | 123456          |

  Scenario Outline: Check user can't register with invalid credentials
    When User press on Register link
    Then Register page is displayed
    When User populates <firstName>, <lastName>, <email>, <password>, <confirmPassword> fields
    And User press on Register button
    Then Warning message is displayed

    Examples:
      | firstName | lastName | email          | password | confirmPassword |
      | Test1     | Test1    | test1@test.com | 1        | 1               |
      | Test2     | Test2    | test2@test.com | 1        | 1               |

  Scenario Outline: Check user can login with valid credentials
    When User press on Login link
    Then Login page is displayed
    When User pupulates <email> and <password> fields
    And User press on Save button
    Then User is successfully logged in

    Examples:
      | email           | password |
      | test1@.test.com | 123456   |
      | test2@.test.com | 123456   |

  Scenario Outline: Check user can't login with invalid credentials
    When User press on Login link
    Then Login page is displayed
    When User pupulates <email> and <password> fields
    And User press on Save button
    Then Warning message is displayed

    Examples:
      | email           | password |
      | test1@.test.com | 12       |
      | test2@.test.com | 12       |

  Scenario Outline: Check user can edit customer information
    When User login and tap on MyAccountLink
    Then My account page is displayed
    When User changes <firstName>, <lastName>, <email> field
    And User press on Save button
    Then Customer information successfully updated
    Examples:
      | firstName | lastName | email             |
      | newTest1  | newTest1 | newTest1@test.com |
      | newTest2  | newTest2 | newTest2@test.com |