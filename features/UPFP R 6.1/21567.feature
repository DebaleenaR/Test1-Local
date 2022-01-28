@21567
Feature: 21567
  
  Scenario: 21567
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then PIselectionandsubmit
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifynotifications
   #Then Logout 
   Then Close the browser
  