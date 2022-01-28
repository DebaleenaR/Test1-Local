@14036
Feature: 14036
 
  
  Scenario: 14036
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_proper_login
   Then Navigateuserprofile_MyProfile_Validate
   Then CLick_edit_verify_fields
   Then Enterphonenumber_save
   Then Selectstudydropdownandverify
   #Then Logout 
   Then Close the browser
  