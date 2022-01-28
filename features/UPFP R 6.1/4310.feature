@4310
Feature: 4310
  
  Scenario: 4310
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyPIstudyhistorynotdiaplayed 
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then verifyPIstudyhistorynotdiaplayed1
   Then verifypullcvsearchresult
   Then clickverifylastname
   Then verifyPIstudyhistorynotdiaplayed1
   #Then Logout 
   Then Close the browser