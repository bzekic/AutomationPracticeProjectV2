Feature: During the whole transaction journey
  I want to ensure the totals on each page match up

@HighRisk @All
  Scenario:
    Given I am an existing user, I am on the homepage and I would like to purchase one item
    When I proceed through the transaction process
    Then I ensure that all totals match up on each page I visit that lists the total order value
@HighRisk @All
  Scenario:
    Given I am an existing user, I am on the homepage and I would like to purchase one item
    When I add one item to cart and continue shopping
    Then I ensure that totals match up to what is expected