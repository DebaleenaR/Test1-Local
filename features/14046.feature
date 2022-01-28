@14046
Feature: 14046
 
  
  Scenario: 14046
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "jacksonc_3694@securepass.exostartest.com" bypass login
   Then Navigatetomyfacilityandverify
   Then PDFExport
   Then verifytaskreceived
   Then Clickondepartmentprofle
   Then Navigatetomyfacilityandverify
   Then docExport
   Then verifytaskreceived1
   Then Clickondepartmentprofle
   #Then Logout
   Then Close the browser
   
   
    
   
   
   
   

 