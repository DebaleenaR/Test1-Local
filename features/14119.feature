@14119
Feature: 14119 
  
  Scenario: 14119
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_proper_login
   Then Navigateuserprofile_MyProfile_Validate
   Then CLick_edit_verify_fields
   Then Enterphonenumber_save
   Then Selectstudydropdownandverify
   Then Navigateandverifytosposoraccessrepor
   Then Mytaskandverify
   Then verifydownloadsposoraccessreport
   #Open PDF check manually
   #Then Logout 
   Then Close the browser
  