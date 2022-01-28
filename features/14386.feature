@14386
Feature: 14386
  
  Scenario: 14386
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_proper_login
   Then Navigateandverifyfacilitydepartmentaudittrailreport
   Then Filldataandgeneratereport
   Then Exportasxls
   Then ExportPDF
   #Then Logout 
   Then Close the browser
   