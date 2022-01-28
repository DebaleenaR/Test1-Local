@7735
Feature: 7735
  
  Scenario: 7735
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then verifymanagedelegationpage
   Then verifyuserabletodelegate  
   Then pooltaskwillnotrecieve 
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then pooltaskwillrecieve
   #Then Logout 
   Then Close the browser