@13380
Feature: 13380
  
  Scenario: 13380
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_proper_login   
   Then Navigatetosearchfacilityandverify
   Then NavigatetoIRBLocalIRBandverify
   #Then Logout 
   Then Close the browser