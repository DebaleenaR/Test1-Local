@6265
Feature: 6265
  
  Scenario: 6265
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyprofileoptions
   Then verifypullcvfields
   Then Navigateandverifypullcv
   Then verifypullhistory
   Then verifynavigateeachsections
   Then Navigateandverifypullcv
   Then clickonpullcvyes
   Then enterpagezero
   Then enterpagemorethan
   Then enterpagedecimal
   Then clickoncancelbutton
   Then Verifycheckboxpullcv
   Then Verifydownloadgeneratedcv
   Then verifypullcvtable
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then clickonbell
   Then navgateabbriviatedcv
   Then verifysposordownloadcv
   #Then Logout 
   Then Close the browser