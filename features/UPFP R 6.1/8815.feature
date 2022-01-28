@8815
Feature: 8815
  
  Scenario: 8815
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then Generatecvbutton
   Then clickonhome
   Then Navigateuserprofile_MyProfile_Validate
   Then Generatecvbutton
   #Then Logout 
   Then Close the browser