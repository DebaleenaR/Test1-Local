@8684-B
Feature: 8684-B
 
  
  Scenario: 8684-B
  


   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "CurieSponsorDocAdmin1_RS@franklin-member-id0" bypass login    
   Then NevigateToMyTaskPageAndVerify as "Facility Profile(s) available for download."
   Then ClickOnTaskTitle as "Facility Profile(s) available for download."
   
#   Both PDF validatiion

   Then NavigatetoSponserSearchfacility
   Then EntersponsercountryfacilitynameDepartmentType
   Then CheckFacility as "FacilityName" and ClickViewDepartment
   
   Then CheckFacility as "Facility+Department"
   Then ExportDepartmentSearchIntoPDF
   Then ExportDepartmentSearchIntoWord
   Then Logout from SipApplication

   

   