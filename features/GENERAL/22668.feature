@22668
Feature: 22668
  
  Scenario: 22668
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 1
   Then Navigate To Reports > General Reports
   Then Select "Organization Contact Details Report" Option From General Reports Dropdown
   Then Click On GENERATE REPORTS Button
   Then Verify Organization Contact Details Report Generated
   Then Verify Organization Contact Details Report Table Headers
   
   Then Click On Export Icon For Organization Contact Details Report
   Then Verify Export As PDF option Under Export Icon In Organization Contact Details Report Screen
   Then Verify Export As XLS option Under Export Icon In Organization Contact Details Report Screen
   Then Verify Export As CSV option Under Export Icon In Organization Contact Details Report Screen
   
   Then Click On Export As PDF option Under Export Icon In Organization Contact Details Report Screen
   Then Verify Organization Contact Details Report For PDF Extension
   
   Then Click On Export Icon For Organization Contact Details Report
   Then Click On Export As XLS option Under Export Icon In Organization Contact Details Report Screen
   Then Verify Organization Contact Details Report For XLSX Extension
    
   Then Click On Export Icon For Organization Contact Details Report
   Then Click On Export As CSV option Under Export Icon In Organization Contact Details Report Screen
   Then Verify Organization Contact Details Report For CSV Extension
   
   Then Logout from SipApplication
   Then Close the browser