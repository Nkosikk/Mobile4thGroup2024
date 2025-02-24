Feature: Calculator

  Scenario: Addition of two numbers
    Given I open the calculator app
    When I press 2
    And I press the add button
    And I press 3
    And I press the equals button
    Then the result should be 5

  Scenario: Calculate VAT of 15% on 100000
    Given I open the calculator app
    When I enter the number 100000
    And I press the multiply button
    And I enter the number 15
    And I press the percent button
    And I press the equals button
    Then the result should be 15000