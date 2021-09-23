Feature: Registration functionality scenario

@Register @One

Scenario: Verify whether the user is able to register into the application by providing all the details
	
		Given I launch the application
		And I navigate to Register page
		When I provide all the below valid details
			
				| First Name	| Ravi 									|
				|	Last Name  	| Kiran 								|
				| Email 			| ravi.kiran2@gmail.com |
				|	Telephone 	| 9121634812						|
				|	Password 		|	rkiran								|
				
		And I select the Privacy Policy
		And I click on Continue button
		Then I should see that the User Account has succeessfully created
		
	@Register @Two
	
	Scenario: Verify whether the user is allowed to register on skipping the mandatory fields
	
		Given I launch the application
		And I navigate to Register page
		When I click on Continue button
		Then I should see that the User Account is not created
		And I should see the error messages informing the User to fill the mandatory fields 
		
		
	@Register @Three

	Scenario: Verify whether the user is able to register into the application by opting for Newsletter subscription
	
		Given I launch the application
		And I navigate to Register page
		When I provide all the below valid details
			
				| First Name	| Ravi 									|
				|	Last Name  	| Kiran 								|
				| Email 			| ravi.kiran2@gmail.com |
				|	Telephone 	| 9121634812						|
				|	Password 		|	rkiran								|
				
		And I select the Privacy Policy
		And I subscribe to Newsletter
		And I click on Continue button
		Then I should see that the User Account has succeessfully created
		
	@Register @Four
		
	Scenario: Verify whether the user is restricted from creating a duplicate account
	
		Given I launch the application
		And I navigate to Register page
		When I provide the below duplicate details
			
				| First Name	| Ravi 									|
				|	Last Name  	| Kiran 								|
				| Email 			| ravi.kiran2@gmail.com |
				|	Telephone 	| 9121634812						|
				|	Password 		|	rkiran								|
				
		And I select the Privacy Policy
		And I click on Continue button
		Then I should see that the User is restricted from creating duplicate account
		
		
		