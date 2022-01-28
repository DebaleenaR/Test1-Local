@6225
Feature: 6225
  
  Scenario: 6225
 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then verifypreviewcvnotdisplayed
   Then Navigateanderfyfacility
   Then Navigateandverifyeducation
   Then Navigateandverifyprofessional
   Then Navigateandverifyreseach
   Then Navigateandlicese
   Then Addlicenseanddenforapproval
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then navigatetoapprovereject
   Then Verifyapproverejectfields
   #Then Logout 
   Then Close the browse
  