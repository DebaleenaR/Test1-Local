@11176
Feature: 11176
 
  
  Scenario: 11176
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login   
   Then NavigatetogeneratereportforSiteUserandverify
   Then SelectFacility/Department Contact DetailsReport                                                                                                                          
   Then EnterFacilityDepartmentCountryUnder_FacilityDepartment_Contact_Details
   Then VerifydetailsReportRecordsInTabularForm
   Then VerifyRecordsofAssociatedDepartment
   Then VerifyRecordsofAssociatedSiteUsers
   Then print
   Then Export
   Then ExportPDF1
   Then ExportXLS
   Then ExportCSV
   
    Then Logout from SipApplication

#   Then Close the browser
   
  
  

 