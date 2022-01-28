@72
Feature: 72
  
  Scenario: 72
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickok
   Then verifytablenorecord
   Then verifyexportprofile
   Then clickandverifyexportprofile
   Then clickexport
   #Then Logout 
   Then Close the browser
  
  