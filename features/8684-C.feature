@8684-C
Feature: 8684-C
 
  
  Scenario: 8684-C
  


   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "CurieSponsorDocAdmin1_RS@franklin-member-id0" bypass login    
   Then NevigateToMyTaskPageAndVerify as "Department Profile(s) available for download."
   Then ClickOnTaskTitle as "Department Profile(s) available for download."
   Then clickonhome
   Then ClickOnViewAllTask
   Then Logout from SipApplication

   

   