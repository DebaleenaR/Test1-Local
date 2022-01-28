@7888
Feature: 7888
  
  Scenario: 7888
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then verifygcpgreentick
   Then verifysumbittrainingrequestdiaplayed
   Then verifystatus
   Then generateCVButton1
   Then verifywordpdf
   Then verifygcpgreentick
   #Then Logout 
   Then Close the browser
   
   
  