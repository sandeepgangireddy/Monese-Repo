Feature: Submit data to webdriveruniversity.com using contact us form

Scenario: Submit valid data via contact us form
	Given I access webdriveruniversity contact us form
	When I enter a valid firstname 
	When I enter a valid last name 
	| woods | jackson | jones |
    And i enter a valid email address on the form   
	And i enter comments on form
	|example comment one | example comment two |
	When i click on the submit button on form
	Then the information should successfully be submitted via the contact us form
	