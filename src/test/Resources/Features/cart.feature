Feature: As an existing user, I can start the checkout procedure from the cart.

@test @All
  Scenario: As a user that is signed in, I can start the checkout procedure by clicking proceed to checkout
    Given I am signed in as an existing user
    And I am on the homepage
    When I have an item added in my cart
    And I click to the proceed to checkout
    Then I go to the Address confirmation page
