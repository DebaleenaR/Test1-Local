@8659
Feature: 8659
  
  Scenario: 8659
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then Verifyprofessionalexpsection
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then navigatetodelegatedprofiles
   Then verifyprofessionalexpyearstrted
   Then verifyaddprofessionalexpyearstrted
   Then Updateprofessionalexpandsendallchangesforapproval
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyapproverejectbuttons
   Then verifynavigateeachsections
   #Then Logout 
   Then Close the browser