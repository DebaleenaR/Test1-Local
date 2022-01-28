@13940
Feature: 13940
  
  Scenario: 13940
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverify
   Then navigatsipuserprofileform
   Then downloadprofiletemplate
   Then uploaddownloadedcv
   Then navigateandverifyeachsection
   #Then Logout 
   Then Close the browser
  