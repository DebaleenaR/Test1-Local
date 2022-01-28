@13352
Feature: 13352
 
  
  Scenario: 13352
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "jacksonc_3694@securepass.exostartest.com" bypass login
   Then Navigatetogeneratereportandverify
   Then Verifymentionedfields
   Then verifyfacilitycountrydropdown
   Then verifyerrormsg
   Then verifyfacilityname
   Then verifydepartment
   Then verifysiteuserrole
   Then verifysiteuserdropdown
   Then verifydelegationtypedropdown
   Then verifybuttons
   #Then Logout
   Then Close the browser
  
  
  

 