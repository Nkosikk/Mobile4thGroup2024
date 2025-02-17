Feature: Calculator

  Scenario: Addition of two numbers
    Given I open the calculator app
    When I press 2
    And I press the add button
    And I press 3
    And I press the equals button
    Then the result should be 5