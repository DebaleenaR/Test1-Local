@17012
Feature: 17012
  
  Scenario: 17012
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then removefacility
   Then verifymanagedelegationpage
   Then Verify_studysite_Column
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then clickonbell
   #Then Logout 
   Then Close the browser
  