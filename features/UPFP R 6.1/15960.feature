@15960
Feature: 15960
  
  Scenario: 15960
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyprofilesummary
   Then Verifyfacilitysection
   Then verifyfacilitymentionedfields
   Then clickdisplayoncv1
   Then Generatecvbutton
   Then Navigateandverifytouserprofileabbriviatedcv
   #Then Logout 
   Then Close the browser
  