@8517
Feature: 8517
  
  Scenario: 8517
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then verifypullcvsearchresult
   Then Navigateandverifytouserprofileabbriviatedcv
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then Navigateuserprofile_MyProfile_Validate
   Then Verifyprofessionalexpsection
   Then verifygeneratecvenable
   Then generateCVButton1
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifypullcvsearchresult
   Then Navigateandverifytouserprofileabbriviatedcv
   Then Verifyprofessionalexpsection
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then Navigatedtodelegatedprofile
   Then Verifyprofessionalexpsection
   Then Updateprofessionalexpandsendallchangesforapproval
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatedtoapproverejectupdate
   #Then Logout 
   Then Close the browser
   