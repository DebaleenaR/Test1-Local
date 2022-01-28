@8244
Feature: 8244
 
  
  Scenario: 8244
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bryantn_8460@securepass.exostartest.com" bypass login   
   Then NavigateToMyProfileFacilitiesAndVerify
   Then Hover Over the action with facilities as "FacilityName"
   Then Hover Over the action with facilities as "Facility+Department"
   Then ClickOnHyperlink as "FacilityName"
   Then SwitchTab And ClickOn OrganizationAffiliations
    Then ClickOnHyperlink as "Facility+Department"
    Then SwitchTab And ClickOn OrganizationAffiliations
    Then Logout from SipApplication

#   Then Close the browser
   
  
  

 