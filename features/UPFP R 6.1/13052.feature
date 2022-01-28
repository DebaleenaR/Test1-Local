@13052
Feature: 13052
  
  Scenario: 13052
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then selectuserprofileauditrailreport
   Then verifyreportfields
   Then generatereport
   Then verifypagination1
   Then verifyexport
   Then verifyprint
   #Then Logout 
   Then Close the browser
  