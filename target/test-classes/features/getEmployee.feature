Feature: To get the list of all employees

  Scenario: To get the list of all employees

   Given I have the Employee Endpoint
    When I hit the endpoint to get the list of employees
    Then Validate that API returns me list of employees
    And Status of API is "200"