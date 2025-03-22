Feature: Login to JPetStore

@signin
 Scenario Outline: Login with valid credentials
    Given User navigates to JPetStore login page
    When User enters username "<username>" and password "<password>"
    And User clicks on login button
    Then User should be logged in successfully

Examples:
      | username | password    |
      | madhu123 | madhuri@987 |
      
@invalidsignin
  Scenario Outline: Login with invalid credentials
    Given User navigates to JPetStore login page
    When User enters username "<username>" and password "<password>"
    And User clicks on login button
    Then User should see an error message and stay on login page

    Examples:
      | username  |password|
      | invalid123| wrongpass| 