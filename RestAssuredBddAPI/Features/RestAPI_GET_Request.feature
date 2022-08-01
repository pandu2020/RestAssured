Feature: Get Rest Call

@RestAPIGetCall  @RestRegression
Scenario: Successul Get API Rest Call
	Given Launch the Base URL
	When User Provide Service Details & Provide the Method Name with All Inputs 
	Then Print The Response Body
	And Validdate Status Codes Header And Response Body 
	
	