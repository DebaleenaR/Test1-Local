@10651
Feature: 10651
  
  Scenario: 10651
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then selectuserprofileauditrailreport
   Then verifyreportfields
   Then generatereport
   Then reportcolumnverification
   #Then Logout 
   Then Close the browser
  