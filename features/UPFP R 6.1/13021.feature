@13021
Feature: 13021
  
  Scenario: 13021
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifypullcvsearchresult
   Then email2norecord
   Then email3norecord
   Then email4norecord
   #Then Logout 
   Then Close the browser
   