@365
Feature: 365
  
  Scenario: 365
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyeducationsectiondisplayed
   Then verifyfacilitysection
   Then verifysearchfacilityscreen
   Then verifysearchresult
   Then verifymarkedascompleted
   Then verifybasicdetailsection
   Then verifyfacilitysection
   #Then Logout 
   Then Close the browser
  
  