@17191
Feature: 17191
 
  
  Scenario: 17191
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "FranklinStudyAdminRed01@franklin-member-id0" bypass login   
   Then Navigateandverifyfacilitydepartmentaudittrailreport
   Then FillDetailsForFacilityDepartmentAuditTrail With Faciliy as "FacilityName"
   Then GenerateReport
   Then ExportPDF
   Then Exportasxls
   Then ClickOnprint

   
   
   
#   ForDepartment
 Then Navigateandverifyfacilitydepartmentaudittrailreport
   Then FillDetailsForFacilityDepartmentAuditTrail With Faciliy as "Facility+Department"
   Then GenerateReport
   Then ExportPDF
   Then Exportasxls
   Then ClickOnprint
   
  

#   Then Close the browser
   
  
  

 