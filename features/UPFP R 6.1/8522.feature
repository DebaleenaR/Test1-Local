@8522
Feature: 8522
  
  Scenario: 8522
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then Verifyprofessionalexpsection
   Then verifyprofessionalexpyearstrted
   #Then Logout 
   Then Close the browser