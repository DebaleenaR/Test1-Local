@6757
Feature: 6757
  
  Scenario: 6757
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then navigatetogcp
   Then Previewabbriviatedcv
   Then Generatecv
   Then abbrivatedcvhistory
   Then verifyexportprofile
   Then clickandverifyexportprofile
   Then clickexport
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then verifypullcvsearchscreen
   Then verifygcpsection
   #Then Logout 
   Then Close the browser
   
  
  