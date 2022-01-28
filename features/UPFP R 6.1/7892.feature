@7892
Feature: 7892
  
  Scenario: 7892
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverify
   Then verifygcpgreentick
   Then noradioselected
   Then Generatecvbutton
   Then Navigatetomyprofileandverify
   Then Navigateandverifytouserprofileabbriviatedcv
   #Then Logout 
   Then Close the browser
   