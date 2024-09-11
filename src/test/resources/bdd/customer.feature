Feature: Customer

  Scenario: Get Customer
    Given an instance of the DB where there are multiple Customer
    When I call the Get Customer endpoint with id = 1
    Then I'll get the corrispondent Customer

  Scenario: Get Customer
    Given an instance of the DB where there are multiple Customer
    When I call the Get Customer endpoint with id = -1
    Then I'll get HTTP Status Code 404 with message 'There is no Customer with ID = -1'

