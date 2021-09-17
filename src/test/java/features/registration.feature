Feature: Registering an user

Background:
	When Bearer token is generated
    
@registration 
Scenario: User registration
		And User is given with request payload 
    When User hits "registration" api with "POST" http call
    Then API returns status code 200
    Then API returns status code 200
        
        
    
    

