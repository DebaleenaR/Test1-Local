@16028
Feature: 16028
  
  Scenario: 16028
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then Navigatedtodelegatedprofile
   Then Verifyfacilitysection
   Then verifysearchfacilityscreen
   Then verifyredirecttotodelegatedprofile
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyapproverejectbuttons
   Then Navigatetomyprofileandverify
   Then verifyfacilitysection
   #Then Logout 
   Then Close the browser