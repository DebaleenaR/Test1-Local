@54
Feature: 54
  
  Scenario: 54
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then clickonmytaskandverify
   Then verifyredirecttotodelegatedprofile
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickok
   Then clickonmytaskandverify1
   Then verifyapproverejectbuttons
   Then verifynavigateeachsections
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then profiledelegationtaskstill
   #Then Logout 
   Then Close the browser
  