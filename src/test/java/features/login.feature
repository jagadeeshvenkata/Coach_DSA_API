
Feature: User Login
    
 

@rlogin 
Scenario Outline: Account Login
		Given User is given with "<userName>" and "<password>"
    When User hits Login "login" api with "POST" http call
    Then API returns status code 200
    And API response has the message "registered"  
 
    Examples: 
      | userName |  | password |
      | jay@dev80.com | | jagadeesh12 |
      | jay@dev80.com | | jagadeesh12 |
      

   
