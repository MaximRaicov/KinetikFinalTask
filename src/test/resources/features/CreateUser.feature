Feature: Create new user

  Background:
    Given user is on Home page

  @amiordan
  Scenario: Check user can register with valid credentials
    When user press on 'register' Button
    Then 'Register' page is displayed
    When user populates fields with following values:
      | firstNameField       | Test1             |
      | lastNameField        | Test1             |
      | emailField           | test1.18@test.com |
      | passwordField        | 123456            |
      | confirmPasswordField | 123456            |
    And user press on 'register' Button
    Then 'RegisterResult' page is displayed

  @amiordan
  Scenario: Check user can't register with invalid credentials
    When user press on 'register' Button
    Then 'Register' page is displayed
    When user populates fields with following values:
      | firstNameField       | Test1             |
      | lastNameField        | Test1             |
      | emailField           | test1.13@test.com |
      | passwordField        | 1                 |
      | confirmPasswordField | 1                 |
    And user press on 'register' Button
    Then 'warning' Message is displayed

  @amiordan
  Scenario: Check user can login with valid credentials
    When user press on 'login' Button
    Then 'Login' page is displayed
    When user populates fields with following values:
      | emailField    | test1.1@test.com |
      | passwordField | 123456           |
    And user press on 'login' Button
    Then 'UserAccount' page is displayed

  @amiordan
  Scenario: Check user can't login with invalid credentials
    When user press on 'login' Button
    Then 'Login' page is displayed
    When user populates fields with following values:
      | emailField    | test1.1@test.com |
      | passwordField | 12               |
    And user press on 'login' Button
    Then 'warning' Message is displayed

  @amiordan
  Scenario: Check user can edit customer information
    When user press on 'login' Button
    Then 'Login' page is displayed
    When user populates fields with following values:
      | emailField    | test1.1@test.com |
      | passwordField | 123456           |
    And user press on 'login' Button
    Then 'UserAccount' page is displayed
    When user press on 'myAccount' Button
    Then 'MyAccount' page is displayed
    When user changes 'firstName' Field with following values:
      | firstNameField | newName4 |
    And user press on 'save' Button
    Then 'firstName' Field successfully updated
