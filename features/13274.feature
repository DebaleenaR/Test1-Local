@13274
Feature: 13274
 
  
  Scenario: 13274
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then enter_to_the_application_with_proper_login
   Then Navigategeneratereportandverify
   Then Verifystatedropdowndisable
   Then Enterdetailsgeneratereportverify
   Then Verifyfacilitydepartmentreportclumns
   Then Verifygeneratereport
   Then Verifynavigatedtofacilityname
   Then verifynavigatedtodepartmentname
   #Then print
   Then Export
   Then ExportPDF1
   Then ExportXLS
   Then ExportCSV
   #Then Logout
   Then Close the browser
   
  
  

 