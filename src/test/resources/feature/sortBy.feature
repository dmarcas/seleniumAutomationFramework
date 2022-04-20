Feature: Add product to the cart
As a user I want to add a product to the cart
	 
Scenario: Add a product to the cart

Given I am in the search product page
When I search for the product "Playmobil Ghostbusters 9220 Ecto-1"
And I add the product "B01LYRIWZ0" to the cart
Then The product "B01LYRIWZ0" is listed in the cart list