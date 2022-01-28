@8637
Feature: 8637
  
  Scenario: 8637
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifypullcvsearchresult
   Then clickandverifyexpand
   #Then Logout 
   Then Close the browser
   