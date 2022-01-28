@16030
Feature: 16030
  
  Scenario: 16030
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverify
   Then navigatsipuserprofileform
   Then uploaddownloadedcv
   #Then Logout 
   Then Close the browser
  