@14735
Feature: 14735
  
  Scenario: 14735
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverify
   Then Verifyprofessionalexpsection
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then navigatetodelegatedprofiles
   Then verifyprofessionalexpyearstrted
   #Then Logout 
   Then Close the browser
   