@5147
Feature: 5147
  
  Scenario: 5147
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyprofileoptions
   Then verifypullcvfields
   Then Navigateandverifypullcv
   Then verifypullhistory
   Then verifynavigateeachsections
   Then Navigateandverifypullcv
   Then Verifycheckboxpullcv
   Then Verifydownloadgeneratedcv
   Then verifypullcvtable
   #Then Logout 
   Then Close the browser

  