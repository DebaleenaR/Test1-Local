@16956
Feature: 16956
 
  
  Scenario: 16956
  


   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "CurieSponsorDocAdmin1_RS@franklin-member-id0" bypass login 
#   Then NavigatetoSponserSearchfacility
#   Then EnterSponserCountryAndFacilityName
#   
#   
#   Then ClickOnFacilityLink
#   Then SwitchTab
#   Then NevigateToAssociatedSiteUserSection
#   Then VerifyAssociatedSiteUserTables
#   Then SwitchToParantTab
#    Then CheckFacility as "FacilityName"
#    Then ExportFacilitySearchIntoPDF
#    Then clickonhome
#    Then NevigateToMyTaskPageAndVerify as "Facility Profile(s) available for download."
#   Then ClickOnTaskTitle as "Facility Profile(s) available for download."
   
   
    Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryAndFacilityName
    Then CheckFacility as "FacilityName" and ClickViewDepartment
    Then ClickOnDepartmentLink
   Then SwitchTab
   Then NevigateToAssociatedSiteUserSection
   Then VerifyAssociatedSiteUserTables
   Then SwitchToParantTab
    Then CheckFacility as "Facility+Department"
    Then ExportDepartmentSearchIntoPDF
    Then clickonhome
    Then NevigateToMyTaskPageAndVerify as "Department Profile(s) available for download."
   Then ClickOnTaskTitle as "Department Profile(s) available for download."
#   PDF Validation On 16956-PDF
   
#   Then Logout from SipApplication
   

   

   