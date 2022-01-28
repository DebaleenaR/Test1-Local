@360
Feature: 360
  
  Scenario: 360
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyprofilesummary
   Then Verifyfacilitysection
   Then facilityfieldsverification
   Then departmenttableverification
   Then sendmsgnotdisplayed
   #Then Logout 
   Then Close the browser
  
   
  
   
  
  