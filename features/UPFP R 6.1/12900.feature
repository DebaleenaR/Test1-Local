@12900
Feature: 12900
  
  Scenario: 12900
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverify
   Then navigateandverifyeachsection
   Then verifygcp
   Then generateCVButton1
   Then verifygcp
   Then generateCVButton1
   #Then Logout 
   Then Close the browser
  