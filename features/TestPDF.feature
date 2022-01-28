@TestPDF
Feature: TestPDF
 
  
  Scenario: TestPDF
  
  Given Open browser and launch SIPUrl
   When Application homepage is open
   Then ValidatePDFFile By Name as "DepartmentAddress"
#   Then ValidatePDFFile By FilePath 
  
  
  

 