@7899
Feature: 7899
  
  Scenario: 7899
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickonmytaskandverify
   Then Navigateuserprofile_MyProfile_Validate
   Then navigateandverifyeachsection
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then generateCVButton1
   Then clickonmytaskandverify
   Then navigatetoexportcv
   Then refreshexport
   #Then Logout 
   Then Close the browser
   
   
  