@346
Feature: 346
  
  Scenario: 346
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickok
   Then verifysipuserprofile
   Then Verifysuccessulmsg
   Then verifyupdates
   Then verifynonotification
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then verifynonotification
   #Then Logout 
   Then Close the browser
  