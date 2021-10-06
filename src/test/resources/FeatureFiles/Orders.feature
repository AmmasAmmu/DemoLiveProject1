Feature: End to end scenarios for placing orders

@Orders @One
Scenario: Verify whether the user is able to place an order

Given I login to the application
When I add a product to bag and checkout
And I place an order
Then I should see the order is placed successfully  

