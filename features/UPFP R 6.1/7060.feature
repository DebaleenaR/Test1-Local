@7060
Feature: 7060
  
  Scenario: 7060
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then navigatetogcp
   Then Generatecv
   Then abbrivatedcvhistory
   Then verifyexportprofile
   Then clickandverifyexportprofile
   Then clickexport
   #Then Logout 
   Then Close the browser
   