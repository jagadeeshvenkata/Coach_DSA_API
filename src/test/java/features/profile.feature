@UpdateProfile
Feature: Profile Update

  #Background: 
    #Given User is already LoggedIn
      #| userName      |  | password    |
      #| jay@dev80.com |  | jagadeesh12 |

  #Scenario: Update FirstName
    #When User hits "profileUpdate" api with firstName as "jagguaidu"
    #Then API returns status code 200
    #And API returns with C360message "Success"

  Scenario: Change password
    When Update Old password with new password as "Jagadeesh12" 
   # Then API returns status code 200
    And API returns with message "Password Updated"
