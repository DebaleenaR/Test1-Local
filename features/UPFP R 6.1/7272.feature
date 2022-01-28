@7272
Feature: 7272
  
  Scenario: 7272
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then NavigatetoMyfacility
   Then verifyfacility1
   Then clickactionandverify
   Then clickadddepartment
   Then clickcancelandnavigate
   Then clickadddepartment
   Then adddepartmenttouserprofile
   Then NavigatetoMyfacility
   Then exportfacility
   Then clickcancelandnavigate
   Then PDFExport
   #Then Logout 
   Then Close the browser
   
   
  