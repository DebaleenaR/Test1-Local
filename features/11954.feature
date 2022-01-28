@11954
Feature: 11954
 
  
  Scenario: 11954
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login  
   Then  Navigateandverifyfacilitydepartmentaudittrailreport
   Then Filldataandgeneratereport as "Date1" And "Date2"
# #Change date in the code Accordingly
   Then ClickOn + buttonForSponser
   Then Filldataandgeneratereport as "Date3" And "Date4" 
   Then ExportPDF 
   Then Exportasxls
#   
#   
#   Then ClickOn + button
   Then SelectUserAndFacilityDocumentUnderAuditTrail
   Then Filldataandgeneratereport as "Date1" And "Date2"
   Then ClickOn + buttonForSponser
 #Change date in the code Accordingly
   Then Filldataandgeneratereport as "Date3" And "Date4" 
 #Change date in the code Accordingly
 
 Then Navigatetogeneratereportandverify
 Then SelectFacility/Department Contact DetailsReport
 Then EnterDetailsUnder Facility/Department Contact DetailsReport
 Then ExportPDFinGeneralReports
  
  
 Then Logout from SipApplication  
#   Then Close the browser
   
  
  

 