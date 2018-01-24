Feature:
	As a customer I have money in my bank account
	I want to withdraw money 
	So that I can spend it for movies and pop corn
	
#Background: eating cukes
#	Given there are cucumbers:
#	# | cukes_start | cukes_eat | cukes_remaining |
#		|      12     |     5     |       7         |
#		|      20     |     12    |       8         |
#		|      200    |     150   |       50        |
			
@iteration1 
@smoke
Scenario: Title of your scenario
    Given I have 200 dollars in my account 
    When I try to withdraw 100 from my account
    Then I should be able to see the remaining balance of 100 dollars 

#parameterizing using numbers
Scenario: Eat 5 out of 12 cukes 
	Given there are 12 cucumbers for lunch 
	And they are in my fridge
	When I eat 5 cucumbers
	And nobody cleans my fridge in the meantime
	Then I should have 7 cucumbers left
	But if somebody cleans the fridge before dinner
	Then I'm not sure how many are left
		
#parameters with string
@iteration2 
Scenario: Tom posting a question in forum
		Given I logged in as "Tom"
		When I try to post a question about "TestNG and cucumber"
		Then I should see my question posted in the forum with "confirmation message"

#Scenario Outline:
#		Given there are <cukes_start> cucumbers
#		When I eat <cukes_eat> cucumbers
#		Then I should have <cukes_remaining> cucumbers left
#		
#Examples:
#		| cukes_start | cukes_eat | cukes_remaining |
#		|      12     |     5     |       7         |
#		|      20     |     12    |       8         |
#		|      200    |     150   |       50        |
		
		

		
		



		
		
